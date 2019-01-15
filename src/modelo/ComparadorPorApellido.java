/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;

/**
 *
 * @author Catica
 */
public class ComparadorPorApellido implements Comparator<Empleado> {

    @Override
    public int compare(Empleado t, Empleado t1) {
        return (t.getApellido().compareToIgnoreCase(t1.getApellido()));
        /*String ape1 = t.getApellido();
        String ape2 = t1.getApellido();
        
        return ape1.compareToIgnoreCase(ape2);*/
    }
 
    /// ---- hasta aqui lo que hice en el examen
}
