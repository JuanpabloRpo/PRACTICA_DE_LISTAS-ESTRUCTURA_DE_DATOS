public class TABLETA_GRAFICA extends Dispositivo{
    private String almacenamiento;
    private double peso;

    public TABLETA_GRAFICA(String serial, String marca, double tamano, double precio, String almacenamiento, double peso) {
        super(serial, marca, tamano, precio);
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
