package com.giaccneto.agendado_tarefas.controller;

import com.giaccneto.agendado_tarefas.business.TarefasService;
import com.giaccneto.agendado_tarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto, @RequestHeader("Autorization")String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));

    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal){
    return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity <List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader ("Autorization") String token){

        List<TarefasDTO> tarefas = tarefasService.buscaTarefasPorEmail(token);
        return ResponseEntity.ok(tarefas);
    }


}
