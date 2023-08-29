package br.com.leilao.leiloesapi.leilao;

import java.time.LocalDate;

public record DadosDetalhamentoLeilao(Long id, Long iduser, String name, Double price, LocalDate data) {

    public DadosDetalhamentoLeilao(Leilao leilao) {

    this(leilao.getId(), leilao.getUsuario().getId(), leilao.getName(), leilao.getPrice(), leilao.getData());

    }
    
}
