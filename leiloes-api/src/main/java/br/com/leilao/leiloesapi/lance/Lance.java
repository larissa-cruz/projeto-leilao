package br.com.leilao.leiloesapi.lance;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.leilao.leiloesapi.leilao.Leilao;
import br.com.leilao.leiloesapi.usuario.Usuario;
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Leilao leilao;

    private Double lance;

    @CreationTimestamp
    @Column(name="datalance", insertable = false, updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataLance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    private Usuario usuario;

    public Lance(DadosCadastroLance dadosCadastroLance) {
        this.lance = dadosCadastroLance.lance();
        this.leilao = new Leilao(dadosCadastroLance.idleilao(), null, null, null, null, null);
        this.dataLance = dadosCadastroLance.dataLance();
        this.usuario = new Usuario(dadosCadastroLance.iduser(), null, null, null);
    }
    
}
