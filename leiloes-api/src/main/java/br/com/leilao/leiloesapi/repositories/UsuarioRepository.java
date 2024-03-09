package br.com.leilao.leiloesapi.repositories;

import br.com.leilao.leiloesapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsernameAndPassword(String username, String password);
}
