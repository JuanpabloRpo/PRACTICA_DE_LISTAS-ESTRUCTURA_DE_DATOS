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

            // verificamos que no sea negativo
            if (newDato < 0){
                return false;
            }

            // verificamos que sea entero y positivo
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

            // verdadero o falso
            return newDato>-1;

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
            if ((( ascii > 0 ) && ( ascii < 32 )) || (( ascii > 32 ) && ( ascii < 65 )) || (( ascii > 90 ) && ( ascii < 97 )) || ((ascii > 122) && (ascii<130)) || ((ascii>130) && (ascii<160)) || (ascii>165) ){
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
                    System.out.println(cadena+" No es un entero positivo, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=isInt(cadena);
                }
                return cadena;
            case 2:
                // para saber si es un numero real
                IsTrue = isDouble(cadena);
                while (!IsTrue){
                    System.out.println(cadena+" No es un numero real positivo, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=isDouble(cadena);
                }
                return cadena;
            case 3:
                IsTrue = withOutSpecialCharacter(cadena);
                while (!IsTrue){
                    System.out.println(cadena+" Contiene caracteres especiales, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=withOutSpecialCharacter(cadena);
                }
                return cadena;
            case 4:
                IsTrue = withOutSpecialCharacterAndNumbers(cadena);
                while (!IsTrue){
                    System.out.println(cadena+" Contiene caracteres especiales ó numeros, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=withOutSpecialCharacterAndNumbers(cadena);
                }
                return cadena;
            case 5:
                IsTrue = forFullName(cadena);
                while (!IsTrue){
                    System.out.println(cadena + " Contiene caracteres especiales ó numeros, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=forFullName(cadena);
                }
                return cadena;
            default:
                System.out.println("Mijo caso incorrecto utilice bien las cosas, digite el caso manual nuevamente: ");
                System.out.println("Ya sabe que tiene que corregir la opcion del metodo no hay una opcion "+opcion+" mire bien como utilizar el metodo :)");
                int opcionNueva= Integer.parseInt(eleccionAValidar(1,cp.readLine()));
                cadena = eleccionAValidar(opcionNueva,cadena);

        }
        return cadena;
    }

}
