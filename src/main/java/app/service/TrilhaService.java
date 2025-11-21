package app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.Trilha;
import app.repository.TrilhaRepository;
import app.exception.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class TrilhaService {

    private final TrilhaRepository repo;

    public TrilhaService(TrilhaRepository repo) {
        this.repo = repo;
    }

    public List<Trilha> findAll() { return repo.findAll(); }

    public Trilha findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada: " + id));
    }

    public Trilha create(Trilha t) { return repo.save(t); }

    public Trilha update(Long id, Trilha t) {
        Trilha existing = findById(id);
        existing.setNome(t.getNome());
        existing.setDescricao(t.getDescricao());
        existing.setNivel(t.getNivel());
        existing.setCargaHoraria(t.getCargaHoraria());
        existing.setFocoPrincipal(t.getFocoPrincipal());
        return repo.save(existing);
    }

    public void delete(Long id) {
        Trilha existing = findById(id);
        repo.delete(existing);
    }
}
