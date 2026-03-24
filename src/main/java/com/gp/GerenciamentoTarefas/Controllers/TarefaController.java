package com.gp.GerenciamentoTarefas.Controllers;

import com.gp.GerenciamentoTarefas.Models.TarefaModel;
import com.gp.GerenciamentoTarefas.Repositories.TarefaRepository;
import com.gp.GerenciamentoTarefas.Services.TarefaService;
import io.swagger.v3.core.util.ApiResponsesDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> salvarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel request = tarefaService.salvarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTarefa() {
        List<TarefaModel> request = tarefaService.findAllTarefa();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> getTarefaById(@PathVariable Long id) {
        TarefaModel request = tarefaService.findTarefaById(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
