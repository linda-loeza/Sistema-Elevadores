/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.*;
import Vista.FrmInicioSistema;

/**
 *
 * @author natalia-loeza
 */
public class ElevadorExpress extends Elevador {
    private int pisosPermitidos;
    private static ControladorDeElevadores unControlador;

    public ElevadorExpress(int id) {
        super(2);
    }

    public int getPisosPermitidos() {
        return pisosPermitidos;
    }

    public void setPisosPermitidos(int pisosPermitidos) {
        this.pisosPermitidos = pisosPermitidos;
    }

    @Override
    public void mover() {

        if (destinos.isEmpty()) {
            return;
        }
          
        Integer siguientePiso = null;
        
        if (this.pisoActualElevador != 1 && this.pisoActualElevador != 10) {
            String mensaje = "Elevador no disponible";
            FrmInicioSistema.mostrarMensaje(mensaje);
            return;
        }
        
        if (this.puertasAbiertas) {
            cerrarPuertas();
        }
        
        if(this.pisoActualElevador == 1){
            if(destinos.contains(10)){
                siguientePiso = 10;
            }else{
                String mensaje = "Elevador no disponible.";
                FrmInicioSistema.mostrarMensaje(mensaje);
            }
        }else if(this.pisoActualElevador == 10){
            if(destinos.contains(1)){
                siguientePiso = 1;
            }else{
                String mensaje = "Elevador no disponible.";
                FrmInicioSistema.mostrarMensaje(mensaje);
            }
        }
        
        if(siguientePiso != null){
            String avisoMovimiento = "Elevador " + getId() + " Viajando del piso " + this.pisoActualElevador + " al " + siguientePiso + "...";
            FrmInicioSistema.mostrarMensaje(avisoMovimiento);

            while (this.pisoActualElevador != siguientePiso){
                this.esperarUnSegundo(); 
        
                if (this.pisoActualElevador < siguientePiso){
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

            if(!destinos.isEmpty()){
                if(this.direccion == SUBIENDO){
                    if(destinos.higher(this.pisoActualElevador) != null){
                        this.direccion = SUBIENDO; 
                    }else{
                        this.direccion = BAJANDO; 
                    }
                }else if(this.direccion == BAJANDO){
                    if(destinos.lower(this.pisoActualElevador) != null){
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
            if (!destinos.isEmpty()){
                if (destinos.higher(this.pisoActualElevador) != null){
                this.direccion = SUBIENDO;
            }else if (destinos.lower(this.pisoActualElevador) != null){
                this.direccion = BAJANDO;
            }
            
            }else{
                this.direccion = PARADO;
            }
            
        } 
}
