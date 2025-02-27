package com.maestria.agenda.agendamento;

import com.maestria.agenda.cliente.DadosCliente;
import com.maestria.agenda.servicos.Servicos;

public record DadosCadastroAgendamento(
        DadosCliente cliente,
        Servicos servico,
        String data,
        String hora

) {
}
