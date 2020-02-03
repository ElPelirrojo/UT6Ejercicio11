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
public class Empleado {
    /**
     * atributos del empleado
     */
    private String nombre;
    private int categoria;
    private float importVentas;
    /**
     * constructor de la clase empleado al que pasaremos el nombre
     * cuando le creemos
     * @param nombre 
     */
    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    /**
     * metodo para poder acceder al nombre
     * @return retornamos el nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * metodo para poder acceder a la categoria
     * @return retornamos la categoria
     */
    public int getCategoria() {
        return categoria;
    }
    /**
     * metodo para poder acceder al importe de ventas
     * @return retornamos el nombre
     */
    public float getImportVentas() {
        return importVentas;
    }
    /**
     * metodo para poder cambiar el valor de la variable categoria
     * @param categoria le pasamos el valor que queremos guardar
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    /**
     * metodo para poder cambiar el valor de la variable importe ventas
     * @param categoria le pasamos el valor que queremos guardar
     */
    public void setImportVentas(float importVentas) {
        this.importVentas = importVentas;
    }
    
}
