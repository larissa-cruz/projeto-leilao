package br.com.leilao.leiloesapi.controllers;

import br.com.leilao.leiloesapi.dtos.UsuarioLoginDTO;
import br.com.leilao.leiloesapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> loginUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {

        UsuarioLoginDTO usuarioLogado = usuarioService.login(usuarioLoginDTO);

        if (usuarioLogado != null) {
            return ResponseEntity.ok(usuarioLogado);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
    
}
