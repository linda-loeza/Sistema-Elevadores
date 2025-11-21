package Controlador;

import Modelo.Elevador;
import Modelo.Peticion;
import java.util.ArrayList;
import java.util.List;

public class ControladorDeElevadores {
    private List<Elevador> elevadores;
    private List<Peticion> peticionesPendientes;

    public ControladorDeElevadores(List<Elevador> elevadores) {
        this.elevadores = elevadores;
        this.peticionesPendientes = new ArrayList<>();
    }

    public void setElevadores(List<Elevador> elevadores) {
        this.elevadores = elevadores;
    }

    public void setPeticionesPendientes(List<Peticion> peticionesPendientes) {
        this.peticionesPendientes = peticionesPendientes;
    }

    public void recibirPeticion(Peticion peticion) {
        System.out.println("Nueva petición recibida: " + peticion);
        peticionesPendientes.add(peticion);
        asignarElevador(peticion);
    }

    private void asignarElevador(Peticion peticion) {
        Elevador mejor = null;
        int distanciaMinima = Integer.MAX_VALUE;

        for (Elevador e : elevadores) {
            int distancia = Math.abs(e.getPisoActual() - peticion.getPisoOrigen());
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                mejor = e;
            }
        }

        if (mejor != null) {
            System.out.println("Elevador #" + mejor.getId() + " asignado a la petición.");
            mejor.agregarDestino(peticion.getPisoOrigen());
            mejor.agregarDestino(peticion.getPisoDestino());
            peticionesPendientes.remove(peticion);
        }
    }

    public void actualizarSistema() {
        for (Elevador e : elevadores) {
            e.mover();
        }
    }

    public void mostrarEstado() {
        System.out.println("\nEstado actual del sistema:");
        for (Elevador e : elevadores) {
            System.out.println(e);
        }
    }
}
