package com.gp.GerenciamentoTarefas.Services;

import com.gp.GerenciamentoTarefas.Models.TarefaModel;
import com.gp.GerenciamentoTarefas.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModel salvarTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    public List<TarefaModel> findAllTarefa() {
        return tarefaRepository.findAll();
    }

    public TarefaModel findTarefaById(Long id) {
        return tarefaRepository.findById(id).get();
    }

    public void  deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
