package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Lance;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class LanceDTO {

    private Long id;

    @NotNull(message = "O id do usuario nao pode ser nulo")
    Long iduser;

    @NotNull(message = "O id do leilao nao pode ser nulo")
    Long idleilao;

    @NotNull(message = "O valor do lance nao pode ser nulo")
    @Positive(message = "O valor do lance deve ser positivo")
    Double lance;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime dataLance;

    public LanceDTO(Lance entity) {
        iduser = entity.getUsuario().getId();
        idleilao = entity.getLeilao().getId();
        lance = entity.getLance();
    }

}
