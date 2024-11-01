import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;



public class Exportar {

    public Exportar() {
    }

    // Metodo para exportar los estudiantes de ingenieria almacenados en las listas
    public void exportarARchivoIngenieria(LinkedList<ESTUDIANTE_INGENIERIA> listaDeEstudiantes){

        try (FileWriter archivo = new FileWriter("Datos_Ingenieria.txt")){
//                archivo.write("\n--- ESTUDIANTES DE INGENIERIA ---\n");
            for (ESTUDIANTE_INGENIERIA estudiante: listaDeEstudiantes){
                archivo.write("Cedula: "+estudiante.getCedula()+ "\n");
                archivo.write("Nombre: "+estudiante.getNombre()+ "\n");
                archivo.write("Apellido: "+estudiante.getApellido()+ "\n");
                archivo.write("Telefono: "+estudiante.getTelefono()+ "\n");
                archivo.write("Semestre actual: "+estudiante.getNumeroDelSemestreActual()+ "\n");
                archivo.write("Promedio acumulado: "+estudiante.getPromedioAcumulado()+ "\n");
                archivo.write("Serial: "+estudiante.getSerial()+ "\n");
                archivo.write("-----------------------------"+ "\n");
            }
            archivo.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Metodo para exportar los estudiantes de diseño almacenados en las listas
    public void exportarARchivoDiseno(LinkedList<ESTUDIANTE_DISENO> listaDeEstudiantes){

        try (FileWriter archivo = new FileWriter("Datos_Diseño.txt")){
//                archivo.write("\n--- ESTUDIANTES DE DISEÑO ---\n");
            for (ESTUDIANTE_DISENO estudiante: listaDeEstudiantes){
                archivo.write("Cedula: "+estudiante.getCedula()+ "\n");
                archivo.write("Nombre: "+estudiante.getNombre()+ "\n");
                archivo.write("Apellido: "+estudiante.getApellido()+ "\n");
                archivo.write("Telefono: "+estudiante.getTelefono()+ "\n");
                archivo.write("Modalidad de estudio: "+estudiante.getModalidadDeEstudio()+ "\n");
                archivo.write("cantidad de asignaturas: "+estudiante.getCantidadDeAsignaturas()+ "\n");
                archivo.write("Serial: "+estudiante.getSerial()+ "\n");
                archivo.write("-----------------------------"+ "\n");
            }
            archivo.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo para exportar los computadores almacenados en las listas
    public void exportarARchivoComputador(LinkedList<COMPUTADOR_PORTATIL> listaDeDispositivos){


        try (FileWriter archivo = new FileWriter("Datos_Computador.txt")){
//                archivo.write("\n--- COMPUTADORES ---\n");
            for (COMPUTADOR_PORTATIL dispositivo: listaDeDispositivos){
                archivo.write("serial: "+dispositivo.getSerial()+ "\n");
                archivo.write("marca: "+dispositivo.getMarca()+ "\n");
                archivo.write("tamaño: "+dispositivo.getTamano()+ "\n");
                archivo.write("precio: "+dispositivo.getPrecio()+ "\n");
                archivo.write("sistema Operativo: "+dispositivo.getSistemaOperativo()+ "\n");
                archivo.write("procesador: "+dispositivo.getProcesador()+ "\n");
                archivo.write("Disponible: "+dispositivo.isDisponible()+ "\n");
                archivo.write("-----------------------------"+ "\n");
            }
            archivo.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo para exportar las tablets almacenadas en las listas
    public void exportarARchivoTableta(LinkedList<TABLETA_GRAFICA> listaDeDispositivos){

        try (FileWriter archivo = new FileWriter("Datos_Tableta.txt")){
//                archivo.write("\n--- Tabletas ---\n");
            for (TABLETA_GRAFICA dispositivo: listaDeDispositivos){
                archivo.write("serial: "+dispositivo.getSerial()+ "\n");
                archivo.write("marca: "+dispositivo.getMarca()+ "\n");
                archivo.write("tamaño: "+dispositivo.getTamano()+ "\n");
                archivo.write("precio: "+dispositivo.getPrecio()+ "\n");
                archivo.write("almacenamiento: "+dispositivo.getAlmacenamiento()+ "\n");
                archivo.write("peso: "+dispositivo.getPeso()+ "\n");
                archivo.write("Disponible: "+dispositivo.isDisponible()+ "\n");
                archivo.write("-----------------------------"+ "\n");
            }
            archivo.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
