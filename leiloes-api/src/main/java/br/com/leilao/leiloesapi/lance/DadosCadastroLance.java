package br.com.leilao.leiloesapi.lance;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroLance(

    @NotNull
    Long idleilao,

    @NotNull
    Double lance) {
    
}
