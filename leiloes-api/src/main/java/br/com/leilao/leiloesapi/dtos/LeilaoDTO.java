package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Leilao;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class LeilaoDTO {

    private Long id;

    @NotNull(message = "O id do usuario nao pode ser nulo")
    private Long iduser;

    @NotBlank(message = "Não pode ser vazio")
    private String name;

    @Positive(message = "O preço deve ser positivo")
    private Double price;

    @NotNull(message = "A data não pode ser nula")
    @Future(message = "A data deve ser futura")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private UsuarioDTO usuarioDTO;

    private List<LanceDTO> lancesDto;

    public LeilaoDTO(Leilao entity) {
        id = entity.getId();
        iduser = entity.getUsuario().getId();
        name = entity.getName();
        price = entity.getPrice();
        data = entity.getData();
    }


}
