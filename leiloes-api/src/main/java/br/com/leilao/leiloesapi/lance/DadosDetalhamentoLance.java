package br.com.leilao.leiloesapi.lance;

import java.time.LocalDateTime;

public record DadosDetalhamentoLance(Long id, Double lance, Long idleilao, LocalDateTime dateLance) {

    public DadosDetalhamentoLance(Lance lance) {
        this(lance.getId(), lance.getLance(), lance.getLeilao().getId(), lance.getDataLance());
    }
    
}
