package br.com.leilao.leiloesapi.lance;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosListagemLance(@JsonFormat(pattern = "dd/MM/yyyy") LocalDateTime dataLance, String nomeUsuario, Double lance, String nameleilao, String donoleilao, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataleilao) {

    public DadosListagemLance(Lance lance) {
        this(lance.getDataLance(), lance.getUsuario().getName(), lance.getLance(), lance.getLeilao().getName(), lance.getLeilao().getUsuario().getName(), lance.getLeilao().getData());
    }
    
}
