package entregafinal.forrester.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import entregafinal.forrester.models.Destinos;
import entregafinal.forrester.services.DestinosService;
import entregafinal.forrester.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/destino")
public class DestinosController {
    
    @Autowired
    private DestinosService destinosService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Destinos> findAll() {
        System.out.println("Listar destinos");
        return destinosService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/adicionar")
    public ResponseEntity<Destinos> save(@RequestBody Destinos destino) {
        destinosService.save(destino);
        return ResponseEntity.ok().body(destino);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Destinos> edit(@PathVariable Long id, @RequestBody Destinos destino) {
        var destinokeep = destinosService.edit(id, destino);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(destinokeep.getId()).toUri();

        return ResponseEntity.created(uri).body(destinokeep);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        destinosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
