package app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.Usuario;
import app.repository.UsuarioRepository;
import app.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> findAll() { return repo.findAll(); }

    public Usuario findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado: " + id));
    }

    public Usuario create(Usuario u) {
        if (u.getDataCadastro() == null) u.setDataCadastro(LocalDate.now());
        return repo.save(u);
    }

    public Usuario update(Long id, Usuario u) {
        Usuario existing = findById(id);
        existing.setNome(u.getNome());
        existing.setEmail(u.getEmail());
        existing.setAreaAtuacao(u.getAreaAtuacao());
        existing.setNivelCarreira(u.getNivelCarreira());
        return repo.save(existing);
    }

    public void delete(Long id) {
        Usuario existing = findById(id);
        repo.delete(existing);
    }
}
