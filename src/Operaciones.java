import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
public class Operaciones {

    // Variables Globales  "No tocar"
    private LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieriaGlbal = new LinkedList<>();
    private LinkedList<ESTUDIANTE_DISENO> estudiantesDisenoGlobal = new LinkedList<>();
    private LinkedList<TABLETA_GRAFICA> tabletasGraficasGlobal = new LinkedList<>();
    private LinkedList<COMPUTADOR_PORTATIL> computadoresPortatilesGlobal = new LinkedList<>();
    

    public Operaciones() {
        Importar importar=new Importar();

        // se importa y se verifica que haya datos sobre los estudiantes de ingenieria
        LinkedList<ESTUDIANTE_INGENIERIA> verificar = importar.importarArchivoIngnieria();
        if (verificar!=null){
            estudiantesIngenieriaGlbal =verificar;
        }

        // se importa y se verifica que haya datos sobre los estudiantes de diseño
        LinkedList<ESTUDIANTE_DISENO> verificar2 = importar.importarArchivoDiseno();
        if (verificar2!=null){
            estudiantesDisenoGlobal=verificar2;
        }

        // se importa y se verifica que haya datos sobre las tablets
        LinkedList<TABLETA_GRAFICA> verificar3 = importar.importarArchivoTableta();
        if (verificar3!=null){
            tabletasGraficasGlobal=verificar3;
        }

        // se importa y se verifica que haya datos sobre los computadores
        LinkedList<COMPUTADOR_PORTATIL> verificar4 = importar.importarArchivoComputador();
        if (verificar4!=null){
            computadoresPortatilesGlobal=verificar4;
        }

    }

    public void menu() throws IOException{

        BufferedReader cp=new BufferedReader(new InputStreamReader(System.in));

        LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria = estudiantesIngenieriaGlbal;
        LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno = estudiantesDisenoGlobal;
        LinkedList<TABLETA_GRAFICA> tabletasGraficas = tabletasGraficasGlobal;
        LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles = computadoresPortatilesGlobal;
        
        Validacion validar=new Validacion();
        Llenado llenar=new Llenado();
        String lineas="--------------------------------------------";

        boolean flagMenu=true;

        while (flagMenu){
            System.out.println(lineas);
            System.out.println("\n--------------- MENU ---------------\n");
            System.out.println("Digite 1 si es ESTUDIANTES DE INGENIERIA.");
            System.out.println("Digite 2 si es ESTUDIANTES DE DISEÑO.");
            System.out.println("Digite 3 para IMPRIMIR INVENTARIO TOTAL.");
            System.out.println("Digite 4 para SALIR DEL PROGRAMA.");
            String opcionMenu= validar.eleccionAValidarSinSobrepasar(1, cp.readLine(), 4);

            switch (opcionMenu){
                case "1":

                    boolean flagMenuIngenieria=true;

                    while (flagMenuIngenieria){
                        System.out.println(lineas);
                        System.out.println("\n---------- ESTUDIANTE DE INGENIERIA ----------\n");
                        System.out.println("Digite 1 para Registrar préstamo de equipo.");
                        System.out.println("Digite 2 para Modificar préstamo de equipo.");
                        System.out.println("Digite 3 para Devolución de equipo.");
                        System.out.println("Digite 4 para Buscar equipo.");
                        System.out.println("Digite 5 para Volver al menú principal.");

                        String opcionIngenieria= validar.eleccionAValidarSinSobrepasar(1, cp.readLine(), 5);

                        switch (opcionIngenieria){
                            case "1":
                                System.out.println(lineas);
                                ESTUDIANTE_INGENIERIA newEstudiante = llenar.llenarIngeniero(llenar.serialStrings(estudiantesIngenieria));


                                COMPUTADOR_PORTATIL newComputador=llenar.asignarComputador(computadoresPortatiles);

                                if (newComputador!=null){
                                    for(COMPUTADOR_PORTATIL compu:computadoresPortatiles ){
                                        if (compu.getSerial().equals(newComputador.getSerial())){

                                            compu.setDisponible(false);
                                            newEstudiante.setSerial(compu.getSerial());
                                            break;

                                        }
                                    }
                                }else {
                                    newComputador=llenar.llenarComputador(newEstudiante.getSerial());
                                    computadoresPortatiles.add(newComputador);
                                }
                                System.out.println(lineas);
                                System.out.println("El serial asignado a usted es: " + newEstudiante.getSerial());
                                System.out.println(lineas);
                                estudiantesIngenieria.add(newEstudiante);
                                exportarIngenieros(estudiantesIngenieria,computadoresPortatiles);
                                break;
                            case "2":
                                Importar importar=new Importar();

                                System.out.println(lineas);
                                System.out.println("\nIngrese la cedula o el serial a modifcar: ");

                                estudiantesIngenieria=modificarEstudianteIngenieria(estudiantesIngenieria,validar.eleccionAValidar(3, cp.readLine()),computadoresPortatiles);


                                computadoresPortatiles = importar.importarArchivoComputador();

                                exportarI(estudiantesIngenieria);
                                break;
                            case "3":
                                System.out.println(lineas);
                                System.out.println("\nIngrese la cedula o el serial para hacer la devolución: ");

                                ArrayList<Integer> datos=dispositivoIngenieria(validar.eleccionAValidar(3, cp.readLine()));
                                // 0 , 1
                                if (datos.getFirst()==1){
                                    // indice del estudiante
                                    estudiantesIngenieria.remove(estudiantesIngenieria.get(datos.get(1)));
                                    // indice del computador
                                    computadoresPortatiles.get(datos.get(2)).setDisponible(true);
                                    System.out.println(lineas);
                                    System.out.println("\nDevolucion hecha\n");
                                    System.out.println(lineas);
                                    exportarIngenieros(estudiantesIngenieria,computadoresPortatiles);
                                }else {
                                    System.out.println("El estudiante no tiene un registro");
                                }


                                break;
                            case "4":
                                System.out.println(lineas);
                                System.out.println("\nIngrese la cedula o serial del prestamo del estudiante a buscar: ");
                                buscarIngenieria(estudiantesIngenieria, computadoresPortatiles,validar.eleccionAValidar(3, cp.readLine()) );

                                break;
                            case "5":
                                flagMenuIngenieria=false;

                                break;
                            default:
                                System.out.println(lineas);
                                System.out.println("el numero "+opcionIngenieria+" no es valido, seleccione una opción valida: ");

                        }
                    }

                    break;
                case "2":

                    boolean flagMenuDiseno=true;

                    while (flagMenuDiseno){
                        System.out.println(lineas);
                        System.out.println("\n---------- ESTUDIANTE DE DISEÑO ----------\n");
                        System.out.println("Digite 1 para Registrar préstamo de equipo.");
                        System.out.println("Digite 2 para Modificar préstamo de equipo.");
                        System.out.println("Digite 3 para Devolución de equipo.");
                        System.out.println("Digite 4 para Buscar equipo .");
                        System.out.println("Digite 5 para Volver al menú principal.");

                        String opcionDiseno= validar.eleccionAValidarSinSobrepasar(1, cp.readLine(), 5);

                        switch (opcionDiseno){
                            case "1":
                                System.out.println(lineas);
                                ESTUDIANTE_DISENO newEstudiante = llenar.llenarDiseno(llenar.serialEnteros(estudiantesDiseno));

                                TABLETA_GRAFICA newTableta_GRAFICA = llenar.asignarTableta(tabletasGraficas);

                                if (newTableta_GRAFICA!=null){

                                    for (TABLETA_GRAFICA table:tabletasGraficas){

                                        if (table.getSerial().equals(newTableta_GRAFICA.getSerial())){

                                            table.setDisponible(false);
                                            newEstudiante.setSerial(Integer.parseInt(table.getSerial()));
                                            break;

                                        }

                                    }

                                }else {
                                    newTableta_GRAFICA = llenar.llenarTableta_GRAFICA(newEstudiante.getSerial());
                                    tabletasGraficas.add(newTableta_GRAFICA);
                                }
                                System.out.println(lineas);
                                System.out.println("El serial generado aleatoriamente es: "+newEstudiante.getSerial());
                                estudiantesDiseno.add(newEstudiante);
                                exportarDisenadores(estudiantesDiseno,tabletasGraficas);
                                break;
                            case "2":
                                Importar importar=new Importar();

                                System.out.println(lineas);
                                System.out.println("ingrese la cedula o el serial a modifcar: ");

                                estudiantesDiseno=modificarEstudianteDiseno(estudiantesDiseno,validar.eleccionAValidar(3, cp.readLine()),tabletasGraficas);


                                tabletasGraficas = importar.importarArchivoTableta();

                                exportarD(estudiantesDiseno);

                                break;
                            case "3":

                                System.out.println(lineas);
                                System.out.println("ingrese la cedula o el serial a eliminar: ");

                                ArrayList<Integer> datos=dispositivoDiseno(validar.eleccionAValidar(3, cp.readLine()));
                                if (datos.getFirst()==1){
                                    estudiantesDiseno.remove(estudiantesDiseno.get(datos.get(1)));

                                    tabletasGraficas.get(datos.get(2)).setDisponible(true);


                                    System.out.println(lineas);
                                    System.out.println("\nDevolucion hecha\n");
                                    System.out.println(lineas);

                                    exportarDisenadores(estudiantesDiseno,tabletasGraficas);

                                }else {
                                    System.out.println(lineas);
                                    System.out.println("El estudiante no tiene un registro");
                                    System.out.println(lineas);
                                }

                                break;
                            case "4":
                                System.out.println(lineas);
                                System.out.println("Ingrese la cedula o serial del prestamo del estudiante a buscar: ");
                                buscardiseno(estudiantesDiseno, tabletasGraficas,validar.eleccionAValidar(3, cp.readLine()) );

                                break;
                            case "5":
                                flagMenuDiseno=false;
                                break;
                            default:
                                System.out.println("el numero "+opcionDiseno+" no es valido, seleccione una opción valida: ");

                        }

                    }

                    break;
                case "3":
                    mostrarInventario(estudiantesIngenieria,estudiantesDiseno,computadoresPortatiles,tabletasGraficas);
                    break;
                case "4":
                    exportarIngenieros(estudiantesIngenieria,computadoresPortatiles);
                    exportarDisenadores(estudiantesDiseno,tabletasGraficas);
                    flagMenu=false;
                    break;
                default:
                    System.out.println(lineas);
                    System.out.println("el numero "+opcionMenu+" no es valido, seleccione una opción valida: ");
            }
        }
    }

    // Metodo para modificar el prestamo de que hizo un estudiante de ingenieria
    public LinkedList<ESTUDIANTE_INGENIERIA> modificarEstudianteIngenieria(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria, String buscar, LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles) throws IOException{

        Llenado llenar=new Llenado();
        boolean Ishere=false;
        //
        for(ESTUDIANTE_INGENIERIA estudiante:estudiantesIngenieria){

            if (estudiante.getSerial().equals(buscar) || estudiante.getCedula().equals(buscar)){

                // se busca el computador
                for (COMPUTADOR_PORTATIL computador :computadoresPortatiles){

                    // se encuentra el computador buscado
                    if (computador.getSerial().equals(estudiante.getSerial())){

                        COMPUTADOR_PORTATIL compu = llenar.asignarComputador(computadoresPortatiles);

                        if(compu!=null){
                            for (COMPUTADOR_PORTATIL computador2 :computadoresPortatiles){

                                if (computador2.getSerial().equals(compu.getSerial())){

                                    computador2.setDisponible(false);
                                    estudiante.setSerial(computador2.getSerial());
                                    break;

                                }
                            }
                        }else{

                            estudiante.setSerial(llenar.serialStrings(estudiantesIngenieria));
                            computadoresPortatiles.add(llenar.llenarComputador(estudiante.getSerial()));

                        }
                        computador.setDisponible(true);
                        break;
                    }

                }

                Ishere=true;
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Modificación exitosa, su nuevo serial es: "+estudiante.getSerial());
                break;
            }

        }

        if (Ishere){
            exportarC(computadoresPortatiles);
        }else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("No se encontro la cedula o el serial en la base de datos.");
        }

        return estudiantesIngenieria;
    }

    // Metodo para modificar el prestamo de que hizo un estudiante de ingenieria
    public LinkedList<ESTUDIANTE_DISENO> modificarEstudianteDiseno(LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno,String buscar, LinkedList<TABLETA_GRAFICA> tabletaGraficas) throws IOException{

        Llenado llenar=new Llenado();
        boolean Ishere=false;

        //
        for(ESTUDIANTE_DISENO estudiante:estudiantesDiseno){

            if (String.valueOf(estudiante.getSerial()).equals(buscar) || estudiante.getCedula().equals(buscar)){


                for (TABLETA_GRAFICA tableta :tabletaGraficas){


                    if (tableta.getSerial().equals(String.valueOf(estudiante.getSerial()))){

                        TABLETA_GRAFICA table = llenar.asignarTableta(tabletaGraficas);

                        if(table!=null){

                            for (TABLETA_GRAFICA tableta2 :tabletaGraficas){

                                if (tableta2.getSerial().equals(table.getSerial())){

                                    tableta2.setDisponible(false);
                                    estudiante.setSerial(Integer.parseInt(tableta2.getSerial()));
                                    break;

                                }
                            }
                        }else{

                            estudiante.setSerial(llenar.serialEnteros(estudiantesDiseno));
                            tabletaGraficas.add(llenar.llenarTableta_GRAFICA(estudiante.getSerial()));

                        }

                        tableta.setDisponible(true);
                        break;
                    }

                }

                Ishere=true;
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Modificación exitosa, su nuevo serial es: "+estudiante.getSerial());
                break;
            }

        }

        if (Ishere){
            exportarT(tabletaGraficas);
        }else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("No se encontro la cedula o el serial en la base de datos.");
        }

        return estudiantesDiseno;
    }

    // Metodo devolucion ingenieria
    public ArrayList<Integer> dispositivoIngenieria(String buscar){

        Importar importar = new Importar();

        ArrayList<Integer> datos = new ArrayList<>();
        LinkedList<ESTUDIANTE_INGENIERIA> estudiantes = importar.importarArchivoIngnieria();
        LinkedList<COMPUTADOR_PORTATIL> computadores = importar.importarArchivoComputador();

        for (int i=0; i<estudiantes.size();i++){
            if (estudiantes.get(i).getCedula().equals(buscar) || estudiantes.get(i).getSerial().equals(buscar)){
                // Primer valor 0,1; 0 si no esta, 1 si esta
                datos.add(1);
                // Segundo valor: indice estudiante
                datos.add(i);

                for (int j=0;j < computadores.size();j++){

                    if (computadores.get(j).getSerial().equalsIgnoreCase(estudiantes.get(i).getSerial())){
                        // Tercer valor: indice computador

                        datos.add(j);
                    }
                }

                return datos;
            }
        }

        // Primer valor 0,1; 0 si no esta, 1 si esta
        datos.add(0);

        return datos;
    }

    // Metodo devolucion diseño
    public ArrayList<Integer> dispositivoDiseno(String buscar){

        Importar importar = new Importar();

        ArrayList<Integer> datos = new ArrayList<>();
        LinkedList<ESTUDIANTE_DISENO> estudiantes = importar.importarArchivoDiseno();
        LinkedList<TABLETA_GRAFICA> tableta = importar.importarArchivoTableta();

        for (int i=0; i<estudiantes.size();i++){
            if (estudiantes.get(i).getCedula().equals(buscar) || String.valueOf(estudiantes.get(i).getSerial()).equals(buscar)){
                // Primer valor 0,1; 0 si no esta, 1 si esta
                datos.add(1);
                // Segundo valor: indice estudiante
                datos.add(i);

                for (int j=0;j < tableta.size();j++){
                    if (tableta.get(j).getSerial().equals(String.valueOf(estudiantes.get(i).getSerial()))){
                        // Tercer valor: indice computador
                        datos.add(j);
                    }
                }
                return datos;
            }
        }

        // Primer valor 0,1; 0 si no esta, 1 si esta
        datos.add(0);

        return datos;
    }

    // Metodo para mostrar el prestamo de un estudiante de ingenieria mediante el serial o la cedula
    public void buscarIngenieria(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria, LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles, String buscar){

        boolean isIn=false;

        for(ESTUDIANTE_INGENIERIA estudiante:estudiantesIngenieria){

            if (estudiante.getSerial().equals(buscar) || estudiante.getCedula().equals(buscar)){
                System.out.println("--------------- "+estudiante.getNombre()+" " +estudiante.getApellido()+" --------------");
                isIn=true;

                for (COMPUTADOR_PORTATIL computador :computadoresPortatiles){

                    if (computador.getSerial().equals(estudiante.getSerial())){

                        System.out.println("Tiene un prestamo activo del computador portatil: " + computador.getMarca() +
                        " \nCon un procesador: " + computador.getProcesador() +
                        "\nCon un sistema operativo: " + computador.getSistemaOperativo());
                        break;
                    }

                }
                break;
            }
        }
        if (!isIn){
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("No se encuentra un prestamo relacionado con el estudiante que tiene la cedula/serial: "+buscar);
        }
    }

    // Metodo para mostrar el prestamo de un estudiante de diseño mediante el serial o la cedula
    public void buscardiseno(LinkedList<ESTUDIANTE_DISENO> estudiantesdiseno, LinkedList<TABLETA_GRAFICA> tabletasGraficas, String buscar){

        boolean isIn=false;

        for(ESTUDIANTE_DISENO estudiante:estudiantesdiseno){

            if (estudiante.getCedula().equals(buscar) || String.valueOf(estudiante.getSerial()).equals(buscar) ){
                System.out.println("--------------- "+estudiante.getNombre()+" " +estudiante.getApellido()+" --------------");
                isIn=true;

                for (TABLETA_GRAFICA tableta :tabletasGraficas){

                    if (tableta.getSerial().equals(String.valueOf(estudiante.getSerial()))){

                        System.out.println("Tiene un prestamo activo de la Tableta Grafica: " + tableta.getMarca() +
                                " \nCon un almacenamiento de : " + tableta.getAlmacenamiento());
                        break;
                    }

                }
                break;
            }
        }
        if (!isIn){
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("No se encuentra un prestamo relacionado con el estudiante que tiene la cedula/serial: "+buscar);
        }
    }

    // Metodo para mostrar el inventario total
    public void mostrarInventario(LinkedList<ESTUDIANTE_INGENIERIA> estudianteI,LinkedList<ESTUDIANTE_DISENO> estudianteD,LinkedList<COMPUTADOR_PORTATIL> computadores,LinkedList<TABLETA_GRAFICA> tabletaGraficas){

        String lineas="------------------------------------------------------------";

        System.out.println(lineas);

        System.out.println("\n     --- INVENTARIO NO DISPONIBLE ---\n");
        System.out.println(lineas);
        System.out.println("\nEstudiantes Ingenieria: \n");
        for (ESTUDIANTE_INGENIERIA estudiante : estudianteI){
            System.out.println(lineas);
            System.out.println(estudiante.getNombre()+" "+estudiante.getApellido());

            for (COMPUTADOR_PORTATIL computadorPortatil: computadores){
                if (computadorPortatil.getSerial().equals(estudiante.getSerial())){

                    System.out.println("Tiene un prestamo activo del computador portatil: " + computadorPortatil.getMarca() +
                            " \nCon un procesador: " + computadorPortatil.getProcesador() +
                            "\nCon un sistema operativo: " + computadorPortatil.getSistemaOperativo());
                    break;
                }
            }

        }
        System.out.println(lineas);
        System.out.println("\nEstudiantes Diseño: \n");

        for (ESTUDIANTE_DISENO estudiante: estudianteD){

            System.out.println(lineas);
            System.out.println(estudiante.getNombre()+" "+estudiante.getApellido());

            for (TABLETA_GRAFICA tableta: tabletaGraficas){

                if (String.valueOf(estudiante.getSerial()).equals(tableta.getSerial())){

                    System.out.println("Tiene un prestamo activo de la Tableta Grafica: " + tableta.getMarca() +
                            " \nCon un almacenamiento de : " + tableta.getAlmacenamiento());

                    break;
                }
            }
        }

        System.out.println(lineas);
        System.out.println("\n     --- INVENTARIO DISPONIBLE ---\n");
        System.out.println(lineas);
        System.out.println("\nComputadores: \n");

        for (COMPUTADOR_PORTATIL computador: computadores){
            if (!computador.isDisponible()){
                continue;
            }
            System.out.println(lineas);
            System.out.println("serial: "+computador.getSerial()+ "\n");
            System.out.println("marca: "+computador.getMarca()+ "\n");
            System.out.println("tamaño: "+computador.getTamano()+ "\n");
            System.out.println("precio: "+computador.getPrecio()+ "\n");
            System.out.println("sistema Operativo: "+computador.getSistemaOperativo()+ "\n");
            System.out.println("procesador: "+computador.getProcesador()+ "\n");
            System.out.println("Disponible: "+computador.isDisponible()+ "\n");


        }
        System.out.println(lineas);
        System.out.println("\nTablets: \n");

        for (TABLETA_GRAFICA tablet: tabletaGraficas){
            if (!tablet.isDisponible()){
                continue;
            }
            System.out.println(lineas);
            System.out.println("serial: "+tablet.getSerial()+ "\n");
            System.out.println("marca: "+tablet.getMarca()+ "\n");
            System.out.println("tamaño: "+tablet.getTamano()+ "\n");
            System.out.println("precio: "+tablet.getPrecio()+ "\n");
            System.out.println("almacenamiento: "+tablet.getAlmacenamiento()+ "\n");
            System.out.println("peso: "+tablet.getPeso()+ "\n");
            System.out.println("Disponible: "+tablet.isDisponible()+ "\n");

        }

    }

    // Metodo para exportar los estudiantes De ingenieria
    private void exportarIngenieros(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria, LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles){

        exportarI(estudiantesIngenieria);
        exportarC(computadoresPortatiles);

    }

    private void exportarI(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoIngenieria(estudiantesIngenieria);
    }
    private void exportarC(LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoComputador(computadoresPortatiles);
    }

    // Metodo para exportar los estudiantes De Diseño
    private void exportarDisenadores(LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno, LinkedList<TABLETA_GRAFICA> tabletasGraficas){

        exportarD(estudiantesDiseno);
        exportarT(tabletasGraficas);

    }

    private void exportarD(LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoDiseno(estudiantesDiseno);
    }
    private void exportarT(LinkedList<TABLETA_GRAFICA> tabletasGraficas){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoTableta(tabletasGraficas);
    }

}
