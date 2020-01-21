/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut6ejercicio11;

/**
 *
 * @author dam
 */
public class Importe {
    
    private float ventas;
    private float comision;

    public Importe(float ventas, float comision) {
        this.ventas = ventas;
        this.comision = comision;
    }

    public float getVentas() {
        return ventas;
    }

    public float getComision() {
        return comision;
    }
    
}
