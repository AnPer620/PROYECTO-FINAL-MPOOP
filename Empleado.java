/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Empleados;

//import java.io.*;
import java.util.*;

/**
 *
 * @author author Marco Antonio, Albarran Daniela,Perez Angel,Gonzalez Victor
 */
public class Empleado {
    String Nombre;
    String[] Apellidos = new String[2];
    String Direccion;
    String NumTrabajador;
    int totalDeProyectos;
    int Edad;
    int antiguedad;
    String[] ProyectosHistoricosaux= new String[40];
    String[] ProyectosVigentesaux= new String[3];
    int proyectosVigentes1;
    int proyectosHistoricos1;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String[] getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String[] Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Dirección) {
        this.Direccion = Dirección;
    }

    public String getNumTrabajador() {
        return NumTrabajador;
    }

    public void setNumTrabajador(String NumTrabajador) {
        this.NumTrabajador = NumTrabajador;
    }
    
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getTotalDeProyectos() {
        return totalDeProyectos;
    }

    public void setTotalDeProyectos(int totalDeProyectos) {
        this.totalDeProyectos = totalDeProyectos;
    }

    public String[] getProyectosHistoricosaux() {
        return ProyectosHistoricosaux;
    }

    public void setProyectosHistoricosaux(String[] ProyectosHistoricosaux) {
        this.ProyectosHistoricosaux = ProyectosHistoricosaux;
    }

    public String[] getProyectosVigentesosaux() {
        return ProyectosVigentesaux;
    }

    public void setProyectosHVigentesaux(String[] ProyectosVigentesaux) {
        this.ProyectosVigentesaux = ProyectosVigentesaux;
    }

    public int getProyectosVigentes1() {
        return proyectosVigentes1;
    }

    public void setProyectosVigentes1(int proyectosVigentes1) {
        this.proyectosVigentes1 = proyectosVigentes1;
    }

    public int getProyectosHistoricos1() {
        return proyectosHistoricos1;
    }

    public void setProyectosHistoricos1(int proyectosHistoricos1) {
        this.proyectosHistoricos1 = proyectosHistoricos1;
    }

    public String[] impresionProyectosHistoricos(String[] ProyectosHistoricosaux){
        String[] Historicos = new String[1];
        for (int k = 0; k < ProyectosHistoricosaux.length; k++) {
            if (ProyectosHistoricosaux[k]==null) {
                ProyectosHistoricosaux[k]="X";                
            } 
        }
        for (int i = 0; i < ProyectosHistoricosaux.length; i++) {
            if(Historicos[0]==null){
                Historicos[0]=ProyectosHistoricosaux[i]+",";
            }else{
                Historicos[0]=Historicos[0]+ProyectosHistoricosaux[i]+",";
            }             
        }
        return Historicos;

    }

    public void listasProyectos(String[] ProyectosHistoricosaux,List<String> proyectosHistoricos11,String[] ProyectosVigentesaux,List<String> proyectosVigentes11){
        for (int l = 0; l < ProyectosHistoricosaux.length; l++) {
            proyectosHistoricos11.add(ProyectosHistoricosaux[l]);
        }
        for (int g = 0; g <ProyectosVigentesaux.length; g++) {
            proyectosVigentes11.add(ProyectosVigentesaux[g]);
        }
    }



    @Override
    public String toString() {
        String[] Historicos = new String[50];
        Historicos= impresionProyectosHistoricos(ProyectosHistoricosaux);
        return Nombre+","+Apellidos[0]+","+Apellidos[1]+","+Direccion+","+NumTrabajador+","+proyectosHistoricos1+","+proyectosVigentes1+","+totalDeProyectos+","+Edad+","+antiguedad+","+""+","+"Pro. Vigentes"+","+ProyectosVigentesaux[0]+","+ProyectosVigentesaux[1]+","+ProyectosVigentesaux[2]+","+""+","+"Pro. Historicos"+","+Historicos[0];
    }
    
    public String mostrarDatos(){
        return "Nombre: " + Nombre+" Apellidos: "+Apellidos[0]+" "+Apellidos[1]+" Dirección: "+Direccion+" Numero de trabajador: "+NumTrabajador+" Proyectos historicos: "+proyectosHistoricos1+" Proyectos vigentes: "+proyectosVigentes1+" Total de proyectos:"+totalDeProyectos+" Edad:"+Edad+" Antigueadad: "+antiguedad;
    }
    
}