package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;

public class Exercise32 {

    public static void main(String[] args) {
        String userInput = generateStringToSave(null);
        // Escribir la cadena en el archivo
        printToFile(userInput);
        System.out.println("El texto ha sido guardado en el fichero.");
    }

    public static String generateStringToSave(String string) {
        // Si la cadena es nula, se genera la entrada del usuario
        if (string == null) {
            return generateUserInputToSave();
        }
        // Si no es nula, se devuelve la cadena tal cual
        return string;
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {

        try {
          PrintWriter  writer = new PrintWriter("src/main/resources/data.txt");
          writer.write(string);
          writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());

        }



    }

}
