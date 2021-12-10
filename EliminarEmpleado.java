/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Empleados;

import java.util.*;

/**
 *
 * @author Lenovo
 */
public class EliminarEmpleado {
    Scanner sc = new Scanner(System.in);                    //Objeto para ller entradas de teclado
    CrearEmpleado cr = new CrearEmpleado();                 //Objeto para mostrar los empleados
    public void elimiarEmpleado(ArrayList<Empleado> Empleados){ //Método para eliminar un empleado
        System.out.println("Estos son los empleados registrados en la empresa:"); 
        cr.mostrarEmpleados(Empleados);                         //Muestra los empleados registrados en la empresa
        System.out.print("Ingresa el Numero de trabajador del empleado que deseas eliminar:       ");
        String num = sc.nextLine();                             //Lee número de trabajador ingresado
        num = num.replaceAll(" ", "");                          //Quita posibles espacios en el número
        int i = 0;
        while(i < Empleados.size())                             //Verifica que haya un trabajador con el número de trabajador ingresado
        {
            if(Empleados.get(i).NumTrabajador.equals(num))      //Comprueba que el número ingresado coincida con alguno registrado
            {
                System.out.println("Los datos del empleado a eliminar son:\n" + Empleados.get(i).mostrarDatos()); //Muestra los datos del empleado que se va a borrar
                Empleados.remove(i);        //Remueve al empleado de la lista
                System.out.println("Trabajor Eliminado Correctamente");
            } else if(i == Empleados.size())
            {
                System.out.println("El numero de trabajador ingresado no coincide con ninguno registrado");
            }
            i++;
        }
    }
}