/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author natalia-loeza
 */
public class ElevadorDePasajeros extends Elevador{
    
    public ElevadorDePasajeros(int id) {
        super(1);
    }

    @Override
    public String toString() {
        return "ElevadorDePasajeros " + super.toString();
    }
    

    @Override
    public void mover() {
        System.out.println("--- Iniciando movimiento ---");
        
        if (destinos.isEmpty()) {
            return;
        }
          
        Integer siguientePiso = null;
        
        // Cerrar puertas antes de mover
        if (this.puertasAbiertas) {
            cerrarPuertas();
        }

        // 2. Verificar si sube o baja
        
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
            this.esperarUnSegundo();
            this.pisoActualElevador = siguientePiso;
            abrirPuertas();
        
            destinos.remove(this.pisoActualElevador); //eliminamos el destino ya que llegamos
        
            System.out.println("Elevador en el piso" + getPisoActualElevador());
            
        } 
    } 
}
