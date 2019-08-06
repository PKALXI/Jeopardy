/*
 *File name: JEOPARDY_REAL.java
 *Number of classes: 2
 *Name of other two class: SPLASH_SCREEN.java
 *Name: Pranav's Elite Jeopardy
 *Brief Description: This game has a UI that helps you play the most elite version of Jeopardy that you have ever played
 *Author of this program: Pranav Kalsi
 *Start Date: February 15th 2018
 *End Date: March 1th 2019
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Main {

    //primitive type variables
    int scoreVal = 0;

    //questions
    String [] [] ques = {
        //sports
        {"Who is the best player on the Toronto Raptors?", "Who is the best player on the Bucks?", "Who is the best player ont the Lakers?",
            "Who is the Greatest Basketball Player All - Time", "Which Basketball player has scored 100 points in a game?"
        },

        //coding
        {"What language is Java based off of?", "What was the original name for JAVA?", "Is JavaScript a compiled language (enter \"y\" for yes and \"n\" for no)",
            "What year was the very first virus created?", "What language is used to program Arduino"},

        //music
        {"Who is the main artist in \"SICKO MODE\"?", "Who sings \"THANK YOU NEXT\"?", "Who is younger Post Malone or Justin Bieber?",
        "How many working parts are there in a piano?", "What is a cello's full name?"},

        //academics
        {"What highschool is the 4th best rated highschool in Toronto according to http://ontario.compareschoolrankings.org/secondary/SchoolsByRankLocationName.aspx",
        "what is the standard quadratic equation (no spaces)?  (use ^ to represent powers)", "What primary trignometric ratio compare the opposite and adjacent sides of a right triangle?",
        "What Macro-Nutrient provides a concentrated source of energy?", "2 + 2 = __________?"},

        //random
        {"What is the name of the boat on the dime?", "What is the name of the animals on the nickel?", "What is the Statue of Liberty made out of?",
        "Is a tomato a fruit or a vegetable?", "What country is the Taj Mahal located in?"}
    };

    //answers
    String [] [] ans = {
        {"kawhi leonard", "giannis antekounpo", "lebron james", "michael jordan", "wilt chaimberlin"},
        {"c", "oak", "n", "1983", "arduino"},
        {"travis scott", "ariana grande", "post malone", "172", "violincello"},
        {"ursula franklin academy", "y=ax^2+bx+c", "tan", "fat", "4"},
        {"bluenose", "beaver", "copper", "fruit", "india"}
    };

    //buttons
    private JButton [] sportsButton = new JButton[5];
    private  JButton [] codingButton = new JButton[5];
    private  JButton [] musicButton = new JButton[5];
    private  JButton [] academicButton = new JButton[5];
    private  JButton [] randomButton = new JButton[5];
    private JButton resetButton = new JButton("RESET"); //button set the Enabled value of all buttons to true so none are greyed out

    //boolean controlling tracing statements
    private boolean tracing = false;

    //JLabels
    private JLabel title = new JLabel("         Jeopardy");//On window title
    private JLabel score = new JLabel("           Score: " + scoreVal);//score
    private JLabel [] categories = new JLabel[5];

    public static void main(String[] args) {

        new Main();

    }//end of main method

    public Main() {
        //Start Splash Screen
        new SPLASH_SCREEN();

        //Initialize JFrame
        JFrame frame = new JFrame();

        //Create JPanels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel subMainPanel = new JPanel(new BorderLayout());

        JPanel centrePanel = new JPanel(new GridLayout(7, 5, 10, 10));
        centrePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        JPanel titlePanel = new JPanel(new GridLayout(1, 2));


        //Add title and score to title panel and set attributes
        score.setFont(new Font("Calibri", Font.ITALIC, 34));
        title.setFont(new Font("Calibri", Font.ITALIC, 34));
        titlePanel.add(title);
        titlePanel.add(score);

        //Create JLabel catagories and set fonts and add to centrePanel
        categories[0] = new JLabel("            SPORTS");
        categories[1] = new JLabel("    PROGRAMMING");
        categories[2] = new JLabel("            MUSIC");
        categories[3] = new JLabel("      ACADEMICS");
        categories[4] = new JLabel("    RANDOM FACTS");

        for(int i = 0; i < 5; i++){
            categories[i].setFont(new Font("Calibri", Font.BOLD,16));
        }//end of loop setting font and size of the JLabels for the categories

        for(int i = 0; i < 5; i++){
            centrePanel.add(categories[i], BorderLayout.CENTER);
        }//end of loop adding JLabel headers for categories to JPanel

        //Create buttons and add to the centrePanel
        for(int i = 0; i < 5; i++){
            sportsButton[i] = new JButton("" + (i*100+100));
            centrePanel.add(sportsButton[i], BorderLayout.CENTER);
            codingButton[i] = new JButton("" + (i*100+100));
            centrePanel.add(codingButton[i], BorderLayout.CENTER);
            musicButton[i] = new JButton("" + (i*100+100));
            centrePanel.add(musicButton[i], BorderLayout.CENTER);
            academicButton[i] = new JButton("" + (i*100+100));
            centrePanel.add(academicButton[i], BorderLayout.CENTER);
            randomButton[i] = new JButton("" + (i*100+100));
            centrePanel.add(randomButton[i], BorderLayout.CENTER);
        }//end of loop putting the buttons on the JPanel and centering them

        //menu bar
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu file = new JMenu("File");
        menubar.add(file);

        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);

        class exitaction implements ActionListener {

            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        }//end of exitaction class (to trigger the exit of the program)

        exit.addActionListener(new exitaction());
        JMenu help = new JMenu("Help");
        menubar.add(help);

        JMenuItem ins = new JMenuItem("Instructions");
        help.add(ins);

        class insaction implements ActionListener {

            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "* * * I N S T R U C T I O N S *    * * \n \n"
                        + "The purpose of this very exciting game is to \n"
                        + " answer the correct answer to answer each question, \n"
                        + " the case for your answer. \n"
                        + "If you answer correctly, you get the number of points corresponding to the number on the button you click on\n \n"
                        + "You can reset at any time by clicking RESET (the score resets as well).\n \n"
                        + "Have fun!", "Instructions", JOptionPane.QUESTION_MESSAGE);
            }//end of JOptionPane for instructions
        }//end of class insaction (action listener to trigger instructions)

        ins.addActionListener(new insaction());

        //Add sub-panels to Main panel
        mainPanel.add(menubar, BorderLayout.NORTH);
        mainPanel.add(subMainPanel, BorderLayout.CENTER);
        subMainPanel.add(centrePanel, BorderLayout.CENTER);
        subMainPanel.add(titlePanel, BorderLayout.NORTH);

        //Frame Attributes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Pranav's Elite Jeopardy");
        frame.setContentPane(mainPanel);
        frame.setLocationRelativeTo(null);

        //sports attributes

        for(int i = 0; i < 5; i++) {
            int finalI = i;
            int finalI1 = i;
            sportsButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        String answer = JOptionPane.showInputDialog(frame, ques[0][finalI]);
                        answer = answer.toLowerCase();
                        if (answer.contains(ans[0][finalI])) {
                            JOptionPane.showMessageDialog(frame, "Correct!!!"/*message*/, "Right Answer!"/*title*/, JOptionPane.PLAIN_MESSAGE);
                            sportsButton[finalI].setEnabled(false);
                            scoreVal += finalI1 *100 + 100;
                            score.setText("           Score: " + scoreVal);
                        } //end of if checking the correct answer
                        else {
                            JOptionPane.showMessageDialog(frame, "Incorrect!!!"/*message*/, "Wrong Answer!"/*title*/, JOptionPane.ERROR_MESSAGE);
                            sportsButton[finalI].setEnabled(false);
                        }//end of else to handle wrong answer
                    }//end of try statement
                    catch (Exception e) {
                        int option = JOptionPane.showConfirmDialog(null, "Are you sure you would like to pass on this question?", "choose one", JOptionPane.YES_NO_OPTION);
                        if (tracing) {
                            System.out.println("Yes no option pane has been created");
                        }

                        if (tracing) {
                            System.out.println("Are you sure you want to continue has been initiated");
                        }

                        if (option == JOptionPane.NO_OPTION) {
                            sportsButton[finalI].setEnabled(true);
                            if (tracing) {
                                System.out.println("NO has been clicked");
                            }
                        }//end of if checking no option

                        if (option == JOptionPane.YES_OPTION) {
                            sportsButton[finalI].setEnabled(false);
                            if (tracing) {
                                System.out.println("YES has been clicked");
                            }
                        }//end of if to check YES_OPTION

                    }//end of catch statement
                }//end of action performed method
            });//end of adding ActionListeners to each button
        }//end of for loop to create sports button questions

        //coding attributes
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            int finalI1 = i;
            codingButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        String answer = JOptionPane.showInputDialog(frame, ques[1][finalI]);
                        answer = answer.toLowerCase();
                        if (answer.contains(ans[1][finalI])) {
                            JOptionPane.showMessageDialog(frame, "Correct!!!"/*message*/, "Right Answer!"/*title*/, JOptionPane.PLAIN_MESSAGE);
                            codingButton[finalI].setEnabled(false);
                            scoreVal += finalI1 *100 + 100;
                            score.setText("           Score: " + scoreVal);
                        } //end of if checking the correct answer
                        else {
                            JOptionPane.showMessageDialog(frame, "Incorrect!!!"/*message*/, "Wrong Answer!"/*title*/, JOptionPane.ERROR_MESSAGE);
                            codingButton[finalI].setEnabled(false);
                        }//end of else to handle wrong answer
                    }//end of try statement
                    catch (Exception e) {
                        int option = JOptionPane.showConfirmDialog(null, "Are you sure you would like to pass on this question?", "choose one", JOptionPane.YES_NO_OPTION);
                        if (tracing) {
                            System.out.println("Yes no option pane has been created");
                        }

                        if (tracing) {
                            System.out.println("Are you sure you want to continue has been initiated");
                        }

                        if (option == JOptionPane.NO_OPTION) {
                            codingButton[finalI].setEnabled(true);
                            if (tracing) {
                                System.out.println("NO has been clicked");
                            }
                        }//end of if checking no option

                        if (option == JOptionPane.YES_OPTION) {
                            codingButton[finalI].setEnabled(false);
                            if (tracing) {
                                System.out.println("YES has been clicked");
                            }
                        }//end of if to check YES_OPTION

                    }//end of catch statement
                }//end of action performed method
            });//end of adding ActionListeners to each button
        }//end of for loop to create coding button questions


        //music attributes
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            int finalI1 = i;
            musicButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        String answer = JOptionPane.showInputDialog(frame, ques[2][finalI]);
                        answer = answer.toLowerCase();
                        if (answer.contains(ans[2][finalI])) {
                            JOptionPane.showMessageDialog(frame, "Correct!!!"/*message*/, "Right Answer!"/*title*/, JOptionPane.PLAIN_MESSAGE);
                            musicButton[finalI].setEnabled(false);
                            scoreVal += finalI1 *100 + 100;
                            score.setText("           Score: " + scoreVal);
                        } //end of if checking the correct answer
                        else {
                            JOptionPane.showMessageDialog(frame, "Incorrect!!!"/*message*/, "Wrong Answer!"/*title*/, JOptionPane.ERROR_MESSAGE);
                            musicButton[finalI].setEnabled(false);
                        }//end of else to handle wrong answer
                    }//end of try statement
                    catch (Exception e) {
                        int option = JOptionPane.showConfirmDialog(null, "Are you sure you would like to pass on this question?", "choose one", JOptionPane.YES_NO_OPTION);
                        if (tracing) {
                            System.out.println("Yes no option pane has been created");
                        }

                        if (tracing) {
                            System.out.println("Are you sure you want to continue has been initiated");
                        }

                        if (option == JOptionPane.NO_OPTION) {
                            musicButton[finalI].setEnabled(true);
                            if (tracing) {
                                System.out.println("NO has been clicked");
                            }
                        }//end of if checking no option

                        if (option == JOptionPane.YES_OPTION) {
                            musicButton[finalI].setEnabled(false);
                            if (tracing) {
                                System.out.println("YES has been clicked");
                            }
                        }//end of if to check YES_OPTION

                    }//end of catch statement
                }//end of action performed method
            });//end of adding ActionListeners to each button
        }//end of for loop to create music button questions


        //academic question buttons
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            int finalI1 = i;
            academicButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        String answer = JOptionPane.showInputDialog(frame, ques[3][finalI]);
                        answer = answer.toLowerCase();
                        if (answer.contains(ans[3][finalI])) {
                            JOptionPane.showMessageDialog(frame, "Correct!!!"/*message*/, "Right Answer!"/*title*/, JOptionPane.PLAIN_MESSAGE);
                            academicButton[finalI].setEnabled(false);
                            scoreVal += finalI1 *100 + 100;
                            score.setText("           Score: " + scoreVal);
                        } //end of if checking the correct answer
                        else {
                            JOptionPane.showMessageDialog(frame, "Incorrect!!!"/*message*/, "Wrong Answer!"/*title*/, JOptionPane.ERROR_MESSAGE);
                            academicButton[finalI].setEnabled(false);
                        }//end of else to handle wrong answer
                    }//end of try statement
                    catch (Exception e) {
                        int option = JOptionPane.showConfirmDialog(null, "Are you sure you would like to pass on this question?", "choose one", JOptionPane.YES_NO_OPTION);
                        if (tracing) {
                            System.out.println("Yes no option pane has been created");
                        }

                        if (tracing) {
                            System.out.println("Are you sure you want to continue has been initiated");
                        }

                        if (option == JOptionPane.NO_OPTION) {
                            academicButton[finalI].setEnabled(true);
                            if (tracing) {
                                System.out.println("NO has been clicked");
                            }
                        }//end of if checking no option

                        if (option == JOptionPane.YES_OPTION) {
                            academicButton[finalI].setEnabled(false);
                            if (tracing) {
                                System.out.println("YES has been clicked");
                            }
                        }//end of if to check YES_OPTION

                    }//end of catch statement
                }//end of action performed method
            });//end of adding ActionListeners to each button
        }//end of for loop to create academic button questions


        //random question buttons
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            int finalI1 = i;
            randomButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        String answer = JOptionPane.showInputDialog(frame, ques[4][finalI]);
                        answer = answer.toLowerCase();
                        if (answer.contains(ans[4][finalI])) {
                            JOptionPane.showMessageDialog(frame, "Correct!!!"/*message*/, "Right Answer!"/*title*/, JOptionPane.PLAIN_MESSAGE);
                            randomButton[finalI].setEnabled(false);
                            scoreVal += finalI1 *100 + 100;
                            score.setText("           Score: " + scoreVal);
                        } //end of if checking the correct answer
                        else {
                            JOptionPane.showMessageDialog(frame, "Incorrect!!!"/*message*/, "Wrong Answer!"/*title*/, JOptionPane.ERROR_MESSAGE);
                            randomButton[finalI].setEnabled(false);
                        }//end of else to handle wrong answer
                    }//end of try statement
                    catch (Exception e) {
                        int option = JOptionPane.showConfirmDialog(null, "Are you sure you would like to pass on this question?", "choose one", JOptionPane.YES_NO_OPTION);
                        if (tracing) {
                            System.out.println("Yes no option pane has been created");
                        }

                        if (tracing) {
                            System.out.println("Are you sure you want to continue has been initiated");
                        }

                        if (option == JOptionPane.NO_OPTION) {
                            randomButton[finalI].setEnabled(true);
                            if (tracing) {
                                System.out.println("NO has been clicked");
                            }
                        }//end of if checking no option

                        if (option == JOptionPane.YES_OPTION) {
                            randomButton[finalI].setEnabled(false);
                            if (tracing) {
                                System.out.println("YES has been clicked");
                            }
                        }//end of if to check YES_OPTION

                    }//end of catch statement
                }//end of action performed method
            });//end of adding ActionListeners to each button
        }//end of for loop to create random button questions


        //reset attributes
        centrePanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (int i = 0; i < 5; i++) {
                    codingButton[i].setEnabled(true);
                    sportsButton[i].setEnabled(true);
                    musicButton[i].setEnabled(true);
                    academicButton[i].setEnabled(true);
                    randomButton[i].setEnabled(true);
                }//end of loop to set all buttons to enables

                scoreVal = 0;
                score.setText("           Score: " + scoreVal);
            }//end of actionPerformed method
        });//end of actionListener for resetButton

        frame.setVisible(true);
    }//end of constructor

}//end of class

/*
* PROBLEMS AND SOLUTIONS REPORT
*
* 1. Adding the menu bar to the screen was a problem as I was trying to add a JPanel and a JMenuBar to the frame, as I later found out that Java doesn't like you to
*    add two items to a JFrame, and using Ryk's idea of having a BorderLayout in inside a BorderLayout so I have to north sections to utilize one for my JMenuBar and
*    one for my titlePanel
*
* 2. The output window was not consistent, as sometimes the JButtons were elongated and not the same shape they were supposed to be, the solution to this was using
*    the "frame.setVisible(true);" after every swing element was set up (frame is the name of my JFrame)
*
* 3. Thirdly, I had to create a running score for this game and my initial idea was to just change the variable and it would work, but it didn't, so I tried
*    changing the variable and re-adding it to its respective panel, that also did not work, then I got a brilliant idea from Ryk which was to use the set text button
*    so it actually changes the text on the JPanel
*
* 4. Lastly, my problem was to add a splash screen for my title page, it was not being able to have the splash screen and frame in the center of the screen, to do
*    this I used the "window.setLocationRelativeTo(null);" (for the JWindow named window which was the splash screen), and "frame.setLocationRelativeTo(null);" (for the
*    JFrame which was named frame, and was the game itself)
*
*/














