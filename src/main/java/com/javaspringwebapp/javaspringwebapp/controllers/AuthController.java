package com.javaspringwebapp.javaspringwebapp.controllers;

import com.javaspringwebapp.javaspringwebapp.dao.UsuarioDao;
import com.javaspringwebapp.javaspringwebapp.models.Usuario;
import com.javaspringwebapp.javaspringwebapp.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired  //APLICA LA INYECCION DE DEPENDENCIAS
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
       if(usuarioLogueado != null){

           String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
           return tokenJwt;
       }
       return "FAIL";
    }
}
