package com.example.microservice.exemplo2.controllers;

import com.example.microservice.exemplo2.exceptions.UnsupportedMathOperationException;
import com.example.microservice.exemplo2.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.example.microservice.exemplo2.converter.NumberConverter.convertToDouble;
import static com.example.microservice.exemplo2.converter.NumberConverter.isNumeric;


@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong(); //Multithread[
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET) //Recuperar dados da url
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            //throw new Exception();
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/diff/{numberOne}/{numberTwo}", method = RequestMethod.GET) //Recuperar dados da url
    public Double diff(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            //throw new Exception();
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.diff(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/prod/{numberOne}/{numberTwo}", method = RequestMethod.GET) //Recuperar dados da url
    public Double prod(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            //throw new Exception();
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.prod(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/quot/{numberOne}/{numberTwo}", method = RequestMethod.GET) //Recuperar dados da url
    public Double quot(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            //throw new Exception();
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.quot(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET) //Recuperar dados da url
    public Double avg(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            //throw new Exception();
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.avg(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/root/{numberOne}", method = RequestMethod.GET) //Recuperar dados da url
    public Double root(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)) {
            //throw new Exception();
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.root(convertToDouble(numberOne));
    }


}
