package io.test.log.testapp1.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class ClientController {

    private Logger log = LogManager.getLogger(ClientController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestService testService;

    @GetMapping("/tracetest")
    public String sayHiClient() {
        log.info("----- New Request -----");

        log.info("Inside App 1 Controller : ");
        // String firstCallresultFromServer2 = restTemplate.getForObject("http://localhost:8082/server/hiclient/Samson" , String.class);
        String firstCallresultFromServer2 = restTemplate.getForObject("https://trace-app2.cfapps.io/server/hiclient/Samson" , String.class);
        testService.go();

        log.info("Result : " + firstCallresultFromServer2);
        // String secondCallResultFromServer2 = restTemplate.getForObject("http://localhost:8082/server/hiclient/Chandar", String.class);
        String secondCallResultFromServer2 = restTemplate.getForObject("https://trace-app2.cfapps.io/server/hiclient/Chandar", String.class);
        log.info("Result : " + secondCallResultFromServer2);

        log.info("------ Request End ----- ");
        return "Testing completed.. check the logs to check the traceid and span id";

    }
}