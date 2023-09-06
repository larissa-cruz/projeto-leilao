package br.com.leilao.leiloesapi.usuario;

public record DadosDetalhamentoUsuario(Long id, String name, String username, String password) {

    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getName(), usuario.getUsername(), usuario.getPassword());
    }
    
}
