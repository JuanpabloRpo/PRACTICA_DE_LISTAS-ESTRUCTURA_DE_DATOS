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

    public ESTUDIANTE_INGENIERIA llenarIngeniero(String serialIngeniero) throws IOException {
        String cedula;
        String nombre;
        String apellido;
        String telefono;
        int numeroDelSemestreActual;
        double promedioAcumulado;

        System.out.println("Ingrese la cedula: ");
        cedula =  validar.eleccionAValidar(6,cp.readLine());
       
        System.out.println("Ingrese el nombre: ");
        nombre = validar.eleccionAValidar(5,cp.readLine());
        
        System.out.println("Ingrese el apellido: ");
        apellido = validar.eleccionAValidar(5,cp.readLine());

        System.out.println("Ingrese el telefono: ");
        telefono =  validar.eleccionAValidar(1,cp.readLine());
       
        System.out.println("Ingrese el numero del semestre actual: ");
        numeroDelSemestreActual = Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1,cp.readLine(),10));
        
        System.out.println("Ingrese el promedio acumulado: ");
        promedioAcumulado = Double.parseDouble(validar.eleccionAValidarSinSobrepasar(2,cp.readLine() ,5));
        
        System.out.println("El serial generado aleatoriamente es: "+serialIngeniero);

        return new ESTUDIANTE_INGENIERIA(cedula, nombre, apellido, telefono, numeroDelSemestreActual, promedioAcumulado, serialIngeniero);
    }
    public ESTUDIANTE_DISENO llenarDiseno(int serialDiseno) throws IOException{
        String cedula;
        String nombre;
        String apellido;
        String telefono;
        String modalidad;
        int cantidadAsignaturas;

        System.out.println("Ingrese la cedula: ");
        cedula =  validar.eleccionAValidar(6,cp.readLine());
       
        System.out.println("Ingrese el nombre: ");
        nombre = validar.eleccionAValidar(5,cp.readLine());
        
        System.out.println("Ingrese el apellido: ");
        apellido = validar.eleccionAValidar(5,cp.readLine());
 
        System.out.println("Ingrese el telefono: ");
        telefono =  validar.eleccionAValidar(1,cp.readLine());

        modalidad = opcionEstudio();

        System.out.println("Ingrese la cantidad de asignaturas: ");
        cantidadAsignaturas = Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1,cp.readLine(),7));
        
        System.out.println("El serial asignado a usted es: " + serialDiseno);

        return new ESTUDIANTE_DISENO(cedula, nombre, apellido, telefono, modalidad, cantidadAsignaturas, serialDiseno);
    }
    public TABLETA_GRAFICA llenarTableta_GRAFICA(int newSerial)throws IOException{

        String serial = String.valueOf(newSerial);
        String marca;
        double tamano;
        double precio;
        String almacenamiento;
        double peso;

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

        String marca;
        double tamano;
        double precio;
        String sistemaOperativo;
        String procesador;

        System.out.println("Ingrese la marca del computador portatil: ");
        marca = validar.eleccionAValidar(4, cp.readLine());

        System.out.println("Ingrese el tamaño del computador portatil en pulgadas: ");
        tamano = Double.parseDouble(validar.eleccionAValidar(2, cp.readLine()));

        System.out.println("Ingrese el precio: ");
        precio = Double.parseDouble(validar.eleccionAValidar(2, cp.readLine()));

        sistemaOperativo = opcionSistemaOperativo();
        procesador = opcionProcesador();

        return new COMPUTADOR_PORTATIL(newSerial, marca, tamano, precio, sistemaOperativo, procesador);
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

    // Metodo para crear el serial de tipo String  de estudiantes de ingenieria
    public String serialStrings(LinkedList<String> serialesIngenieria){
        String serial = "0";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            if(random.nextInt(1,3)==1){
                serial +=enteroAleatorio();
            }else{
                serial += Character.toString(letraAleatoria(random.nextInt(1,3)));
            }
               
       }


        for (String serialLista : serialesIngenieria) {
            if (serial.equals(serialLista)) {
                serial = String.valueOf(serialStrings(serialesIngenieria));
                break;
            }
        }



        return serial;   
    }

    // Metodo para generar un numero aleatorio
    public String enteroAleatorio(){

        Random random = new Random();
        return String.valueOf(random.nextInt(10));

    }

    // Metodo para generar una letra mayuscula o minuscula aleatoria
    public int letraAleatoria(int opcion){
        Random random = new Random();
        if (opcion==1){
            return random.nextInt(97,123);
        }else{
            return random.nextInt(65,91);
        }
    }

}
