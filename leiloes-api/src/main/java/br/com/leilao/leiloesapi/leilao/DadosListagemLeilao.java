package br.com.leilao.leiloesapi.leilao;

import java.time.LocalDate;

public record DadosListagemLeilao(String name, Double price, LocalDate data) {

    public DadosListagemLeilao(Leilao leilao) {
        this(leilao.getName(), leilao.getPrice(), leilao.getData());
    }
    
}
