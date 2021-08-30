package com.cefet.clinicamedica.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "paciente")
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @OneToOne
    private Pessoa pessoa;

    private String peso;
    private String altura;
    private String tipoSanguineo;

}