package IFC33.Pipe_CI_CD.controller;

import IFC33.Pipe_CI_CD.model.Usuario;
import IFC33.Pipe_CI_CD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repository;
    
    @GetMapping
    public List<Usuario> todos() {
        return repository.findAll();
    }
    
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }
}
