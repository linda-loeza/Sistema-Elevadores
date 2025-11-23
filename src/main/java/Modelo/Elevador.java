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
    protected int pisoActualElevador;
    protected boolean puertasAbiertas;
    protected ArrayList<Peticion> peticionesAsignadas;
    protected int direccion;
    protected Peticion peticion;
    
    //para tener la lista de pisos destino ordenado
    protected TreeSet<Integer> destinos;
    
    public static final int SUBIENDO = 1;
    public static final int BAJANDO = -1;
    public static final int PARADO = 0;
    
    //contructor elevador modificado
    public Elevador(int id){
        this.id = id;
        this.pisoActualElevador = 1;
        this.direccion = PARADO;
        this.destinos= new TreeSet<>();
    }


    
    public int getId() {
        return id;
    }

    public int getPisoActualElevador() {
        return pisoActualElevador;
    }

    public boolean isPuertasAbiertas() {
        return puertasAbiertas;
    }

    public ArrayList<Peticion> getPeticionesAsignadas() {
        return peticionesAsignadas;
    }

    public void setPisoActualElevador(int pisoActualElevador) {
        this.pisoActualElevador = pisoActualElevador;
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
                ", pisoActual=" + getPisoActualElevador() + 
                ", puertasAbiertas=" + isPuertasAbiertas() + 
                ", peticionesAsignadas=" + getPeticionesAsignadas();
    }
    
    public abstract void mover();
    

    public void agregarDestino(int pisoOrigen, int pisoDireccion){
        
        if (!(this.direccion == PARADO && this.pisoActualElevador == pisoOrigen)) {
            this.destinos.add(pisoOrigen); //el elevador sabra en donde esta el pasajero
        } else { //si ya esta en el piso y esta parado el elevador
            System.out.println("Elevador ya está en el piso de origen. Abriendo puertas.");
            abrirPuertas(); 
        }
        
        boolean agregado = this.destinos.add(pisoDireccion); //el elevador sabra a donde quiere ir el pasajero
        
        if(agregado){
            System.out.println("Elevador " +getId() + 
                ": Destino " + getPisoActualElevador() + " agregado. Destinos actuales: " + destinos);
        }
    }
    
    public void procesarMovimiento(){
        if (destinos.isEmpty()) {
            if(this.direccion != PARADO){
                this.direccion = PARADO;
            }
            return;
        }
        
        if(this.direccion == PARADO){
            if(destinos.higher(this.pisoActualElevador) != null){
                this.direccion = SUBIENDO;
            }else if(destinos.lower(this.pisoActualElevador) != null){
                this.direccion = BAJANDO;
            } 
        }else{ //por si el destino es el piso actual.
                //abrimos puertas y lo sacamos de la lista.
            System.out.println("Elevador " + id + " ya está en el piso. Abriendo puertas.");
            abrirPuertas();
            destinos.remove(this.pisoActualElevador);
            return; // Terminamos aquí, no hace falta llamar a mover()
        }
        mover();
    }
    
    public void cerrarPuertas() {
        this.puertasAbiertas = false;
        System.out.println("Puertas cerrando...");
    }

    public void abrirPuertas() {
        this.puertasAbiertas = true;
        System.out.println("Puertas abriendo...");
    }
    
    public void esperarUnSegundo() {
        try {
            Thread.sleep(1000); // Pausa el programa 1 seg
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public String direccionToString() {
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
