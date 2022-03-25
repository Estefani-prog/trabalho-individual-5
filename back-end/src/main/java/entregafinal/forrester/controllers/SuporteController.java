package entregafinal.forrester.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import entregafinal.forrester.models.Suporte;
import entregafinal.forrester.services.SuportesService;

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
@RequestMapping(value = "/suporte")
public class SuporteController {
    
    @Autowired
    private SuportesService suporteService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Suporte> findAll() {
        System.out.println("Listar suporte");
        return suporteService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/novo")
    public ResponseEntity<Suporte> save(@RequestBody Suporte suporte) {
        suporteService.save(suporte);
        System.out.println("Request: " + suporte);
        return ResponseEntity.ok().body(suporte);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Suporte> edit(@PathVariable Long id, @RequestBody Suporte suporte) {
        var ticketkeep = suporteService.edit(id, suporte);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticketkeep.getId()).toUri();

        return ResponseEntity.created(uri).body(ticketkeep);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        suporteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
