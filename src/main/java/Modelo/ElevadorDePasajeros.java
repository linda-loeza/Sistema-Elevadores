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
public class ElevadorDePasajeros extends Elevador{
    private int pisosPermitidos;

    public ElevadorDePasajeros(int id) {
        super(id);
    }

    public int getPisosPermitidos() {
        return pisosPermitidos;
    }

    public void setPisosPermitidos(int pisosPermitidos) {
        this.pisosPermitidos = pisosPermitidos;
    }

    @Override
    public String toString() {
        return "ElevadorDePasajeros{" + "pisosPermitidos=" + getPisosPermitidos() + '}';
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
