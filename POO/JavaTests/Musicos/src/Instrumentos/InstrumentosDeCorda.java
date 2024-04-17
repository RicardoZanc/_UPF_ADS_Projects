/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instrumentos;

/**
 *
 * @author ricar
 */
public abstract class InstrumentosDeCorda extends Instrumento{
    private String cordas;
    private String marca;
    private String modelo;

    public InstrumentosDeCorda(String cordas, String marca, String modelo) {
        this.cordas = cordas;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getCordas() {
        return cordas;
    }

    public void setCordas(String cordas) {
        this.cordas = cordas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
