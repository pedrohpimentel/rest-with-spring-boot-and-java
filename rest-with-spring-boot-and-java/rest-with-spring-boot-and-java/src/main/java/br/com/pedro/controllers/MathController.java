package br.com.pedro.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController /*Quando eu aplico o @RestController e o @RequestMapping antes de inciar a classe,
eles irão se aplicar para a classe como um todo. */
@RequestMapping ("/math") /*Todas as operações desta classe vão começar com /math.*/
public class MathController {

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    public static Double covertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedOperationException("Please set a numeric value!");
        String number = strNumber.replaceAll(",", ".");// Moeda Americana x Brasileira
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        Double n2 = covertToDouble(numberTwo);
        if (n2.equals(0.0)){
            throw new UnsupportedOperationException("Cannot divide by zero!");
        }

        return covertToDouble(numberOne) / n2;
    }

    @RequestMapping(value="/ave/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double ava(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        Double average = (covertToDouble(numberOne) + covertToDouble(numberTwo)) / 2.0;

        return average;
    }

    @RequestMapping(value="/sqrt/{number}", method=RequestMethod.GET)
    public Double sqrt(@PathVariable("number") String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        Double n1 = covertToDouble(number);
        if (n1 < 0){
            throw new UnsupportedOperationException("Cannot calculate the square root of a negative number!");
        }
        return Math.sqrt(n1) ;
    }
}
