/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author natalia-loeza
 */
public class ElevadorDeCarga extends Elevador{
    private double capacidadMaxKg;
    private double cargaActualKg;

    public ElevadorDeCarga(int id) {
        super(id);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
