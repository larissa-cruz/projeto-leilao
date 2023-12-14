package br.com.leilao.leiloesapi.repositories;

import br.com.leilao.leiloesapi.entities.Lance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanceRepository extends JpaRepository<Lance, Long> {
    
}
