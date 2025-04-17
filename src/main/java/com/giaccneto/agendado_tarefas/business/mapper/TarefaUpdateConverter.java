package com.giaccneto.agendado_tarefas.business.mapper;

import com.giaccneto.agendado_tarefas.business.dto.TarefasDTO;
import com.giaccneto.agendado_tarefas.infraestructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);


}
