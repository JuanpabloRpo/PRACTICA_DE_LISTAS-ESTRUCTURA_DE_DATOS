public class COMPUTADOR_PORTATIL extends Dispositivo{
    private String sistemaOperativo;
    private String procesador;


    public COMPUTADOR_PORTATIL(String serial, String marca, double tamano, double precio, String sistemaOperativo, String procesador,boolean disponible) {
        super(serial, marca, tamano, precio,disponible);
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
}
