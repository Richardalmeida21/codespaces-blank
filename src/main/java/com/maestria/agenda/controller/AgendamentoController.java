package com.maestria.agenda.controller;

import com.maestria.agenda.agendamento.Agendamento;
import com.maestria.agenda.agendamento.AgendamentoRepository;
import com.maestria.agenda.agendamento.DadosCadastroAgendamento;
import com.maestria.agenda.cliente.Cliente;
import com.maestria.agenda.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroAgendamento dados) {
        // 1. Salva o Cliente primeiro
        Cliente cliente = new Cliente();
        cliente.setNome(dados.cliente().nome());
        cliente.setEmail(dados.cliente().email());
        cliente.setTelefone(dados.cliente().telefone());
        clienteRepository.save(cliente);

        // 2. Depois, salva o Agendamento com o cliente associado
        Agendamento agendamento = new Agendamento(dados, cliente);
        agendamentoRepository.save(agendamento);
    }


}
