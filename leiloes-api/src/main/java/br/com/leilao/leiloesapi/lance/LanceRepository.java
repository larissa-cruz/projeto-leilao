package br.com.leilao.leiloesapi.lance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanceRepository extends JpaRepository<Lance, Long> {
    
}
