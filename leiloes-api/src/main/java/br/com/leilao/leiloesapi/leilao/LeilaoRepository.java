package br.com.leilao.leiloesapi.leilao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
    
}
