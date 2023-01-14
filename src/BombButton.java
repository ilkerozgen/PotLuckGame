import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

/**
 * A class that represents a button that hides a bomb.
 * @author İlker Özgen
 * @version 31.03.2021
 */
public class BombButton extends JButton
{
    
    // Constructors
    /**
     * A constructor to create a bomb button.
     * @param name the text of the button
     */
    public BombButton( String name )
    {
        super( name );
    }
    
    // Methods
    /**
     * A method to draw a bomb on the button.
     * @param g graphics component
     */
    @Override
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g;
        
        super.paintComponent( g );
        
        g2.setColor( Color.GRAY );
        g2.fillRect( 3 * getWidth() / 8, getHeight() / 5 + 2, getWidth() / 4, getHeight() / 6 );
        g2.setColor( Color.BLACK );
        g2.fillOval( getWidth() / 4, getHeight() / 4 + 2, getWidth() / 2, getHeight() / 2 );
        g2.setColor( Color.RED );
        g2.drawArc( getWidth() / 2, getHeight() / 9 + 2, getWidth() / 4, 2 * getHeight() / 9, 45, 135);
    }

}
