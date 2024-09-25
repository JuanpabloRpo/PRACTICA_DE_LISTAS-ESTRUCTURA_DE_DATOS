import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;



public class Exportar {
    public Exportar() {
    }

    public void exportarARchivoIngenieria(LinkedList<ESTUDIANTE_INGENIERIA> listaDeEstudiantes){

        if (listaDeEstudiantes.isEmpty()){
            System.out.println("\nLista vacia, por favor ingrese los datos\n");
        }else {
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
                System.out.println("\nArchivo exportado correctamente - Ingenieria\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void exportarARchivoDiseno(LinkedList<ESTUDIANTE_DISENO> listaDeEstudiantes){

        if (listaDeEstudiantes.isEmpty()){
            System.out.println("\nLista vacia, por favor ingrese los datos\n");
        }else {
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
                System.out.println("\nArchivo exportado correctamente - Diseño\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
