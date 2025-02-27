package com.maestria.agenda.profissional;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profissional that = (Profissional) o;
        return id == that.id && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}

