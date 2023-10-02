package br.com.leilao.leiloesapi.lance;

public record DadosDetalhamentoLance(Long id, Double lance, Long idleilao) {

    public DadosDetalhamentoLance(Lance lance) {
        this(lance.getId(), lance.getLance(), lance.getLeilao().getId());
    }
    
}
