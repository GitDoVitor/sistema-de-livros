package com.bts.booksys.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
    final
    AutorService autorService;
    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }
}
