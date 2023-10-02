package br.com.leilao.leiloesapi.lance;

import java.time.LocalDate;

public record DadosListagemLance(LocalDate data, String nomeUsuario, Double lance) {

    public DadosListagemLance(Lance lance) {
        this(LocalDate.now(), lance.getLeilao().getUsuario().getName(), lance.getLance());
    }
    
}
