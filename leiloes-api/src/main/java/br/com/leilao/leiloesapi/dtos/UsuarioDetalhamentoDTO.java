package br.com.leilao.leiloesapi.dtos;

public record UsuarioDetalhamentoDTO(Long id, String name, String username) {

    public UsuarioDetalhamentoDTO(UsuarioDTO usuarioDTO) {
        this(usuarioDTO.getId(), usuarioDTO.getName(), usuarioDTO.getUsername());
    }
    
}
