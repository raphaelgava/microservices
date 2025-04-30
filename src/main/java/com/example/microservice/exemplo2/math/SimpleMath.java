package com.example.microservice.exemplo2.math;

public class SimpleMath {
    
    public Double sum(Double numberOne,
                      Double numberTwo) throws Exception {
        return numberOne + numberTwo;
    }

    public Double diff(Double numberOne,
                       Double numberTwo) throws Exception {
        return numberOne - numberTwo;
    }

    public Double prod(Double numberOne,
                       Double numberTwo) throws Exception {
        return numberOne * numberTwo;
    }

    public Double quot(Double numberOne,
                       Double numberTwo) throws Exception {
        return numberOne / numberTwo;
    }

    public Double avg(Double numberOne,
                      Double numberTwo) throws Exception {
        return (numberOne + numberTwo) / 2;
    }

    public Double root(Double numberOne) throws Exception {

        return Math.sqrt(numberOne);
    }
}
