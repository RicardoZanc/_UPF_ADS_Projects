/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class GetInput {
    public static float Float(String Message){
        float res = Float.parseFloat(JOptionPane.showInputDialog(Message));
        return res;
    }
}
