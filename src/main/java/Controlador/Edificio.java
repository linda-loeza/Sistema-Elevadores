/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author natalia-loeza
 */
public class Edificio {
    private ControladorDeElevadores controlador;
    private final int numeroDePisos = 10;

    public Edificio(int numElevadores) {
        this.listaDeElevadores = new ArrayList<>();
        //un elevador de carga y uno de express, los demas seran para pasajeros
        listaDeElevadores.add(new ElevadorDeCarga(0));
        listaDeElevadores.add(new ElevadorExpress(1));
        
        for(int i=2; i<(numElevadores+2); i++){
            listaDeElevadores.add(new ElevadorDePasajeros(i));
        }
        
        this.controlador = new ControladorDeElevadores(listaDeElevadores);
         
    }
    
    public void iniciarSimulacion(){
        //AQUI VA EL FRM DE INCIO DEL GUI
        //frmInicio.setVisible(true);
    }
    
    public void realizarPeticion(int piso, int direccion, int tipoElevador){
        System.out.println("Solicitud recibida: De piso " + piso + " a piso " + direccion + "Elevador de tipo " + tipoElevador);
        this.peticion.setPisoOrigen(piso);
        this.peticion.setPisoDestino(direccion);
        controlador.procesarPeticion(peticion);
    }
}
