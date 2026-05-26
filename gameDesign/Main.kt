import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.Random
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.Timer

fun main() {
    val window = JFrame("Mini Arcade Shell")
    window.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    window.isResizable = false

    val panel = GamePanel()
    window.add(panel)
    window.pack()
    window.setLocationRelativeTo(null)
    window.isVisible = true

    panel.startGame()
}

// ============================================================
// GamePanel handles the window, game loop, keyboard input,
// drawing, updating, collision, and spawning.
// ============================================================
class GamePanel : JPanel(), ActionListener, KeyListener {
    companion object {
        const val WIDTH = 800
        const val HEIGHT = 600
    }

    private val timer: Timer
    private var player: Player
    private val entities: MutableList<Entity>
    private val rand: Random

    private var upPressed = false
    private var downPressed = false
    private var leftPressed = false
    private var rightPressed = false

    private var score = 0
    private var lives = 3
    private var spawnCounter = 0
    private var gameOver = false

    init {
        preferredSize = Dimension(WIDTH, HEIGHT)
        background = Color.BLACK
        isFocusable = true
        addKeyListener(this)

        rand = Random()
        entities = ArrayList()
        player = Player(380, 500, 40, 40)

        // About 60 frames per second
        timer = Timer(16, this)
    }

    fun startGame() {
        timer.start()
    }

    override fun actionPerformed(e: ActionEvent) {
        if (!gameOver) {
            updateGame()
        }
        repaint()
    }

    private fun updateGame() {
        // Move player based on keyboard input
        player.setMoving(upPressed, downPressed, leftPressed, rightPressed)
        player.update()

        // Keep player inside the screen
        player.keepInsideScreen(WIDTH, HEIGHT)

        // Spawn enemies over time
        spawnCounter++
        if (spawnCounter >= 45) {
            spawnEnemy()
            spawnCounter = 0
        }

        // Update all entities
        for (i in entities.size - 1 downTo 0) {
            val entity = entities[i]
            entity.update()

            // Remove entities that leave the screen
            if (entity.isOffScreen(WIDTH, HEIGHT)) {
                entities.removeAt(i)
                score++
            }
        }

        // Check collision between player and enemies
        for (i in entities.size - 1 downTo 0) {
            val entity = entities[i]

            if (player.collidesWith(entity)) {
                entities.removeAt(i)
                lives--

                if (lives <= 0) {
                    gameOver = true
                }
            }
        }
    }

    private fun spawnEnemy() {
        val size = rand.nextInt(25) + 25
        val x = rand.nextInt(WIDTH - size)
        val y = -size
        val speed = rand.nextInt(4) + 2

        // This is where students can experiment with polymorphism.
        // Example: randomly spawn BasicEnemy, FastEnemy, ZigZagEnemy, PowerUp, etc.
        entities.add(BasicEnemy(x, y, size, size, speed))
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        // Draw player
        player.draw(g)

        // Draw all other entities
        for (entity in entities) {
            entity.draw(g)
        }

        // Draw UI
        g.color = Color.WHITE
        g.font = Font("Arial", Font.BOLD, 20)
        g.drawString("Score: $score", 20, 30)
        g.drawString("Lives: $lives", 20, 60)

        if (gameOver) {
            drawGameOver(g)
        }
    }

    private fun drawGameOver(g: Graphics) {
        g.color = Color(0, 0, 0, 180)
        g.fillRect(0, 0, WIDTH, HEIGHT)

        g.color = Color.WHITE
        g.font = Font("Arial", Font.BOLD, 48)
        g.drawString("GAME OVER", 250, 280)

        g.font = Font("Arial", Font.PLAIN, 24)
        g.drawString("Final Score: $score", 320, 330)
        g.drawString("Press R to restart", 300, 370)
    }

    private fun restartGame() {
        entities.clear()
        player = Player(380, 500, 40, 40)
        score = 0
        lives = 3
        spawnCounter = 0
        gameOver = false
    }

    // ========================================================
    // Keyboard input
    // ========================================================
    override fun keyPressed(e: KeyEvent) {
        val key = e.keyCode

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            upPressed = true
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            downPressed = true
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            leftPressed = true
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rightPressed = true
        }
        if (key == KeyEvent.VK_R && gameOver) {
            restartGame()
        }
    }

    override fun keyReleased(e: KeyEvent) {
        val key = e.keyCode

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            upPressed = false
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            downPressed = false
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            leftPressed = false
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rightPressed = false
        }
    }

    override fun keyTyped(e: KeyEvent) {
        // Not needed, but required by KeyListener
    }
}

// ============================================================
// Abstract superclass
// Every visible object in the game should extend Entity.
// ============================================================
abstract class Entity(
    protected var x: Int,
    protected var y: Int,
    protected var width: Int,
    protected var height: Int,
    protected var speed: Int
) {
    abstract fun update()

    abstract fun draw(g: Graphics)

    fun getBounds(): Rectangle {
        return Rectangle(x, y, width, height)
    }

    fun collidesWith(other: Entity): Boolean {
        return getBounds().intersects(other.getBounds())
    }

    fun isOffScreen(screenWidth: Int, screenHeight: Int): Boolean {
        return x + width < 0 || x > screenWidth || y + height < 0 || y > screenHeight
    }
}

// ============================================================
// Player subclass
// ============================================================
class Player(x: Int, y: Int, width: Int, height: Int) : Entity(x, y, width, height, 6) {
    private var movingUp = false
    private var movingDown = false
    private var movingLeft = false
    private var movingRight = false

    fun setMoving(up: Boolean, down: Boolean, left: Boolean, right: Boolean) {
        movingUp = up
        movingDown = down
        movingLeft = left
        movingRight = right
    }

    override fun update() {
        if (movingUp) {
            y -= speed
        }
        if (movingDown) {
            y += speed
        }
        if (movingLeft) {
            x -= speed
        }
        if (movingRight) {
            x += speed
        }
    }

    override fun draw(g: Graphics) {
        g.color = Color.CYAN
        g.fillRect(x, y, width, height)

        g.color = Color.WHITE
        g.drawRect(x, y, width, height)
    }

    fun keepInsideScreen(screenWidth: Int, screenHeight: Int) {
        if (x < 0) {
            x = 0
        }
        if (y < 0) {
            y = 0
        }
        if (x + width > screenWidth) {
            x = screenWidth - width
        }
        if (y + height > screenHeight) {
            y = screenHeight - height
        }
    }
}

// ============================================================
// BasicEnemy subclass
// This enemy falls straight down.
// ============================================================
class BasicEnemy(x: Int, y: Int, width: Int, height: Int, speed: Int) : Entity(x, y, width, height, speed) {
    override fun update() {
        y += speed
    }

    override fun draw(g: Graphics) {
        g.color = Color.RED
        g.fillOval(x, y, width, height)

        g.color = Color.WHITE
        g.drawOval(x, y, width, height)
    }
}

// ============================================================
// STUDENT CHALLENGES
// ============================================================
// 1. Create a FastEnemy class that extends Entity.
// 2. Create a ZigZagEnemy class that moves left and right while falling.
// 3. Create a PowerUp class that gives the player an extra life.
// 4. Create a Bullet class and allow the player to shoot with SPACE.
// 5. Add a BossEnemy that takes multiple hits.
// 6. Add a title screen.
// 7. Add a win condition.
// 8. Add different colors, shapes, or images.
// 9. Add difficulty that increases as score goes up.
// 10. Add sound effects.
