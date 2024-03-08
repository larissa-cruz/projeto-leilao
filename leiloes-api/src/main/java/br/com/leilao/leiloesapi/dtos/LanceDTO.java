package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Lance;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record LanceDTO(
        Long id,
        @NotNull(message = "O id do usuario nao pode ser nulo") Long iduser,
        @NotNull(message = "O id do leilao nao pode ser nulo") Long idleilao,
        @NotNull(message = "O valor do lance nao pode ser nulo") @Positive(message = "O valor do lance deve ser positivo") Double lance,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDateTime dateLance
) {
    public LanceDTO(Lance lance) {
        this(lance.getId(), lance.getUsuario().getId(), lance.getLeilao().getId(), lance.getLance(), lance.getDataLance());
    }
}
