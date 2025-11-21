package app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "trilhas")
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @Column(length = 2000)
    private String descricao;

    @NotBlank
    private String nivel; // INICIANTE / INTERMEDIARIO / AVANCADO

    @Min(value = 1, message = "cargaHoraria deve ser positiva")
    private Integer cargaHoraria;

    private String focoPrincipal;

    public Trilha() {}

    public Trilha(Long id, String nome, String descricao, String nivel, Integer cargaHoraria, String focoPrincipal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
        this.cargaHoraria = cargaHoraria;
        this.focoPrincipal = focoPrincipal;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public Integer getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    public String getFocoPrincipal() { return focoPrincipal; }
    public void setFocoPrincipal(String focoPrincipal) { this.focoPrincipal = focoPrincipal; }
}
