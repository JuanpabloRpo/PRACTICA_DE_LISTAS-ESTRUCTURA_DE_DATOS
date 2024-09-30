public class Validacion {

    public Validacion() {
    }

    public boolean isInt(String dato){

        try {

            // verificamos si no contiene letras
            double newDato=Double.parseDouble(dato);

            // verificamos que sea entero
            if ((newDato>(int)newDato) && (newDato<(int)newDato+1)){
                return false;
            }

            return true;

        }catch (Exception e){
            return false;
        }

    }

    public boolean isDouble(String dato){

        try {

            // verificamos si no contiene letras
            double newDato=Double.parseDouble(dato);

            return true;

        }catch (Exception e){
            return false;
        }
    }

}
