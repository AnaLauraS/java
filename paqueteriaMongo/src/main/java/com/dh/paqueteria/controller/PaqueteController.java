package com.dh.paqueteria.controller;

import com.dh.paqueteria.model.Paquete;
import com.dh.paqueteria.service.PaqueteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    private PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @GetMapping
    public List<Paquete> listarPaquetes(){
        return paqueteService.listarPaquetes();
    }

    @GetMapping("/enCamino")
    public List<Paquete> listarPaquetesEnCamino(){
        return paqueteService.listarPaquetesEnCamino();
    }

    @PostMapping
    public Paquete guardar(@RequestBody Paquete paquete){
        return paqueteService.guardar(paquete);
    }


}
