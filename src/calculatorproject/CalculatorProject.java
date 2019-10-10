/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorproject;

/**
 *
 * @author Draggem
 */
public class CalculatorProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Auto load basic from on Open
        CalculatorExtendedView frame = new CalculatorExtendedView();
        frame.setVisible(true);
        frame.setBounds(500,0,360,480);
        frame.setTitle("Calculator Project v1.1");
    }
    
}
