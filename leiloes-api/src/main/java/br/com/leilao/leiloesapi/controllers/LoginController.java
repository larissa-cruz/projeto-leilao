package br.com.leilao.leiloesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leilao.leiloesapi.usuario.Usuario;
import br.com.leilao.leiloesapi.usuario.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> loginUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioLogado = this.usuarioRepository.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());

        if (usuarioLogado != null) {
            return ResponseEntity.ok("Usuário está logado.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas. Usuário não está logado.");
        }

    }
    
}
