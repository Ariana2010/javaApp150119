/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Empleado;
import modelo.Modelo;

/**
 * 
 *
 * @author Catica
 */
public class Controlador {
    Modelo m = new Modelo();
    
    public void cargarDatos(){
        m.loadFile();
    }
    
    public void guardarDatos(){
        m.save();
    }
    
    public void addEmpleadoToModelo (String[] de){
        Empleado e = Empleado.instanceEmpleadoFromArrayString(de);
        m.addEmpleadoToDepto(e);
    }
    
    public String[] ListadoEmpleadosDepto(String _depto){
        List<Empleado> empDepto = m.getEmpleadosDepto(_depto);
        String[] listaEmp = new String[empDepto.size()];
        
        int i = 0;
        for(Empleado e: empDepto){
            listaEmp[i++]=e.empleadoToStringConFormato();
        }
        return listaEmp;
    }
}
