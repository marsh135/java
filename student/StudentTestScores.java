import javax.swing.*;
import BreezySwing.*;

public class StudentTestScores extends GBFrame{
    //Window size
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    //Declare window objects

    private JButton addButton, modifyButton, firstButton, previousButton, nextButton, lastButton;

    private JLabel blankLine1, nameLabel, test1Label, test2Label, test3Label, test4Label, 
                    test5Label, test6Label, test7Label, test8Label, test9Label, test10Label,
                    averageLabel, blankLine2, countLabel, indexLabel;

    private JTextField nameField;

    private IntegerField test1Field, test2Field, test3Field, test4Field, 
                            test5Field, test6Field, test7Field, test8Field, test9Field, test10Field,
                            averageField, countField, indexField; 

    //Other instance variables

    private Student[] students;
    
    private int indexSelectedStudent;
    private int studentCount;

    //Constructor

    public StudentTestScores(){
        //Initialize window objects

       //Initialize the data
       indexSelectedStudent = -1;
        studentCount = 0;
        students = new Student[10];

        //Instantiate window objects
        addButton       = addButton("Add Student",      2,4,1,1);
        modifyButton    = addButton("Modify Student",   3,4,1,1);

        blankLine1      = addLabel("",                  16,1,1,1);
        firstButton     = addButton("<<",               17,1,1,1);
        previousButton  = addButton("<",                17,2,1,1);
        nextButton      = addButton(">",                17,3,1,1);
        lastButton      = addButton(">>",               17,4,1,1);
        blankLine2      = addLabel("",                  18,1,1,1);

        nameLabel       = addLabel("Name:",              1,1,1,1);
        test1Label      = addLabel("Test 1:",            2,1,1,1);
        test2Label      = addLabel("Test 2:",            3,1,1,1);
        test3Label      = addLabel("Test 3:",            4,1,1,1);
        test4Label      = addLabel("Test 4:",            5,1,1,1);
        test5Label      = addLabel("Test 5:",            6,1,1,1);
        test6Label      = addLabel("Test 6:",            7,1,1,1);
        test7Label      = addLabel("Test 7:",            8,1,1,1);
        test8Label      = addLabel("Test 8:",            9,1,1,1);
        test9Label      = addLabel("Test 9:",            10,1,1,1);
        test10Label     = addLabel("Test 10:",           11,1,1,1);
        averageLabel    = addLabel("Average:",           12,1,1,1);

        nameField       = addTextField("",              1,2,2,1);
        test1Field      = addIntegerField(0,             2,2,1,1);
        test2Field      = addIntegerField(0,             3,2,1,1);
        test3Field      = addIntegerField(0,             4,2,1,1);
        test4Field      = addIntegerField(0,             5,2,1,1);
        test5Field      = addIntegerField(0,             6,2,1,1);
        test6Field      = addIntegerField(0,             7,2,1,1);
        test7Field      = addIntegerField(0,             8,2,1,1);
        test8Field      = addIntegerField(0,             9,2,1,1);
        test9Field      = addIntegerField(0,             10,2,1,1);
        test10Field     = addIntegerField(0,             11,2,1,1);
        averageField    = addIntegerField(0,             12,2,1,1);

        blankLine2      = addLabel("",                  18,1,1,1);
        countLabel      = addLabel("Count:",             14,1,1,1);
        countField      = addIntegerField(0,             14,2,1,1);
        indexLabel      = addLabel("Index:",             14,3,1,1);
        indexField      = addIntegerField(-1,             14,4,1,1);

        //Set field properties
        averageField.setEditable(false);
        countField.setEditable(false);
        indexField.setEditable(false);

        //Set window properties
        setTitle("Student Test Scores");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
    }

    public void buttonClicked(JButton buttonObj){
        if(buttonObj == addButton)          addStudent();
        else if(buttonObj == modifyButton)  modifyStudent();
        else if(buttonObj == firstButton)   displayFirstStudent();
        else if(buttonObj == previousButton)displayPreviousStudent();
        else if(buttonObj == nextButton)    displayNextStudent();
        else if(buttonObj == lastButton)    displayLastStudent();
    }
    
    private void addStudent(){
        if(studentCount < students.length){
            Student s = new Student();
            s.setName(nameField.getText());
            s.setScore(1, test1Field.getNumber());
            s.setScore(2, test2Field.getNumber());
            s.setScore(3, test3Field.getNumber());
            s.setScore(4, test4Field.getNumber());
            s.setScore(5, test5Field.getNumber());
            s.setScore(6, test6Field.getNumber());
            s.setScore(7, test7Field.getNumber());
            s.setScore(8, test8Field.getNumber());
            s.setScore(9, test9Field.getNumber());
            s.setScore(10, test10Field.getNumber());

            students[studentCount] = s;
            studentCount++;
            indexSelectedStudent = studentCount - 1;
            countField.setNumber(studentCount);
            displaySelectedStudent();
        }
        else{
            JOptionPane.showMessageDialog(this, "Cannot add more than " + students.length + " students.");
        }
    }

    private Student getDataOnScreen(){
        Student s = new Student();
        s.setName(nameField.getText());
        for(int i = 1; i <= 10; i++){
            s.setScore(i, getTestField(i).getNumber());
        }
        return s;
    }

    private IntegerField getTestField(int i) {
        switch(i){
            case 1: return test1Field;
            case 2: return test2Field;
            case 3: return test3Field;
            case 4: return test4Field;
            case 5: return test5Field;
            case 6: return test6Field;
            case 7: return test7Field;
            case 8: return test8Field;
            case 9: return test9Field;
            case 10: return test10Field;
            default: return null;
        }
    }

    private void modifyStudent(){
        if(indexSelectedStudent != -1){
            students[indexSelectedStudent] = getDataOnScreen();
            displaySelectedStudent();
        }
    }
    private void displayFirstStudent(){
        if(studentCount > 0){
            indexSelectedStudent = 0;
            displaySelectedStudent();
        }
    }

    private void displayPreviousStudent(){
        if(studentCount > 0 && indexSelectedStudent > 0){
            indexSelectedStudent--;
            displaySelectedStudent();
        }
    }

    private void displayNextStudent(){
        if(studentCount > 0 && indexSelectedStudent < studentCount - 1){
            indexSelectedStudent++;
            displaySelectedStudent();
        }
    }

    private void displayLastStudent(){
        if(studentCount > 0){
            indexSelectedStudent = studentCount - 1;
            displaySelectedStudent();
        }
    }

    private void displaySelectedStudent(){
        Student s = students[indexSelectedStudent];
        nameField.setText(s.getName());
        test1Field.setNumber(s.getScore(1));
        test2Field.setNumber(s.getScore(2));
        test3Field.setNumber(s.getScore(3));
        averageField.setNumber(s.getAverage());
        indexField.setNumber(indexSelectedStudent);
    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}
