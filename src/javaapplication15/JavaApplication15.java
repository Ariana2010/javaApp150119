/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import vista.Vista;
/**
 *
 * @author Catica
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista v = new Vista();
        v.runMenu("\n1. Cargar Archivos."
                + "\n2. Añadir Empleado."
                + "\n3. Listar Empleados departamento."
                + "\n4. Guardar archivo: departamentos.bin en el escritorio."
                + "\nq. Salir.");
    }
    
}
