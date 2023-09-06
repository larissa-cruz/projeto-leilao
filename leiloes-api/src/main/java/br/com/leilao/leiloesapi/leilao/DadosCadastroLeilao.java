package br.com.leilao.leiloesapi.leilao;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLeilao(

    @NotNull
    Long iduser,

    @NotBlank
    String name,

    @NotNull
    Double price,

    @NotNull
    @Future
    LocalDate data) {
    
}
