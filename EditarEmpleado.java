/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Empleados;

import java.io.*;
import java.util.*;
//import proyecto1.Menus;

/**
 *
 * @author Lenovo
 */
public class EditarEmpleado {
    Scanner sc = new Scanner(System.in);                    //Objeto para leer entradas de teclado
    CrearEmpleado cr = new CrearEmpleado();                 //Objeto para mostrar los empleados
    Menus m = new Menus();
    
    public void updateEmpleado(ArrayList<Empleado> Empleados, CrearEmpleado creador){
        Empleado e;
        int opc2,opc3;
        String Direccion = new String();
        String[] apellidos = new String[2];
        System.out.println("Ingresa numero de trabajador de empleado al cual deseas hacerle cambios");
        String trabajador = sc.next();
        trabajador = trabajador.replaceAll(" ", "");
        int i = 0;
        while(i < Empleados.size())                             //Verifica que haya un trabajador con el número de trabajador ingresado
        {
            if(Empleados.get(i).NumTrabajador.equals(trabajador))      //Comprueba que el número ingresado coincida con alguno registrado
            {
                System.out.println("Los datos del empleado son:\n" + Empleados.get(i).mostrarDatos()); //Muestra los datos del empleado que se va a editar
                e = Empleados.get(i);
                Direccion = e.getDireccion();
                apellidos = e.getApellidos();
                int opc = m.menuCambiar();
                switch(opc){
                    case 1:
                        System.out.print("Ingrea nuevo nombre:\t");
                        String nombre = sc.next();
                        nombre = nombre.replaceAll(" ", "");
                        nombre = nombre.toUpperCase();
                        nombre = nombre.replaceAll(",", "");
                        e.setNombre(nombre);
                        System.out.println("Nombre actualizado con exito");
                        break;
                    case 2:
                        System.out.print("Ingresa nuevo apellido paterno:\t");
                        apellidos[0] = sc.next();
                        apellidos[0] = apellidos[0].replaceAll(" ", "");
                        apellidos[0] = apellidos[0].toUpperCase();
                        apellidos[0] = apellidos[0].replaceAll(",", "");
                        e.setApellidos(apellidos);
                        System.out.println("Apellido paterno actualizado con exito");
                        break;
                    case 3:
                        System.out.print("Ingresa nuevo materno paterno:\t");
                        apellidos[1] = sc.next();
                        apellidos[1] = apellidos[1].replaceAll(" ", "");
                        apellidos[1] = apellidos[1].toUpperCase();
                        apellidos[1] = apellidos[1].replaceAll(",", "");
                        e.setApellidos(apellidos);
                        System.out.println("Apellido materno actualizado con exito");
                        break;
                    case 4:
                        System.out.println("Ingresa nuevo edad");
                        int edad = sc.nextInt();
                        while(edad<18 || edad>80){
                            System.out.println("Edad No valida, debe estar entre 18 y 80");
                            edad = sc.nextInt();
                        }
                        e.setEdad(edad);
                        System.out.println("Edad actualizada con exito");
                        break;
                    case 5:
                        System.out.println("Ingrese nueva direccion, se recomienda ingresarla de la siguiente forma: [Girnalda #4 Col. Colosio Cuernavaca Morelos]");
                        Direccion = System.console().readLine();
                        e.setDireccion(Direccion);
                        break;
                    case 6:
                        System.out.println("Ingrese nuevo numero de trabajador");
                        String numTrabajador = sc.next();
                        numTrabajador = numTrabajador.replaceAll(" ", "");
                        numTrabajador = numTrabajador.replaceAll(",", "");
                        e.setNumTrabajador(numTrabajador);
                        System.out.println("Numero de trabajador actualizado con exito");
                        break;
                    case 7:
                        mostrarProyectosHistoricos(e);
                        System.out.println("Que deseas hacer? \n\t1)Borrar proyecto\n\t2)Agregar Proyecto");
                        opc2 = sc.nextInt();
                        switch(opc2){
                            case 1:
                                System.out.println("Cual proyecto deseas borrar?");
                                opc3 = sc.nextInt() - 1;
                                while(opc3<0 || opc3 > e.ProyectosHistoricosaux.length){
                                    System.out.println("Valor no valido debe estar entre 1 y " + e.ProyectosHistoricosaux.length + ", intenta de jnuevo");
                                    opc3 = sc.nextInt();
                                }
                                
                                for (int k = opc3; k < e.ProyectosHistoricosaux.length-1; k++) {
                                    e.ProyectosHistoricosaux[opc3]=e.ProyectosHistoricosaux[k+1];
                                }
                                e.setProyectosHistoricos1(e.getProyectosHistoricos1()-1);
                                e.setTotalDeProyectos(e.getTotalDeProyectos()-1);

                                System.out.println("Proyecto eliminado correctamente del registro del empleado");
                                break;
                            case 2:
                                int b=1;
                                int g=0;
                                int f=0;
                                String[] ArregloHistoricoAux = new String[50];
                                if(e.ProyectosHistoricosaux.length>=51)
                                {
                                    System.out.println("El empleado no puede tener más proyectos historicos en su registro");
                                    break;
                                }else{
                                System.out.println("Lista de proyectos historicos");
                                try {
                                    FileReader fr2 = new FileReader("ProyectosHistoricos.txt");
                                    BufferedReader br2 = new BufferedReader(fr2);
                                    String linea2 = br2.readLine();
                                    while (linea2!=null) {
                                        System.out.println(b+".-"+linea2);
                                        ArregloHistoricoAux[g]=linea2;
                                        linea2=br2.readLine();
                                        b++;
                                        g++;
                                    }
                                    br2.close();                                       
                                } catch (FileNotFoundException ex) {
                                    System.out.println(ex.getMessage());
                                }catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                
                                System.out.println("Cual deseas agregar");
                                opc3 = sc.nextInt() - 1;
                                while(opc3<0 || opc3>e.ProyectosHistoricosaux.length){
                                    System.out.println("Proyecto no valido, ingresa uno correcto");
                                    opc3 = sc.nextInt() - 1;
                                }
                                while (e.ProyectosHistoricosaux[f]!=null) {
                                    f++;
                                }
                                e.ProyectosHistoricosaux[f]=ArregloHistoricoAux[opc3];
                                e.setProyectosHistoricosaux(e.ProyectosHistoricosaux);
                                e.setProyectosHistoricos1(e.getProyectosHistoricos1()+1);
                                e.setTotalDeProyectos(e.getTotalDeProyectos()+1);
                                }
                                break;
                            default:
                                System.out.println("Opcion incorrecta, regresaras al menu principal");
                        }
                        break;
                    case 8:
                        mostrarProyectosVigentes(e);
                        System.out.println("Que deseas hacer? \n\t1)Borrar proyecto\n\t2)Agregar Proyecto");
                        opc2 = sc.nextInt();
                        switch(opc2){
                            case 1:
                                System.out.println("Cual proyecto deseas borrar?");
                                opc3 = sc.nextInt() - 1;
                                while(opc3<0 || opc3 > e.ProyectosVigentesaux.length){
                                    System.out.println("Valor no valido debe estar entre 1 y " + e.ProyectosVigentesaux.length + ", intenta de jnuevo");
                                    opc3 = sc.nextInt();
                                }
                                
                                for (int k = opc3; k < e.ProyectosVigentesaux.length-1; k++) {
                                    e.ProyectosVigentesaux[opc3]=e.ProyectosVigentesaux[k+1];
                                }
                                e.setProyectosVigentes1(e.getProyectosVigentes1()-1);
                                e.setTotalDeProyectos(e.getTotalDeProyectos()-1);

                                System.out.println("Proyecto eliminado correctamente del registro del empleado");
                                break;
                            case 2:
                            int b=1;
                            int g=0;
                            int f=0;
                            String[] ArregloVigentesAux = new String[10];
                            if( e.ProyectosVigentesaux.length>3)
                            {
                                System.out.println("El empleado no puede tener más proyectos historicos en su registro");
                                break;
                            }else{
                            System.out.println("Lista de proyectos historicos");
                            try {
                                FileReader fr2 = new FileReader("ProyectosVigentes.txt");
                                BufferedReader br2 = new BufferedReader(fr2);
                                String linea2 = br2.readLine();
                                while (linea2!=null) {
                                    System.out.println(b+".-"+linea2);
                                    ArregloVigentesAux[g]=linea2;
                                    linea2=br2.readLine();
                                    b++;
                                    g++;
                                }
                                br2.close();                                       
                            } catch (FileNotFoundException ex) {
                                System.out.println(ex.getMessage());
                            }catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            
                            System.out.println("Cual deseas agregar");
                            opc3 = sc.nextInt() - 1;
                            while(opc3<0 || opc3>10){
                                System.out.println("Proyecto no valido, ingresa uno correcto");
                                opc3 = sc.nextInt() - 1;
                            }
                            while (e.ProyectosVigentesaux[f]!=null) {
                                f++;
                            }
                            e.ProyectosVigentesaux[f]=ArregloVigentesAux[opc3];
                            e.setProyectosHVigentesaux(e.ProyectosVigentesaux);
                            e.setProyectosVigentes1(e.getProyectosVigentes1()+1);
                            e.setTotalDeProyectos(e.getTotalDeProyectos()+1);
                            
                            }
                            break;
                            default:
                                System.out.println("Opcion incorrecta, regresaras al menu principal");
                                
                        }
                        break;
                    case 9:
                        System.out.println("Ingrese nueva antigueadd del usuario");
                        int antiguedad = sc.nextInt();
                        e.setAntiguedad(antiguedad);
                        System.out.println("Antiguedad del usuario actualizada correctamente");
                        creador.generadorProyectosHistoricos1(e,antiguedad);
                        break;
                    default:
                        System.out.println("Opción invalida, regresaras al menu principal");
                }
            } else if(i == Empleados.size())
            {
                System.out.println("El numero de trabajador ingresado no coincide con ninguno registrado");
            }
            i++;
        }
    }
    
    void mostrarProyectosHistoricos(Empleado e){
        for (int i = 0; i < e.ProyectosHistoricosaux.length; i++) {
            System.out.println((i+1)+".-"+e.ProyectosHistoricosaux[i]);            
        }
    }
    void mostrarProyectosVigentes(Empleado e){
        for (int i = 0; i < e.ProyectosVigentesaux.length; i++) {
            System.out.println((i+1)+".-"+e.ProyectosVigentesaux[i]);            
        }
    }
}