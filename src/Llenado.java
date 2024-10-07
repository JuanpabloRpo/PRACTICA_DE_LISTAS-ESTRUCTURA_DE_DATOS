import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;


public class Llenado {

    public BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
    public Validacion validar = new Validacion();
    

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
        promedioAcumulado = Double.parseDouble(validar.eleccionAValidarSinSobrepasar(2,cp.readLine() ,5));
        
        
        System.out.println("Ingrese el numero de serial: ");
        serial =  validar.eleccionAValidar(3,cp.readLine());

        return new ESTUDIANTE_INGENIERIA(cedula, nombre, apellido, telefono, numeroDelSemestreActual, promedioAcumulado, serial);
    }
    public ESTUDIANTE_DISENO llenarDiseno(int serialDiseno) throws IOException{
        String cedula;
        String nombre;
        String apellido;
        String telefono;
        String modalidad;
        int cantidadAsignaturas;
        int serial = serialDiseno;

        System.out.println("Ingrese la cedula: ");
        cedula =  validar.eleccionAValidar(3,cp.readLine());
       
        System.out.println("Ingrese el nombre: ");
        nombre = validar.eleccionAValidar(4,cp.readLine());
        
        System.out.println("Ingrese el apellido: ");
        apellido = validar.eleccionAValidar(4,cp.readLine());
 
        System.out.println("Ingrese el telefono: ");
        telefono =  validar.eleccionAValidar(1,cp.readLine());

        modalidad = opcionEstudio();

        System.out.println("Ingrese la cantidad de asignaturas: ");
        cantidadAsignaturas = Integer.parseInt(validar.eleccionAValidar(1,cp.readLine()));
        
        System.out.println("El serial asignado a usted es: " + serial);

        return new ESTUDIANTE_DISENO(cedula, nombre, apellido, telefono, modalidad, cantidadAsignaturas, serial);
    }
    public TABLETA_GRAFICA llenarTableta_GRAFICA(int newSerial)throws IOException{

        String serial = String.valueOf(newSerial);
        String marca = "";
        double tamano = 0;
        double precio = 0;
        String almacenamiento = "";
        Double peso = 0.0;

        System.out.println("Ingrese la marca de la tableta gráfica: ");
        marca = validar.eleccionAValidar(4, cp.readLine());

        System.out.println("Ingrese el tamaño de la tableta gráfica en pulgadas: ");
        tamano = Double.parseDouble(validar.eleccionAValidar(2, cp.readLine()));

        System.out.println("Ingrese el precio: ");
        precio = Double.parseDouble(validar.eleccionAValidar(2, cp.readLine()));

        almacenamiento = opcionAlmacenamiento();

        System.out.println("Ingrese el peso en kilogramos(Kg): ");
        peso = Double.parseDouble(validar.eleccionAValidar(2, cp.readLine()));

        return new TABLETA_GRAFICA(serial, marca, tamano, precio, almacenamiento, peso);
    }

    public COMPUTADOR_PORTATIL llenarComputador(String newSerial)throws IOException{

        String serial = newSerial;
        String marca = "";
        double tamano = 0.0;
        double precio = 0.0;
        String sistemaOperativo = "";
        String procesador = "";

        System.out.println("Ingrese la marca del computador portatil: ");
        marca = validar.eleccionAValidar(4, cp.readLine());

        System.out.println("Ingrese el tamaño del computador portatil en pulgadas: ");
        tamano = Double.parseDouble(validar.eleccionAValidar(2, cp.readLine()));

        System.out.println("Ingrese el precio: ");
        precio = Double.parseDouble(validar.eleccionAValidar(2, cp.readLine()));

        sistemaOperativo = opcionSistemaOperativo();
        procesador = opcionProcesador();

        return new COMPUTADOR_PORTATIL(serial, marca, tamano, precio, sistemaOperativo, procesador);
    }
    //  Método para seleccion la modalidad de estudio

    public String opcionEstudio()throws IOException{
        System.out.println("Ingrese \"1\" si el estudiante estudia de manera Virtual o \"2\" si estudia de manera Presencial: ");
        int opcion = Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1, cp.readLine(),2));
        switch (opcion) {
            case 1:
                return  "Virtual";
            case 2:
                return "Presencial";
        
            default:
                System.out.println("Dato no valido");
                opcionEstudio();
        }
        return "Gracias por su elección";
    }
    // Método para selecion de almacenamiento de la tableta grafica

    public String opcionAlmacenamiento()throws IOException{
        System.out.println("Ingrese 1 si desea un almacenamiento de 256 GB: \n Ingrese 2 si desea un almacenamiento de 512 GB: \n Ingrese 3 si desea un almacenamiento de 1 TB: ");
        int opcion = Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1, cp.readLine(),3));
        switch (opcion) {
            case 1:
                return "256 GB";
            
            case 2:
                return "512 GB";
            
            case 3:
                return "1 TB";

            default:
            System.out.println("Dato no valido");
            opcionAlmacenamiento();
        }
        return "Gracias por su elección";
    }
    // Método para selecionar el sistema operativo del computador portatil

    public String opcionSistemaOperativo()throws IOException{
        System.out.println("Ingrese 1 si desea el sistema operativo Windows 7: \n Ingrese 2 si desea el sistema operativo Windows 10: \n Ingrese 3 si desea el sistema operativo Windows 11: ");

        int opcion= Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1, cp.readLine(),3));

        switch (opcion){
            case 1:
                return "Window 7";
            case 2: 
                return "Windows 10";
            case 3:
                return "Windows 11";

            default:
            System.out.println("Dato no valido");
            opcionSistemaOperativo();
        }
        return "Gracias por su elección";
    }
    // Método para seleccionar el tipo de procesador del computador portatil
    public String opcionProcesador()throws IOException{
        System.out.println("Ingrese 1 si desea el procesador AMD Ryzen: \n Ingrese 2 si desea el procesadaor Intel® Core™ i5: ");
        int opcion = Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1, cp.readLine(),2));
        switch (opcion) {
            case 1:
                return "AMD Ryzen";
            
            case 2:
                return "Intel® Core™ i5";
            default:
            System.out.println("Dato no valido");
            opcionProcesador();
        }
        return "Gracias por su elección";
    }
    // Método para crear el serial de números enteros de estudiantes de diseño
    public int serialEnteros(LinkedList<Integer> serialesDiseno){
        String serial = "0";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
             serial += String.valueOf(random.nextInt(9-1) +1);     
        }
        for (Integer serialLista : serialesDiseno) { 
            if (Integer.parseInt(serial) == serialLista) {
                serial = String.valueOf(serialEnteros(serialesDiseno));
                break;
            }
        }
        return Integer.parseInt(serial);
    }
}
