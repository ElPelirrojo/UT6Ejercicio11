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
public class Categoria {
    
    private String nombre;
    private float sueldo;

    public Categoria(String nombre, float sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSueldo() {
        return sueldo;
    }
    
}
