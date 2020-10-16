package com.codigolimpo.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany
    private List<Endereco> enderecos = new ArrayList<>();

    public void adicionarEndereco(final Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removerEndereco(final Endereco endereco) {
        this.enderecos.remove(endereco);
    }
}
