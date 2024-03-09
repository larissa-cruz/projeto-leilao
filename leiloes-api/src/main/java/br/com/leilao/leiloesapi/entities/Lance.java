package br.com.leilao.leiloesapi.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Table(name = "lances")
@Entity(name = "Lances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lance;

    @CreationTimestamp
    @Column(name="datalance", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataLance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leilao_id")
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Leilao leilao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    
}
