package com.gp.GerenciamentoTarefas.Repositories;

import com.gp.GerenciamentoTarefas.Models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
