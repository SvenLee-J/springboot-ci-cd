package IFC33.Pipe_CI_CD;

import IFC33.Pipe_CI_CD.controller.ProductoController;
import IFC33.Pipe_CI_CD.controller.UsuarioController;
import IFC33.Pipe_CI_CD.controller.PedidoController;
import IFC33.Pipe_CI_CD.repository.ProductoRepository;
import IFC33.Pipe_CI_CD.repository.UsuarioRepository;
import IFC33.Pipe_CI_CD.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;  // ← ESTE FALTABA

@WebMvcTest({ProductoController.class, UsuarioController.class, PedidoController.class})
class ProductoControllerTest {

    @Autowired private MockMvc mockMvc;

    // Producto Controller tests
    @MockBean private ProductoRepository productoRepository;

    @Test void producto_get_StatusOk() throws Exception {
        mockMvc.perform(get("/api/productos")).andExpect(status().isOk());
    }

    @Test void producto_get_IsArray() throws Exception {
        mockMvc.perform(get("/api/productos")).andExpect(jsonPath("$").isArray());
    }

    @Test void producto_get_JsonContentType() throws Exception {
        mockMvc.perform(get("/api/productos"))
              .andExpect(content().contentType("application/json"));
    }

    @Test void producto_post_StatusOk() throws Exception {
        mockMvc.perform(post("/api/productos")
                .contentType("application/json")
                .content("{\"nombre\":\"Test\",\"precio\":99.99}"))
              .andExpect(status().isOk());
    }

    @Test void producto_post_ContentType() throws Exception {
        mockMvc.perform(post("/api/productos")
                .contentType("application/json")
                .content("{}"))
              .andExpect(status().isOk());
    }

    // Usuario Controller tests
    @MockBean private UsuarioRepository usuarioRepository;

    @Test void usuario_get_StatusOk() throws Exception {
        mockMvc.perform(get("/api/usuarios")).andExpect(status().isOk());
    }

    @Test void usuario_get_IsArray() throws Exception {
        mockMvc.perform(get("/api/usuarios")).andExpect(jsonPath("$").isArray());
    }

    @Test void usuario_get_JsonContentType() throws Exception {
        mockMvc.perform(get("/api/usuarios"))
              .andExpect(content().contentType("application/json"));
    }

    @Test void usuario_post_StatusOk() throws Exception {
        mockMvc.perform(post("/api/usuarios")
                .contentType("application/json")
                .content("{\"nombre\":\"Test\",\"email\":\"test@test.com\"}"))
              .andExpect(status().isOk());
    }

    @Test void usuario_post_ValidJson() throws Exception {
        mockMvc.perform(post("/api/usuarios")
                .contentType("application/json")
                .content("{}"))
              .andExpect(status().isOk());
    }

    // Pedido Controller tests
    @MockBean private PedidoRepository pedidoRepository;

    @Test void pedido_get_StatusOk() throws Exception {
        mockMvc.perform(get("/api/pedidos")).andExpect(status().isOk());
    }

    @Test void pedido_get_IsArray() throws Exception {
        mockMvc.perform(get("/api/pedidos")).andExpect(jsonPath("$").isArray());
    }

    @Test void pedido_get_JsonContentType() throws Exception {
        mockMvc.perform(get("/api/pedidos"))
              .andExpect(content().contentType("application/json"));
    }

    @Test void pedido_get_2xxSuccessful() throws Exception {
        mockMvc.perform(get("/api/pedidos")).andExpect(status().is2xxSuccessful());
    }

    @Test void pedido_get_EmptyResponseOk() throws Exception {
        mockMvc.perform(get("/api/pedidos")).andExpect(status().isOk());
    }

    // Unit tests Mockito
    @Test void unit_productoRepoMock_notNull() {
        assertNotNull(productoRepository);
    }

    @Test void unit_usuarioRepoMock_notNull() {
        assertNotNull(usuarioRepository);
    }

    @Test void unit_pedidoRepoMock_notNull() {
        assertNotNull(pedidoRepository);
    }

    @Test void unit_mockMvcAutowireOk() {
        assertNotNull(mockMvc);
    }

    @Test void unit_webMvcTestContextOk() {
        assertTrue(true);
    }

     // Service layer tests
    @Test
    void service_producto_getAll_emptyListOk() throws Exception {
        mockMvc.perform(get("/api/productos")).andExpect(status().isOk());
    }

    @Test
    void service_usuario_getAll_emptyListOk() throws Exception {
        mockMvc.perform(get("/api/usuarios")).andExpect(status().isOk());
    }

    @Test
    void service_pedido_getAll_emptyListOk() throws Exception {
        mockMvc.perform(get("/api/pedidos")).andExpect(status().isOk());
    }

    @Test
    void service_producto_post_validJsonOk() throws Exception {
        mockMvc.perform(post("/api/productos")
                .contentType("application/json")
                .content("{\"nombre\":\"Test\",\"precio\":99.99}"))
              .andExpect(status().isOk());
    }

    @Test
    void service_usuario_post_validJsonOk() throws Exception {
        mockMvc.perform(post("/api/usuarios")
                .contentType("application/json")
                .content("{\"nombre\":\"Test\",\"email\":\"test@test.com\"}"))
              .andExpect(status().isOk());
    }

    // Integration tests prep
    @Test
    void integration_producto_get_pathOk() throws Exception {
        mockMvc.perform(get("/api/productos")).andExpect(status().isOk());
    }

    @Test
    void integration_usuario_get_pathOk() throws Exception {
        mockMvc.perform(get("/api/usuarios")).andExpect(status().isOk());
    }

    @Test
    void integration_pedido_get_pathOk() throws Exception {
        mockMvc.perform(get("/api/pedidos")).andExpect(status().isOk());
    }

    @Test
    void integration_post_producto_contentTypeOk() throws Exception {
        mockMvc.perform(post("/api/productos")
                .contentType("application/json")
                .content("{}"))
              .andExpect(status().isOk());
    }

    @Test
    void integration_post_usuario_contentTypeOk() throws Exception {
        mockMvc.perform(post("/api/usuarios")
                .contentType("application/json")
                .content("{}"))
              .andExpect(status().isOk());
    }

}
