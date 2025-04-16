package com.giaccneto.agendado_tarefas.infraestructure.repository;

import com.giaccneto.agendado_tarefas.infraestructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
}
