package br.com.leilao.leiloesapi.services;

import br.com.leilao.leiloesapi.dtos.UsuarioDTO;
import br.com.leilao.leiloesapi.dtos.UsuarioLoginDTO;
import br.com.leilao.leiloesapi.entities.Usuario;
import br.com.leilao.leiloesapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDTO insert(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        copyDtoToEntity(dto, entity);
        entity = usuarioRepository.save(entity);
        return new UsuarioDTO(entity);
    }

    @Transactional
    public UsuarioLoginDTO login(UsuarioLoginDTO dto) {
        Usuario entity = usuarioRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        return new UsuarioLoginDTO(entity);
    }


    private void copyDtoToEntity(UsuarioDTO dto, Usuario entity) {
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
    }

}
