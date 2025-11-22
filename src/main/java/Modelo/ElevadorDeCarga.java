/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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
         //verificar el pesos
        System.out.println("Verificando peso...");
        if(this.cargaActualKg > this.capacidadMaxKg){
            System.out.println("Peso excedido. Libere peso del elevador.");
            return;
        }
        
        if (destinos.isEmpty()) {
            return;
        }
          
        Integer siguientePiso = null;
        
        // Cerrar puertas antes de mover
        if (this.puertasAbiertas) {
            cerrarPuertas();
        }

        //Verificar si sube o baja
        
        if(this.direccion == SUBIENDO){
            siguientePiso = destinos.higher(this.pisoActual);
            if(siguientePiso == null){
                this.direccion = BAJANDO;
                siguientePiso = destinos.lower(this.pisoActual);
                if(siguientePiso == null){
                   siguientePiso = destinos.higher(this.pisoActual);
                }
            }
        }else{
            siguientePiso = destinos.lower(this.pisoActual);
            if(siguientePiso == null){
                this.direccion = SUBIENDO;
                siguientePiso = destinos.higher(this.pisoActual);
                if(siguientePiso == null){
                    this.direccion = BAJANDO;
                    siguientePiso = destinos.lower(this.pisoActual);
                }
            }
        }
        if(siguientePiso != null){
            this.esperarUnSegundo();
            this.pisoActual = siguientePiso;
            abrirPuertas();
        
            destinos.remove(this.pisoActual); //eliminamos el destino ya que llegamos
        
            System.out.println("Elevador en el piso" + getPisoActual());
            
        } 
    } 
}