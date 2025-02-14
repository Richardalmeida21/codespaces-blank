package com.maestria.agenda.agendamento;

import com.maestria.agenda.cliente.Cliente;
import com.maestria.agenda.servicos.Servicos;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Agendamento")
@Data
public class Agendamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Servicos servico;

    private String data;
    private String hora;

    public Agendamento(DadosCadastroAgendamento dados, Cliente cliente) {
        this.cliente = cliente;
        this.servico = dados.servico();
        this.data = dados.data();
        this.hora = dados.hora();
    }


    public Agendamento() {

    }
}
