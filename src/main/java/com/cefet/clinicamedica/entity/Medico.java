package com.cefet.clinicamedica.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "medico")
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @OneToOne
    private Funcionario funcionario;

    private String crm;
    private String especialidade;

}