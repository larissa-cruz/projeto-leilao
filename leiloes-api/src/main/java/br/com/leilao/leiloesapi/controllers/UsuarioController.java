package br.com.leilao.leiloesapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leilao.leiloesapi.usuario.DadosCadastroUsuario;

@RestController
@RequestMapping("cadastrousuario")
public class UsuarioController {

    @PostMapping
    public void cadastrarUsuario(@RequestBody DadosCadastroUsuario dadosCadastroUsuario) {

    }
    
}
