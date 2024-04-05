/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;


/**
 *
 * @author ricar
 */
public class Pessoa {
    private String nome;
    private long cpf;
    private float peso;
    private float altura;
    private float imc;
    private String interpretacao;
    
    public Pessoa(String nome, long cpf, float peso, float altura){
        this.nome = nome;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;        
        this.setImc();
        this.setInterpretacao();
        
    }
    
    public String[] stringfyPessoa(){
        String[] stringfiedPessoa = {
            nome,
            Long.toString(cpf),
            String.format("%.02f kg",peso),
            String.format("%.02f m", altura),
            String.format("%.02f", imc),
            interpretacao
        };
        return stringfiedPessoa;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc() {
        imc = Imc.calcular(this.getPeso(), this.getAltura());
    }

    public String getInterpretacao() {
        return interpretacao;
    }

    public void setInterpretacao() {
        interpretacao = Imc.interpretacao(this.getImc());
    }
}
