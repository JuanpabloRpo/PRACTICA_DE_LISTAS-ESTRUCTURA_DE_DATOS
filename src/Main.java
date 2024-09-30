import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
//        Operaciones operaciones=new Operaciones();
//        operaciones.menu();

        Importar importar=new Importar();
        LinkedList<ESTUDIANTE_INGENIERIA> list=importar.importarArchivoIngnieria();
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        for(ESTUDIANTE_INGENIERIA estudiante: list){
            System.out.println("Cedula: "+estudiante.getCedula()+ "\n");
            System.out.println("Nombre: "+estudiante.getNombre()+ "\n");
            System.out.println("Apellido: "+estudiante.getApellido()+ "\n");
            System.out.println("Telefono: "+estudiante.getTelefono()+ "\n");
            System.out.println("Semestre actual: "+estudiante.getNumeroDelSemestreActual()+ "\n");
            System.out.println("Promedio acumulado: "+estudiante.getPromedioAcumulado()+ "\n");
            System.out.println("Serial: "+estudiante.getSerial()+ "\n");
            System.out.println("-----------------------------"+ "\n");
        }

        LinkedList<ESTUDIANTE_DISENO> list2=importar.importarArchivoDiseno();
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        for (ESTUDIANTE_DISENO estudiante: list2){
            System.out.println("Cedula: "+estudiante.getCedula()+ "\n");
            System.out.println("Nombre: "+estudiante.getNombre()+ "\n");
            System.out.println("Apellido: "+estudiante.getApellido()+ "\n");
            System.out.println("Telefono: "+estudiante.getTelefono()+ "\n");
            System.out.println("Modalidad de estudio: "+estudiante.getModalidadDeEstudio()+ "\n");
            System.out.println("cantidad de asignaturas: "+estudiante.getCantidadDeAsignaturas()+ "\n");
            System.out.println("Serial: "+estudiante.getSerial()+ "\n");
            System.out.println("-----------------------------"+ "\n");
        }

        LinkedList<COMPUTADOR_PORTATIL> compu=importar.importarArchivoComputador();
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        for (COMPUTADOR_PORTATIL dispositivo: compu){
            System.out.println("serial: "+dispositivo.getSerial()+ "\n");
            System.out.println("marca: "+dispositivo.getMarca()+ "\n");
            System.out.println("tamaño: "+dispositivo.getTamano()+ "\n");
            System.out.println("precio: "+dispositivo.getPrecio()+ "\n");
            System.out.println("sistema Operativo: "+dispositivo.getSistemaOperativo()+ "\n");
            System.out.println("procesador: "+dispositivo.getProcesador()+ "\n");
            System.out.println("-----------------------------"+ "\n");
        }

        LinkedList<TABLETA_GRAFICA> tableta=importar.importarArchivoTableta();
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        for (TABLETA_GRAFICA dispositivo: tableta){
            System.out.println("serial: "+dispositivo.getSerial()+ "\n");
            System.out.println("marca: "+dispositivo.getMarca()+ "\n");
            System.out.println("tamaño: "+dispositivo.getTamano()+ "\n");
            System.out.println("precio: "+dispositivo.getPrecio()+ "\n");
            System.out.println("almacenamiento: "+dispositivo.getAlmacenamiento()+ "\n");
            System.out.println("peso: "+dispositivo.getPeso()+ "\n");
            System.out.println("-----------------------------"+ "\n");
        }



    }
}