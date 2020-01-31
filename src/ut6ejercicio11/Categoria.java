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
    /**
     * atributos de la clase categoria
     */
    private String nombre;
    private float sueldo;
    /**
     * constructor de la clase categoria
     * @param nombre le pasaremos el nombre cuando le creemos
     * @param sueldo le pasaremos el sueldo cuando le creemos
     */
    public Categoria(String nombre, float sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    /**
     * metodo para poder acceder al nombre
     * @return retornamos el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * metodo para poder acceder al sueldo
     * @return retornamos el sueldo del empleado
     */
    public float getSueldo() {
        return sueldo;
    }
    
}
