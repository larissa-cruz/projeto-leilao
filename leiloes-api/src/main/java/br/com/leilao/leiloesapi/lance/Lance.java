package br.com.leilao.leiloesapi.lance;

import jakarta.persistence.*;

import br.com.leilao.leiloesapi.leilao.Leilao;
import lombok.*;

@Table(name = "lances")
@Entity(name = "Lances")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idleilao")
    private Leilao leilao;

    private Double lance;

    public Lance(DadosCadastroLance dadosCadastroLance) {
        this.lance = dadosCadastroLance.lance();
        this.leilao = new Leilao(dadosCadastroLance.idleilao(), null, null, lance, null);
    }
    
}
