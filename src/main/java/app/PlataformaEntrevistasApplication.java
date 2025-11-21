package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import app.model.Trilha;
import app.model.Usuario;
import app.repository.TrilhaRepository;
import app.repository.UsuarioRepository;

import java.time.LocalDate;

@SpringBootApplication
public class PlataformaEntrevistasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlataformaEntrevistasApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepo, TrilhaRepository trilhaRepo) {
        return args -> {
            if (usuarioRepo.count() == 0) {
                usuarioRepo.save(new Usuario(null, "Ana Recrutadora", "ana@empresa.com", "Recursos Humanos", "Senior", LocalDate.now()));
                usuarioRepo.save(new Usuario(null, "Carlos Recrutador", "carlos@empresa.com", "Tech Recruiting", "Pleno", LocalDate.now()));
            }
            if (trilhaRepo.count() == 0) {
                trilhaRepo.save(new Trilha(null, "Entrevistas Técnicas", "Preparação de entrevistas técnicas focadas em algoritmos e estruturas de dados", "INTERMEDIARIO", 20, "IA/Tech"));
                trilhaRepo.save(new Trilha(null, "Entrevista Comportamental", "Como avaliar soft skills, viés inconsciente e fit cultural", "INICIANTE", 8, "Soft Skills"));
            }
        };
    }
}
