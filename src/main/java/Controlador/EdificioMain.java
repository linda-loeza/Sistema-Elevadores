/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;
import Modelo.*;
import Controlador.ControladorDeElevadores;
import java.util.ArrayList;

/**
 *
 * @author natalia-loeza
 */
public class EdificioMain {

    /**
     * @param args the command line arguments
     */
    
    private final int numeroDePisos = 10;
    private ControladorDeElevadores controlador;
    private ArrayList<Elevador> losElevadores;

    public EdificioMain(ControladorDeElevadores controlador, ArrayList<Elevador> losElevadores) {
        this.controlador = controlador;
        this.losElevadores = losElevadores;
    }
    
    public ControladorDeElevadores getControladorDeElevadores() {
        return controlador;
    }
    
    public static void main(String[] args) {
        EdificioMain edificio = new EdificioMain();
        
        // 2. Iniciamos la Simulación Gráfica
        edificio.iniciarSimulacion();
        
    }
    
    public EdificioMain(){
        losElevadores = new ArrayList<>();
        
        //creamos los objetos especificos
        ElevadorDePasajeros pasajeros = new ElevadorDePasajeros(1);
        losElevadores.add(pasajeros);
        
        // ID 2: Express (Solo piso 1 y 10)
        ElevadorExpress express = new ElevadorExpress(2);
        losElevadores.add(express);
        
        // ID 3: Carga (Con capacidad inicial)
        ElevadorDeCarga carga = new ElevadorDeCarga(3, 0.0);
        losElevadores.add(carga);
        
        this.controlador = new ControladorDeElevadores(losElevadores);
    }
    
    public void iniciarSimulacion(){
        //AQUI VA EL FRM DE INCIO DEL GUI
        //frmInicio.setVisible(true);
    }
    
    public void realizarPeticion(int piso, int direccion, int tipoElevador){
        System.out.println("Solicitud recibida: De piso " + piso + " a piso " + direccion + "Elevador de tipo " + tipoElevador);
        Peticion unaPeticion = new Peticion(piso,direccion, tipoElevador);
        unaPeticion.setElevadorElegido(tipoElevador);
        
        controlador.recibirPeticion(unaPeticion);
        controlador.asignarPeticion();
    }
    
}
