package com.example.demo.controller;

import com.example.demo.service.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TareaController {
    @Autowired
    private TareasService tareasService;
}
