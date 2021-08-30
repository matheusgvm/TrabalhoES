package com.cefet.clinicamedica.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "funcionario")
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @OneToOne
    private Pessoa pessoa;

    private String dataContrato;
    private String salario;
    private String senhaHash;
}