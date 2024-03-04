package br.com.leilao.leiloesapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "usuarios")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String username;
    @JsonBackReference
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Leilao> leiloes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Lance> lances = new ArrayList<>();

}
