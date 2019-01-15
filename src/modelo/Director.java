/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Catica
 */
public class Director implements Serializable{
    
    private String nombreDepto;
    private String director;
    List<Empleado> empleadosDepto;

    public Director(String nombreDepto, String director) {
        this.nombreDepto = nombreDepto;
        this.director = director;
        this.empleadosDepto = new ArrayList<>();
    }

    public Director() {
        this.nombreDepto = "";
        this.director = "";
    }

    public static Director instanceDirFromArrayString(String [] _data){
        Director d = new Director (_data[0],_data[1]);
       /* Director d = new Director ();
        d.setNombreDepto(_data[0]);
        d.setDirector(_data[1]);
        d.setEmpleadosDepto(new ArrayList<>());*/
        return d;
    }
    /// ---- hasta aqui lo que hice en el examen
   
    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Empleado> getEmpleadosDepto() {
        return empleadosDepto;
    }

    public void setEmpleadosDepto(List<Empleado> empleadosDepto) {
        this.empleadosDepto = empleadosDepto;
    }
    
    
}
