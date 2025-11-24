/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Peticion {
    private int pisoOrigen;
    private int pisoDestino;
    private int elevadorElegido;

    public Peticion(int pisoOrigen, int pisoDestino, int elevadorElegido) {
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
        this.elevadorElegido = elevadorElegido;
    }

    public int getPisoOrigen() {
        return pisoOrigen;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
    
    public int getElevadorElegido() {
        return elevadorElegido;
    }

    public void setPisoOrigen(int pisoOrigen) {
        this.pisoOrigen = pisoOrigen;
    }
    
    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    public void setElevadorElegido(int elevadorElegido) {
        this.elevadorElegido = elevadorElegido;
    }
    
    @Override
    public String toString() {
        return "Peticion{" + "pisoOrigen=" + getPisoOrigen() + 
                ", pisoDestino=" + getPisoDestino() + '}';
    }
    
    
}
