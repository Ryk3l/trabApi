package com.api.entity;

import com.api.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Column(unique = true)
    private String cpfCnpj;

    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
}
