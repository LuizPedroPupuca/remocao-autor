package br.com.zup.edu.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid CadastraAutorRequest autorRequest, UriComponentsBuilder uri){
        Autor autor = autorRequest.toModel();
        repository.save(autor);

        URI location = uri.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody @Valid RemoveAutorRequest autorRequest, UriComponentsBuilder uri){
        Autor autor = repository.findById(autorRequest.getIdAutor()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
        repository.delete(autor);

        return ResponseEntity.noContent().build();
    }
}
