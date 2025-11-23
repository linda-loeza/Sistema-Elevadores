package Controlador;

import Modelo.*;
import static Modelo.Elevador.BAJANDO;
import static Modelo.Elevador.SUBIENDO;
import Modelo.Peticion;
import java.util.ArrayList;

public class ControladorDeElevadores {
    private ArrayList<Elevador> elevadores;
    private ArrayList<Peticion> peticionesPendientes;
    private Peticion unaPeticion;
    
    
    public ControladorDeElevadores(ArrayList<Elevador> elevadores) {
        this.elevadores = elevadores;
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
        
        if (this.peticionesPendientes.isEmpty()) {
            return;
        }
        
        // sacamos la petición (Usamos remove(0) para revisar la primera y sacarla de la fila)
        Peticion peticionActual = this.peticionesPendientes.remove(0);
        int elevadorElegidoFinal = peticionActual.getElevadorElegido();
        boolean elevadorCorrecto = false;
        
        for(int i=0; i<elevadores.size(); i++){
            Elevador elevadorActual = elevadores.get(i);
            int elevadorActualId = elevadores.get(i).getId();
            elevadorCorrecto = false;
            
                switch(elevadorElegidoFinal){
                    case 1:
                        if(elevadorActual instanceof ElevadorDePasajeros){
                            elevadorCorrecto = true;
                            break;
                        }
                    case 2:
                        if(elevadorActual instanceof ElevadorExpress){
                            elevadorCorrecto = true;
                            break;
                        }
                    case 3:
                        if(elevadorActual instanceof ElevadorDeCarga){
                            elevadorCorrecto = true;
                            break;
                        }
                }
                
                if(elevadorCorrecto){
                    System.out.println("Asignando tarea al Elevador: " + elevadorActual.getId());
                    
                    elevadorActual.agregarDestino(peticionActual.getPisoOrigen(),peticionActual.getPisoDestino() );
            
                    elevadorActual.mover();
            
                    return;
                }
        }
        System.out.println("No se encontro elevador disponible.");
                
    }
    
    public void actualizarSistema(){
        //Ciclo de Simulación
        for(int i=0; i<elevadores.size();i++){
            elevadores.get(i).procesarMovimiento();
        }
    }
    
    public void mostrarEstado(){
        //polimorfismo
        for (int i = 0; i < elevadores.size(); i++) {
            Elevador unElevador = elevadores.get(i);
            System.out.println(unElevador.toString()); 
        }
    }
}
