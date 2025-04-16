package com.giaccneto.agendado_tarefas.business.mapper;

import com.giaccneto.agendado_tarefas.business.dto.TarefasDTO;
import com.giaccneto.agendado_tarefas.infraestructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {
    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);


}
