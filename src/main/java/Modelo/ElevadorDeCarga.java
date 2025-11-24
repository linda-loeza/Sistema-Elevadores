/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.FrmInicioSistema;

/**
 *
 * @author natalia-loeza
 */
public class ElevadorDeCarga extends Elevador{
    private double capacidadMaxKg = 200;
    private double cargaActualKg;

    public ElevadorDeCarga(int id, double cargaActualKg) {
        super(3);
        this.cargaActualKg = cargaActualKg;
    }

    public double getCapacidadMaxKg() {
        return capacidadMaxKg;
    }

    public double getCargaActualKg() {
        return cargaActualKg;
    }

    public void setCapacidadMaxKg(double capacidadMaxKg) {
        this.capacidadMaxKg = capacidadMaxKg;
    }

    public void setCargaActualKg(double cargaActualKg) {
        this.cargaActualKg = cargaActualKg;
    }

    @Override
    public String toString() {
        return "ElevadorDeCarga{" + "capacidadMaxKg=" + getCapacidadMaxKg() + 
                ", cargaActualKg=" + getCargaActualKg();
    }

    @Override
    public void mover() {
         //verificar el peso en kg
        System.out.println("Verificando peso...");
        if(this.cargaActualKg > this.capacidadMaxKg){
            String mensaje = "Peso excedido. Libere peso del elevador.";
            FrmInicioSistema.mostrarMensaje(mensaje);
            return;
        }
        
        if (destinos.isEmpty()) {
            return;
        }
          
        Integer siguientePiso = null;
        
        // cerrar puertas antes de mover
        if (this.puertasAbiertas) {
            cerrarPuertas();
        }

        //verificar si sube o baja
        if(this.direccion == SUBIENDO){
            siguientePiso = destinos.higher(this.pisoActualElevador);
            if(siguientePiso == null){
                this.direccion = BAJANDO;
                siguientePiso = destinos.lower(this.pisoActualElevador);
                if(siguientePiso == null){
                   siguientePiso = destinos.higher(this.pisoActualElevador);
                }
            }
        }else{
            siguientePiso = destinos.lower(this.pisoActualElevador);
            if(siguientePiso == null){
                this.direccion = SUBIENDO;
                siguientePiso = destinos.higher(this.pisoActualElevador);
                if(siguientePiso == null){
                    this.direccion = BAJANDO;
                    siguientePiso = destinos.lower(this.pisoActualElevador);
                }
            }
        }
        
        if(siguientePiso != null){
            String avisoMovimiento = "Elevador " + getId() + " Viajando del piso " + this.pisoActualElevador + " al " + siguientePiso + "...";
            FrmInicioSistema.mostrarMensaje(avisoMovimiento);

            // si el elevador no llega, va esto
            while(this.pisoActualElevador != siguientePiso) {
                this.esperarUnSegundo(); 
        
                if(this.pisoActualElevador < siguientePiso) {
                    this.pisoActualElevador++;  //va a subir 1
                    this.direccion = SUBIENDO; 
                }else{
                    this.pisoActualElevador--; // va a bajar 1
                    this.direccion = BAJANDO;
                }
                String paso = "Elevador " + getId() + " ... Pasando por piso " + getPisoActualElevador();
                System.out.println(paso);
                Vista.FrmInicioSistema.mostrarMensaje(paso);
            }
    
            
            abrirPuertas();
            destinos.remove(this.pisoActualElevador); //eliminamos el destino ya que llegamos

            System.out.println("ELEVADOR: Estoy en " + pisoActualElevador + ". Destinos pendientes: " + destinos);

            if(!destinos.isEmpty()) {
                if(this.direccion == SUBIENDO) {
                    if(destinos.higher(this.pisoActualElevador) != null) {
                        this.direccion = SUBIENDO; 
                    }else{
                        this.direccion = BAJANDO; 
                    }
                }else if(this.direccion == BAJANDO) {
                    if(destinos.lower(this.pisoActualElevador) != null) {
                        this.direccion = BAJANDO; // Seguimos bajando
                    }else{
                        this.direccion = SUBIENDO;
                    }
                }else{
                    if(destinos.higher(this.pisoActualElevador) != null) this.direccion = SUBIENDO;
                        else this.direccion = BAJANDO;
                }               
            }else{
                this.direccion = PARADO;
            }
        }
        
        String pisoElevador = "Elevador llego al piso "+ getPisoActualElevador();
        FrmInicioSistema.mostrarMensaje(pisoElevador);
        
            //para saber si hay algun destino al que hay que ir
            if(!destinos.isEmpty()) {
                if (destinos.higher(this.pisoActualElevador) != null) {
                this.direccion = SUBIENDO;
            }else if(destinos.lower(this.pisoActualElevador) != null) {
                this.direccion = BAJANDO;
            }
            
            }else{
                this.direccion = PARADO;
            }
            
        } 
    
}