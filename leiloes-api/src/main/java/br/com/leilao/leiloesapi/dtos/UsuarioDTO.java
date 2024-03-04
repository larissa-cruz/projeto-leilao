package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "Não pode ser vazio")
    private String name;

    @NotBlank(message = "Não pode ser vazio")
    private String username;

    @NotBlank(message = "Não pode ser vazio")
    private String password;

    public UsuarioDTO(Usuario entity) {
        id = entity.getId();
        name = entity.getName();
        username = entity.getUsername();
        password = entity.getPassword();
    }

}
