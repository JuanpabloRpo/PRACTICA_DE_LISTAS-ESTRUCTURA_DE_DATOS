public class ESTUDIANTE_INGENIERIA extends Persona{
    private int numeroDelSemestreActual;
    private double promedioAcumulado;
    private String serial;


    public ESTUDIANTE_INGENIERIA(String cedula, String nombre, String apellido, String telefono,int numeroDelSemestreActual, double promedioAcumulado, String serial) {
        super(cedula,nombre,apellido,telefono);
        this.numeroDelSemestreActual = numeroDelSemestreActual;
        this.promedioAcumulado = promedioAcumulado;
        this.serial = serial;
    }

    public int getNumeroDelSemestreActual() {
        return numeroDelSemestreActual;
    }

    public void setNumeroDelSemestreActual(int numeroDelSemestreActual) {
        this.numeroDelSemestreActual = numeroDelSemestreActual;
    }

    public double getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
