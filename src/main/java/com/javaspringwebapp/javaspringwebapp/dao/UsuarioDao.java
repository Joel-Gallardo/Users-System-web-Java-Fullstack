package com.javaspringwebapp.javaspringwebapp.dao;

import com.javaspringwebapp.javaspringwebapp.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
