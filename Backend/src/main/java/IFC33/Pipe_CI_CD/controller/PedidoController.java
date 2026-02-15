package IFC33.Pipe_CI_CD.controller;

import IFC33.Pipe_CI_CD.model.Pedido;
import IFC33.Pipe_CI_CD.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;
    
    @GetMapping
    public List<PedidoDTO> todos() {
        return repository.findAll().stream()
            .map(p -> new PedidoDTO(p.getId(), p.getTotal(), p.getFecha()))
            .collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    public static class PedidoDTO {
        private Long id;
        private Double total;
        private LocalDateTime fecha;
    }

}
