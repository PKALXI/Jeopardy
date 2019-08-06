/*
 *File name: SPLASH_SCREEN.java
 *Number of classes: 2
 *Name of other two class: JEOPARDY_REAL.java
 *Name: Pranav's Elite Jeopardy
 *Brief Description: This game has a UI that helps you play the most elite version of Jeopardy that you have ever played
 *Author of this program: Pranav Kalsi
 *Start Date: February 15th 2018
 *End Date: March 1st 2019
 */
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.lang.*;

public class SPLASH_SCREEN {
    public static void main(String [] args){
        new SPLASH_SCREEN();
    }
    public SPLASH_SCREEN(){
        JWindow window = new JWindow();
        window.getContentPane().add(new JLabel("", new ImageIcon("/Users/PK/IdeaProjects/Jeopardy/curveBar.gif"), SwingConstants.CENTER));
        window.setBounds(450, 300, 320, 240);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){}
        window.dispose();
    }
}