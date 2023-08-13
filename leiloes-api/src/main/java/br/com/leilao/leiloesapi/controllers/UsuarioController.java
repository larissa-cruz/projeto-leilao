package br.com.leilao.leiloesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leilao.leiloesapi.usuario.DadosCadastroUsuario;
import br.com.leilao.leiloesapi.usuario.Usuario;
import br.com.leilao.leiloesapi.usuario.UsuarioRepository;

@RestController
@RequestMapping("/cadastrousuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody DadosCadastroUsuario dadosCadastroUsuario) {
        usuarioRepository.save(new Usuario(dadosCadastroUsuario));
    }
    
}
