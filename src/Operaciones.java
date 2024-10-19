import java.io.*;
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

                                        estudiantesIngenieria=modificarEstudiante(estudiantesIngenieria,validar.eleccionAValidar(3, cp.readLine()),serialIngenieria,computadoresPortatiles);

                                        serialIngenieria = importar.importarArchivoSrialIngenieros();
                                        computadoresPortatiles = importar.importarArchivoComputador();

                                        exportarI(estudiantesIngenieria);
                                        break;
                                    case "3":
                                        System.out.println("null");

                                        exportarIngenieros(estudiantesIngenieria,computadoresPortatiles,serialIngenieria);
                                        break;
                                    case "4":
                                        System.out.println("null");

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
                                        System.out.println("null");


                                        exportarDisenadores(estudiantesDiseno,tabletasGraficas,serialDiseno);
                                        break;
                                    case "3":
                                        System.out.println("null");


                                        exportarDisenadores(estudiantesDiseno,tabletasGraficas,serialDiseno);
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

    public LinkedList<ESTUDIANTE_INGENIERIA> modificarEstudiante (LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria,String buscar, LinkedList<String> serialIngenieria, LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles ) throws IOException{

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

        Exportar exportar=new Exportar();

        exportar.exportarARchivoDiseno(estudiantesDiseno);
        exportar.exportarARchivoTableta(tabletasGraficas);
        exportar.exportarARchivoSerialDiseno(serialDiseno);

    }


}
