/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author ricar
 */
public class Imc {
    public static float calcular(float peso, float altura){
        return peso/(altura*altura);
    }
    
    public static String interpretacao(float imc){
        if(imc < 17f){
            return "Muito abaixo do peso";
        }
        else if(imc < 18.5f){
            return "Abaixo do peso";
        }
        else if(imc < 25f){
            return "Peso normal";
        }
        else if(imc < 30f){
            return "Acima do peso";
        }
        else if(imc < 35f){
            return "Obesidade grau I";
        }
        else if(imc <= 40f){
            return "Obesidade grau II";
        }
        else {
            return "Obesidade grau III";
        }
    }
}
