package br.com.leilao.leiloesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.leilao.leiloesapi.usuario.DadosCadastroUsuario;
import br.com.leilao.leiloesapi.usuario.Usuario;
import br.com.leilao.leiloesapi.usuario.UsuarioRepository;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriBuilder) {
        
        var usuario = new Usuario(dadosCadastroUsuario);
        usuarioRepository.save(usuario);

        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }
    
}
