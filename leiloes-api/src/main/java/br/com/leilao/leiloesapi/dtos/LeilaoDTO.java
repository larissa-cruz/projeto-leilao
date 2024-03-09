package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Leilao;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record LeilaoDTO(
        Long id,
        @NotNull(message = "O id do usuario nao pode ser nulo") Long iduser,
        String nameUser,
        @NotBlank(message = "Não pode ser vazio") String name,
        @Positive(message = "O preço deve ser positivo") Double price,
        @NotNull(message = "A data não pode ser nula") @Future(message = "A data deve ser futura") @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data
) {
    public LeilaoDTO(Leilao leilao) {
        this(leilao.getId(), leilao.getUsuario().getId(), leilao.getUsuario().getName(), leilao.getName(), leilao.getPrice(), leilao.getData());
    }
}
