package br.com.leilao.leiloesapi.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroLance(

    @NotNull
    Long iduser,

    @NotNull
    Long idleilao,

    @NotNull
    Double lance,
    
    LocalDateTime dataLance) {
    
}
