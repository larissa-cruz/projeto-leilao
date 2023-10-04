package br.com.leilao.leiloesapi.lance;

import java.time.LocalDateTime;

public record DadosListagemLance(LocalDateTime dataLance, String nomeUsuario, Double lance) {

    public DadosListagemLance(Lance lance) {
        this(lance.getDataLance(), lance.getLeilao().getUsuario().getName(), lance.getLance());
    }
    
}
