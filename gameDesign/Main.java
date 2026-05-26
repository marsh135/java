
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Mini Arcade Shell");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel panel = new GamePanel();
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.startGame();
    }
}

// ============================================================
// GamePanel handles the window, game loop, keyboard input,
// drawing, updating, collision, and spawning.
// ============================================================
class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Timer timer;
    private Player player;
    private ArrayList<Entity> entities;
    private Random rand;

    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    private int score;
    private int lives;
    private int spawnCounter;
    private boolean gameOver;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        rand = new Random();
        entities = new ArrayList<>();
        player = new Player(380, 500, 40, 40);

        score = 0;
        lives = 3;
        spawnCounter = 0;
        gameOver = false;

        // About 60 frames per second
        timer = new Timer(16, this);
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            updateGame();
        }
        repaint();
    }

    private void updateGame() {
        // Move player based on keyboard input
        player.setMoving(upPressed, downPressed, leftPressed, rightPressed);
        player.update();

        // Keep player inside the screen
        player.keepInsideScreen(WIDTH, HEIGHT);

        // Spawn enemies over time
        spawnCounter++;
        if (spawnCounter >= 45) {
            spawnEnemy();
            spawnCounter = 0;
        }

        // Update all entities
        for (int i = entities.size() - 1; i >= 0; i--) {
            Entity entity = entities.get(i);
            entity.update();

            // Remove entities that leave the screen
            if (entity.isOffScreen(WIDTH, HEIGHT)) {
                entities.remove(i);
                score++;
            }
        }

        // Check collision between player and enemies
        for (int i = entities.size() - 1; i >= 0; i--) {
            Entity entity = entities.get(i);

            if (player.collidesWith(entity)) {
                entities.remove(i);
                lives--;

                if (lives <= 0) {
                    gameOver = true;
                }
            }
        }
    }

    private void spawnEnemy() {
        int size = rand.nextInt(25) + 25;
        int x = rand.nextInt(WIDTH - size);
        int y = -size;
        int speed = rand.nextInt(4) + 2;

        // This is where students can experiment with polymorphism.
        // Example: randomly spawn BasicEnemy, FastEnemy, ZigZagEnemy, PowerUp, etc.
        entities.add(new BasicEnemy(x, y, size, size, speed));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw player
        player.draw(g);

        // Draw all other entities
        for (Entity entity : entities) {
            entity.draw(g);
        }

        // Draw UI
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);
        g.drawString("Lives: " + lives, 20, 60);

        if (gameOver) {
            drawGameOver(g);
        }
    }

    private void drawGameOver(Graphics g) {
        g.setColor(new Color(0, 0, 0, 180));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("GAME OVER", 250, 280);

        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Final Score: " + score, 320, 330);
        g.drawString("Press R to restart", 300, 370);
    }

    private void restartGame() {
        entities.clear();
        player = new Player(380, 500, 40, 40);
        score = 0;
        lives = 3;
        spawnCounter = 0;
        gameOver = false;
    }

    // ========================================================
    // Keyboard input
    // ========================================================
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (key == KeyEvent.VK_R && gameOver) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed, but required by KeyListener
    }
}

// ============================================================
// Abstract superclass
// Every visible object in the game should extend Entity.
// ============================================================
abstract class Entity {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;

    public Entity(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean collidesWith(Entity other) {
        return this.getBounds().intersects(other.getBounds());
    }

    public boolean isOffScreen(int screenWidth, int screenHeight) {
        return x + width < 0 || x > screenWidth || y + height < 0 || y > screenHeight;
    }
}

// ============================================================
// Player subclass
// ============================================================
class Player extends Entity {
    private boolean movingUp;
    private boolean movingDown;
    private boolean movingLeft;
    private boolean movingRight;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 6);
    }

    public void setMoving(boolean up, boolean down, boolean left, boolean right) {
        movingUp = up;
        movingDown = down;
        movingLeft = left;
        movingRight = right;
    }

    @Override
    public void update() {
        if (movingUp) {
            y -= speed;
        }
        if (movingDown) {
            y += speed;
        }
        if (movingLeft) {
            x -= speed;
        }
        if (movingRight) {
            x += speed;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, width, height);

        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
    }

    public void keepInsideScreen(int screenWidth, int screenHeight) {
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x + width > screenWidth) {
            x = screenWidth - width;
        }
        if (y + height > screenHeight) {
            y = screenHeight - height;
        }
    }
}

// ============================================================
// BasicEnemy subclass
// This enemy falls straight down.
// ============================================================
class BasicEnemy extends Entity {
    public BasicEnemy(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
    }

    @Override
    public void update() {
        y += speed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);

        g.setColor(Color.WHITE);
        g.drawOval(x, y, width, height);
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
