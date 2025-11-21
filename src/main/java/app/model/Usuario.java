package app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @NotBlank
    @Email(message = "email inválido")
    @Column(unique = true)
    private String email;

    private String areaAtuacao;

    private String nivelCarreira;

    private LocalDate dataCadastro;

    public Usuario() {}

    public Usuario(Long id, String nome, String email, String areaAtuacao, String nivelCarreira, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.areaAtuacao = areaAtuacao;
        this.nivelCarreira = nivelCarreira;
        this.dataCadastro = dataCadastro;
    }

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAreaAtuacao() { return areaAtuacao; }
    public void setAreaAtuacao(String areaAtuacao) { this.areaAtuacao = areaAtuacao; }

    public String getNivelCarreira() { return nivelCarreira; }
    public void setNivelCarreira(String nivelCarreira) { this.nivelCarreira = nivelCarreira; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
}
