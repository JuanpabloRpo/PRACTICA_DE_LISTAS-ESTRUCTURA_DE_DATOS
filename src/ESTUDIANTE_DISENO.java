public class ESTUDIANTE_DISENO extends Persona{
    private String modalidadDeEstudio;
    private int cantidadDeAsignaturas;
    private int serial;

    public ESTUDIANTE_DISENO(String cedula, String nombre, String apellido, String telefono, String modalidadDeEstudio, int cantidadDeAsignaturas, int serial) {
        super(cedula, nombre, apellido, telefono);
        this.modalidadDeEstudio = modalidadDeEstudio;
        this.cantidadDeAsignaturas = cantidadDeAsignaturas;
        this.serial = serial;
    }

    public String getModalidadDeEstudio() {
        return modalidadDeEstudio;
    }

    public void setModalidadDeEstudio(String modalidadDeEstudio) {
        this.modalidadDeEstudio = modalidadDeEstudio;
    }

    public int getCantidadDeAsignaturas() {
        return cantidadDeAsignaturas;
    }

    public void setCantidadDeAsignaturas(int cantidadDeAsignaturas) {
        this.cantidadDeAsignaturas = cantidadDeAsignaturas;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
