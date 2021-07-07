package com.bts.booksys;

import com.bts.booksys.models.Autor;
import com.bts.booksys.services.AutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class TesteIntegracao {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AutorService autorService;

    @Test
    void insereAutor_Test() throws Exception {
        Autor autor = new Autor();
        autor.setNome("Achado de Massis");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/autores")
                .content(objectMapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

//    @Test
//    void listaTodosAutores_Test() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/autores")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
    
//    @Test
//    void listaAutorPorId_Test() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/autores/{id}", 1)
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

    @Test
    void deletaAutorPorId_Test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/autores/{id}", 1L))
                .andExpect(status().isAccepted());
    }

//    @Test
//    void alteraAutor_Test() throws Exception {
//        Optional<Autor> autorDb = Optional.ofNullable(autorService.listaAutorPorId(1L));
//
//        autorDb.ifPresent(autor -> autor.setNome("novoNome"));
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .put("/usuario/{id}",1)
//                .content(objectMapper.writeValueAsString(autorDb.get()))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("novoNome"));
//    }

}
