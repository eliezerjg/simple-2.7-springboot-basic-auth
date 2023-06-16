package com.basic.auth.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/teste")
@RestController
public class Teste {

    @GetMapping
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok("Teste");
    }

}
