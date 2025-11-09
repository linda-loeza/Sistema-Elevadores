/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author natalia-loeza
 */
public class Peticion {
    private int pisoOrigen;
    private int pisoDestino;

    public Peticion(int pisoOrigen, int pisoDestino) {
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
    }

    public int getPisoOrigen() {
        return pisoOrigen;
    }

    public void setPisoOrigen(int pisoOrigen) {
        this.pisoOrigen = pisoOrigen;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    @Override
    public String toString() {
        return "Peticion{" + "pisoOrigen=" + getPisoOrigen() + 
                ", pisoDestino=" + getPisoDestino() + '}';
    }
    
    
}
