import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class Llenado {

    public BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));
    public Validacion validar = new Validacion();

    public Llenado() {

    }

    // Metodo para llenar los estudiantes que estudian ingenieria
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
        telefono =  validar.eleccionAValidar(7,cp.readLine());
       
        System.out.println("Ingrese el numero del semestre actual: ");
        numeroDelSemestreActual = Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1,cp.readLine(),10));
        
        System.out.println("Ingrese el promedio acumulado: ");
        promedioAcumulado = Double.parseDouble(validar.eleccionAValidarSinSobrepasar(2,cp.readLine() ,5));

        return new ESTUDIANTE_INGENIERIA(cedula, nombre, apellido, telefono, numeroDelSemestreActual, promedioAcumulado, serialIngeniero);
    }

    // Metodo para llenar los estudiantes que estudian diseño
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
        telefono =  validar.eleccionAValidar(7,cp.readLine());

        modalidad = opcionEstudio();

        System.out.println("Ingrese la cantidad de asignaturas: ");
        cantidadAsignaturas = Integer.parseInt(validar.eleccionAValidarSinSobrepasar(1,cp.readLine(),7));

        return new ESTUDIANTE_DISENO(cedula, nombre, apellido, telefono, modalidad, cantidadAsignaturas, serialDiseno);
    }

    // Metodo para llenar los datos de las tabletas graficas
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

        return new TABLETA_GRAFICA(serial, marca, tamano, precio, almacenamiento, peso,false);
    }

    // Metodo para llenar los datos de los computadores
    public COMPUTADOR_PORTATIL llenarComputador(String newSerial) throws IOException{

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

        return new COMPUTADOR_PORTATIL(newSerial, marca, tamano, precio, sistemaOperativo, procesador,false);
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
    public int serialEnteros(LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno){
        String serial = "0";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
             serial += String.valueOf(random.nextInt(9-1) +1);     
        }

        for (ESTUDIANTE_DISENO estudiante : estudiantesDiseno) {
            if (Integer.parseInt(serial) == estudiante.getSerial()) {
                serial = String.valueOf(serialEnteros(estudiantesDiseno));
                break;
            }
        }

        return Integer.parseInt(serial);
    }

    // Metodo para crear el serial de tipo String  de estudiantes de ingenieria
    public String serialStrings(LinkedList<ESTUDIANTE_INGENIERIA> estudianteIngenieria){
        String serial = "0";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            if(random.nextInt(1,3)==1){
                serial +=enteroAleatorio();
            }else{
                serial += Character.toString(letraAleatoria(random.nextInt(1,3)));
            }
               
       }

        // Comprobamos que el serial no se repita; en tal caso se vuelve a llamar la funcion
        for (ESTUDIANTE_INGENIERIA  estudiante: estudianteIngenieria) {
            if (serial.equals(estudiante.getSerial())) {
                serial = String.valueOf(serialStrings(estudianteIngenieria));
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

    // Metodo para buscar los computadores disponibles
    public String buscarComputador(LinkedList<COMPUTADOR_PORTATIL> computadores) throws IOException{

        int count = 0;

        ArrayList<String> serialesDisponibles = new ArrayList<>();
        for (COMPUTADOR_PORTATIL dispositivo: computadores){

            if (dispositivo.isDisponible()){

                count++;

                if (count==1) {
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("\nEn este momento tenemos disponibles los siguientes computadores: ");
                }
                serialesDisponibles.add(dispositivo.getSerial());
                System.out.println("----------------------------------------");
                System.out.println("serial: "+dispositivo.getSerial()+ "\n");
                System.out.println("marca: "+dispositivo.getMarca()+ "\n");
                System.out.println("tamaño: "+dispositivo.getTamano()+ "\n");
                System.out.println("precio: "+dispositivo.getPrecio()+ "\n");
                System.out.println("sistema Operativo: "+dispositivo.getSistemaOperativo()+ "\n");
                System.out.println("procesador: "+dispositivo.getProcesador()+ "\n");
                System.out.println("-----------------------------"+ "\n");
            }

        }

        if (count>4) {
            System.out.println("Digite el serial del computador que le gusto: ");
            String opcion=validar.eleccionAValidar(3,cp.readLine());
            while (true){
                if (serialesDisponibles.contains(opcion)){
                    return opcion;

                }else {
                    System.out.println("Dato no valido, digite un serial que este disponible: ");
                    opcion=validar.eleccionAValidar(3,cp.readLine());
                }
            }
        }

        if(count>0) {
            System.out.println("Digite el serial del computador que le gusto ó digite NO para escoger las especificaciones: ");
            String opcion=validar.eleccionAValidar(3,cp.readLine());
            while (true){
                if (serialesDisponibles.contains(opcion) || opcion.equalsIgnoreCase("no")){
                    return opcion;
                }else {
                    System.out.println("Dato no valido, digite el serial del computador que le gusto ó digite NO para escoger las especificaciones: ");
                    opcion=validar.eleccionAValidar(3,cp.readLine());
                }
            }

        }else {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("\nDigite los datos del computador que desea: \n");
            System.out.println("-------------------------------------------------------------------------------------");
            return "-100";
        }

    }

    // Metodo para asignar un computador disponible
    public COMPUTADOR_PORTATIL asignarComputador(LinkedList<COMPUTADOR_PORTATIL> computadores) throws IOException {

        String serial = buscarComputador(computadores);

        for (COMPUTADOR_PORTATIL dispositivo: computadores){

            if (serial.equals(dispositivo.getSerial()) && dispositivo.isDisponible()){
                return dispositivo;
            }

        }

        return null;
    }

    // Metodo para buscar las tablets disponibles
    public String buscarTabletas(LinkedList<TABLETA_GRAFICA> tabletasGraficas) throws IOException{

        int cout = 0;

        ArrayList<String> serialesDisponibles=new ArrayList<>();

        for (TABLETA_GRAFICA dispositivo: tabletasGraficas){

            if (dispositivo.isDisponible()){
                cout++;
                if (cout==1){
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("\n----- En este momento tenemos disponibles las siguientes tablets: ");
                }
                System.out.println("-------------------------------------------");
                serialesDisponibles.add(dispositivo.getSerial());
                System.out.println("serial: "+dispositivo.getSerial()+ "\n");
                System.out.println("marca: "+dispositivo.getMarca()+ "\n");
                System.out.println("tamaño: "+dispositivo.getTamano()+ "\n");
                System.out.println("precio: "+dispositivo.getPrecio()+ "\n");
                System.out.println("almacenamiento: "+dispositivo.getAlmacenamiento()+ "\n");
                System.out.println("peso: "+dispositivo.getPeso()+ "\n");
                System.out.println("-----------------------------"+ "\n");
            }

        }

        if(cout>4){
            System.out.println("Digite el serial de la tableta que le gusto: ");
            String opcion=validar.eleccionAValidar(3,cp.readLine());
            while (true){
                if (serialesDisponibles.contains(opcion)){
                    return opcion;

                }else {
                    System.out.println("Dato no valido, digite un serial que este disponible: ");
                    opcion=validar.eleccionAValidar(3,cp.readLine());
                }
            }
        }

        if (cout>0){

            System.out.println("Digite el serial de la tableta que le gusto ó digite NO para escoger las especificaciones: ");
            String opcion=validar.eleccionAValidar(3,cp.readLine());
            while (true){
                if (serialesDisponibles.contains(opcion) || opcion.equalsIgnoreCase("no")){
                    return opcion;
                }else {
                    System.out.println("Dato no valido, digite el serial de la tableta que le gusto ó digite NO para escoger las especificaciones: ");
                    opcion=validar.eleccionAValidar(3,cp.readLine());
                }
            }
        }else {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("\nDigite los datos de la tableta que desea: \n");
            System.out.println("-------------------------------------------------------------------------------------");
            return "-100";
        }


    }

    // Metodo para asignar una tablet disponible
    public TABLETA_GRAFICA asignarTableta(LinkedList<TABLETA_GRAFICA> tabletasGraficas) throws IOException {

        String serial = buscarTabletas(tabletasGraficas);

        for (TABLETA_GRAFICA dispositivo: tabletasGraficas){

            if (serial.equals(String.valueOf(dispositivo.getSerial())) && dispositivo.isDisponible()){
                return dispositivo;
            }
        }


        return null;
    }

}
