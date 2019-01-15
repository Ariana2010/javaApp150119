/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.coti.tools.Esdia;
import controlador.Controlador;
import java.util.Scanner;
import static java.lang.System.err;
import static java.lang.System.out;
/**
 *
 * @author Catica
 */
public class Vista {
    Controlador c = new Controlador();
    Scanner sc = new Scanner(System.in,
            System.getProperty("os.name").contains("Windows") ? "iso-8859-1" : "UTF-8");
    
    public void runMenu(String menu){
        String[] opVal = {"1","2","3","4","q"};
        String op;
        boolean salir = false;
        //c.cargarDatos();
        do{
            op = Esdia.readString(menu, opVal);
            switch(op){
                case"1": 
                    c.cargarDatos();
                    System.out.println("...Datos cargados correctamente.");
                    break;
                case"2": 
                    this.leerDatosEmpleado();
                    System.out.println("...Añadido Empleado correctamente.");
                    break;
                case"3": 
                    this.listar();
                    break;
                case"4": 
                    c.guardarDatos();
                    System.out.println("...Archivo salvado correctamente.");
                    break;
                case"q": 
                    String[] ops = {"s","n"};
                    String s = Esdia.readString("Salir? ", ops);
                    salir = s.equals("s");
                    break;
                default:
                    err.println("No deberia entrar aquí...");
            }
        }while(!salir);
    }

    private void leerDatosEmpleado() {
        String[]e = new String[7];
        for(int i=0; i<e.length; i++){
            switch(i){
                case 0:
                    System.out.println("nombre: ");
                    e[i] = sc.nextLine();
                    break;
                case 1:
                    System.out.println("apellido: ");
                    e[i] = sc.nextLine();
                    break;
                case 2:
                    System.out.println("dni: ");
                    e[i] = sc.nextLine();
                    break;
                case 3:
                    System.out.println("sexo: ");
                    e[i] = sc.nextLine();
                    break;
                case 4:
                    System.out.println("departmento: ");
                    e[i] = sc.nextLine();
                    break;
                case 5:
                    System.out.println("correo electrónico: ");
                    e[i] = sc.nextLine();
                    break;
                case 6:
                    do{
                        System.out.println("altura: ");
                        e[i] = sc.nextLine();
                        try{
                            float alt = Float.parseFloat(e[i]);
                            break;
                        }catch(NumberFormatException ex){
                            err.println("reintentelo: error: "+ex.getMessage()+" "+ex.toString());
                        }
                    }while(true);
                    break;
                default:
                    System.err.println("Error: Vista: leerDatosEmpleado() ");
                    break;
            }
        }
        c.addEmpleadoToModelo(e);
    }
    
    public void listar(){
        String[]empleados;
        String cad;
        out.print("nombre departamento: ");
        cad = sc.nextLine();
        empleados = c.ListadoEmpleadosDepto(cad);
        if(empleados.length != 0){
            System.out.printf(" %-25s %-25s %8s %12s %30s %10s %20s ","APELLIDO",
                    "NOMBRE","SEXO","DNI","CORREO ELECTRÓNICO","ALTURA","DEPARTAMENTO");
            System.out.println("");
            for(String e: empleados){
                System.out.println(e);
            }
        }else {System.out.println("...No hay datos para ese departamento.");}
    }
    
}
