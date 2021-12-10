/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package proyecto1;
import java.util.*;
import java.io.*;
//import Empleados.*;
/**
 *
 * @author Marco Antonio, Albarran Daniela,Perez Angel,Gonzalez Victor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        final int empleadosRegistrados = 100;                             //Cantidad de trabajadores registrados inicialmente en la empresa
        Menus menus = new Menus();                                        //Objeto que tiene los menus del programa
        Scanner sc = new Scanner(System.in);                              //Objeto para poder leer los datos de entrada
        EliminarEmpleado borrador = new EliminarEmpleado();               //Objeto para poder eliminar empleados
        EditarEmpleado editor = new EditarEmpleado();                     
        CrearEmpleado creador = new CrearEmpleado();                      //Objeto para poder crear y eliminar trabajadores
        
        ArrayList<Empleado> Empleados = new ArrayList<>();                //Lista de objetos que almacena los datos de todos los trabajadores

        int opc = 0,opcA;                                                 //Opciones de los menus
        for (int i = 0; i < empleadosRegistrados; i++)                    //Ciclo para crear aleatoriamente los trabajadores registrados desde un inicio
        {
            creador.nuevoEmpleado(Empleados);                             //Crea un trabajador aleatorio
        }
        while(opc!=5)                                                     //Mientras el adminstrador no ingrese la opcion 4 no saldrá del programa
        {
            opc = menus.menuPrincipal();                                  //Menu prinicpal
            switch(opc)                                                   //Opciion elegida
            {
                case 1:
                    System.out.println("ESCOGIO MOSTRAR EMPLEADOS, LOS EMPLEADOS REGISTRADOS SON:");
                    creador.mostrarEmpleados(Empleados);                  //Muestra todos los empleados registrados en la empresa
                    break;
                case 2:
                    System.out.println("ESCOGIO AGREGAR EMPLEADO");
                    opcA = menus.menuAgregar();
                    switch(opcA)
                    {
                        case 1:
                            System.out.println("Seleccionaste agregar aleatoriamente un empleado");
                            creador.nuevoEmpleado(Empleados);   //Agrega un empleado con datos aleatorios
                            System.out.println("Empleado agregado con éxito");
                            break;
                        case 2:
                            System.out.println("Seleccionaste ingresar datos");
                            creador.agregarEmpleado(Empleados); //Agrega un empleados con los datos que el administrador ingrese
                            System.out.println("Empleado agregado con exito");
                            break;
                        default: System.out.println("OPCION INVALIDA, REGRESARAS AL MENU PRINCIPAL");
                    }
                    break;
                case 3:
                    System.out.println("ESCOGIO ELIMINAR EMPLEADO");
                    borrador.elimiarEmpleado(Empleados);     //Elimina un empleado de la lista de empleados registrados
                    break;
                case 4:
                    editor.updateEmpleado(Empleados,creador);
                    break;
                case 5:
                    break;
                default: System.out.println("OPCION INVALIDA, INTENTA DE NUEVO");
            }
        }
        System.out.println("Deseas crear el registro de empleados en un archivo .csv?\n\t1)Si\n\t2)No");
        opc = sc.nextInt();
        if(opc == 1){
        creador.crearRegistro(Empleados); //Crea el archivo .csv con los datos de los trabajadores
        System.out.println("Programa terminado");
        }else{
            System.out.println("Programa terminado");
        }
    }
}
