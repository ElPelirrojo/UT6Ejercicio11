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
    
    private String nombre;
    private int categoria;
    private float importVentas;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public float getImportVentas() {
        return importVentas;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setImportVentas(float importVentas) {
        this.importVentas = importVentas;
    }
    
}
