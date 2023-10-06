package br.com.leilao.leiloesapi.leilao;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.leilao.leiloesapi.lance.Lance;

public record DadosDetalhamentoLeilao(Long idleilao, Long iduser, String name, Double price, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data, List<Lance> lances) {

    public DadosDetalhamentoLeilao(Leilao leilao) {

    this(leilao.getId(), leilao.getUsuario().getId(), leilao.getName(), leilao.getPrice(), leilao.getData(), leilao.getLances());

    }


    
}
