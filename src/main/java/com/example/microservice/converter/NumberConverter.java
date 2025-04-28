package com.example.microservice.converter;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) {
        if (strNumber == null)
            return 0D;

        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);

        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;

        String number = strNumber.replaceAll(",", ".");

        //[-+]?
        //Indica que o número pode opcionalmente começar com um sinal de mais (+) ou menos (-). O ? significa que essa parte é opcional.

        //[0-9]*:
        //Aqui, [0-9] representa qualquer dígito de 0 a 9, e o * indica que pode haver zero ou mais dígitos antes do ponto decimal.

        //\\.?:
        //O \\. representa um ponto decimal. O ? indica que o ponto decimal também é opcional, ou seja, o número pode ser inteiro ou decimal.

        //[0-9]+:
        //Finalmente, [0-9]+ exige que haja pelo menos um dígito após o ponto decimal (se existir). O + significa que deve haver um ou mais dígitos.
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
