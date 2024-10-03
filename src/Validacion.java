import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validacion {



    public Validacion() {
    }

    // Devuelve true si es un entero
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

    // Devuelve true si es un boolean
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
                return false;
            }
        }
        return true;
    }

    // Devuelve un true si contiene caracteres especiales y numeros
    public boolean withOutSpecialCharacterAndNumbers(String cadena){

        int ascii;

        for (char carater: cadena.toCharArray()){
            ascii= carater;
            if ((( ascii > 0 ) && ( ascii < 65 )) || (( ascii > 90 ) && ( ascii < 97 )) || ( ascii > 122 )){
                return false;
            }
        }

        return true;
    }

    // Valida que no tenga caracteres especiales ni numeros
    public boolean forFullName(String cadena){

        int ascii;

        for (char carater: cadena.toCharArray()){
            ascii= carater;
            if ((( ascii > 0 ) && ( ascii < 32 )) || (( ascii > 32 ) && ( ascii < 65 )) || (( ascii > 90 ) && ( ascii < 97 )) || ( ascii > 122 )){
                return false;
            }
        }

        return true;
    }

    public String eleccionAValidar(int opcion, String cadena) throws IOException {

        BufferedReader cp=new BufferedReader(new InputStreamReader(System.in));
        boolean IsTrue;

        switch (opcion){
            case 1:
                // para saber si es un numero entero
                IsTrue = isInt(cadena);
                while (!IsTrue){
                    System.out.println("Dato incorrecto, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=isInt(cadena);
                }
                return cadena;
            case 2:
                // para saber si es un numero real
                IsTrue = isDouble(cadena);
                while (!IsTrue){
                    System.out.println("Dato incorrecto, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=isDouble(cadena);
                }
                return cadena;
            case 3:
                IsTrue = withOutSpecialCharacter(cadena);
                while (!IsTrue){
                    System.out.println("Dato incorrecto, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=withOutSpecialCharacter(cadena);
                }
                return cadena;
            case 4:
                IsTrue = withOutSpecialCharacterAndNumbers(cadena);
                while (!IsTrue){
                    System.out.println("Dato incorrecto, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=withOutSpecialCharacterAndNumbers(cadena);
                }
                return cadena;
            case 5:
                IsTrue = forFullName(cadena);
                while (!IsTrue){
                    System.out.println("Dato incorrecto, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=forFullName(cadena);
                }
                return cadena;
            default:
                System.out.println("caso incorrecto, digitelo nuevamente: ");
                String opcionNueva= cp.readLine();
                eleccionAValidar(1,opcionNueva);
        }
        return cadena;
    }

}
