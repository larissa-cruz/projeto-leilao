package br.com.leilao.leiloesapi.services;

import br.com.leilao.leiloesapi.dtos.LeilaoDTO;
import br.com.leilao.leiloesapi.dtos.LeilaoDetalhamentoDTO;
import br.com.leilao.leiloesapi.dtos.LeilaoListagemDTO;
import br.com.leilao.leiloesapi.entities.Leilao;
import br.com.leilao.leiloesapi.repositories.LeilaoRepository;
import br.com.leilao.leiloesapi.repositories.UsuarioRepository;
import br.com.leilao.leiloesapi.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeilaoService {

    @Autowired
    LeilaoRepository leilaoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public LeilaoDTO insert(LeilaoDTO dto) {
        Leilao entity = new Leilao();
        copyDtoToEntity(dto, entity);
        entity = leilaoRepository.save(entity);
        return new LeilaoDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<LeilaoListagemDTO> findAll(Pageable pageable) {
        Page<Leilao> result = leilaoRepository.findAll(pageable);
        return result.map(x -> new LeilaoListagemDTO(x));
    }

    @Transactional(readOnly = true)
    public LeilaoDetalhamentoDTO findById(Long id) {
        Leilao leilao = leilaoRepository.findLeilaoComLancesEUsuarios(id);
        return new LeilaoDetalhamentoDTO(leilao);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!leilaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } else {
            leilaoRepository.deleteById(id);
        }
    }

    private void copyDtoToEntity(LeilaoDTO dto, Leilao entity) {
        entity.setName(dto.name());
        entity.setPrice(dto.price());
        entity.setData(dto.data());
        entity.setUsuario(usuarioRepository.findById(dto.iduser())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + dto.iduser())));
    }

}
