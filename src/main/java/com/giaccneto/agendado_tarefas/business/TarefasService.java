package com.giaccneto.agendado_tarefas.business;

import com.giaccneto.agendado_tarefas.business.dto.TarefasDTO;
import com.giaccneto.agendado_tarefas.business.mapper.TarefaConverter;
import com.giaccneto.agendado_tarefas.infraestructure.entity.TarefasEntity;
import com.giaccneto.agendado_tarefas.infraestructure.enums.StatusNotificacaoEnum;
import com.giaccneto.agendado_tarefas.infraestructure.repository.TarefasRepository;
import com.giaccneto.agendado_tarefas.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuari(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);


        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return tarefaConverter.paraListaTarefasDTO(tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }
}
