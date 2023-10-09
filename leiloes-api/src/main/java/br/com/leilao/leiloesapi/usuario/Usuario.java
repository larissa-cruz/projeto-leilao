package br.com.leilao.leiloesapi.usuario;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    
    @JsonBackReference
    private String password;

    public Usuario(DadosCadastroUsuario dadosCadastroUsuario) {
        this.name = dadosCadastroUsuario.name();
        this.username = dadosCadastroUsuario.username();
        this.password = dadosCadastroUsuario.password();
    }
    
}
