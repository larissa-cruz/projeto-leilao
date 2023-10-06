package br.com.leilao.leiloesapi.lance;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosDetalhamentoLance(Long id, Double lance, Long idleilao, @JsonFormat(pattern = "dd/MM/yyyy") LocalDateTime dateLance, Long iduser) {

    public DadosDetalhamentoLance(Lance lance) {
        this(lance.getId(), lance.getLance(), lance.getLeilao().getId(), lance.getDataLance(), lance.getUsuario().getId());
    }
    
}
