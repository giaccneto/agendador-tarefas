package com.giaccneto.agendado_tarefas.controller;

import com.giaccneto.agendado_tarefas.business.TarefasService;
import com.giaccneto.agendado_tarefas.business.dto.TarefasDTO;
import com.giaccneto.agendado_tarefas.infraestructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto, @RequestHeader("Autorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));

    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {
        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader("Autorization") String token) {

        List<TarefasDTO> tarefas = tarefasService.buscaTarefasPorEmail(token);
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id) {
        tarefasService.deletaTarefaPorId(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefasDTO> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status, @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id));

    }

    @PutMapping
    public ResponseEntity<TarefasDTO> updateTarefas(@RequestBody TarefasDTO dto, @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id));

    }


}
