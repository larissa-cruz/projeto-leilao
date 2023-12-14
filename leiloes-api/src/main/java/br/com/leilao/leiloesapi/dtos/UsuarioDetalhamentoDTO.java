package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioDetalhamentoDTO {
    private Long id;
    private String name;
    private String username;

    public UsuarioDetalhamentoDTO(UsuarioDTO dto) {
        id = dto.getId();
        name = dto.getName();
        username = dto.getUsername();
    }


}