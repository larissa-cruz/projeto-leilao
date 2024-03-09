package br.com.leilao.leiloesapi.services;

import br.com.leilao.leiloesapi.dtos.LanceDTO;
import br.com.leilao.leiloesapi.dtos.LanceListagemDTO;
import br.com.leilao.leiloesapi.entities.Lance;
import br.com.leilao.leiloesapi.repositories.LanceRepository;
import br.com.leilao.leiloesapi.repositories.LeilaoRepository;
import br.com.leilao.leiloesapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanceService {

    @Autowired
    LanceRepository lanceRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LeilaoRepository leilaoRepository;

    @Transactional
    public LanceDTO insert(LanceDTO dto) {
        Lance entity = new Lance();
        copyDtoToEntity(dto, entity);
        entity = lanceRepository.save(entity);
        return new LanceDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<LanceListagemDTO> findAll(Pageable pageable) {
        Page<Lance> result = lanceRepository.findAll(pageable);
        return result.map(x -> new LanceListagemDTO(x));
    }


    private void copyDtoToEntity(LanceDTO dto, Lance entity) {
        entity.setLance(dto.lance());
        entity.setUsuario(usuarioRepository.findById(dto.iduser())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + dto.iduser())));
        entity.setLeilao(leilaoRepository.findById(dto.idleilao())
                .orElseThrow(() -> new RuntimeException("Leilão/Produto não encontrado com o ID: " + dto.idleilao())));
    }

}
