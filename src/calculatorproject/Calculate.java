/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorproject;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Draggem
 */
public final class Calculate {
    private static final double PI = Math.PI; //Used for PI button
    private static final double E = Math.E; //Used for E buton
    private double num1 = 0; //Input 1
    private double num2 = 0; //Input 2
    private double answer = 0; //Output Answer
    private char op; //Input Operation Selected


    
    
    
    //Constructor 
    public Calculate(){
        reset();
    }
    
    /**
     * Resets the whole calculator values
     */
    public void reset(){
        setNum1(0);
        setNum2(0);
        answer = 0;
    }
    
    
    
    /**
     * Sin Cos Tan asin acos atan functions (Also automatically converts to degrees and radians accordingly if Degrees is selected)
     * @param oper
     * @param isDegrees 
     */
    public void extendedOperations(String oper, boolean isDegrees){
        try{
            if (!isDegrees){
            switch (oper){
                case "sin": answer = Math.sin(num1);
                    break;
                case "cos": answer = Math.cos(num1);
                    break;
                case "tan": answer = Math.tan(num1);
                    break;
                case "asin":answer = Math.asin(num1);
                    break;
                case "acos":answer = Math.acos(num1);
                    break;
                case "atan":answer = Math.atan(num1);
                    break;
            }
        }
        else{ 
            switch (oper){
                case "sin": answer = Math.sin(Math.toRadians(num1));
                    break;
                case "cos": answer = Math.cos(Math.toRadians(num1)); //Convert INPUT from degrees to radians
                    break;
                case "tan": answer = Math.tan(Math.toRadians(num1));
                    break;
                case "asin":answer = Math.toDegrees(Math.asin(num1));
                    break;
                case "acos":answer = Math.toDegrees(Math.acos(num1));//Convert ANSWER from Radians to Degrees
                    break;
                case "atan":answer = Math.toDegrees(Math.atan(num1));
                    break;
            }
            
        }
            
        } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null,
                "Error: You must enter an integer0" + nfe);

       } catch (ArithmeticException ae) {
          JOptionPane.showMessageDialog(null,
                "Error!" + ae);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, 
                    "ERROR: Invalid Input" + e, "Error |0|0|||0|",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /**
     * Sets the Current Selected Operation for Calculation
     * @param op 
     */
    public void setOp(char op) {
        this.op = op;
    }

    /**
     * @return the answer
     */
    public double getAnswer() {
        return answer;
    }

    /**
     * @param num1 the num1 to set
     */
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    /**
     * @param num2 the num2 to set
     */
    public void setNum2(double num2) {
        this.num2 = num2;
    }

    /**
     * @return the PI
     */
    public static double getPI() {
        return PI;
    }

    /**
     * @return the E
     */
    public static double getE() {
        return E;
    }
    
/**
 * Basic Operations and Power Functions
 */
    public void calculate(){
        try{
            switch(op){
            case '+': answer = getNum1() + getNum2();
                break;
            case '-': answer = getNum1() - getNum2();
                break; 
            case '*': answer = getNum1() * getNum2();
                break;
            case '/': if (num1 == 0 || num2 == 0){
                 JOptionPane.showMessageDialog(null, "ERROR: Division by zero is not allowed", "Error 42",javax.swing.JOptionPane.ERROR_MESSAGE);

            }    else{answer = getNum1() / getNum2();}            
                break;
            case 'p': answer = Math.pow(getNum1(), getNum2());
        }
            
        }catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null,
                "Error: You must enter an integer0" + nfe);

       } catch (ArithmeticException ae) {
          JOptionPane.showMessageDialog(null,
                "Error!" + ae);
        }
        catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR: Invalid Input", "Error |0|0|||0|",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
        
    }

    /**
     * @return Encapsulate the num1
     */
    public double getNum1() {
        return num1;
    }

    /**
     * @return the num2
     */
    public double getNum2() {
        return num2;
    }
    
    
    /**
     * Fraction Method
     * @return 
     */
    public String fraction(){
        if (num1 == 0){
             JOptionPane.showMessageDialog(null, "ERROR: Division by zero is not allowed", "Error 42",javax.swing.JOptionPane.ERROR_MESSAGE);
             return "";
        }else{
        answer = 1 / num1;
        return String.valueOf(answer);
        }
        
    }
    
    /**
     * Opposite (Negative and Positive) Method
     * @return 
     */
    public String opposites(){
        answer = num1 * -1;
        
        return String.valueOf(answer); //returns as String automatically
    }
    

/**
 * Factorial Method
 * @return 
 */
    public String factorial(){
        int fact = 1;
        
        if (num1 > -1 && num1 < 21){
            double number = num1;
            if (num1 == (int)num1){
                for(int i=1;i<=number;i++){    
                fact=fact*i;
                }
                return String.valueOf(fact);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR: Please provide a positive integer between 0 - 20", "Error 808",javax.swing.JOptionPane.ERROR_MESSAGE);
                return "";
            }
            
            
        }else{
            JOptionPane.showMessageDialog(null, "ERROR: Please provide a positive integer between 0 - 20", "Error 808",javax.swing.JOptionPane.ERROR_MESSAGE);
            return "";
            
        }
        
        
    }
    
    
}

