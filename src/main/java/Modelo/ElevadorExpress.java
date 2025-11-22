/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import Modelo.*;
import Controlador.*;

/**
 *
 * @author natalia-loeza
 */
public class ElevadorExpress extends Elevador {
    private int pisosPermitidos;

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
        
        if (this.pisoActual != 1 && this.pisoActual != 10) {
            System.out.println("Elevador no disponible");
            return;
        }
        
        // Cerrar puertas antes de mover
        if (this.puertasAbiertas) {
            cerrarPuertas();
        }
        
        if(this.pisoActual == 1){
            if(destinos.contains(10)){
                siguientePiso = 10;
            }else{
                System.out.println("Elevador no disponible.");
            }
        }else if(this.pisoActual == 10){
            if(destinos.contains(1)){
                siguientePiso = 1;
            }else{
                System.out.println("Elevador no disponible.");
            }
        }
        
        if(siguientePiso != null){
            this.pisoActual = siguientePiso;
            this.esperarUnSegundo();
            abrirPuertas();
            
            System.out.println("Elevador en el piso " + this.getPisoActual());
            destinos.remove(this.pisoActual);
        }       
    }   
}
