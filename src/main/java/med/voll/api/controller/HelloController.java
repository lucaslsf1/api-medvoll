package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String inicio(){
        return "Página inicial da api.";
    }

    @GetMapping("/hello")
    public String paginaInicial() {
        return "Olá, Você acessou a página inicial da API!";
    }
}
