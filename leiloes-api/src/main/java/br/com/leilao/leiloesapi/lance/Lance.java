package br.com.leilao.leiloesapi.lance;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private Leilao leilao;

    private Double lance;

    @CreationTimestamp
    @Column(name="datalance", insertable = false, updatable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataLance;

    public Lance(DadosCadastroLance dadosCadastroLance) {
        this.lance = dadosCadastroLance.lance();
        this.leilao = new Leilao(dadosCadastroLance.idleilao(), null, null, null, null, null);
        this.dataLance = dadosCadastroLance.dataLance();
    }
    
}
