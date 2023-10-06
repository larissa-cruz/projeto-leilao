package br.com.leilao.leiloesapi.leilao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public record DadosListagemLeilao(String name, Double price, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data, Long id, String nameUsuario) {

    public DadosListagemLeilao(Leilao leilao) {
        this(leilao.getName(), leilao.getPrice(), leilao.getData(), leilao.getId(), leilao.getUsuario().getName());
    }
    
}
