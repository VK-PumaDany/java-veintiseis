package src.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
    public int numRandom(int max) {
        int randomNum = (int) (Math.random() * max);
        return randomNum;
    }
    
    public String createDateDDMMYYYY(){
        // Obtenemos la fecha actual
        LocalDate hoy = LocalDate.now();

        // Definimos el patrón (DD-MM-YYYY)
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Aplicamos el formato
        return hoy.format(formato);

    }
    
}