package com.salesianostrina.dam._PrimerApiRest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

@RestController // Equivalente a @Controller + @ResponseBody
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    public final TaskRepository repository;

    @GetMapping("/")
    public List<Task> findAll() {

        return repository.findAll();
    }

    @PostMapping("/")
        public ResponseEntity<Task> create(@RequestBody Task task) {
            //return repository.save(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task));
        }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id")Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
        //return ResponseEntity.status(204).build();
    }

    @PutMapping("/{id}")
    public Task edit(@RequestBody Task task, @PathVariable Long id) {
        Task antigua = repository.findById(id).orElse(task);
        antigua.setText(task.getText());
        antigua.setTitle(task.getTitle());

        return repository.save(antigua);
    }


    @GetMapping("/{id}")
    public Task findOne (@PathVariable("id")Long id){
        return repository.findById(id).orElse(null);
    }




}
