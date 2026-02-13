package IFC33.Pipe_CI_CD.controller;

import IFC33.Pipe_CI_CD.model.Producto;
import IFC33.Pipe_CI_CD.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoRepository repository;
    
    @GetMapping
    public List<Producto> todos() {
        return repository.findAll();
    }
    
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return repository.save(producto);
    }
}
