/**
 * @author           Serge Kishiko <sergekishiko@gmail.com>
 * @copyright        (c) 2018, Serge Kishiko. All Rights Reserved.
 * @link             https://github.com/Kishiko
 */

package core;

import calculator.Calculator;
import controls.JMyButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Serge
 */
public class EngineCalculate implements ActionListener
{
    private static boolean update = false, clicOperator = false;
    private static double chiffre;
    private static String actionSelected = "";

    Calculator parent;

    // Constructor;
    public EngineCalculate(Calculator parent)
    {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e)
    {
        String textBoutton = ((JMyButton) e.getSource()).getText();

        if(null != textBoutton)

        // Si le boutton est numerique;
        switch (textBoutton) 
        {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                chiffreEngine(textBoutton);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operatorEngine(textBoutton);
                break;
            case "=":
                egalEngine();
                break;
            case "C":
                clicOperator = false;
                update = true;
                chiffre = 0;
                actionSelected = "";
                Calculator.displayLabelResult.setText("0");
                break;
            case "CE":
                update = true;
                Calculator.displayLabelResult.setText("0");
                break;
            case "<-":
                String original = Calculator.displayLabelResult.getText();
                int longueur = original.length();
                Calculator.displayLabelResult.setText(original.substring(0,longueur-1));
                break;
            case ",":
                Calculator.displayLabelResult.setText(Calculator.displayLabelResult.getText()+".");
                break;
            case "V":
            {
                String valeur = Calculator.displayLabelResult.getText();
                double valeurInt = Double.parseDouble(valeur);
                Calculator.displayLabelResult.setText(""+Math.sqrt(valeurInt));
                break;
            }
            case "1/x":
            {
                double valeur = Double.parseDouble(Calculator.displayLabelResult.getText());
                Calculator.displayLabelResult.setText(""+1/valeur);
                break;
            }
            case "%":
                Calculator.displayLabelResult.setText("0");
                break;
            case "+ou-":
            {
                double valeur = Double.parseDouble(Calculator.displayLabelResult.getText());
                Calculator.displayLabelResult.setText("" + valeur*-1);
                break;
            }
            case "MC":
            case "MS":
            case "MR":
            case "M+":
            case "M-":
                Calculator.displayLabelResult.setText("0");
                break;
            default:
                break;
        }
    }
    
    // La methode de bouttons numeriques;
    public void chiffreEngine(String textBoutton)
    {
        if(update)	
            update = false;
        else
        {
            if(!Calculator.displayLabelResult.getText().equals("0"))
                textBoutton = Calculator.displayLabelResult.getText() + textBoutton;
        }

        Calculator.displayLabelResult.setText(textBoutton);
    }

    // La methode des bouttons "Operateurs";
    public void operatorEngine(String textBoutton)
    {
        if(clicOperator)
        {
            calcul();
            Calculator.displayLabelResult.setText(String.valueOf(chiffre));
        }
        else
        {
            chiffre = Double.parseDouble(Calculator.displayLabelResult.getText());
            clicOperator = true;
        }

        if("+".equals(textBoutton))	actionSelected = " + ";
        if("-".equals(textBoutton))	actionSelected = " - ";
        if("*".equals(textBoutton))	actionSelected = " * ";
        if("/".equals(textBoutton))	actionSelected = " / ";

        Calculator.displayLabelResult.setText(Calculator.displayLabelResult.getText()+actionSelected);
        update = true;
    }

    // La methode du signe d'egalite;
    public void egalEngine()
    {
        calcul();
        Calculator.displayLabelResult.setText(Calculator.displayLabelResult.getText());
        update = true;
        clicOperator = false;
    }

    // Je calcule tout;
    private void calcul()
    {

        switch (actionSelected) 
        {
            case " + ":
                chiffre = chiffre + Double.parseDouble(Calculator.displayLabelResult.getText());
                Calculator.displayLabelResult.setText(String.valueOf(chiffre));
                break;
            case " - ":
                chiffre = chiffre - Double.parseDouble(Calculator.displayLabelResult.getText());
                Calculator.displayLabelResult.setText(String.valueOf(chiffre));
                break;
            case " * ":
                chiffre = chiffre * Double.parseDouble(Calculator.displayLabelResult.getText());
                Calculator.displayLabelResult.setText(String.valueOf(chiffre));
                break;
            case " / ":
                try
                {
                    chiffre = chiffre / Double.parseDouble(Calculator.displayLabelResult.getText());
                    Calculator.displayLabelResult.setText(String.valueOf(chiffre));
                }
                catch(ArithmeticException e)
                {
                    Calculator.displayLabelResult.setText("0");
                }
                break;
            default:
                break;
        }
    }
}
