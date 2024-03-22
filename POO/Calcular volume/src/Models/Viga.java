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
public class Viga {
    private float base;
    private float altura;
    private float comprimento;
    private float volume;
    
    public Viga ()
    {
        this.base = GetInput.Float("Digite a base");
        this.altura = GetInput.Float("Digite a altura");
        this.comprimento = GetInput.Float("Digite o comprimento");
    }
    
    public void CalcularVolume(){
        volume = base*altura*comprimento;
        JOptionPane.showMessageDialog(null, "O volume calculado para viga informada é de " +volume+"cm³");
    }
    
}
