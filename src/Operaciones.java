import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
public class Operaciones {

    // Variables Globales  "No tocar"
    private LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieriaGlbal = new LinkedList<>();
    private LinkedList<ESTUDIANTE_DISENO> estudiantesDisenoGlobal = new LinkedList<>();
    private LinkedList<TABLETA_GRAFICA> tabletasGraficasGlobal = new LinkedList<>();
    private LinkedList<COMPUTADOR_PORTATIL> computadoresPortatilesGlobal = new LinkedList<>();
    private LinkedList<Integer> serialDisenoGlobal = new LinkedList<>();
    private LinkedList<String> serialIngenieriaGlobal = new LinkedList<>();
    

    public Operaciones() {
        Importar importar=new Importar();

        String lineas="--------------------------------------------";
        System.out.println(lineas);
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

        // se importa y se verifica que haya datos sobre los computadores
        LinkedList<TABLETA_GRAFICA> verificar3 = importar.importarArchivoTableta();
        if (verificar3!=null){
            tabletasGraficasGlobal=verificar3;
        }

        // se importa y se verifica que haya datos sobre los computadores
        LinkedList<COMPUTADOR_PORTATIL> verificar4 = importar.importarArchivoComputador();
        if (verificar4!=null){
            computadoresPortatilesGlobal=verificar4;
        }

        LinkedList<String> verificar5 = importar.importarArchivoSrialIngenieros();
        if (verificar5!=null){
            serialIngenieriaGlobal=verificar5;
        }

        LinkedList<Integer> verificar6 = importar.importarArchivoSerialDiseno();
        if (verificar6!=null){
            serialDisenoGlobal=verificar6;
        }
    }

    public void menu() throws IOException{

        BufferedReader cp=new BufferedReader(new InputStreamReader(System.in));

        LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria = estudiantesIngenieriaGlbal;
        LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno = estudiantesDisenoGlobal;
        LinkedList<TABLETA_GRAFICA> tabletasGraficas = tabletasGraficasGlobal;
        LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles = computadoresPortatilesGlobal;
        LinkedList<Integer> serialDiseno = serialDisenoGlobal;
        LinkedList<String> serialIngenieria = serialIngenieriaGlobal;
        
        Validacion validar=new Validacion();
        Llenado llenar=new Llenado();
        String lineas="--------------------------------------------";

        boolean flagMenu=true;

        while (flagMenu){
            System.out.println(lineas);
            System.out.println("\n----- MENU -----\n");
            System.out.println("Digite 1 si es ESTUDIANTES DE INGENIERIA.");
            System.out.println("Digite 2 si es ESTUDIANTES DE DISEÑO.");
            System.out.println("Digite 3 para IMPRIMIR INVENTARIO TOTAL.");
            System.out.println("Digite 4 para SALIR DEL PROGRAMA.");
            String opcion= cp.readLine();

            // se valida que sea un entero
            if (validar.isInt(opcion)){

                switch (opcion){
                    case "1":

                        boolean flagMenuIngenieria=true;

                        while (flagMenuIngenieria){
                            System.out.println(lineas);
                            System.out.println("\n----- ESTUDIANTE DE INGENIERIA -----\n");
                            System.out.println("Digite 1 para Registrar préstamo de equipo.");
                            System.out.println("Digite 2 para Modificar préstamo de equipo.");
                            System.out.println("Digite 3 para Devolución de equipo.");
                            System.out.println("Digite 4 para Buscar equipo.");
                            System.out.println("Digite 5 para Volver al menú principal.");

                            String opcionIngenieria= cp.readLine();

                            // se valida que sea un entero
                            if (validar.isInt(opcionIngenieria)){
                                switch (opcionIngenieria){
                                    case "1":

                                        ESTUDIANTE_INGENIERIA newEstudiante = llenar.llenarIngeniero(llenar.serialStrings(serialIngenieria));
                                        estudiantesIngenieria.add(newEstudiante);
                                        serialIngenieria.add(newEstudiante.getSerial());

                                        COMPUTADOR_PORTATIL newComputador=llenar.llenarComputador(newEstudiante.getSerial());
                                        computadoresPortatiles.add(newComputador);

                                        exportarIngenieros(estudiantesIngenieria,computadoresPortatiles,serialIngenieria);
                                        break;
                                    case "2":
                                        Importar importar=new Importar();

                                        System.out.println("ingrese la cedula o el serial a modifcar: ");

                                        estudiantesIngenieria=modificarEstudianteIngenieria(estudiantesIngenieria,validar.eleccionAValidar(3, cp.readLine()),serialIngenieria,computadoresPortatiles);

                                        serialIngenieria = importar.importarArchivoSrialIngenieros();
                                        computadoresPortatiles = importar.importarArchivoComputador();

                                        exportarI(estudiantesIngenieria);
                                        break;
                                    case "3":

                                        System.out.println("ingrese la cedula o el serial a eliminar: ");

                                        ArrayList<Integer> datos=dispositivoIngenieria(validar.eleccionAValidar(3, cp.readLine()));
                                        if (datos.getFirst()==1){

                                            estudiantesIngenieria.remove(estudiantesIngenieria.get(datos.get(1)));
                                            computadoresPortatiles.remove(computadoresPortatiles.get(datos.get(2)));
                                            serialIngenieria.remove(serialIngenieria.get(datos.get(3)));
                                            System.out.println("Devolucion hecha");
                                            exportarIngenieros(estudiantesIngenieria,computadoresPortatiles,serialIngenieria);

                                        }else {
                                            System.out.println("El estudiante no tiene un registro");
                                        }


                                        break;
                                    case "4":
                                        System.out.println("Ingrese la cedula o serial del prestamo del estudiante a buscar");
                                        buscarIngenieria(estudiantesIngenieria, computadoresPortatiles,validar.eleccionAValidar(3, cp.readLine()) );

                                        break;
                                    case "5":
                                        flagMenuIngenieria=false;

                                        break;
                                    default:
                                        System.out.println("Digite por favor un dato valido");

                                }
                            }
                        }

                        break;
                    case "2":

                        boolean flagMenuDiseno=true;

                        while (flagMenuDiseno){
                            System.out.println(lineas);
                            System.out.println("\n----- ESTUDIANTE DE DISEÑO -----\n");
                            System.out.println("Digite 1 para Registrar préstamo de equipo.");
                            System.out.println("Digite 2 para Modificar préstamo de equipo.");
                            System.out.println("Digite 3 para Devolución de equipo.");
                            System.out.println("Digite 4 para Buscar equipo .");
                            System.out.println("Digite 5 para Volver al menú principal.");

                            String opcionDiseno= cp.readLine();

                            // se valida que sea un entero
                            if (validar.isInt(opcionDiseno)){
                                switch (opcionDiseno){
                                    case "1":
                                        ESTUDIANTE_DISENO newEstudiante = llenar.llenarDiseno(llenar.serialEnteros(serialDiseno));
                                        estudiantesDiseno.add(newEstudiante);
                                        serialDiseno.add(newEstudiante.getSerial());

                                        TABLETA_GRAFICA newTableta_GRAFICA = llenar.llenarTableta_GRAFICA(newEstudiante.getSerial());
                                        tabletasGraficas.add(newTableta_GRAFICA);

                                        exportarDisenadores(estudiantesDiseno,tabletasGraficas,serialDiseno);
                                        break;
                                    case "2":
                                        Importar importar=new Importar();

                                        System.out.println("ingrese la cedula o el serial a modifcar: ");

                                        estudiantesDiseno=modificarEstudianteDiseno(estudiantesDiseno,validar.eleccionAValidar(3, cp.readLine()),serialDiseno,tabletasGraficas);

                                        serialDiseno = importar.importarArchivoSerialDiseno();
                                        tabletasGraficas = importar.importarArchivoTableta();

                                        exportarD(estudiantesDiseno);

                                        break;
                                    case "3":

                                        System.out.println("ingrese la cedula o el serial a eliminar: ");

                                        ArrayList<Integer> datos=dispositivoDiseno(validar.eleccionAValidar(3, cp.readLine()));
                                        if (datos.getFirst()==1){

                                            estudiantesDiseno.remove(estudiantesDiseno.get(datos.get(1)));
                                            tabletasGraficas.remove(tabletasGraficas.get(datos.get(2)));
                                            serialDiseno.remove(serialDiseno.get(datos.get(3)));
                                            System.out.println("Devolucion hecha");
                                            exportarDisenadores(estudiantesDiseno,tabletasGraficas,serialDiseno);

                                        }else {
                                            System.out.println("El estudiante no tiene un registro");
                                        }

                                        break;
                                    case "4":

                                        System.out.println("null");
                                        break;
                                    case "5":
                                        flagMenuDiseno=false;
                                        break;
                                    default:
                                        System.out.println("Digite por favor un dato valido");

                                }
                            }
                        }

                        break;
                    case "3":
                        System.out.println(lineas);
                        System.out.println("Mantenimiento");
                        break;
                    case "4":
                        exportarIngenieros(estudiantesIngenieria,computadoresPortatiles,serialIngenieria);
                        exportarDisenadores(estudiantesDiseno,tabletasGraficas,serialDiseno);
                        flagMenu=false;
                        break;
                    default:
                        System.out.println("Digite por favor un dato valido");
                }
            }else {
                System.out.println("Digite por favor un dato valido");
            }
        }
    }
    // empiecen de aqui para abajo

    public LinkedList<ESTUDIANTE_INGENIERIA> modificarEstudianteIngenieria(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria, String buscar, LinkedList<String> serialIngenieria, LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles ) throws IOException{

        Llenado llenar=new Llenado();
        boolean Ishere=false;

        for(ESTUDIANTE_INGENIERIA estudiante:estudiantesIngenieria){
            if (estudiante.getSerial().equals(buscar) || estudiante.getCedula().equals(buscar)){

                String serialAnterior=estudiante.getSerial();
                estudiante.setSerial(llenar.serialStrings(serialIngenieria));

                for (COMPUTADOR_PORTATIL computador :computadoresPortatiles){

                    if (computador.getSerial().equals(serialAnterior)){
                        computadoresPortatiles.remove(computador);

                        computadoresPortatiles.add(llenar.llenarComputador(estudiante.getSerial()));
                        break;
                    }

                }

                for (String serial:serialIngenieria){

                    if (serial.equals(serialAnterior)){

                        serialIngenieria.remove(serialAnterior);
                        serialIngenieria.add(estudiante.getSerial());
                        break;

                    }
                }
                Ishere=true;
                break;
            }

        }

        if (Ishere){
            exportarC(computadoresPortatiles);
            exportarS(serialIngenieria);
        }else {
            System.out.println("No se encontro la cedula o el serial en la base de datos.");
        }

        return estudiantesIngenieria;
    }

    public LinkedList<ESTUDIANTE_DISENO> modificarEstudianteDiseno(LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno,String buscar, LinkedList<Integer> serialDiseno, LinkedList<TABLETA_GRAFICA> tabletaGraficas ) throws IOException{

        Llenado llenar=new Llenado();
        boolean Ishere=false;

        for(ESTUDIANTE_DISENO estudiante:estudiantesDiseno){
            if (estudiante.getSerial() == Integer.parseInt(buscar) || estudiante.getCedula().equals(buscar)){

                Integer serialAnterior=estudiante.getSerial();
                estudiante.setSerial(llenar.serialEnteros(serialDiseno));

                for (TABLETA_GRAFICA tableta :tabletaGraficas){

                    if (Integer.parseInt(tableta.getSerial())==serialAnterior){
                        tabletaGraficas.remove(tableta);

                        tabletaGraficas.add(llenar.llenarTableta_GRAFICA(estudiante.getSerial()));
                        break;
                    }

                }

                for (Integer serial:serialDiseno){

                    if (serial.equals(serialAnterior)){

                        serialDiseno.remove(serialAnterior);
                        serialDiseno.add(estudiante.getSerial());
                        break;

                    }
                }
                Ishere=true;
                break;
            }

        }

        if (Ishere){
            exportarT(tabletaGraficas);
            exportarSd(serialDiseno);
        }else {
            System.out.println("No se encontro la cedula o el serial en la base de datos.");
        }

        return estudiantesDiseno;
    }

    //metodo devolucion ingenieria
    public ArrayList<Integer> dispositivoIngenieria(String buscar){

        Importar importar = new Importar();

        ArrayList<Integer> datos = new ArrayList<>();
        LinkedList<ESTUDIANTE_INGENIERIA> estudiantes = importar.importarArchivoIngnieria();
        LinkedList<String> seriales = importar.importarArchivoSrialIngenieros();
        LinkedList<COMPUTADOR_PORTATIL> computadores = importar.importarArchivoComputador();

        for (int i=0; i<estudiantes.size();i++){
            if (estudiantes.get(i).getCedula().equals(buscar) || estudiantes.get(i).getSerial().equals(buscar)){
                // Primer valor 0,1; 0 si no esta, 1 si esta
                datos.add(1);
                // Segundo valor: indice estudiante
                datos.add(i);

                for (int j=0;j < computadores.size();j++){
                    if (computadores.get(j).getSerial().equals(estudiantes.get(i).getSerial())){
                        // Tercer valor: indice computador
                        datos.add(j);
                    }
                }

                for (int k=0; k<seriales.size();k++){
                    if (seriales.get(k).equals(estudiantes.get(i).getSerial())){
                        // Cuarto valor: indice serial
                        datos.add(k);
                    }
                }
                return datos;
            }
        }

        // Primer valor 0,1; 0 si no esta, 1 si esta
        datos.add(0);

        return datos;
    }

    //metodo devolucion diseño
    public ArrayList<Integer> dispositivoDiseno(String buscar){

        Importar importar = new Importar();

        ArrayList<Integer> datos = new ArrayList<>();
        LinkedList<ESTUDIANTE_DISENO> estudiantes = importar.importarArchivoDiseno();
        LinkedList<Integer> seriales = importar.importarArchivoSerialDiseno();
        LinkedList<TABLETA_GRAFICA> tableta = importar.importarArchivoTableta();

        for (int i=0; i<estudiantes.size();i++){
            if (estudiantes.get(i).getCedula().equals(buscar) || estudiantes.get(i).getSerial() == Integer.parseInt(buscar)){
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

                for (int k=0; k<seriales.size();k++){
                    if (seriales.get(k) == estudiantes.get(i).getSerial()){
                        // Cuarto valor: indice serial
                        datos.add(k);
                    }
                }
                return datos;
            }
        }

        // Primer valor 0,1; 0 si no esta, 1 si esta
        datos.add(0);

        return datos;
    }

    public void buscarIngenieria(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria, LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles, String buscar){
        boolean isIn=false;
        for(ESTUDIANTE_INGENIERIA estudiante:estudiantesIngenieria){
            if (estudiante.getSerial().equals(buscar) || estudiante.getCedula().equals(buscar)){
                System.out.println("El estudiante: "+ estudiante.getNombre()+" " +estudiante.getApellido());
                isIn=true;
                for (COMPUTADOR_PORTATIL computador :computadoresPortatiles){
                    if (computador.getSerial().equals(estudiante.getSerial())){
                System.out.println("Tiene un prestamo activo del computador portatil: " + computador.getMarca() + " \ncon un procesador: " + computador.getProcesador() + "\n con un sistema operativo: " + computador.getSistemaOperativo());
                        break;
                    }

                }
                break;
            }
        }
        if (!isIn){
            System.out.println("El prestamo del estudiante que desea ingresar no se encuentra");
        }
    }
    // ultimo metodo
    // Metodo para exportar los estudiantes De ingenieria
    private void exportarIngenieros(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria, LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles, LinkedList<String> serialIngenieria){

        exportarI(estudiantesIngenieria);
        exportarC(computadoresPortatiles);
        exportarS(serialIngenieria);

    }

    private void exportarI(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoIngenieria(estudiantesIngenieria);
    }
    private void exportarC(LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoComputador(computadoresPortatiles);
    }
    private void exportarS(LinkedList<String> serialIngenieria){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoSerialIngeniero(serialIngenieria);
    }

    // Metodo para exportar los estudiantes De Diseño
    private void exportarDisenadores(LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno, LinkedList<TABLETA_GRAFICA> tabletasGraficas, LinkedList<Integer> serialDiseno){

        exportarD(estudiantesDiseno);
        exportarT(tabletasGraficas);
        exportarSd(serialDiseno);

    }

    private void exportarD(LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoDiseno(estudiantesDiseno);
    }
    private void exportarT(LinkedList<TABLETA_GRAFICA> tabletasGraficas){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoTableta(tabletasGraficas);
    }
    private void exportarSd(LinkedList<Integer> serialDiseno){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoSerialDiseno(serialDiseno);
    }


}
