package br.com.leilao.leiloesapi.dtos;

import java.time.LocalDateTime;

import br.com.leilao.leiloesapi.entities.Lance;
import com.fasterxml.jackson.annotation.JsonFormat;

public record LanceDetalhamentoDTO(Long id, Double lance, Long idleilao, @JsonFormat(pattern = "dd/MM/yyyy") LocalDateTime dateLance, Long iduser) {

    public LanceDetalhamentoDTO(Lance lance) {
        this(lance.getId(), lance.getLance(), lance.getLeilao().getId(), lance.getDataLance(), lance.getUsuario().getId());
    }
    
}
