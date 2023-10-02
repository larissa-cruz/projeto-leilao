package br.com.leilao.leiloesapi.lance;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosListagemLance(@JsonFormat(pattern="dd-MM-yyyy") LocalDate data, String nomeUsuario, Double lance) {

    public DadosListagemLance(Lance lance) {
        this(LocalDate.now(), lance.getLeilao().getUsuario().getName(), lance.getLance());
    }
    
}
