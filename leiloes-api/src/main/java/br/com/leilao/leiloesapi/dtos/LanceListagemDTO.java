package br.com.leilao.leiloesapi.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.leilao.leiloesapi.entities.Lance;
import com.fasterxml.jackson.annotation.JsonFormat;

public record LanceListagemDTO(@JsonFormat(pattern = "dd/MM/yyyy") LocalDateTime dataLance, String nomeUsuario, Double lance, String nameleilao, String donoleilao, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataleilao) {

    public LanceListagemDTO(Lance lance) {
        this(lance.getDataLance(), lance.getUsuario().getName(), lance.getLance(), lance.getLeilao().getName(), lance.getLeilao().getUsuario().getName(), lance.getLeilao().getData());
    }
    
}
