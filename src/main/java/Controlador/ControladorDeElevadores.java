package Controlador;

import Modelo.Elevador;
import Modelo.Peticion;
import java.util.ArrayList;

public class ControladorDeElevadores {
    private ArrayList<Elevador> elevadores;
    private ArrayList<Peticion> peticionesPendientes;
    private Peticion unaPeticion;
    
    
    public ControladorDeElevadores(ArrayList<Elevador> elevadores, ArrayList<Peticion> peticionesPendientes) {
        this.elevadores = elevadores;
        this.peticionesPendientes = peticionesPendientes;
    }

    public void setElevadores(ArrayList<Elevador> elevadores) {
        this.elevadores = elevadores;
    }

    public void setPeticionesPendientes(ArrayList<Peticion> peticionesPendientes) {
        this.peticionesPendientes = peticionesPendientes;
    }
    


    public void recibirPeticion(Peticion unaPeticion){
        System.out.println("Elegir elevador. 1>Pasajeros, 2>Express, 3>De Carga");
        int origen = this.unaPeticion.getPisoOrigen();
        int destino = this.unaPeticion.getPisoDestino();
        int tipoElevador = this.unaPeticion.getElevadorElegido();
        
        peticionesPendientes.add(unaPeticion);
                
    }
    
    public void asignarPeticion(){
        
    }
    
    public void actualizarSistema(){
        
    }
    
    public void mostrarEstado(){
        
    }

    
}
