/**
 * @author           Serge Kishiko <sergekishiko@gmail.com>
 * @copyright        (c) 2018, Serge Kishiko. All Rights Reserved.
 * @link             https://github.com/Kishiko
 */

package controls;

import global.Colors;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;



public class JMyButtonControl extends JButton 
{
    public JMyButtonControl(String pText)
    {
    	super(pText);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Colors.COULEUR_SECONDAIRE);
        setFont(new Font("Euphemia", Font.BOLD, 20));

        // Definition du ToolTip pour chaque boutton de controle;
        if( "_".equals(pText))    setToolTipText("Minimiser");
        if( "x".equals(pText))    setToolTipText("Fermer");

        // Pour fermer la fenetre au clic de la souris sur le boutton x;
        MouseAdapter listenFermer = new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                System.exit(0);
            }
        };

        // Mise en application de ces deux Events (listenFermer et listernMinimiser);
        if( "x".equals(pText))
            addMouseListener(listenFermer);

        // Pour changer la couleur lors du ":hover in";
        addMouseListener(new MouseAdapter() 
        {
            @Override
            //Au survol de la souris
            public void mouseEntered(MouseEvent e) 
            {
                setForeground(Colors.COULEUR_LIGHT);
            }
        });

        // Pour remettre la couleur initiale lors du ":hover out";
        addMouseListener(new MouseAdapter() 
        {
            @Override
            //Au survol de la souris
            public void mouseExited(MouseEvent e) 
            {
                setForeground(Colors.COULEUR_SECONDAIRE);
            }
        });
    }
}