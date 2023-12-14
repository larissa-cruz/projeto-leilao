package br.com.leilao.leiloesapi.dtos;

import java.time.LocalDate;
import java.util.List;

import br.com.leilao.leiloesapi.entities.Leilao;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.leilao.leiloesapi.entities.Lance;

public record DadosDetalhamentoLeilao(Long idleilao, Long iduser, String nameUser, String name, Double price, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data, List<Lance> lances) {

    public DadosDetalhamentoLeilao(Leilao leilao) {

    this(leilao.getId(), leilao.getUsuario().getId(), leilao.getUsuario().getName(), leilao.getName(), leilao.getPrice(), leilao.getData(), leilao.getLances());

    }


    
}
