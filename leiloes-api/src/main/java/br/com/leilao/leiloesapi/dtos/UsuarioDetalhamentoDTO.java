package br.com.leilao.leiloesapi.dtos;

import br.com.leilao.leiloesapi.entities.Usuario;

public record UsuarioDetalhamentoDTO(Long id, String username) {

    public UsuarioDetalhamentoDTO(Usuario usuario) {

        this(usuario.getId(), usuario.getUsername());

    }


}