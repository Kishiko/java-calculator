/**
 * @author           Serge Kishiko <sergekishiko@gmail.com>
 * @copyright        (c) 2018, Serge Kishiko. All Rights Reserved.
 * @link             https://github.com/Kishiko
 */

package controls;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

import core.EngineCalculate;
import calculator.Calculator;
import global.Colors;



public class JMyButton extends JButton
{
    public JMyButton(String pTitre, String pNature, String pDimension)
    {
        // Pour recevoir le parametre en le tagant par "final";
        final String nature = pNature;

        setText(pTitre);
        setBorder(BorderFactory.createLoweredBevelBorder());
        setForeground(Color.white);
        setFont(new Font("Euphemia", Font.PLAIN, 18));

        if("Autre".equals(pNature))
                setBackground(new Color(40, 100, 150));

        if("Numerique".equals(pNature))
                setBackground(Colors.COULEUR_SECONDAIRE);

        if("BigH".equals(pDimension))
                setPreferredSize(new Dimension(105,30));

        if("Small".equals(pDimension))
                setPreferredSize(new Dimension(50,30));

        // Pour changer la couleur lors du ":hover in";
        addMouseListener(new MouseAdapter() 
        {
            @Override
            //Au survol de la souris
            public void mouseEntered(MouseEvent e) 
            {
                setBackground(Colors.COULEUR_LIGHT);
                setForeground(Colors.COULEUR_SECONDAIRE);
            }

            @Override
            //Au survol de la souris
            public void mouseExited(MouseEvent e) 
            {
            	setForeground(Color.white);
            	
                if( "Autre".equals(nature))
                    setBackground(new Color(40, 100, 150));

                if( "Numerique".equals(nature))
                    setBackground(Colors.COULEUR_SECONDAIRE);
            }
        });


        // Une propriete qui represente la classe "Main" afin de recuperer ses composants;
        Calculator argument = new Calculator();
        EngineCalculate engineCalculate = new EngineCalculate(argument);
        addActionListener(engineCalculate);
        // Fin;
    }
}