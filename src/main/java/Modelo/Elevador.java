/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author natalia-loeza
 */
public abstract class Elevador {
    protected final int id;
    protected int pisoActual;
    protected boolean puertasAbiertas;
    protected ArrayList<Peticion> peticionesAsignadas;
    protected int direccion;
    
    public static final int SUBIENDO = 1;
    public static final int BAJANDO = -1;
    public static final int PARADO = 0;

    //para tener la lista de pisos destino ordenado
    protected TreeSet<Integer> destinos;
    
    //contructor elevador modificado
    public Elevador(int id){
        this.id = id;
        this.pisoActual = 1;
        this.direccion = PARADO;
        this.destinos= new TreeSet<>();
    }

    public void agregarDestino(int pisoActual){
        //si ya esta en el piso y esta parado el elevador
        if(pisoActual == this.pisoActual && this.direccion == PARADO){
            return;
        }
        
        boolean agregado = this.destinos.add(pisoActual);
        
        if(agregado){
            System.out.println("Elevador " +getId() + 
                ": Destino " + getPisoActual() + " agregado. Destinos actuales: " + destinos);
    
        }
        
    }
    
    public int getId() {
        return id;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public boolean isPuertasAbiertas() {
        return puertasAbiertas;
    }

    public ArrayList<Peticion> getPeticionesAsignadas() {
        return peticionesAsignadas;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public void setPuertasAbiertas(boolean puertasAbiertas) {
        this.puertasAbiertas = puertasAbiertas;
    }

    public void setPeticionesAsignadas(ArrayList<Peticion> peticionesAsignadas) {
        this.peticionesAsignadas = peticionesAsignadas;
    }

    @Override
    public String toString() {
        return "id=" + getId() + 
                ", pisoActual=" + getPisoActual() + 
                ", puertasAbiertas=" + isPuertasAbiertas() + 
                ", peticionesAsignadas=" + getPeticionesAsignadas();
    }
    
    public abstract void mover();
    
    private String direccionToString() {
        switch (this.direccion) {
            case SUBIENDO:
                return "SUBIENDO";
            case BAJANDO:
                return "BAJANDO";
            case PARADO:
                return "PARADO";
            default:
                return "DESCONOCIDO";
        }
    }
    
}
