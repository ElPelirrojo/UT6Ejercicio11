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
    /**
     * atributos de la clase importe
     */
    private float ventas;
    private float comision;
    /**
     * constructor de la clase importe
     * @param ventas le pasaremos las ventas cuando le creemos
     * @param comision le pasaremos la comision cuando le creemos
     */
    public Importe(float ventas, float comision) {
        this.ventas = ventas;
        this.comision = comision;
    }
    /**
     * metodo para poder acceder a las ventas
     * @return retornamos las ventas del empleado
     */
    public float getVentas() {
        return ventas;
    }
    /**
     * metodo para poder acceder a la comision
     * @return retornamos la comision del empleado
     */
    public float getComision() {
        return comision;
    }
    
}
