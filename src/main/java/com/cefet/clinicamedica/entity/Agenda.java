package com.cefet.clinicamedica.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "agenda")
@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private Long idMedico;

    private String data;
    private String horario;
    private String nome;
    private String email;
    private String telefone;
}