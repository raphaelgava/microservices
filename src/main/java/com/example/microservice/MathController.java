package com.example.microservice;

import com.example.microservice.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {
    private static final String template = "Hello, %s!!!";
    private final AtomicLong counter = new AtomicLong(); //Multithread

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET) //Recuperar dados da url
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            //throw new Exception();
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null)
            return 0D;

        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);

        return 0D;
    }

    private boolean isNumeric(String strNumber) {
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
