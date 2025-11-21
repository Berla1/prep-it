package app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import app.model.Trilha;
import app.service.TrilhaService;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trilhas")
@Validated
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trilha> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Trilha getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Trilha> create(@Valid @RequestBody Trilha trilha) {
        Trilha created = service.create(trilha);
        return ResponseEntity.created(URI.create("/trilhas/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public Trilha update(@PathVariable Long id, @Valid @RequestBody Trilha trilha) {
        return service.update(id, trilha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
