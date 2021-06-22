package com.itarocha.stardata.controller;

import com.itarocha.stardata.model.entities.SignoSolarEntity;
import com.itarocha.stardata.service.BuscadorService;
import com.itarocha.stardata.service.MapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MapaController {

    @Autowired
    private MapaService service;

    @Autowired
    private BuscadorService buscador;

    @GetMapping
    public ResponseEntity<String> retorno()
    {
        SignoSolarEntity signoSolar = service.findSignoSolar("ES");
        //System.out.println(signoSolar.getTexto());
        buscador.gravarTodos();
        buscador.restaurarTodos();
        return ResponseEntity.ok(signoSolar.getTexto());
    }

}
