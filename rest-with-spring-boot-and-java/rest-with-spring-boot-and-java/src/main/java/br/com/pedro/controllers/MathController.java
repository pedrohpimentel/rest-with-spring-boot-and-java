package br.com.pedro.controllers;

import br.com.pedro.service.MathService;
import br.com.pedro.util.MathConverter;
import org.springframework.web.bind.annotation.*;

@RestController /*Quando eu aplico o @RestController e o @RequestMapping antes de inciar a classe,
eles irão se aplicar para a classe como um todo. */
@RequestMapping ("/math") /*Todas as operações desta classe vão começar com /math.*/
public class MathController {

    //Fazendo uma injeção via construtor para gerenciar melhor as dependências.
    private final MathService mathService;
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping(value="/sum/{numberOne}/{numberTwo}")
    //Substituindo o @RequestMapping por @GetMapping, pois ele expressa a requisição HTTP de forma mais clara e moderna.
    //Sem precisar adicionar o method=RequestMethod.GET como parâmetro.
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) {
        Double n1 = MathConverter.convertToDouble(numberOne);
        Double n2 = MathConverter.convertToDouble(numberTwo);
        return mathService.sum(n1,n2);

    }

    @GetMapping(value="/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo)  {
        Double n1 = MathConverter.convertToDouble(numberOne);
        Double n2 = MathConverter.convertToDouble(numberTwo);
        return mathService.sub(n1,n2);
    }

    @GetMapping(value="/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) {
        Double n1 = MathConverter.convertToDouble(numberOne);
        Double n2 = MathConverter.convertToDouble(numberTwo);
        return mathService.mult(n1,n2);
    }

    @GetMapping(value="/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo) {

        Double n1 = MathConverter.convertToDouble(numberOne);
        Double n2 = MathConverter.convertToDouble(numberTwo);
        return mathService.div(n1,n2);
    }

    @GetMapping(value="/ave/{numberOne}/{numberTwo}")
    public Double ava(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo){
        Double n1 = MathConverter.convertToDouble(numberOne);
        Double n2 = MathConverter.convertToDouble(numberTwo);
        return mathService.ave(n1,n2);
    }

    @GetMapping(value="/sqrt/{number}")
    public Double sqrt(@PathVariable("number") String number) {

        Double n1 = MathConverter.convertToDouble(number);
        return mathService.sqrt(n1) ;
    }
}
