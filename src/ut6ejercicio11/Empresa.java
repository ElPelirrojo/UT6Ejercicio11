/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut6ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author dam
 */
public class Empresa {
    
    Categoria[]categorias;
    Empleado[]empleados;
    Importe[]importes;
    
    /**
     * constructo donde inicializaremos los arrays
     * @param n valor que le pasamos para decirle cuantos empleados queremos
     */
    public Empresa(int n){
        empleados = new Empleado[n];
        categorias = new Categoria[]{new Categoria("administrativo", 1000f), new Categoria("operador", 1100f), 
            new Categoria("programador", 1500f), new Categoria("analista", 2000f)};
        importes = new Importe[] {new Importe(10000f, 0.05f), new Importe(15000f, 0.10f), new Importe(20000f, 0.15f), 
            new Importe(25000f, 0.20f), new Importe(Float.MAX_VALUE, 0.25f)};
        //inicializaR()
    }
    /**
     * mismo constructor pero sin pasarle ningun valor, se le ponemos directamente cuando le
     * inicializamos
     */
    public Empresa(){
        empleados = new Empleado[10];
        categorias = new Categoria[]{new Categoria("administrativo", 1000f), new Categoria("operador", 1100f), 
            new Categoria("programador", 1500f), new Categoria("analista", 2000f)};
        importes = new Importe[] {new Importe(10000f, 0.05f), new Importe(15000f, 0.10f), new Importe(20000f, 0.15f), 
            new Importe(25000f, 0.20f), new Importe(Float.MAX_VALUE, 0.25f)};
        //inicializaR()
    }
    /**
     * metodo donde creamos los trabajadores y metemos los datos como la categoria
     * y las ventas
     */
    public void trabajadores(){ //categoria[empleado[xx].getCodigoCategoria()].getSueldo
        String nombre, categoria;
        int existe;
        float ventas;
        for(int i = 0;i < empleados.length;i++){
            nombre = pedirNombre("introduzca el nombre del empleado");
            empleados[i] = new Empleado(nombre);
            categoria = pedirNombre("introduzca el nombre de la categoria");
            existe = busqueda(categoria);
            while(existe == -1){
                System.out.println("no existe esa categoria");
                categoria = pedirNombre("introduzca el nombre de la categoria");
                existe = busqueda(categoria);
            }
            empleados[i].setCategoria(existe); //categorias[].getNombre();
            ventas = pedirNumeroReal("introduzca las ventas del empleado",0,Float.MAX_VALUE);
            empleados[i].setImportVentas(ventas);
        }
    }
    /**
     * con este metodo lo que hacemos es ver si existe la categoria que metemos en el array
     * @param categoria le pasamos el valor que a metido el operador
     * @return retornamos la posicion de la categoria en el array, si no existe retorna el valor
     * -1
     */
    public int busqueda(String categoria){
        int cate = 0;
        boolean encontrado = false;
        while(cate < categorias.length && !encontrado){ //encontrado == false
            if(categorias[cate].getNombre().equals(categoria)){
		encontrado = true;
            }else{
		cate++;
            }
        }
        if(!encontrado){
            cate = -1;
        }
        return cate;
    }
    /**
     * metodo para calcular el importe de la comision
     * @param nempleado le pasamos la posicion del empleado
     * @return retornamos el valor del importe
     */
    public float importeComision(int nempleado){
        float resultado;
        int porcentaje;
        porcentaje = busquedaPorcentaje(nempleado);
        resultado = empleados[nempleado].getImportVentas() * importes[porcentaje].getComision();
        return resultado;
    }
    /**
     * metodo que nos sirve para buscar el porcentaje segun las ventas
     * @param nempleado le pasamos la posicion del empleado
     * @return retornamos esa posicion
     */
    public int busquedaPorcentaje(int nempleado){
        int cate = 0;
        boolean encontrado = false;
        while(cate < categorias.length && !encontrado){ //encontrado == false
            if(empleados[nempleado].getImportVentas() < importes[cate].getVentas()){
		encontrado = true;
            }else{
		cate++;
            }
        }
        return cate;
    }
    /**
     * metodo que vale para calcular el importe a percibir
     * @param nempleado
     * @param importComision
     * @return 
     */
    public float importePercibir(int nempleado, float importComision){
        float resultado, sueldo;
        sueldo = categorias[empleados[nempleado].getCategoria()].getSueldo();
        resultado = sueldo + importComision;
        return resultado;
    }
    /**
     * este metodo es para sacar el informe final
     */
    public void informe(){
        int nempleado;
        float importComision;
        System.out.println("\t\t\tINFORME DE TRABAJADORES");
        System.out.println("NOMBRE   CATEGORIA     IMPORTE VENTAS     IMPORTE COMISION     IMPORTE A PERCIBIR");
        for(nempleado = 0;nempleado < empleados.length;nempleado++){
            importComision = importeComision(nempleado);
            System.out.println(empleados[nempleado].getNombre() + "     " + categorias[empleados[nempleado].getCategoria()].getNombre() 
                    + "   " + empleados[nempleado].getImportVentas() + "            " + importComision + "               " + importePercibir(nempleado, importComision));
            //System.out.println(importComision);
            //System.out.println(importePercibir(nempleado, importComision));
        }
    }
    /**
     * este metodo es el que usamos para pedir el nombre del empleado
     * @param mensaje le pasamos un mensaje para que el operador sepa que hacer
     * @return nos retorna un String con el nombre del empleado
     */
    private String pedirNombre(String mensaje) {
       InputStreamReader flujo = new InputStreamReader(System.in);
       BufferedReader entrada = new BufferedReader(flujo);
       String dato = ""; //puedo poner new string tambien
       try {
           System.out.println(mensaje);
           dato = entrada.readLine();
           while(dato.trim().isEmpty()){ //dato.trim().equals("")
               System.out.println("no es un tipo de curso valido");
               System.out.println(mensaje);
               dato = entrada.readLine();
           }
       }catch(IOException ex) {
           System.out.println("");
       }
       return dato;
    }
    /**
     * este metodo sirve para pedir las ventas del empleado
     * @param mensaje le pasamos un mensaje para que el operador sepa que hacer
     * @param limiteInferior le pasamos el limite inferior para que no pueda
     * meter un valor menor que ese
     * @param limiteSuperior le pasamos el limite superior para queno pueda meter
     * un valor mayor que el que le pasamos
     * @return retonamos el numero
     */
    public float pedirNumeroReal(String mensaje, float limiteInferior, float limiteSuperior) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(flujo);
        float numero = 0;
        boolean mal;
        try {
            mal = true;
            while (mal) {
                try {
                    System.out.println(mensaje);
                    numero = Float.parseFloat(entrada.readLine());
                    if (numero < limiteInferior || numero > limiteSuperior) {
                        System.out.println("No cumple las condiciones. Debe estar "
                                + "comprendido entre " + limiteInferior+ " y "+
                                limiteSuperior);
                    } else {
                        mal = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("No es un numero");
                }
            }
        } catch (IOException ex) {
        }
        return numero;
    }
}
