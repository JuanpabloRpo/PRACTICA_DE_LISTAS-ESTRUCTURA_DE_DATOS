import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
public class Importar {

    public Importar() {
    }

    public LinkedList<ESTUDIANTE_INGENIERIA> importarArchivoIngnieria(){
        String rutaArchivo = "Datos_Ingenieria.txt";

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return null;
        }


        LinkedList<ESTUDIANTE_INGENIERIA> listaDePersonas = new LinkedList<>();
        String line;
        String cedula="";
        String nombre="";
        String apellido="";
        String telefono="";
        int numeroDelSemestreActual=0;
        double promedioAcumulado=0.0;
        String serial="";
        try (BufferedReader cp = new BufferedReader(new FileReader(rutaArchivo))){
            while ((line = cp.readLine()) != null){

                if (line.startsWith("Cedula: ")){
                    cedula=line.substring(8);
                    continue;
                }
                if (line.startsWith("Nombre: ")){
                    nombre=line.substring(8);
                    continue;
                }
                if (line.startsWith("Apellido: ")){
                    apellido=line.substring(10);
                    continue;
                }
                if (line.startsWith("Telefono: ")){
                    telefono=line.substring(10);
                    continue;
                }
                if (line.startsWith("Semestre actual: ")){
                    numeroDelSemestreActual=Integer.parseInt(line.substring(17));
                    continue;
                }
                if (line.startsWith("Promedio acumulado: ")){
                    promedioAcumulado=Double.parseDouble(line.substring(20));
                    continue;
                }
                if (line.startsWith("Serial: ")){
                    serial=line.substring(8);
                    continue;
                }
                listaDePersonas.add(new ESTUDIANTE_INGENIERIA(cedula,nombre,apellido,telefono,numeroDelSemestreActual,promedioAcumulado,serial));
            }
            System.out.println("\nArchivo importado correctamente\n");
        }catch (IOException e) {
            e.printStackTrace();
        }


        return listaDePersonas;
    }

    public LinkedList<ESTUDIANTE_DISENO> importarArchivoDiseno(){

        String rutaArchivo = "Datos_Diseño.txt";
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return null;
        }

        LinkedList<ESTUDIANTE_DISENO> listaDePersonas = new LinkedList<>();
        String line;
        String cedula="";
        String nombre="";
        String apellido="";
        String telefono="";
        String modalidadDeEstudio="";
        int cantidadDeAsignaturas=0;
        int serial=0;

        try (BufferedReader cp = new BufferedReader(new FileReader(rutaArchivo))){
            while ((line = cp.readLine()) != null){

                if (line.startsWith("Cedula: ")){
                    cedula=line.substring(8);
                    continue;
                }
                if (line.startsWith("Nombre: ")){
                    nombre=line.substring(8);
                    continue;
                }
                if (line.startsWith("Apellido: ")){
                    apellido=line.substring(10);
                    continue;
                }
                if (line.startsWith("Telefono: ")){
                    telefono=line.substring(10);
                    continue;
                }
                if (line.startsWith("Modalidad de estudio: ")){
                    modalidadDeEstudio=line.substring(22);
                    continue;
                }
                if (line.startsWith("cantidad de asignaturas: ")){
                    cantidadDeAsignaturas=Integer.parseInt(line.substring(25));
                    continue;
                }
                if (line.startsWith("Serial: ")){
                    serial=Integer.parseInt(line.substring(8));
                    continue;
                }
                listaDePersonas.add(new ESTUDIANTE_DISENO(cedula,nombre,apellido,telefono,modalidadDeEstudio,cantidadDeAsignaturas,serial));
            }
            System.out.println("\nArchivo importado correctamente\n");
        }catch (IOException e) {
            e.printStackTrace();
        }


        return listaDePersonas;
    }
}
