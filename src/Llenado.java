import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Llenado {

    public BufferedReader cp=new BufferedReader(new InputStreamReader(System.in));
    public Validacion validar=new Validacion();

    public Llenado() {

    }

    public ESTUDIANTE_INGENIERIA llenarIngeniero() throws IOException {
        String cedula;
        String nombre;
        String apellido;
        String telefono;
        int numeroDelSemestreActual;
        double promedioAcumulado;
        String serial;

        System.out.println("Ingrese la cedula: ");
        cedula =  validar.eleccionAValidar(3,cp.readLine());
       
        System.out.println("Ingrese el nombre: ");
        nombre = validar.eleccionAValidar(5,cp.readLine());
        
        System.out.println("Ingrese el apellido: ");
        apellido = validar.eleccionAValidar(5,cp.readLine());

        System.out.println("Ingrese el telefono: ");
        telefono =  validar.eleccionAValidar(3,cp.readLine());
       
        System.out.println("Ingrese el numero del semestre actual: ");
        numeroDelSemestreActual = Integer.parseInt(validar.eleccionAValidar(1,cp.readLine()));
        
        System.out.println("Ingrese el promedio acumulado: ");
        promedioAcumulado = Double.parseDouble(validar.eleccionAValidar(2,cp.readLine()));
        while (promedioAcumulado>5){
            System.out.println("No hay un promedio mayor a 5; En donde estudia usted ??");
            System.out.println("Ingrese nuevamente el promedio");
            promedioAcumulado = Double.parseDouble(validar.eleccionAValidar(2,cp.readLine()));
        }
        
        System.out.println("Ingrese el numero de serial: ");
        serial =  validar.eleccionAValidar(3,cp.readLine());

        return new ESTUDIANTE_INGENIERIA(cedula, nombre, apellido, telefono, numeroDelSemestreActual, promedioAcumulado, serial);
    }
    public ESTUDIANTE_DISENO llenarDiseno() throws IOException{
        String cedula;
        String nombre;
        String apellido;
        String telefono;
        String modalidad;
        int cantidadAsignaturas;
        int serial;

        System.out.println("Ingrese la cedula: ");
        cedula =  validar.eleccionAValidar(3,cp.readLine());
       
        System.out.println("Ingrese el nombre: ");
        nombre = validar.eleccionAValidar(4,cp.readLine());
        
        System.out.println("Ingrese el apellido: ");
        apellido = validar.eleccionAValidar(4,cp.readLine());
 
        System.out.println("Ingrese el telefono: ");
        telefono =  validar.eleccionAValidar(3,cp.readLine());

        System.out.println("Ingrese si el estudiante estudia de manera \"virtual\" o \"presencial\": ");
        modalidad = validar.eleccionAValidar(4,cp.readLine());

        System.out.println("Ingrese la cantidad de asignaturas: ");
        cantidadAsignaturas = Integer.parseInt(validar.eleccionAValidar(1,cp.readLine()));
        
        System.out.println("Ingrese el numero de serial: ");
        serial =  Integer.parseInt(validar.eleccionAValidar(1,cp.readLine()));

        return new ESTUDIANTE_DISENO(cedula, nombre, apellido, telefono, modalidad, cantidadAsignaturas, serial);

    }
    

    public COMPUTADOR_PORTATIL llenarComputador(String newSerial){

        String serial=newSerial;
        String marca;
        double tamano;
        double precio;
        String sistemaOperativo;
        String procesador;

        return null;
    }

    public String opcionSistemaOperativo()throws IOException{
        System.out.println("Ingrese 1 si");

        int opcion= Integer.parseInt(validar.eleccionAValidar(1, cp.readLine()));

        switch (opcion){
            case 1:
                return "Window 7";

        }
        return "Windows 7";
    }

}
