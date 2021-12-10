/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Empleados;

import java.io.*;
import java.util.*;

/**
 *
 * @author Marco Antonio, Albarran Daniela,Perez Angel,Gonzalez Victor
 */
public class CrearEmpleado {
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    String[] Nombres = {"ALEJANDRO","ANDREA","TATIANA","CARLOS","DIANA","DIANA","DIANA","MAURICIO","GABRIEL","HUGO","LAURA","NATALIA",
                               "MARIA","OSCAR","FERNANDO","MONICA","MIRIAM","KAREN","EDUARDO","ALEXIS","LIZBETH"}; //Nombres disponibles
    String[] Apellidos = {"MALDONADO","ROJAS","PEREZ","GONZALEZ","CUELLAR","RUIZ","RODRIGUEZ","HERNANDEZ","SOLANO","JIMENEZ","ARTEAGA","ALVAREZ",
                          "NAVARRO","SALINAS","DOLORES","SANCHEZ","LOPEZ","GUZMAN","DAVALOS","AVILA","AYALA"};     //Apellidos disponibles
    
        
    public void mostrarEmpleados(ArrayList<Empleado> Empleados){
        
        int i = 0;
        
        while(i<Empleados.size())
        {
            System.out.println(Empleados.get(i).mostrarDatos());                //Muestra los datos de los empleados
            i++;
        }
    } 
    void mostrarArchivos(ArrayList<File> Proyectos){
        for (int j = 0; j < Proyectos.size(); j++) {
            System.out.println((j+1) + ".- " + Proyectos.get(j).getName()); //Muestra una lista con los nombres de los proyectos
        }
    }
    
    public void nuevoEmpleado(ArrayList<Empleado> Empleados){ //Método que crea empleado con datos aleatorios
        Empleado empleado = new Empleado();                         //Objeto auxiliar para poder agregarlo a la lista de empleados  
        String[] auxApellidos = new String[2];                      //Arreglo con apellidos de un trabajador
        empleado.setNombre(generadorNombres());                     //Asigna el nombre al trabajador
        auxApellidos[0] = generadorApellido();                      //Agrega el primer apellido
        auxApellidos[1] = generadorApellido();                      //Agrega el segundo apellido
        empleado.setApellidos(auxApellidos);                        //Asigna los dos apellidos al trabajador
        int h=generadorAntiguedad(empleado);

        generadorProyectosVigentes1(empleado);
        generadorProyectosHistoricos1(empleado,h);
        generadorDirecciones(empleado);

        empleado.setEdad(generadorEdad());                            //Asigna la edad al trabajador
        empleado.setNumTrabajador(generadorNumTrabajador(Empleados)); //Asigna Número de trabajador al empleado
        empleado.setAntiguedad(h); //Asigna el número de años de antiguedad
        empleado.setTotalDeProyectos(empleado.proyectosHistoricos1 + empleado.proyectosVigentes1);
        Empleados.add(empleado); //Agrega el empleado a la lista de empleados
    }
    
    public void agregarEmpleado(ArrayList<Empleado> Empleados){         //Metodo para agregar un dato con datos que seleccionemos
        Empleado e = new Empleado();                                    //Objeto auxilar para poder agregarlo a la lista
        String[] Apellidos = new String[2];                             //Objeto para asignar apellidos al empleados
        e.setNombre(selectorNombre());                                  //Asigna el nombre
        Apellidos[0] = selectorApellidoPaterno();                       //Asigna el primer apellido
        Apellidos[1] = selectorApellidoMaterno();                       //Asigna el segundo apellido
        e.setApellidos(Apellidos);                                      //Asigna los dos apellidos al empleado
        e.setNumTrabajador(selectorNumTrabajador(Empleados));           //Asigna el número de trabajador al empleado
        e.setEdad(selectorEdad());                                      //Asigna la edad al trabajador
        int u= selectorAntiguedad();
        e.setAntiguedad(u);                                             //Asigna el tiempo en la empresa del trabajador

        generadorProyectosHistoricos1(e,u);
        generadorProyectosVigentes1(e);
        agregarDireccion(e);
        
        e.setTotalDeProyectos(e.proyectosHistoricos1+ e.proyectosVigentes1);    //Asigna el total de proyectos del trabajador
        Empleados.add(e);                                               //Agrega el empleado a la lista de empleados
    }
        
    public void crearRegistro(ArrayList<Empleado> Empleados) throws IOException{
        File archivo = new File("Registro.csv"); //Objeto para manipular archivos
        if(!archivo.exists()) //Verifica que el archivo exista
        {
            try
            {
            archivo.createNewFile(); //Si el archivo no existe lo crea
            } catch(IOException e){
                
            }
        }
        FileWriter fw = new FileWriter(archivo); //Auxilar para escribir en el archivo
        BufferedWriter bw = new BufferedWriter(fw); //Auxilar para agregar texto ala rchivo
        int i = 0;
        bw.write("Nombre,Apellido Parterno,Apellido Materno,Direccion,Numero de Trabajador,Proyectos Historicos,Proyectos Vigentes,Total de Proyectos,Edad,Antiguedad\n");
    while(i<Empleados.size())
        {
            bw.write(Empleados.get(i).toString()); //Agrega el texto al documento
            bw.write("\n");         //Separa entre filas cada información de empleado
            i++;
        }
        bw.close();         //Cierra el buffer que escribe datos
        System.out.println("Registro de empleados creado correctamente en Registro.csv");
    }
    
    String generadorNombres(){
        String nombre = Nombres[rd.nextInt(Nombres.length)];
        return nombre;
    }
    
    String generadorApellido(){
        String apellido = Apellidos[rd.nextInt(Apellidos.length)];
        return apellido;
    }
    
    int generadorEdad(){
        int Edad = rd.nextInt(62)+18;
        return Edad;
    }

    
    
    String generadorNumTrabajador(ArrayList<Empleado> Empleados){
        String numTrabajador = Integer.toString(rd.nextInt(999999)+ 310000000);
        int j = 0;
        while(j < Empleados.size()) { //Ciclo para comparar el número de trabajador y sea diferente para cada uno
            if(Empleados.get(j).NumTrabajador.equals(numTrabajador)) //Verifica que el número de trabajador sea diferente a los ya registrados
            {
                numTrabajador = Integer.toString(rd.nextInt(999999)+ 310000000);
                j = 0;                                                              //Reinicia el contador para verificar de nuevo
            }
            j++;
        }
        return numTrabajador;
    }
    
    int generadorAntiguedad(Empleado empleado){
        int antiguedad = rd.nextInt(30);
        if(empleado.getEdad() == 18){
            antiguedad = 0;
        }else if (empleado.getEdad()>18 && empleado.getEdad()<48){
            antiguedad = rd.nextInt(empleado.getEdad()-18);
        }else{
            antiguedad = rd.nextInt(30);
        }
        return antiguedad;
    }
    

    void generadorProyectosHistoricos1(Empleado empleado, int antiguo){
        int i = rd.nextInt(50)+1;
        if (antiguo==0) {
            i=0;
        } else if(antiguo<10){
            i=rd.nextInt(12);
            if (i<5) {
                i=i+5;
            }
        }else if(antiguo<20){
            i=rd.nextInt(30);
            if (i<15) {
                i=i+10;
            }
        }else if(antiguo<30){
            i=rd.nextInt(50);
            if (i<20) {
                i=i+15;
            }
        }else{
            System.out.println("ERROR");
        }

        empleado.setProyectosHistoricos1(i);;
        String[] auxProyectosHistoricos = new String[50];
        empleado.setProyectosHistoricosaux(auxProyectosHistoricos);
        try {
            for (int p = 0; p <i; p++) {
                FileReader fr1 = new FileReader("ProyectosHistoricos.txt");
                BufferedReader br1 = new BufferedReader(fr1);
                String linea1 = br1.readLine();
                int t = rd.nextInt(39);
                for (int a = 0; a <= t; a++) {
                    linea1 = br1.readLine();                    
                    auxProyectosHistoricos[p] = linea1;
                }
                empleado.setProyectosHistoricosaux(auxProyectosHistoricos);
                br1.close();
            }   
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    void generadorProyectosVigentes1(Empleado empleado){
        String[] auxProyectosVigentes = new String[3];
        empleado.setProyectosHVigentesaux(auxProyectosVigentes);

        

        int i = rd.nextInt(3)+1;
        empleado.setProyectosVigentes1(i);
        try {
            for (int k=0;k<auxProyectosVigentes.length;k++){
                auxProyectosVigentes[k]="X";
            }
            for (int p = 0; p <i; p++) {
                FileReader fr2 = new FileReader("ProyectosVigentes.txt");
                BufferedReader br2 = new BufferedReader(fr2);
                String linea2 = br2.readLine();
                int t = rd.nextInt(9);
                for (int a = 0; a <= t; a++) {
                    linea2 = br2.readLine();                    
                    auxProyectosVigentes[p] = linea2;
                }
                empleado.setProyectosHVigentesaux(auxProyectosVigentes);
                br2.close();
            }   
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    void generadorDirecciones(Empleado empleado){
        String direccionaux = new String(); 
        empleado.setDireccion(direccionaux);
        int i = rd.nextInt(300);//Con esto trabajamos las direcciones
        try {
            FileReader fr = new FileReader("Direcciones2.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            for (int j = 0; j <= i; j++) {
                linea = br.readLine();
                direccionaux = linea;
            }
            empleado.setDireccion(direccionaux);
            br.close();           
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    String selectorNombre(){
        String nombre;
            System.out.print("Ingresa nombre:\t");
            nombre = sc.nextLine();
            nombre = nombre.replaceAll(" ", "");
            nombre = nombre.replaceAll(",", "");
            nombre = nombre.toUpperCase();
        return nombre;
    }
    
    String selectorApellidoPaterno(){
        String apellido;
        System.out.print("Ingresa apellido paterno:\t");
            apellido = sc.nextLine();
            apellido = apellido.replaceAll(" ", "");
            apellido = apellido.replaceAll(",", "");
            apellido = apellido.toUpperCase();
        return apellido;
    }
    
    String selectorApellidoMaterno(){
        String apellido;
        System.out.print("Ingresa apellido materno:\t");
            apellido = sc.nextLine();
            apellido = apellido.replaceAll(" ", "");
            apellido = apellido.replaceAll(",", "");
            apellido = apellido.toUpperCase();
        return apellido;
    }
    
    int selectorEdad(){
        int edad;
        System.out.print("Ingresa edad:\t");
        edad = sc.nextInt();
        while(edad < 18 || edad > 80){
            System.out.println("Ingresa una edad válida entre 18 y 80");
            edad = sc.nextInt();
        }
        return edad;
    }
    
    int selectorAntiguedad(){
        int antiguedad;
        System.out.print("Ingre el tiempo que lleva en la empresa la persona:\t");
        antiguedad = sc.nextInt();
        return antiguedad;
    }
    
    String selectorNumTrabajador(ArrayList<Empleado> empleados){
        String numTrabajador;
        System.out.print("Ingresa numero de trabajador:\t");
        numTrabajador = sc.nextLine();
        numTrabajador = numTrabajador.replaceAll(" ", "");
        numTrabajador = numTrabajador.replaceAll(",", "");
        int i = 0;
        while(i<empleados.size()){
            if(empleados.get(i).NumTrabajador.equals(numTrabajador)){       //Comprueba que no exista un empleado con mismo número de empleado
                System.out.println("El número de trabajador que ingreso ya esta en uso, ingrese uno nuevo:      ");
                numTrabajador = sc.nextLine();                              //Ingresa un nuevo número de empleado en caso de que exista el que se ingresó antes
                numTrabajador = numTrabajador.replaceAll(" ", "");          //Quita posibles espacios en el número de trabajador
                numTrabajador = numTrabajador.replaceAll(",", "");
                i = -1;                  //Verifica de nuevo todos los números
            }
            i++;
        }
        return numTrabajador;
    }
    
    void agregarDireccion(Empleado empleado){
        String Direccion;
        System.out.println("Ingrese nueva direccion, se recomienda ingresarla de la siguiente forma: [Girnalda #4 Col. Colosio Cuernavaca Morelos]");
        Direccion = System.console().readLine();
        empleado.setDireccion(Direccion);
    }
}