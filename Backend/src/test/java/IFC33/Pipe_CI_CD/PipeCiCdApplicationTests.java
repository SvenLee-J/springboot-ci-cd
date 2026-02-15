package IFC33.Pipe_CI_CD;

import IFC33.Pipe_CI_CD.controller.UsuarioController;
import IFC33.Pipe_CI_CD.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository usuarioRepository;  // ← ¡ESTE FALTABA!

    @Test
    void getUsuarios_StatusOk() throws Exception {
        mockMvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk());
    }

    @Test
    void getUsuarios_IsArray() throws Exception {
        mockMvc.perform(get("/api/usuarios"))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void postUsuario_StatusOk() throws Exception {
        mockMvc.perform(post("/api/usuarios")
                        .contentType("application/json")
                        .content("{\"nombre\":\"Test\",\"email\":\"test@test.com\"}"))
                .andExpect(status().isOk());
    }
}
