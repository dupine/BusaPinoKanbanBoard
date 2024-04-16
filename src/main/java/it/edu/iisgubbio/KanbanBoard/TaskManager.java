package it.edu.iisgubbio.KanbanBoard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TaskManager {

    @Autowired
    TaskInterface repoTask;

    @GetMapping("/todolist")
    public List<Task> elenco() {
        List<Task> k = repoTask.findAll();
        return k;
    }

    @GetMapping("/kanbanBoard")
    public List<Task> cerca(
        @RequestParam(required = false) String titolo,
        @RequestParam(required = false) String descrizione,
        @RequestParam(required = false) String assegnatario,
        @RequestParam(required = false) String stato,
        @RequestParam(required = false) Integer priorita
    ) {
    	Task t = new Task();
        t.setTitolo(titolo);
        t.setDescrizione(descrizione);
        t.setAssegnatario(assegnatario);
        t.setStato(stato);
        t.setPriorita(priorita);
        Example<Task> example = Example.of(t);
        return repoTask.findAll( example );
    }

    /*@GetMapping("/kanbanBoard2")
    public List<KanbanBoard> cercaParte( @RequestParam String cosa){
        return repoKanban.cerca("%"+cosa+"%");
    }*/

    @GetMapping("kanbanBoard/{id}")
    public Optional<Task> prendiPerChiave( @PathVariable int id ) {
        return repoTask.findById(id);
    }

    @PostMapping("/kanbanBoard")
    public void inserisci(@RequestBody Task td) {
        repoTask.save( td );
    }

    @DeleteMapping("kanbanBoard/{id}")
    public void cancellaPerChiave( @PathVariable int id ) {
        repoTask.deleteById(id);
    }

    @PutMapping("kanbanBoard/{id}")
    public void modifica( @PathVariable int id, @RequestBody Task td ) {
        Optional<Task> k = repoTask.findById(id);
        if(k.isPresent()) {
        	Task t = k.get();
        	t.setTitolo(td.getTitolo());
            t.setDescrizione(td.getDescrizione());
            t.setAssegnatario(td.getAssegnatario());
            t.setStato(td.getStato());
            t.setPriorita(td.getPriorita());
            repoTask.save(t);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}