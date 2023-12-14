package br.com.leilao.leiloesapi.entities;

import br.com.leilao.leiloesapi.dtos.DadosCadastroLeilao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Table(name = "leiloes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Leilao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    private Usuario usuario;

    private String name;
    private Double price;
    private LocalDate data;

    @OneToMany(mappedBy = "leilao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Lance> lances;

    public Leilao(DadosCadastroLeilao dadosCadastroLeilao) {
        this.name = dadosCadastroLeilao.name();
        this.price = dadosCadastroLeilao.price();
        this.data = dadosCadastroLeilao.data();
        this.usuario = new Usuario(dadosCadastroLeilao.iduser(), null, null, null);

    }
    
}
