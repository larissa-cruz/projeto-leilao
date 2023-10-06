package br.com.leilao.leiloesapi.lance;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosListagemLance(@JsonFormat(pattern = "dd/MM/yyyy") LocalDateTime dataLance, String nomeUsuario, Double lance) {

    public DadosListagemLance(Lance lance) {
        this(lance.getDataLance(), lance.getUsuario().getName(), lance.getLance());
    }
    
}
