package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.repository.CategoriaRepository;
import com.example.mscatalogo.service.CategoriaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    ResponseEntity<List<Categoria>> lista(){
        return ResponseEntity.ok(categoriaService.lista());
    }
    @PostMapping
    ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.guardar((categoria)));
    }

    @GetMapping("/id")
    ResponseEntity<Categoria>buscarPorid(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id).get());

    }

    @PutMapping
    ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.actualizar((categoria)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Categoria>> eleminar(@PathVariable(required = true) Integer id){
        categoriaService.eleminar(id);
        return ResponseEntity.ok(categoriaService.lista());
    }
}
