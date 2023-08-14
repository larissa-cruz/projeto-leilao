package br.com.leilao.leiloesapi.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
    
    @NotBlank
    String name, 

    @NotBlank
    String username, 

    @NotBlank
    String password) {

}
