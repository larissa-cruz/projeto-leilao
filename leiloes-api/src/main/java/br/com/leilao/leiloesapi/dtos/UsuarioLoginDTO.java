package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioLoginDTO(
        @NotBlank(message = "Não pode ser vazio") String username,
        @NotBlank(message = "Não pode ser vazio") String password
) {
    public UsuarioLoginDTO(Usuario usuario) {
        this(usuario.getUsername(), usuario.getPassword());
    }
}
