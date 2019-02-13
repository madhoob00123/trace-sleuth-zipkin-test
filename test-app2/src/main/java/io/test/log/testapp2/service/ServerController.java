package io.test.log.testapp2.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerController {

    private Logger log = LogManager.getLogger(ServerController.class);

    @GetMapping("/hiclient/{name}")
    public String sayHiServer(@PathVariable String name) {
        log.info("--> App 2 ");
        log.info("  a stmt : ");
        log.info("  b stmt: ");
        log.info("  c stmt: ");
        log.info("<-- App 2 ");
        return "Server: Hi - " + name;
    }
}
