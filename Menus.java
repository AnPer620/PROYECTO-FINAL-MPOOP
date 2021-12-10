/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
//package proyecto1;
import java.util.Scanner;

/**
 *
 * @author Marco Antonio, Albarran Daniela,Perez Angel,Gonzalez Victor
 */
public class Menus  {
    Scanner sc = new Scanner(System.in);
    public int menuPrincipal()
    {
        int opc = 0;
        System.out.println("¿QUE DESEAS HACER?");
        System.out.println("\t1)Mostrar Empleados");
        System.out.println("\t2)Agregar Empleado");
        System.out.println("\t3)Eliminar Empleado");
        System.out.println("\t4)Cambiar Dato De Empleado");
        System.out.println("\t5)Salir");
        opc = sc.nextInt();
        return opc;
    }
    
    public int menuAgregar()
    {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        System.out.println("¿COMO DESEAS AGREGARLO?");
        System.out.println("\t1)Aleatorio");
        System.out.println("\t2)Ingresar Datos de Trabajador");
        System.out.println("\t3)Salir");
        opc = sc.nextInt();
        return opc;
    }
    
    public int menuCambiar(){
        int opc;
        System.out.println("QUE DESEAS CAMBIAR?");
        System.out.println("\t1)Nombre");
        System.out.println("\t2)Apellido Paterno");
        System.out.println("\t3)Apellido Materno");
        System.out.println("\t4)Edad");
        System.out.println("\t5)Dirección");
        System.out.println("\t6)Numero de Trabajador");
        System.out.println("\t7)Historial de Proyectos Historicos");
        System.out.println("\t8)Historial de Proyectos Vigentes");
        System.out.println("\t9)Antiguedad en la empresa");
        opc = sc.nextInt();
        return opc;
    }
}
