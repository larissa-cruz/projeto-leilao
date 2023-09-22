package br.com.leilao.leiloesapi.leilao;

import java.time.LocalDate;


public record DadosListagemLeilao(String name, Double price, LocalDate data, Long id, Long idusuario) {

    public DadosListagemLeilao(Leilao leilao) {
        this(leilao.getName(), leilao.getPrice(), leilao.getData(), leilao.getId(), leilao.getUsuario().getId());
    }
    
}
