package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioLoginDTO {

    @NotBlank(message = "Não pode ser vazio")
    private String username;

    @NotBlank(message = "Não pode ser vazio")
    private String password;

    public UsuarioLoginDTO(Usuario entity) {
        username = entity.getUsername();
        password = entity.getPassword();
    }


}