/**
 * @author           Serge Kishiko <sergekishiko@gmail.com>
 * @copyright        (c) 2018, Serge Kishiko. All Rights Reserved.
 * @link             https://github.com/Kishiko
 */

package controls;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

public class JMyLabel extends JLabel
{
    public JMyLabel()
    {
        setText("CALCULATOR");
        setIcon(new ImageIcon(this.getClass().getResource("/images/favicon.png")));
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setForeground(new Color(65, 113, 156));
        setFont(new Font("Euphemia", Font.BOLD, 20));
        setPreferredSize(new Dimension(192,40));
    }
}