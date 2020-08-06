//Two player game of monopoly
import java.util.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Dimension;
class player
{
    public int money;
    public int dice1;
    public int dice2;
    public int totaldice;
    public int position;
    int random;
    public player(int newPosition, int newMoney)
    {
        position = newPosition;
        money = newMoney;
    }
    public int rollDice()
    {
        dice1 = (int)(Math.random() * 6) + 1;
        dice2 = (int)(Math.random() * 6) + 1;
       
        totaldice = dice1+ dice2;
        if(position > 39)
        {
            position = position - 40;   
        }
        return totaldice;
    }
    public int chance()
    {
        random = (int)(Math.random()*5) + 1;
        return random;
    }
}
class place
{
    public String name;
    public int price;
    public int rent;
    public int owned; //0 if not owned, 1 if player 1 owns, 2 if player 2 owns, 
    // -1 is it is a place that cannot be bought
    public place(String newname, int newprice, int newrent, int newowned)
    {
        name = newname;
        price = newprice;
        rent = newrent;
        owned = newowned;
    }
    public place()
    {
    }
    
    public place[] getArray()
    {
        place[] placeList = new place[40];
        placeList[0] = new place("GO", 0, 0, -10);
        placeList[1] = new place("Mediterranean Avenue", 60, 10, 0);
        placeList[2] = new place("COMMUNITY CHEST", 0, 0, -2);
        placeList[3] = new place("Baltic Avenue", 60, 10, 0);
        placeList[4] = new place("INCOME TAX", 0, 200, -3);
        placeList[5] = new place("Reading Railroad", 200, 100, 0);
        placeList[6] = new place("Oriental Avenue", 100, 20, 0);
        placeList[7] = new place("CHANCE", 0, 0, -1);
        placeList[8] = new place("Vermont Avenue", 100, 20, 0);
        placeList[9] = new place("Connecticut Avenue", 120, 30, 0);
        placeList[10] = new place("JAIL", 0, 0, -10);
        placeList[11] = new place("St. Charles Place", 140, 40, 0);
        placeList[12] = new place("Electric Company", 150, 0, 0);
        placeList[13] = new place("States Avenue", 140, 40, 0);
        placeList[14] = new place("Virginia Avenue", 160, 50, 0);
        placeList[15] = new place("Pennsylvania Railroad", 200, 100, 0);
        placeList[16] = new place("St. James Place", 180, 50, 0);
        placeList[17] = new place("COMMUNITY CHEST", 0, 0, -2);
        placeList[18] = new place("Tennessee Avenue", 180, 60, 0);
        placeList[19] = new place("New York Avenue", 200, 70, 0);
        placeList[20] = new place("FREE PARKING", 0, 0, -10);
        placeList[21] = new place("Kentucky Avenue", 220, 70, 0);
        placeList[22] = new place("CHANCE", 0, 0, -1);
        placeList[23] = new place("Indiana Avenue", 220, 80, 0);
        placeList[24] = new place("Illinois Avenue", 240, 80, 0);
        placeList[25] = new place("B&O Railroad", 200, 90, 0);
        placeList[26] = new place("Atlantic Avenue", 260, 100, 0);
        placeList[27] = new place("Ventor Avenue", 260, 100, 0);
        placeList[28] = new place("Water Works", 150, 0, 0);
        placeList[29] = new place("Marvin Gardens", 280, 110, 0);
        placeList[30] = new place("GO TO JAIL", 0, 0, -5);
        placeList[31] = new place("Pacific Avenue", 300, 120, 0);
        placeList[32] = new place("North Carolina Avenue", 300, 120, 0);
        placeList[33] = new place("COMMUNITY CHEST", 0, 0, -2);
        placeList[34] = new place("Pennsylvania Avenue", 320, 125, 0);
        placeList[35] = new place("Short Line", 200, 100, 0);
        placeList[36] = new place("CHANCE", 0, 0, -1);
        placeList[37] = new place("Park Place", 350, 150, 0);
        placeList[38] = new place("LUXARY TAX", 0, 75, -4);
        placeList[39] = new place("Boardwalk", 400, 200, 0);
        return placeList;
    }
}


public class board extends JFrame implements ActionListener
{
    JButton b1 = new JButton("Roll Dice");
    contents x = new contents();
    public board()
    {
        b1.addActionListener(this);
        b1.setSize(100, 100);
        b1.setVisible(true);
        b1.setText("Roll Dice");
        b1.setLocation(490, 775);
        
        super.add(b1);
        super.setTitle("Monopoly");
        super.setSize(1100, 1100);
        super.setLocation(400, 0);
        super.setResizable(false);
        super.add(new contents());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    public static void main(String[] args)
    {
        new board();
        System.out.println("arrived");
    }
    public void actionPerformed(ActionEvent evt)
    {
        boolean condition = x.getGame();
        String conditionS = Boolean.toString(condition);
        if(condition == true)
        {
            System.out.println("Turn 2");
            System.out.println(conditionS);
            b1.setEnabled(false);
        }
        else
        {
            System.out.println("Turn 1");
            System.out.println(conditionS);
            repaint();
        }
    }
}



 
