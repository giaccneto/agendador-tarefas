package com.giaccneto.agendado_tarefas.controller;

import com.giaccneto.agendado_tarefas.business.TarefasService;
import com.giaccneto.agendado_tarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto, @RequestHeader("Autorization")String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));

    }
}
