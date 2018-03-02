/**
 * @author           Serge Kishiko <sergekishiko@gmail.com>
 * @copyright        (c) 2018, Serge Kishiko. All Rights Reserved.
 * @link             https://github.com/Kishiko
 */

package controls;

import global.Colors;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JMyFrame extends JFrame
{
    private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;   //Position Y de la souris au clic

    // Les dimensions de la fenetre;
    private static final int LARGEUR = 285;
    private static final int HAUTEUR = 360;
 
    public JMyFrame() 
    {
        // Deplacer la fenetre;
        addMouseListener(new MouseAdapter() 
        {
            @Override
            //on recupere les coordonnées de la souris
            public void mousePressed(MouseEvent e) 
            {
                posX = e.getX();    //Position X de la souris au clic
                posY = e.getY();    //Position Y de la souris au clic
            }
        });
        

        // Deposer la fenetre a la position du pointeur;
        addMouseMotionListener(new MouseMotionAdapter() 
        {
            // A chaque deplacement on recalcul le positionnement de la fenetre
            @Override
            public void mouseDragged(MouseEvent e) 
            {
                int depX = e.getX() - posX;
                int depY = e.getY() - posY;
                setLocation(getX()+depX, getY()+depY);
            }
        });


        //Proprietes de la fenetre
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        getContentPane().setBackground(Colors.COULEUR_PRIMAIRE);
        getRootPane().setBorder(BorderFactory.createLineBorder(Colors.COULEUR_SECONDAIRE, 2));
        setUndecorated(true);
        pack();
    }

    public void configContainer(JPanel pMainPanel)
    {
        // Permet de le rendre Flow[Layout] sans gap en x ou en y;
        pMainPanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));

        // Il sera transparent ou faire voir la couleur de la fenetre;
        pMainPanel.setOpaque(false);

        // Lui definir entant que panel principal;
        getContentPane().add(pMainPanel);
    }
 }