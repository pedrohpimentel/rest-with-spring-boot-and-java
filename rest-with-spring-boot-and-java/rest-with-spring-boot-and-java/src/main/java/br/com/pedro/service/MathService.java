package br.com.pedro.service;

import br.com.pedro.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {


        public double sum(Double numberOne,Double numberTwo){
            return numberOne + numberTwo;
        }

        public  double sub (Double numberOne,Double numberTwo){
            return numberOne - numberTwo;
        }

        public double mult (Double numberOne,Double numberTwo){
            return numberOne * numberTwo;
        }

        public double div (Double numberOne,Double numberTwo){
            if (numberTwo.equals(0.0)){
                throw new UnsuportedMathOperationException("Cannot divide by zero!");
            }
        return numberOne / numberTwo;
        }

        public double ave (Double numberOne,Double numberTwo){
        return (numberOne + numberTwo) / 2.0;
        }

        public double sqrt (Double number){
            if (number < 0){
                throw new UnsuportedMathOperationException("Cannot calculate the square root of a negative number!");
            }
        return Math.sqrt(number) ;
        }
}