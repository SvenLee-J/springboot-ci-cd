package IFC33.Pipe_CI_CD.controller;

import IFC33.Pipe_CI_CD.model.Pedido;
import IFC33.Pipe_CI_CD.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;
    
    @GetMapping
    public List<Pedido> todos() {
        return repository.findAll();
    }
    
    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }
}
