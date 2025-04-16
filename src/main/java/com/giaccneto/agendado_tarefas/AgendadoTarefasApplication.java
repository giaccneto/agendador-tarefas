package com.giaccneto.agendado_tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgendadoTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadoTarefasApplication.class, args);
	}

}
