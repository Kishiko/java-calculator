/**
 * @author           Serge Kishiko <sergekishiko@gmail.com>
 * @copyright        (c) 2018, Serge Kishiko. All Rights Reserved.
 * @link             https://github.com/Kishiko
 */

package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controls.JMyButton;
import controls.JMyButtonControl;
import controls.JMyFrame;
import controls.JMyLabel;
import static global.Colors.COULEUR_SECONDAIRE;
import javax.swing.JLabel;

/**
 *
 * @author Serge
 */
public class Calculator 
{
    static JPanel mainPanel = new JPanel();
    static JPanel panMenu = new JPanel(new FlowLayout(FlowLayout.LEADING,0,0));
    static JPanel miniDisplay = new JPanel(new BorderLayout());
    static JPanel panDisplay = new JPanel(new FlowLayout(FlowLayout.LEADING,5,5));
    static JPanel panButton = new JPanel(new FlowLayout(FlowLayout.LEADING));

    static JMyLabel label = new JMyLabel();
    public static JLabel displayLabelResult = new JLabel("0", JLabel.RIGHT);

    static JMyButtonControl fermer = new JMyButtonControl("_");
    static JMyButtonControl minimiser = new JMyButtonControl("x");

    static JMyButton btn_MC = new JMyButton("MC","Autre","Small");
    static JMyButton btn_MR = new JMyButton("MR","Autre","Small");
    static JMyButton btn_MS = new JMyButton("MS","Autre","Small");
    static JMyButton btn_Mplus = new JMyButton("M+","Autre","Small");
    static JMyButton btn_Mmoins = new JMyButton("M-","Autre","Small");
    static JMyButton btn_BackFleche = new JMyButton("<-","Autre","Small");
    static JMyButton btn_CE = new JMyButton("CE","Autre","Small");
    static JMyButton btn_C = new JMyButton("C","Autre","Small");
    static JMyButton btn_PlusOuMoins = new JMyButton("+ou-","Autre","Small");
    static JMyButton btn_RacineCarre = new JMyButton("V","Autre","Small");
    static JMyButton btn_7 = new JMyButton("7","Numerique","Small");
    static JMyButton btn_8 = new JMyButton("8","Numerique","Small");
    static JMyButton btn_9 = new JMyButton("9","Numerique","Small");
    static JMyButton btn_Div = new JMyButton("/","Autre","Small");
    static JMyButton btn_Pourcent = new JMyButton("%","Autre","Small"); 
    static JMyButton btn_4 = new JMyButton("4","Numerique","Small");
    static JMyButton btn_5 = new JMyButton("5","Numerique","Small");
    static JMyButton btn_6 = new JMyButton("6","Numerique","Small");
    static JMyButton btn_Prod = new JMyButton("*","Autre","Small");
    static JMyButton btn_UnSurX = new JMyButton("1/x","Autre","Small");
    static JMyButton btn_1 = new JMyButton("1","Numerique","Small");
    static JMyButton btn_2 = new JMyButton("2","Numerique","Small");
    static JMyButton btn_3 = new JMyButton("3","Numerique","Small");
    static JMyButton btn_Diff = new JMyButton("-","Autre","Small");
    static JMyButton btn_Equal = new JMyButton("=","Autre","BigH");
    static JMyButton btn_0 = new JMyButton("0","Numerique","BigH");
    static JMyButton btn_Virgule = new JMyButton(",","Numerique","Small");
    static JMyButton btn_Somme = new JMyButton("+","Autre","Small");

    static JMenuBar barreMenu = new JMenuBar();


    public static void main(String[] args) 
    {
        JMyFrame fen = new JMyFrame();
        fen.configContainer(mainPanel);

        // Preconfigurer tous les components static;
        init();

        // Configure et ajoute les elements du menu dans la menuBar;
        init_Menu(barreMenu);

        // panButton recoit tous les btn (JButton) puis sera jette dans la mainPanel;
        panButton.add(btn_MC);
        panButton.add(btn_MR);
        panButton.add(btn_MS);
        panButton.add(btn_Mplus);
        panButton.add(btn_Mmoins);
        panButton.add(btn_BackFleche);
        panButton.add(btn_CE);
        panButton.add(btn_C);
        panButton.add(btn_PlusOuMoins);
        panButton.add(btn_RacineCarre);
        panButton.add(btn_7);
        panButton.add(btn_8);
        panButton.add(btn_9);
        panButton.add(btn_Div);
        panButton.add(btn_Pourcent);
        panButton.add(btn_4);
        panButton.add(btn_5);
        panButton.add(btn_6);
        panButton.add(btn_Prod);
        panButton.add(btn_UnSurX);
        panButton.add(btn_1);
        panButton.add(btn_2);
        panButton.add(btn_3);
        panButton.add(btn_Diff);
        panButton.add(btn_Somme);
        panButton.add(btn_0);
        panButton.add(btn_Virgule);
        panButton.add(btn_Equal);


        // mainPanel devient le panel principal de la Frame;
        mainPanel.add(label);
        mainPanel.add("West",fermer);
        mainPanel.add(minimiser);
        mainPanel.add(panMenu);
        mainPanel.add(panDisplay);
        mainPanel.add(panButton);


        // Finalisation de ma JMyFrame;
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
    }


    public static void init_Menu(JMenuBar myMenu)
    {
        myMenu.setBackground(new Color(157, 195, 230));
        myMenu.setPreferredSize(new Dimension(300,20));

    
    	// Tous sur l'item AFFICHAGE;

        JMenu affichage = new JMenu("Affichage");
        affichage.setFont(new Font("Euphemia", Font.PLAIN, 14));

        JCheckBoxMenuItem aff_Standard = new JCheckBoxMenuItem("Standard");
        aff_Standard.setSelected(false);
        aff_Standard.setMnemonic(KeyEvent.VK_S);
        aff_Standard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));

        JCheckBoxMenuItem aff_Scientifique = new JCheckBoxMenuItem("Scientifique");
        aff_Scientifique.setSelected(false);
        aff_Scientifique.setMnemonic(KeyEvent.VK_C);
        aff_Scientifique.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

        JCheckBoxMenuItem aff_Programmeur = new JCheckBoxMenuItem("Programmeur");
        aff_Programmeur.setSelected(false);
        aff_Programmeur.setMnemonic(KeyEvent.VK_P);
        aff_Programmeur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));

        JCheckBoxMenuItem aff_Statistiques = new JCheckBoxMenuItem("Statistiques");
        aff_Programmeur.setSelected(false);
        aff_Programmeur.setMnemonic(KeyEvent.VK_T);
        aff_Programmeur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));

        JMenuItem aff_Historique = new JMenuItem("Historique");
        aff_Historique.setEnabled(false);

        JMenuItem aff_grChiffre = new JMenuItem("Groupement des Chiffres");
        aff_grChiffre.setEnabled(false);

        affichage.add(aff_Standard);
        affichage.add(aff_Scientifique);
        affichage.add(aff_Programmeur);
        affichage.add(aff_Statistiques);
        affichage.addSeparator();
        affichage.add(aff_Historique);
        affichage.add(aff_grChiffre);

    	// Fin;

    	// Tous sur l'item EDITION;

        JMenu edition = new JMenu("Edition");
        edition.setFont(new Font("Euphemia", Font.PLAIN, 14));

        JMenuItem ed_copier = new JMenuItem("Copier");
        ed_copier.setMnemonic(KeyEvent.VK_C);
        ed_copier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));


        JMenuItem ed_coller = new JMenuItem("Coller");
        ed_coller.setMnemonic(KeyEvent.VK_L);
        ed_coller.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        edition.add(ed_copier);
        edition.add(ed_coller);

    	// Fin;

        JMenu question = new JMenu("?");
        question.setFont(new Font("Euphemia", Font.PLAIN, 14));

        //Ajout des items dans le conteneur
        myMenu.add(affichage);
        myMenu.add(edition);
        myMenu.add(question);
    }

    
    public static void init()
    {

    	// Dimension du Menu panel;
        panMenu.setPreferredSize(new Dimension(300,20));
        panMenu.setOpaque(false);
        panMenu.add(barreMenu);


        // Dimension du Button panel;
        panButton.setPreferredSize(new Dimension(300,220));
        panButton.setOpaque(false);


    	// Le big display panel contenant le little panel (miniDisplay);
        panDisplay.setPreferredSize(new Dimension(300,80));
        panDisplay.setOpaque(false);
        panDisplay.add(miniDisplay);


    	// Le petit panel du display (contenant les deux labels - haut et bas - );
    	miniDisplay.setPreferredSize(new Dimension(270,60));
    	miniDisplay.setOpaque(false);
        miniDisplay.setBorder(BorderFactory.createLoweredBevelBorder());
        miniDisplay.add(displayLabelResult);


        // Les labels du resultat;
       	displayLabelResult.setForeground(COULEUR_SECONDAIRE);
       	displayLabelResult.setFont(new Font("Euphemia", Font.PLAIN, 24));
    }
}
