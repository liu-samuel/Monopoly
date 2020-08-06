import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class contents extends JPanel
{
    int xvelocity = 90;
    int yvelocity = 90;
    player player1 = new player(0, 2000);
    player player2 = new player(0, 2000);
    int money1;
    int x = 0;
    int y = 0;
    String rent1;
    String rent2;
    String moneyStr1;
    int money2;
    String moneyStr2;
    int random1;
    int random2;
    int turn = 1;
    int x1;
    int y1;
    int x2;
    int y2;
    
    int counter;
    int jailcounter1;
    int jailcounter2;
    place [] property1 = new place[40];
    place places = new place();
    String [] ownedProp1 = new String[40];
    String [] ownedProp2 = new String[40];
    int numprop1 = 0;
    int numprop2 = 0;
    static boolean gameover = false;
       
    public contents()
    {
        super.setDoubleBuffered(true);
    }
    public boolean getGame()
    {
        return gameover;
    }
    private void endGame()
    {
        this.gameover = true;
    }
    public void paintComponent(Graphics g) 
    {
        if(turn == 1)
        {
            property1 = places.getArray();
        }
        System.out.print('\u000C');
        //board frame
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 35, 990, 990);
        
        //property colors
        g2d.setColor(Color.GRAY);
        g2d.fillRect(860, 935, 90, 25);
        g2d.fillRect(680, 935, 90, 25);
        
        g2d.setColor(Color.CYAN);
        g2d.fillRect(410, 935, 90, 25);
        g2d.fillRect(230, 935, 90, 25);
        g2d.fillRect(140, 935, 90, 25);
        
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(115, 845, 25, 90);
        g2d.fillRect(115, 665, 25, 90);
        g2d.fillRect(115, 575, 25, 90);
        
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(115, 395, 25, 90);
        g2d.fillRect(115, 215, 25, 90);
        g2d.fillRect(115, 125, 25, 90);
        
        g2d.setColor(Color.RED);
        g2d.fillRect(140, 100, 90, 25);
        g2d.fillRect(320, 100, 90, 25);
        g2d.fillRect(410, 100, 90, 25);
        
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(590, 100, 90, 25);
        g2d.fillRect(680, 100, 90, 25);
        g2d.fillRect(860, 100, 90, 25);
        
        g2d.setColor(Color.GREEN);
        g2d.fillRect(950, 125 , 25, 90);
        g2d.fillRect(950, 215 , 25, 90);
        g2d.fillRect(950, 395 , 25, 90);
        
        g2d.setColor(Color.BLUE);
        g2d.fillRect(950, 665, 25, 90);
        g2d.fillRect(950, 845, 25, 90);
        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(500, 935, 90, 25);
        g2d.fillRect(115, 485, 25, 90);
        g2d.fillRect(500, 100, 90, 25);
        g2d.fillRect(950, 485, 25, 90);
        
        
        //jail lines
        g2d.drawLine(80, 935, 80, 995);
        g2d.drawLine(80, 995, 140, 995);
        //top vertical lines
        for(int i = 0; i < 8; i++)
        {
            g2d.drawLine(230+(90*i), 35, 230+(90*i), 125);
        }
        g2d.drawLine(140, 35, 140, 1025);
        g2d.drawLine(950, 35, 950, 1025);
        //bottom vertical lines
        for(int i = 0; i < 8; i++)
        {
            g2d.drawLine(230+(90*i), 935, 230+(90*i), 1025);
        }
        //left horizontal lines
        for(int i = 0; i < 8; i++)
        {
            g2d.drawLine(50, 215+(90*i), 140, 215+(90*i));
        }
        g2d.drawLine(50, 125, 1040, 125);
        g2d.drawLine(50, 935, 1040, 935);
        
        //right horizontal lines
        for(int i = 0; i < 8; i++)
        {
            g2d.drawLine(950, 215+(90*i), 1040, 215+(90*i));
        }
        
        //names and prices of row 1
        g2d.drawString("GO", 980, 975);
        g2d.drawString("<-----------", 965, 995);
        g2d.drawString("+ $100", 978, 1015);
        g2d.drawString("Mediterranean", 867, 975);
        g2d.drawString("Avenue", 884, 995);
        g2d.drawString("$60", 893, 1015);
        g2d.drawString("COMMUNITY", 780, 965);
        g2d.drawString("CHEST", 794, 1005);
        g2d.drawString("Baltic", 710, 975);
        g2d.drawString("Avenue", 705, 995);
        g2d.drawString("$60", 713, 1015);
        g2d.drawString("INCOME", 613, 955);
        g2d.drawString("TAX", 623, 970);
        g2d.drawString("$200", 620, 1015);
        g2d.drawString("Reading", 522, 975);
        g2d.drawString("Railroad", 522, 995);
        g2d.drawString("$200", 530, 1015);
        g2d.drawString("Oriental", 434, 975);
        g2d.drawString("Avenue", 436, 995);
        g2d.drawString("$100", 441, 1015);
        g2d.drawString("CHANCE", 341, 985);
        g2d.drawString("Vermont", 251, 975);
        g2d.drawString("Avenue", 255, 995);
        g2d.drawString("$100", 259, 1015);
        g2d.drawString("Connecticut", 155, 975);
        g2d.drawString("Avenue", 166, 995);
        g2d.drawString("$120", 171, 1015);
        g2d.drawString("IN JAIL", 95, 955);
        g2d.drawString("JUST VISITING", 55, 1015);
        //names and prices of column 1
        AffineTransform at = new AffineTransform();
        at.rotate(Math.PI/2);
        g2d.setTransform(at);
        g2d.drawString("St. Charles", 860, -100);
        g2d.drawString("Place", 875, -80);
        g2d.drawString("$140", 875, -60);
        g2d.drawString("Electric", 783, -120);
        g2d.drawString("Company", 776, -90);
        g2d.drawString("$150", 789, -60);
        g2d.drawString("States", 693, -100);
        g2d.drawString("Avenue", 693, -80);
        g2d.drawString("$140", 698, -60);
        g2d.drawString("Virginia", 601, -100);
        g2d.drawString("Avenue", 603, -80);
        g2d.drawString("$160", 608, -60);
        g2d.drawString("Pennsylvania", 497, -100);
        g2d.drawString("Railroad", 510, -80);
        g2d.drawString("$200", 518, -60);
        g2d.drawString("St. James", 415, -100);
        g2d.drawString("Place", 426, -80);
        g2d.drawString("$180", 428, -60);
        g2d.drawString("COMMUNITY", 314, -110);
        g2d.drawString("CHEST", 329, -70);
        g2d.drawString("Tennesee", 234, -100);
        g2d.drawString("Avenue", 240, -80);
        g2d.drawString("$180", 248, -60);
        g2d.drawString("New York", 144, -100);
        g2d.drawString("Avenue", 150, -80);
        g2d.drawString("$200", 158, -60);
        at.rotate(-Math.PI/2);
        g2d.setTransform(at);
        g2d.drawString("FREE", 77, 65);
        g2d.drawString("PARKING", 67, 95);
        g2d.drawString("GO TO", 977, 65);
        g2d.drawString("JAIL", 983, 95);
        at.rotate(Math.PI);
        g2d.setTransform(at);
        g2d.drawString("Kentucky", -207, -85);
        g2d.drawString("Avenue", -205, -65);
        g2d.drawString("$220", -200, -45);
        g2d.drawString("LUXARY TAX", -835, 980);
        g2d.drawString("$75", -815, 1005);
        g2d.drawString("CHANCE", -300, -80);
        g2d.drawString("Indiana", -385, -85);
        g2d.drawString("Avenue", -385, -65);
        g2d.drawString("$220", -380, -45);
        g2d.drawString("Illinois", -475, -85);
        g2d.drawString("Avenue", -475, -65);
        g2d.drawString("$240", -470, -45);
        g2d.drawString("B & O", -562, -85);
        g2d.drawString("Railroad", -568, -65);
        g2d.drawString("$200", -560, -45);
        g2d.drawString("Atlantic", -655, -85);
        g2d.drawString("Avenue", -655, -65);
        g2d.drawString("$260", -650, -45);
        g2d.drawString("Ventnor", -745, -85);
        g2d.drawString("Avenue", -745, -65);
        g2d.drawString("$260", -740, -45);
        g2d.drawString("Water", -835, -105);
        g2d.drawString("Works", -835, -75);
        g2d.drawString("$150", -830, -45);
        g2d.drawString("Marvin", -925, -85);
        g2d.drawString("Gardens", -930, -65);
        g2d.drawString("$280", -925, -45);
        at.rotate(Math.PI/2);
        g2d.setTransform(at);
        g2d.drawString("Pacific", -188, 990);
        g2d.drawString("Avenue", -188, 1010);
        g2d.drawString("$300", -188, 1030);
        g2d.drawString("North", -278, 990);
        g2d.drawString("Carolina", -283, 1005);
        g2d.drawString("Avenue", -278, 1020);
        g2d.drawString("$300", -278, 1035);
        g2d.drawString("COMMUNITY", -388, 980);
        g2d.drawString("CHEST", -376, 1020);
        g2d.drawString("Pennsylvannia", -480, 990);
        g2d.drawString("Avenue", -465, 1010);
        g2d.drawString("$320", -458, 1030);
        g2d.drawString("Short", -550, 990);
        g2d.drawString("Line", -548, 1010);
        g2d.drawString("$200", -548, 1030);
        g2d.drawString("CHANCE", -647, 1000);
        g2d.drawString("Park", -726, 990);
        g2d.drawString("Place", -728, 1010);
        g2d.drawString("$350", -728, 1030);
        g2d.drawString("LUXARY", -824, 970);
        g2d.drawString("TAX", -814, 985);
        g2d.drawString("$75", -815, 1030);
        g2d.drawString("Boardwalk", -920, 990);
        g2d.drawString("$400", -908, 1030);
        at.rotate(Math.PI/2);
        g2d.setTransform(at);
        
        g2d.setFont(g2d.getFont().deriveFont(18.0f));
        
        g2d.setColor(Color.BLUE);
        g2d.fillOval(480, 200, 25, 25);
        g2d.drawString("Player 1", 470, 190);
        g2d.setColor(Color.RED);
        g2d.fillOval(560, 200, 25, 25);
        g2d.drawString("Player 2", 550, 190);
        
        g2d.setColor(Color.BLACK);
        g2d.drawString("MONOPOLY", 505, 500);
        //players
        
        if(turn == 1)
        {
            x1 = 950;
            y1 = 1000;
            x2 = 1015 ;
            y2 = 1000;
            g2d.setColor(Color.BLUE);
            g2d.fillOval(x1, y1, 25, 25);
            g2d.setColor(Color.RED);
            g2d.fillOval(x2, y2, 25, 25);
        }
        g2d.setColor(Color.BLACK);
        g2d.drawString("Dice Roll", 510, 725);
        String turn1 = Integer.toString(turn);

        g2d.drawString("TURN " + turn1, 800, 200);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Player 1 Properties", 175, 400);
        g2d.drawString("Player 1 Money", 175, 280);
        g2d.setColor(Color.RED);
        g2d.drawString("Player 2 Properties", 750, 400);
        g2d.drawString("Player 2 Money", 800, 280);
        int diceroll;
        String diceroll1;
        int diceroll2;
        String diceroll3;
        boolean gameover = false;
        boolean diceRolled = false;
        
        if(turn > 1 && turn%2 == 0)
        {
            if(jailcounter1 == 0)
            {
                diceroll = player1.rollDice();
                diceroll1 = Integer.toString(diceroll);
                g2d.setColor(Color.BLUE);
                g2d.drawString(diceroll1, 528, 750);
                player1.position = player1.position + diceroll;
                int position = player1.position;
                int position1 = position;    
                if(position1 > 39)
                {
                    position1 = player1.position - 40;
                }
                String player12 = Integer.toString(position1);
                g2d.drawString(player12, 200, 200);
                g2d.setColor(Color.WHITE);
                g2d.fillOval(x1, y1, 25, 25);
                g2d.setColor(Color.RED);
                g2d.fillOval(x2, y2, 25, 25);
                g2d.setColor(Color.BLUE);
                if(position <= 10)
                {
                    y1 = 1000;
                    x1 = 950 - (90*position);
                    
                    /*for(int d = 0; d < diceroll; d++)
                    {
                        g2d.setColor(Color.WHITE);
                        g2d.fillOval(x1, y1, 25, 25);
                        System.out.println("d = " + d);
                        
                        
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException e)
                        {
                            System.out.println("Error");
                        }
                        g2d.setColor(Color.BLUE);
                        g2d.fillOval(x1 - xvelocity, y1, 25, 25);
                        x1 = x1 - xvelocity;
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException e)
                        {
                            System.out.println("Error");
                        }
                        repaint();
                    }*/
                    
                    g2d.fillOval(x1, y1, 25, 25);
                }
                else if(position > 10 && position < 21)
                {
                    int column1y1 = position - 10;
                    y1 = 1000 - (90 * column1y1);
                    x1 = 50;
                    g2d.fillOval(x1, y1, 25, 25);
                }
                else if(position >= 21 && position < 31)
                {
                    int row2x1 = position - 20;
                    y1 = 35;
                    x1 = 50 + (row2x1 * 90);
                    g2d.fillOval(x1, y1, 25, 25);
                }
                else if(position >= 31 && position < 40)
                {
                    int column2y1 = position - 30;
                    y1 = 35 + column2y1*90;
                    x1 = 1015;
                    g2d.fillOval(x1, y1, 25, 25);
                }
                else if(position >= 40 && position < 51)
                {
                    int extraposition = position - 40;
                    y1 = 1000;
                    x1 = 950 - (90*extraposition);
                    g2d.fillOval(x1, y1, 25, 25);
                    player1.money = player1.money + 100;
                }
                else
                {
                    g2d.fillOval(50, 910, 25, 25);
                    player1.money = player1.money + 100;
                }
                if(property1[position1].owned == -5)
                {
                    player1.position = 10;
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(x1, y1, 25, 25);
                    g2d.setColor(Color.BLUE);
                    x1 = 85;
                    y1 = 965;
                    g2d.fillOval(x1, y1, 25, 25);
                    g2d.drawString("Go to Jail!", 500, 350);
                    jailcounter1 = 3;
                }
                if(property1[position1].owned == -4)
                {
                    player1.money = player1.money - 75;
                    g2d.drawString( "Luxary Tax! Pay 75 dollars", 465, 350);
                    if(player1.money < 0)
                    {
                        System.out.println("Player 1 is bankrupt, Player 2 wins!");
                        endGame();
                    }
                }
                if(property1[position1].owned == -3)
                {
                    player1.money = player1.money - 200;
                    g2d.drawString("Income Tax! Pay 200 dollars", 450, 350);
                    if(player1.money < 0)
                    {
                        System.out.println("Player 1 is bankrupt, Player 2 wins!");
                        endGame();
                    }
                }
                if(property1[position1].owned == -2)
                {
                    random1 = player1.chance();
                    if(random1 == 1)
                    {
                        player1.money = player1.money + 50;
                        g2d.drawString("Community Chest! Gain 50 dollars", 450, 350);
                    }
                    else if(random1 == 2)
                    {
                        player1.money = player1.money - 50;
                        g2d.drawString("Community Chest! Lose 50 dollars", 450, 350);
                        if(player1.money < 0)
                        {
                            System.out.println("Player 1 is bankrupt, Player 2 wins!");
                            endGame();
                        }
                    }
                    else if(random1 == 3)
                    {
                        player1.money = player1.money + 100;
                        g2d.drawString("Community Chest! Gain 100 dollars", 450, 350);
                    }
                    else if(random1 == 4)
                    {
                        player1.money = player1.money - 100;
                        g2d.drawString("Community Chest! Lose 100 dollars", 450, 350);
                        if(player1.money < 0)
                        {
                            System.out.println("Player 1 is bankrupt, Player 2 wins!");
                            endGame();
                        }
                    }
                    else if(random1 == 5)
                    {
                        player1.money = player1.money + 75;
                        g2d.drawString("Community Chest! Gain 75 dollars", 460, 350);
                    }    
                }
                if(property1[position1].owned == -1)
                {
                    random1 = player1.chance();
                    if(random1 == 1)
                    {
                        player1.money = player1.money + 50;
                        g2d.drawString("Chance! Gain 50 dollars", 470, 350);
                    }
                    else if(random1 == 2)
                    {
                        player1.money = player1.money - 50;
                        g2d.drawString("Chance! Lose 50 dollars", 470, 350);
                        if(player1.money < 0)
                        {
                            System.out.println("Player 1 is bankrupt, Player 2 wins!");
                            endGame();
                        }
                    }
                    else if(random1 == 3)
                    {
                        player1.money = player1.money + 100;
                        g2d.drawString("Chance! Gain 100 dollars", 470, 350);
                    }
                    else if(random1 == 4)
                    {
                        player1.money = player1.money - 100;
                        g2d.drawString("Chance! Lose 100 dollars", 470, 350);
                        if(player1.money < 0)
                        {
                            System.out.println("Player 1 is bankrupt, Player 2 wins!");
                            endGame();
                        }
                    }
                    else if(random1 == 5)
                    {
                        player1.money = player1.money + 75;
                        g2d.drawString("Chance! Gain 75 dollars", 470, 350);
                    }    
                }
    
                if(property1[position1].owned == 0)
                {
                    if(player1.money - property1[position1].price >= 0)
                    {
                        ownedProp1[x] = property1[position1].name;
                        x = x + 1;
                        numprop1 = numprop1 + 1;
                        property1[position1].owned = 1;
                        player1.money = player1.money - property1[position1].price;
                        g2d.drawString("Player 1 bought " + property1[position1].name, 440, 350);
                    }
                    else
                    {
                        g2d.drawString("Player 1 does not have enough money to buy " + property1[position1].name, 390, 350);
                    }
                }
                if(property1[position1].owned == 2)
                {
                    if(property1[position1].name.equals("Electric Company") || property1[position1].name.equals("Water Works"))
                    {
                        property1[position1].rent = 4*diceroll;
                    }
                    player1.money = player1.money - property1[position1].rent;
                    player2.money = player2.money + property1[position1].rent;
                    rent1 = Integer.toString(property1[position1].rent);
                    g2d.drawString("Player 1 landed on Player 2's property (" + property1[position1].name + ") and must pay " + rent1 + " dollars", 230, 350);
                    if(player1.money < 0)
                    {
                        System.out.println("Player 1 is bankrupt, Player 2 wins!");
                        endGame();
                    }
                }
            }
            else
            {
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x1, y1, 25, 25);
                g2d.drawString("Player 1 is in Jail " + jailcounter1 + " more turns in Jail", 450, 350);
                jailcounter1--;
                g2d.setColor(Color.RED);
                g2d.fillOval(x2, y2, 25, 25);
            }
            g2d.setColor(Color.BLUE);
            for(int a = 0; a < numprop1; a++)
            {
                g2d.drawString(ownedProp1[a], 175, 420 + (20*a));
            }
            g2d.setColor(Color.RED);
            for(int b = 0; b < numprop2; b++)
            {
                g2d.drawString(ownedProp2[b], 750, 420 + (20*b));
            }
        }
        
        
        else if(turn > 1 && turn%2 == 1)
        {
            if(jailcounter2 == 0)
            {
                diceroll2 = player2.rollDice();
                diceroll3 = Integer.toString(diceroll2);
                g2d.setColor(Color.RED);
                g2d.drawString(diceroll3, 528, 750);
                player2.position = player2.position + diceroll2;
                int position2 = player2.position;
                int position21 = position2;
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x1, y1, 25, 25);
                if(position21 > 39)
                {
                    position21 = player2.position - 40;
                }
                g2d.setColor(Color.RED);
                String player21 = Integer.toString(position21);
                g2d.drawString(player21, 200, 200);
                g2d.setColor(Color.WHITE);
                g2d.fillOval(x2, y2, 25, 25);
                g2d.setColor(Color.RED);
                if(position2 <= 10)
                {
                    y2 = 1000;
                    x2 = 1015 - 90*position2;
                    g2d.fillOval(x2, y2, 25, 25);
                }
                else if(position2 >= 11 && position2 <= 20)
                {
                    int column1y2 = position2 - 10;
                    x2 = 50;
                    y2 = 935 - (column1y2 * 90);
                    g2d.fillOval(x2, y2, 25, 25);
                }
                else if(position2 >= 21 && position2 <= 30)
                {
                    int row2x2 = position2 - 20;
                    y2 = 35;
                    x2 = 115 + row2x2*90;
                    g2d.fillOval(x2, y2, 25, 25);
                }
                else if(position2 >= 31 && position2 < 40)
                {
                    int column2y2 = position2 - 30;
                    x2 = 1015;
                    y2 = column2y2*90 + 100;
                    g2d.fillOval(x2, y2, 25, 25);
                }
                else if(position2 >= 40 && position2 < 51)
                {
                    int extraposition2 = position2 - 40;
                    y2 = 1000;
                    x2 = 1015 - (90*extraposition2);
                    g2d.fillOval(x2, y2, 25, 25);
                    player2.money = player2.money + 100;
                }
                else
                {
                    g2d.fillOval(50, 845, 25, 25);
                    player2.money = player2.money + 100;
                }
                if(property1[position21].owned == -5)
                {
                    player2.position = 10;
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(x2, y2, 25, 25);
                    g2d.setColor(Color.RED);
                    x2 = 115;
                    y2 = 965;
                    g2d.fillOval(x2, y2, 25, 25);
                    g2d.drawString("Go to Jail!", 475, 350);
                    jailcounter2 = 3;
                }
                if(property1[position21].owned == -4)
                {
                    player2.money = player2.money - 75;
                    g2d.drawString("Luxary Tax! Pay 75 dollars", 465, 350);
                    if(player2.money < 0)
                    {
                        System.out.println("Player 2 is bankrupt, Player 1 wins!");
                        endGame();
                    }
                }
                if(property1[position21].owned == -3)
                {
                    player2.money = player2.money - 200;
                    g2d.drawString("Income Tax! Pay 200 dollars", 465, 350);
                    if(player2.money < 0)
                    {
                        System.out.println("Player 2 is bankrupt, Player 1 wins!");
                        endGame();
                    }
                }
                if(property1[position21].owned == 0)
                {
                    if(player2.money - property1[position21].price >= 0)
                    {
                        ownedProp2[y] = property1[position21].name;
                        y = y + 1;
                        numprop2 = numprop2 + 1;
                        property1[position21].owned = 2;
                        player2.money = player2.money - property1[position21].price;
                        g2d.drawString("Player 2 bought " + property1[position21].name, 440, 350);
                    }
                    else
                    {
                        g2d.drawString("Player 2 does not have enough money to buy " + property1[position21].name, 390, 350);
                    }
                }
                if(property1[position21].owned == -2)
                {
                    random2 = player2.chance();
                    if(random2 == 1)
                    {
                        player2.money = player2.money + 50;
                        g2d.drawString("Community Chest! Gain 50 dollars", 450, 350);
                    }
                    else if(random2 == 2)
                    {
                        player2.money = player2.money - 50;
                        g2d.drawString("Community Chest! Lose 50 dollars", 450, 350);
                        if(player2.money < 0)
                        {
                            System.out.println("Player 2 is bankrupt, Player 1 wins!");
                            endGame();
                        }
                    }
                    else if(random2 == 3)
                    {
                        player2.money = player2.money + 100;
                        g2d.drawString("Community Chest! Gain 50 dollars", 450, 350);
                    }
                    else if(random2 == 4)
                    {
                        player2.money = player2.money - 100;
                        g2d.drawString("Community Chest! Lose 100 dollars", 450, 350);
                        if(player2.money < 0)
                        {
                           System.out.println("Player 2 is bankrupt, Player 1 wins!");
                           endGame();
                        }
                    }
                    else if(random2 == 5)
                    {
                        player2.money = player2.money + 75;
                        g2d.drawString("Community Chest! Gain 75 dollars", 450, 350);
                    }    
                }
                if(property1[position21].owned == -1)
                {
                    random2 = player2.chance();
                    if(random2 == 1)
                    {
                        player2.money = player2.money + 50;
                        g2d.drawString("Chance! Gain 50 dollars", 460, 350);
                    }
                    else if(random2 == 2)
                    {
                        player2.money = player2.money - 50;
                        g2d.drawString("Chance! Lose 50 dollars", 460, 350);
                        if(player2.money < 0)
                        {
                            System.out.println("Player 2 is bankrupt, Player 1 wins!");
                            endGame();
                        }
                    }
                    else if(random2 == 3)
                    {
                        player2.money = player2.money + 100;
                        g2d.drawString("Chance! Gain 100 dollars", 460, 350);
                    }
                    else if(random2 == 4)
                    {
                        player2.money = player2.money - 100;
                        g2d.drawString("Chance! Lose 100 dollars", 460, 350);
                        if(player2.money < 0)
                        {
                            System.out.println("Player 2 is bankrupt, Player 1 wins!");
                            endGame();
                        }
                    }
                    else if(random2 == 5)
                    {
                        player2.money = player2.money + 75;
                        g2d.drawString("Chance! Gain 75 dollars", 460, 350);
                    }    
                }
                if(property1[position21].owned == 1)
                {
                    if(property1[position21].name.equals("Electric Company") || property1[position21].name.equals("Water Works"))
                    {
                        property1[position21].rent = 4*diceroll2;
                    }
                    player2.money = player2.money - property1[position21].rent;
                    player1.money = player1.money + property1[position21].rent;
                    rent2 = Integer.toString(property1[position21].rent);
                    g2d.drawString("Player 2 landed on Player 1's property (" + property1[position21].name + ") and must pay " + rent2 + " dollars", 230, 350);
                    if(player2.money < 0)
                    {
                        System.out.println("Player 2 is bankrupt, Player 1 wins!");
                        endGame();
                    }
                }
            }
            else
            {
                g2d.setColor(Color.RED);
                g2d.fillOval(x2, y2, 25, 25);
                g2d.drawString("Player 2 is in Jail " + jailcounter2 + " more turns in Jail", 465, 350);
                jailcounter2--;
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x1, y1, 25, 25);
            }
            g2d.setColor(Color.RED);
            for(int b = 0; b < numprop2; b++)
            {  
                g2d.drawString(ownedProp2[b], 750, 420 + (20*b));
            }
            g2d.setColor(Color.BLUE);
            for(int a = 0; a < numprop1; a++)
            {
                g2d.drawString(ownedProp1[a], 175, 420 + (20*a));
            }
        }
        g2d.setColor(Color.BLUE);
        money1 = player1.money;
        moneyStr1 = Integer.toString(money1);
        g2d.drawString(moneyStr1, 210, 300);
        g2d.setColor(Color.RED);
        money2 = player2.money;
        moneyStr2 = Integer.toString(money2);
        g2d.drawString(moneyStr2, 835, 300);
        turn = turn + 1;
    }
 
}  



