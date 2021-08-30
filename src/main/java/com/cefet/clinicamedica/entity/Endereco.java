package com.cefet.clinicamedica.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "endereco")
@Entity
public class Endereco {

    @Id
    private String cep;

    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}