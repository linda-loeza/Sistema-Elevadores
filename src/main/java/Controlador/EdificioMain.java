/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.FrmInicioSistema;
import java.util.ArrayList;

/**
 *
 * @author natalia-loeza
 */
public class EdificioMain {

    /**
     * @param args the command line arguments
     */
    
    FrmInicioSistema inicioMenu = new FrmInicioSistema();
    
    private final int numeroDePisos = 10;
    public static ControladorDeElevadores controlador;
    public ArrayList<Elevador> losElevadores;

    public EdificioMain(ControladorDeElevadores controlador, ArrayList<Elevador> losElevadores) {
        this.controlador = controlador;
        this.losElevadores = losElevadores;
    }
    
    public ControladorDeElevadores getControladorDeElevadores() {
        return controlador;
    }
    
    public static void main(String[] args) {
        EdificioMain edificio = new EdificioMain();
        edificio.iniciarSimulacion();
        
    }
    
    public EdificioMain(){
        losElevadores = new ArrayList<>();
        
        //creamos los objetos especificos
        ElevadorDePasajeros pasajeros = new ElevadorDePasajeros(1);
        losElevadores.add(pasajeros);
        
        ElevadorExpress express = new ElevadorExpress(2);
        losElevadores.add(express);
        
        ElevadorDeCarga carga = new ElevadorDeCarga(3, 0.0);
        losElevadores.add(carga);
        
        this.controlador = new ControladorDeElevadores(losElevadores);
    }
    
    public void iniciarSimulacion(){
        FrmInicioSistema.edificio = this;
        inicioMenu.setVisible(true);
    }
    
    public void realizarPeticion(int piso, int direccion, int tipoElevador){
        System.out.println("Solicitud recibida: De piso " + piso + " a piso " + direccion + "Elevador de tipo " + tipoElevador);
        Peticion unaPeticion = new Peticion(piso,direccion, tipoElevador);
        unaPeticion.setElevadorElegido(tipoElevador);
        
        controlador.recibirPeticion(unaPeticion);
        controlador.asignarPeticion();
    }
    
}
