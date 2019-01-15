/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Catica
 */
public class Empleado implements Serializable {
    
    private String nombre;
    private String apellido;
    private String dni;
    private String sexo;
    private String depto;
    private String correoElectronico;
    float altura;
    
    public Empleado(String nombre, String apellido, String dni, String sexo, 
            String depto, String email, float altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.depto = depto;
        this.correoElectronico = email;
        this.altura = altura;
    }

    public Empleado() {
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.sexo = "";
        this.depto = "";
        this.correoElectronico = "";
        this.altura = 0.0f;
    }
    
    
    public static Empleado instanceEmpleadoFromArrayString(String[] _data){
        Empleado e = new Empleado(_data[0],_data[1],_data[2],_data[3],_data[4],
                _data[5],Float.parseFloat(_data[6]));
        return e;
    }

    public String empleadoToStringConFormato(){
        String formato = " %-25s %-25s %8s %12s %30s %10.2f %20s ";
        String eSt = String.format(formato, this.apellido,this.nombre,
                this.sexo,this.dni,this.correoElectronico,this.altura,this.depto);
        return eSt;
    }
    /// ---- hasta aqui lo que hice en el examen
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
}
