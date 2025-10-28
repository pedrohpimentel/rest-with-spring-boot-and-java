package br.com.pedro.controllers;

import br.com.pedro.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestLogController {


    private static final Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());;//Usado para registrar informações (logs).

    @GetMapping("/test")
    public String testLog(){
        logger.debug("This is an DEBUG log");
        logger.info("This is an INFO log");
        logger.warn("This is an WARN log");
        logger.error("This is an ERROR log");
        return "Logs generated successfully!";
    }

}
