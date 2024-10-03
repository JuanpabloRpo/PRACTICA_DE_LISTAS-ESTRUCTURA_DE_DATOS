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

    // Devuelve un true si contiene caracteres especiales
    public boolean withOutSpecialCharacter(String cadena){

        int ascii;

        for (char carater: cadena.toCharArray()){
            ascii = carater;
            if ((( ascii > 0 ) && ( ascii < 48 )) || (( ascii > 57 ) && ( ascii < 65 ))|| (( ascii > 90) && ( ascii < 97 )) || ( ascii > 122 )){
                return true;
            }
        }
        return false;
    }

    // Devuelve un true si contiene caracteres especiales y numeros
    public boolean withOutSpecialCharacterAndNumbers(String cadena){

        int ascii;

        for (char carater: cadena.toCharArray()){
            ascii= carater;
            if ((( ascii > 0 ) && ( ascii < 65 )) || (( ascii > 90 ) && ( ascii < 97 )) || ( ascii > 122 )){
                return true;
            }
        }

        return false;
    }

}
