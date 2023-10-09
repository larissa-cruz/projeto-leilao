package br.com.leilao.leiloesapi.leilao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

    @Query("SELECT l FROM Leiloes l " +
    "LEFT JOIN FETCH l.lances lance " +
    "LEFT JOIN FETCH lance.usuario " + 
    "WHERE l.id = :leilaoId")
    Leilao findLeilaoComLancesEUsuarios(@Param("leilaoId") Long leilaoId);
    
}
