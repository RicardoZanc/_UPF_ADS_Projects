/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author ricar
 */
public class Estatistica {
    public int muitoAbaixo;
    public int abaixo;
    public int normal;
    public int acima;
    public int obesidadeI;
    public int obesidadeII;
    public int obesidadeIII;
    
    public void Zerar(){
        muitoAbaixo = 0;
        abaixo = 0;
        normal = 0;
        acima = 0;
        obesidadeI = 0;
        obesidadeII = 0;
        obesidadeIII = 0;
    }
    
    public void Teste(Pessoa p){
        if(p.getImc() < 17f){
            muitoAbaixo++;
        }
        else if(p.getImc() < 18.5f){
            abaixo++;
        }
        else if(p.getImc() < 25f){
            normal++;
        }
        else if(p.getImc() < 30f){
            acima++;
        }
        else if(p.getImc() < 35f){
            obesidadeI++;
        }
        else if(p.getImc() <= 40f){
            obesidadeII++;
        }
        else {
            obesidadeIII++;
        }
    }
    
    public void Imprime(){
        System.out.println("Muito abaixo: "+muitoAbaixo);
        System.out.println("Abaixo: "+abaixo);
        System.out.println("Normal: "+normal);
        System.out.println("Acima: "+acima);
        System.out.println("Obesidade I: "+obesidadeI);
        System.out.println("Obesidade II: "+obesidadeII);
        System.out.println("Obesidade III: "+obesidadeIII);
    }
}
