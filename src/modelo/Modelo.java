/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.coti.tools.Rutas;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import static java.lang.System.err;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author Catica
 */
public class Modelo {
    private List<Director> departamentos;
    private final String nombreCarpeta = "datos_empresa";
    private final String nombreFichDepto = "departamentos.csv";
    private final String nombreFichEmp = "empleados.csv";
    private final String nombreBin = "directores.bin";
    
    public void loadFile(){
        departamentos = new ArrayList<>();
        List<String> data = new ArrayList<>();
        Path pD = Rutas.pathToFileInFolderOnDesktop(this.nombreCarpeta,this.nombreFichDepto);
        Path pE = Rutas.pathToFileInFolderOnDesktop(nombreCarpeta,nombreFichEmp);
        if(!Files.exists(pD)){
            err.println("El archivo: " +pD+ " No existe.");
        }else{
            try{
                data = Files.readAllLines(pD,Charset.forName("UTF-8"));
            }catch(IOException ex){
                err.print("Error: ");
                err.print(ex.toString());
                err.print(" Message: ");
                err.println(ex.getMessage());
            }
            for(String ld : data){
                if (!ld.isEmpty()){ //<-- No la puse en el examen.
                    String[] d = ld.split("\t");
                    Director dir = Director.instanceDirFromArrayString(d);
                    departamentos.add(dir);
                }
            }
        }//else
        if(!Files.exists(pE)){
            err.println("El archivo: "+pE+" No existe.");
        }else{
            try{
                data = Files.readAllLines(pE,Charset.forName("UTF-8"));
            }catch(IOException ex){
                err.println("Excepcion: "+ex.toString());
            }
            for(String ld : data){
                if(!ld.isEmpty()){
                    String[] d = ld.split("\t");
                    Empleado e = Empleado.instanceEmpleadoFromArrayString(d);
                    this.addEmpleadoToDepto(e);
                }
            }
        }//else
    }//end loadFile()
    
    public void save(){
        Path rutaBin = Rutas.pathToFileOnDesktop(nombreBin);
        try{
            FileOutputStream fos = new FileOutputStream (rutaBin.toFile());
            BufferedOutputStream bos = new BufferedOutputStream (fos);
            try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                oos.writeObject(departamentos);
            }
        }catch (IOException ex){
            err.println("Excepcion: "+ex.toString()+" No fue posible guardar el archivo.");
        }    
    }
    
    
    public void sortByApellido (String Depto){
        Comparator<Empleado> c = new ComparadorPorApellido();
        for(Director d: departamentos){
            if(d.getNombreDepto().equalsIgnoreCase(Depto)){
               Collections.sort(d.getEmpleadosDepto(), c);
               break;
            }
        }
    }

    public void addEmpleadoToDepto(Empleado e){
        for(Director d: departamentos){
            if(d.getNombreDepto().equalsIgnoreCase(e.getDepto())){
                d.getEmpleadosDepto().add(e);
                break;
            }
        }
    }
    
    /// ---- hasta aqui lo que hice en el examen
    
    public List<Empleado> getEmpleadosDepto(String _depto){
        //Devolverlos ordenados por apellido
        this.sortByApellido(_depto);
        List<Empleado> e = new ArrayList<>();
        for(Director dir : departamentos){
            if(dir.getNombreDepto().equalsIgnoreCase(_depto)){
                e = dir.getEmpleadosDepto();
                break;
            }
        }
        return e;
    }
    
}
