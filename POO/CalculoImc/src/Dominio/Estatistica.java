/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Telas.Principal;

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
    
    public String muitoAbaixoPorcentagem;
    public String abaixoPorcentagem;
    public String normalPorcentagem;
    public String acimaPorcentagem;
    public String obesidadeIPorcentagem;
    public String obesidadeIIPorcentagem;
    public String obesidadeIIIPorcentagem;
    
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
    
    public void definePorcentagem(int QtdePessoas){
        float muitoAbaixoPorcentagem = (muitoAbaixo*100)/QtdePessoas;
        this.muitoAbaixoPorcentagem = String.format("%.02f", muitoAbaixoPorcentagem);
        
        float abaixoPorcentagem = (abaixo*100)/QtdePessoas;
        this.abaixoPorcentagem = String.format("%.02f", abaixoPorcentagem);
        
        float normalPorcentagem = (normal*100)/QtdePessoas;
        this.normalPorcentagem = String.format("%.02f", normalPorcentagem);
        
        float acimaPorcentagem = (acima*100)/QtdePessoas;
        this.acimaPorcentagem = String.format("%.02f", acimaPorcentagem);
        
        float obesidadeIPorcentagem = (obesidadeI*100)/QtdePessoas;
        this.obesidadeIPorcentagem = String.format("%.02f", obesidadeIPorcentagem);
        
        float obesidadeIIPorcentagem = (obesidadeII*100)/QtdePessoas;
        this.obesidadeIIPorcentagem = String.format("%.02f", obesidadeIIPorcentagem);
        
        float obesidadeIIIPorcentagem = (obesidadeIII*100)/QtdePessoas;
        this.obesidadeIIIPorcentagem = String.format("%.02f", obesidadeIIIPorcentagem);
        
    }
    
    
    
}
