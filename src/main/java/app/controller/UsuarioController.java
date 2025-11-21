package app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import app.model.Usuario;
import app.service.UsuarioService;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Validated
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        Usuario created = service.create(usuario);
        return ResponseEntity.created(URI.create("/usuarios/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        return service.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
