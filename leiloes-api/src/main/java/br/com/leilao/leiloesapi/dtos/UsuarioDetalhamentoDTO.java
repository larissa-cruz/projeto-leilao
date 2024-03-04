package br.com.leilao.leiloesapi.dtos;

public record UsuarioDetalhamentoDTO(Long id, String username) {

    public UsuarioDetalhamentoDTO(UsuarioDTO dto) {

        this(dto.getId(), dto.getUsername());

    }


}