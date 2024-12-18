import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
public class Importar {

    public Importar() {

    }

    // Metodo para importar los estudiantes de ingenieria almacenados
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

        }catch (IOException e) {
            e.printStackTrace();
        }


        return listaDePersonas;
    }

    // Metodo para importar los estudiantes de diseño almacenados
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

        }catch (IOException e) {
            e.printStackTrace();
        }


        return listaDePersonas;
    }

    // Metodo para importar los computadores almacenados
    public LinkedList<COMPUTADOR_PORTATIL> importarArchivoComputador(){

        String rutaArchivo = "Datos_Computador.txt";

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return null;
        }

        LinkedList<COMPUTADOR_PORTATIL> Dispositivos = new LinkedList<>();
        String line;
        String serial="";
        String marca="";
        double tamano=0.0;
        double precio=0.0;
        String sistemaOperativo="";
        String procesador="";
        boolean disponible=false;

        try (BufferedReader cp = new BufferedReader(new FileReader(rutaArchivo))){
            while ((line = cp.readLine()) != null){

                if (line.startsWith("serial: ")){
                    serial=line.substring(8);
                    continue;
                }
                if (line.startsWith("marca: ")){
                    marca=line.substring(7);
                    continue;
                }
                if (line.startsWith("tamaño: ")){
                    tamano=Double.parseDouble(line.substring(8));
                    continue;
                }
                if (line.startsWith("precio: ")){
                    precio=Double.parseDouble(line.substring(8));
                    continue;
                }
                if (line.startsWith("sistema Operativo: ")){
                    sistemaOperativo=line.substring(19);
                    continue;
                }
                if (line.startsWith("procesador: ")){
                    procesador=line.substring(12);
                    continue;
                }
                if (line.startsWith("Disponible: ")){
                    String dato = line.substring(12);
                    if (dato.equalsIgnoreCase("true")){
                        disponible=true;
                    }else {
                        disponible=false;
                    }
                    continue;
                }
                Dispositivos.add(new COMPUTADOR_PORTATIL(serial,marca,tamano,precio,sistemaOperativo,procesador,disponible));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }


        return Dispositivos;
    }

    // Metodo para importar las tablets almacenadas
    public LinkedList<TABLETA_GRAFICA> importarArchivoTableta(){

        String rutaArchivo = "Datos_Tableta.txt";
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return null;
        }

        LinkedList<TABLETA_GRAFICA> Dispositivos = new LinkedList<>();
        String line;
        String serial="";
        String marca="";
        double tamano=0.0;
        double precio=0.0;
        String almacenamiento="";
        double peso=0.0;
        boolean disponible=false;

        try (BufferedReader cp = new BufferedReader(new FileReader(rutaArchivo))){
            while ((line = cp.readLine()) != null){

                if (line.startsWith("serial: ")){
                    serial=line.substring(8);
                    continue;
                }
                if (line.startsWith("marca: ")){
                    marca=line.substring(7);
                    continue;
                }
                if (line.startsWith("tamaño: ")){
                    tamano=Double.parseDouble(line.substring(8));
                    continue;
                }
                if (line.startsWith("precio: ")){
                    precio=Double.parseDouble(line.substring(8));
                    continue;
                }
                if (line.startsWith("almacenamiento: ")){
                    almacenamiento=line.substring(16);
                    continue;
                }
                if (line.startsWith("peso: ")){
                    peso=Double.parseDouble(line.substring(6));
                    continue;
                }
                if (line.startsWith("Disponible: ")){
                    String dato = line.substring(12);
                    if (dato.equalsIgnoreCase("true")){
                        disponible=true;
                    }else {
                        disponible=false;
                    }
                    continue;
                }
                Dispositivos.add(new TABLETA_GRAFICA(serial,marca,tamano,precio,almacenamiento,peso,disponible));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }


        return Dispositivos;
    }

}
