package br.com.leilao.leiloesapi.dtos;

import java.time.LocalDate;
import java.util.List;

import br.com.leilao.leiloesapi.entities.Lance;
import br.com.leilao.leiloesapi.entities.Leilao;
import com.fasterxml.jackson.annotation.JsonFormat;


public record LeilaoDetalhamentoDTO(Long idleilao, Long iduser, String nameUser, String name, Double price, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data, List<Lance> lances) {

    public LeilaoDetalhamentoDTO(Leilao leilao) {

        this(leilao.getId(), leilao.getUsuario().getId(), leilao.getUsuario().getName(), leilao.getName(), leilao.getPrice(), leilao.getData(), leilao.getLances());

    }



}