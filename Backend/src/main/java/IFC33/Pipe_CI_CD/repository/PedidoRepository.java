package IFC33.Pipe_CI_CD.repository;

import IFC33.Pipe_CI_CD.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
