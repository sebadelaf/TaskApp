package com.example.demo.service;

import com.example.demo.repository.TareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareasService {
    @Autowired
    private TareasRepository tareasRepository;
}
