import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
  
/**
 * A class that allows the user to playe the Pot Luck game.
 * @author İlker Özgen
 * @version 31.03.2021
 */
public class PotLuck implements ActionListener
{  
    public static void main( String[] args ) 
    {
        // Variables
        int x;
        int y;
        int width;
        int height;
        int buttonNumber;
        int bombNumber1;
        int bombNumber2;
        int prizeNumber;
        JButton[] buttons;
        ArrayList<Integer> numberOfGuesses = new ArrayList<Integer>();
    
        // Program Code
        
        // Choose the first bomb number randomly.
        bombNumber1 = (int) (Math.random() * 24); 
        
        // Choose the second bomb number randomly and different from the first.
        do 
        {
            bombNumber2 = (int) (Math.random() * 24);  
        } while ( bombNumber1 == bombNumber2 );
        
        // Choose prize number. It should be different than bomb numbers.
        do 
        {
            prizeNumber = (int) (Math.random() * 24);
        } while ( bombNumber1 == prizeNumber || bombNumber2 == prizeNumber );
        
        // Initialize some variables.
        y = 10;
        width = 50;
        height = 50;
        buttonNumber = 1;
        buttons = new JButton[25];
        
        // Create a frame.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        // Create the status bar.
        JLabel label = new JLabel( "Number of guesses: " +  numberOfGuesses.size() );
        label.setFont(label.getFont().deriveFont (14.0f));
        label.setBounds( 5, 295, 320, 30 );
        frame.add(label);
        
        // Display the buttons in 5x5 layout.
        for ( int i = 0; i < 5; i++ ) 
        {
            x = 10;
            
            for ( int j = 0; j < 5; j++ ) 
            {
                if ( bombNumber1 == buttonNumber )
                {
                    int bombIndex1 = bombNumber1 - 1;
                    int currentX = x;
                    int currentY = y;
                
                    // Create the button.
                    buttons[buttonNumber - 1] = new JButton( "" + buttonNumber );
                    
                    // Add action listener to the button.
                    buttons[buttonNumber - 1].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed( ActionEvent e ) 
                        {
                            // Draw a bomb
                            frame.remove(buttons[bombIndex1]);
                            buttons[bombIndex1] = new BombButton( "" );
                            buttons[bombIndex1].setBounds( currentX, currentY, width, height );
                            frame.add(buttons[bombIndex1]);
                            buttons[bombIndex1].setEnabled(false);
                            
                            // Increment of the number of guesses.
                            numberOfGuesses.add( 0 );
                            
                            int currentNumberOfGuesses = numberOfGuesses.size();
                            
                            // Reveal the content of the buttons.
                            for (int k = 0; k < buttons.length; k++) 
                            {
                                buttons[k].doClick();
                            }
                            
                            label.setText( "Sorry! You are blown up at attempt " + currentNumberOfGuesses + "!" );
                        }
                    });
                }
                else if ( bombNumber2 == buttonNumber )
                {
                    int bombIndex2 = bombNumber2 - 1;
                    int currentX = x;
                    int currentY = y;
                    
                    // Create the button.
                    buttons[buttonNumber - 1] = new JButton( "" + buttonNumber );
                    
                    // Add action listener to the button.
                    buttons[buttonNumber - 1].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed( ActionEvent e ) 
                        {
                            // Draw a bomb
                            frame.remove(buttons[bombIndex2]);
                            buttons[bombIndex2] = new BombButton( "" );
                            buttons[bombIndex2].setBounds( currentX, currentY, width, height );
                            frame.add(buttons[bombIndex2]); 
                            buttons[bombIndex2].setEnabled(false);
                            
                            // Increment of the number of guesses.
                            numberOfGuesses.add( 0 );
                            
                            int currentNumberOfGuesses = numberOfGuesses.size();
                            
                            // Reveal the content of the buttons.
                            for (int k = 0; k < buttons.length; k++) 
                            {
                                buttons[k].doClick();
                            }  
                            
                            label.setText( "Sorry! You are blown up at attempt " + currentNumberOfGuesses + "!" );
                        }
                    });
                }
                else if ( prizeNumber == buttonNumber )
                {
                    int prizeIndex = prizeNumber - 1;
                    
                    // Create the button.
                    buttons[buttonNumber - 1] = new PrizeButton( "" + buttonNumber );
                    buttons[buttonNumber - 1].setOpaque(true);
                    
                    // Add action listener to the button.
                    buttons[buttonNumber - 1].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed( ActionEvent e ) 
                        {
                            // Set the button text to star.
                            buttons[prizeIndex].setText( "\u2605" );
                            buttons[prizeIndex].setFont( new Font(buttons[prizeIndex].getFont().getName(), buttons[prizeIndex].getFont().getStyle(), 19) );
                            buttons[prizeIndex].setForeground(Color.ORANGE);
                            numberOfGuesses.add( 0 );
                            buttons[prizeIndex].setEnabled(false);
                            
                            int currentNumberOfGuesses = numberOfGuesses.size();
                            
                            // Reveal the content of the buttons.
                            for (int k = 0; k < buttons.length; k++) 
                            {
                                buttons[k].doClick();
                            }  
                            
                            label.setText( "You got it in " + currentNumberOfGuesses + " attempts!");
                            
                            buttons[prizeIndex].setEnabled(true);
                        }
                    });
                }
                else
                {
                    int regularIndex = buttonNumber - 1;
                    
                    // Create the button.
                    buttons[buttonNumber - 1] = new JButton( "" + buttonNumber );
                    
                    // Add action listener to the button.
                    buttons[buttonNumber - 1].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed( ActionEvent e ) 
                        {
                            // Disable the button.
                            buttons[regularIndex].setEnabled(false);
                            numberOfGuesses.add( 0 );
                            label.setText( "Number of guesses: " + numberOfGuesses.size());
                        }
                    });
                }
                
                buttons[buttonNumber - 1].setBounds( x, y, width, height );
                frame.add(buttons[buttonNumber - 1]);
                
                x += 60;
                buttonNumber++;
            }
            
            y += 60;
        }
        
        frame.setSize(320,360);  
        frame.setLayout(null);  
        frame.setVisible(true); 
    }

	@Override
    public void actionPerformed(ActionEvent e) 
    {
        
	}

}  
    
