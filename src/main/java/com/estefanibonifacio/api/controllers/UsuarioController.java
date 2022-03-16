package com.estefanibonifacio.api.controllers;

import java.util.List;

import com.estefanibonifacio.api.models.Usuario;
import com.estefanibonifacio.api.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // função que faz com que a classe seja um controlador rest (crud mvc)
@RequestMapping("/usuarios") // url base para acessar os métodos
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    // Protocolos HTTP: Get, Post, Put, Delete 
    @GetMapping // método get
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping("/criar")
    public ResponseEntity<Usuario> save(Usuario usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

}
