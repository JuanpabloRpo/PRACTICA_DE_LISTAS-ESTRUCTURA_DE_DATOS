import java.io.*;
import java.util.LinkedList;
public class Operaciones {

    // Variables Globales  "No tocar"
    private LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieriaGlbal = new LinkedList<>();
    private LinkedList<ESTUDIANTE_DISENO> estudiantesDisenoGlobal = new LinkedList<>();
    private LinkedList<TABLETA_GRAFICA> tabletasGraficasGlobal = new LinkedList<>();
    private LinkedList<COMPUTADOR_PORTATIL> computadoresPortatilesGlobal = new LinkedList<>();
    private int contadorPersonas;
    private int contadorDispositivos;

    public Operaciones() {
        Importar importar=new Importar();

        String lineas="--------------------------------------------";

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
                                        System.out.println("null");

                                        ESTUDIANTE_INGENIERIA newEstudiante = llenar.llenarIngeniero();
                                        estudiantesIngenieria.add(newEstudiante);

                                        COMPUTADOR_PORTATIL newComputador=llenar.llenarComputador(newEstudiante.getSerial());
                                        computadoresPortatiles.add(newComputador);

                                        break;
                                    case "2":
                                        System.out.println("null");

                                        break;
                                    case "3":
                                        System.out.println("null");

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

                            String opcionIngenieria= cp.readLine();

                            // se valida que sea un entero
                            if (validar.isInt(opcionIngenieria)){
                                switch (opcionIngenieria){
                                    case "1":
                                        System.out.println("null");

                                        break;
                                    case "2":
                                        System.out.println("null");

                                        break;
                                    case "3":
                                        System.out.println("null");

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
                        exportarEstudiantes(estudiantesIngenieria,estudiantesDiseno);
                        exportarDispositivos(tabletasGraficas,computadoresPortatiles);
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


    // ultimo metodo
    // Metodo para exportar los estudiantes ingresados
    private void exportarEstudiantes(LinkedList<ESTUDIANTE_INGENIERIA> estudiantesIngenieria,LinkedList<ESTUDIANTE_DISENO> estudiantesDiseno){
        Exportar exportar=new Exportar();

        exportar.exportarARchivoIngenieria(estudiantesIngenieria);
        exportar.exportarARchivoDiseno(estudiantesDiseno);


    }

    // Metodo para exportar los dispositivos
    private void exportarDispositivos(LinkedList<TABLETA_GRAFICA> tabletasGraficas,LinkedList<COMPUTADOR_PORTATIL> computadoresPortatiles){
        Exportar exportar=new Exportar();
        exportar.exportarARchivoTableta(tabletasGraficas);
        exportar.exportarARchivoComputador(computadoresPortatiles);
    }


}
