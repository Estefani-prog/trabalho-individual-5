package com.estefanibonifacio.api.services;

import java.util.List;

import com.estefanibonifacio.api.models.Usuario;
import com.estefanibonifacio.api.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //@Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @Transactional
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
