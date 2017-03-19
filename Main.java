import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
JFrame window;
JPanel p1;
JPanel p2;
JPanel p3;
JPanel p4;
JPanel p5;
JButton graphic;
JTextArea statusT;
JTextArea storyT;
JTextField input;
JButton commandB1;
JButton commandB2;
JButton commandB3;
JButton commandB4;
JButton commandB5;
Timer timer;

public static void main(String[]args)
{

    Main game = new Main();
    game.opening();

}

public void opening()
{


    JFrame window = new JFrame();
    window.setBounds(200,200,1024,768);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBackground(Color.black);
    window.setLayout(null); //Disabling the default layout.

    Font basicfont = new Font("MS Gothic", Font.PLAIN, 20);

    // Panel Setup
    JPanel p1 = new JPanel(); //This is where graphics are displayed.
    p1.setBounds(670, 680, 325, 50); //Panel layout(x,y,x,y)
    p1.setBackground(Color.black);

    JPanel p2 = new JPanel(); //This is where status is displayed.
    p2.setBounds(670, 10, 325, 350);
    p2.setBackground(Color.black);

    JPanel p3 = new JPanel(); //This is where story text is displayed.
    p3.setBounds(10, 370, 650, 350);
    p3.setBackground(Color.black);

    JPanel p4 = new JPanel(); //This is where command menu is displayed.
    p4.setBounds(670, 370, 325, 300);
    p4.setBackground(Color.black);
    p4.setLayout(new GridLayout(5,1)); //Setting the layout of Panel 4

    JPanel p5 = new JPanel(); //This is the text-entry box.
    p5.setBounds(10, 10, 650, 350);


    // TextArea Setup
    statusT = new JTextArea();
    storyT = new JTextArea();
    input = new JTextField(32);


    JButton commandB1 = new JButton("1:Stay");
    JButton commandB2 = new JButton("2:Attack the man");
    JButton commandB3 = new JButton("3:Drink");
    JButton commandB4 = new JButton("4:Leave");
    JButton commandB5 = new JButton("5:(Debug)Clear the text");


    //Graphic setup
    //graphic = new JButton(new ImageIcon("dungeonSample.jpg"));
    //graphic.setBackground(Color.black);


    //Status text setup
    statusT.setFont(basicfont);
    statusT.setBackground(Color.black);
    statusT.setForeground(Color.white);
    statusT.setText("\nLV     Kitchen\nHP   100\nMP    28\nEXP   36"); //Ths is just a sample status

    //Story text setup
    storyT.setFont(basicfont);
    storyT.setBackground(Color.black);
    storyT.setForeground(Color.white);
    storyT.setText("\nYou have entered the library \nDo you want to continue?\n (1) Yes. \n (2) No.");

    //Input box setup
    input.setFont(basicfont);
    input.setBackground(Color.black);
    input.setForeground(Color.white);
    //input.setText("Input a number here>");
    input.addActionListener(this);



    // Add Text>>Panel>>Window
    //p1.add(graphic);
    p2.add(statusT);
    p3.add(storyT);
    p4.add(commandB1);
    p4.add(commandB2);
    p4.add(commandB3);
    p4.add(commandB4);
    p4.add(commandB5);
    p5.add(input);

    window.add(p1);
    window.add(p2);
    window.add(p3);
    window.add(p4);
    window.add(p5);

    window.setVisible(true);
}

public void actionPerformed(ActionEvent e)
{

    String choice = input.getText();
    input.selectAll();

    if(choice.equals("1")){
        storyT.setText("\nRiddle 1: \nWhat is a 7 letter word containing thousands of letters? ");
        input.selectAll();
        if(choice.equals("mailbox")){
          storyT.setText("Correct! \n Next riddle: \nWhat is it that after you take away the whole, some still remains? ");
          input.selectAll();
          if(choice.equals("wholesome")){
            storyT.setText("Correct! \n Next riddle: \nName an eight letter word that has kst in the middle, in the beginning, and at the end. ");
            input.selectAll();
            if (choice.equals("inkstand")){
              storyT.setText("Correct! ");
            }
            else {
              storyT.setText("Incorrect. ");
            }
          }
          else{
            storyT.setText("Incorrect. ");
          }
          //storyT.setText("There is a table across the room. \nYou see a cabinet and hope to find something useful\n (1) Move towards the Table.\n (2) Try to open the Cabinet.");
        }
        else {
          storyT.setText("Incorrect. ");
        }
    }
    if(choice.equals("2"))
    {
        storyT.setText("Goodbye!");
    }

    if(choice.equals(""))
    {
        storyT.setText("Sorry, we can't serve booze anymore because of the restriction by the lord");
    }
    if(choice.equals("4"))
    {
        storyT.setText("See ya.");
    }
    if(choice.equals("5"))
    {
        storyT.setText("");
    }
  

}


}
