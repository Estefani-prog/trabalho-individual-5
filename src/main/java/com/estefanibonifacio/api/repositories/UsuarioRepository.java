package com.estefanibonifacio.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estefanibonifacio.api.models.Usuario;

@Repository                              // Classe, Tipo do primary key
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
