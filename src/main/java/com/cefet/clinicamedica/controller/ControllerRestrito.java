package com.cefet.clinicamedica.controller;

import com.cefet.clinicamedica.entity.*;
import com.cefet.clinicamedica.repository.FuncionarioRepository;
import com.cefet.clinicamedica.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerRestrito {

    @Autowired
    private Services services;

    @PostMapping(value = "/cadastrarFuncionario")
    public void cadastrarFuncionario(String json){
        services.cadastrarFuncionario(json);
    }

    @PostMapping(value = "/cadastrarMedico")
    public void cadastrarMedico(String json){
        services.cadastrarMedico(json);
    }

    @PostMapping(value = "/cadastrarPaciente")
    public void cadastrarPaciente(Paciente paciente){
        services.cadastrarPaciente(paciente);
    }

    @GetMapping(value = "/listarFuncionarios")
    public List<Funcionario> listarFuncionarios(){
        return services.listarFuncionarios();
    }

    @GetMapping(value = "/listarPacientes")
    public List<Paciente> listarPacientes(){
        return services.listarPacientes();
    }

    @GetMapping(value = "/listarEnderecos")
    public List<Endereco> listarEnderecos(){
        return services.listarEnderecos();
    }

    @GetMapping(value = "/listarAgendamentos")
    public List<Agenda> listarAgendamentos(){
        return services.listarAgendamentos();
    }

    @GetMapping(value = "/listarAgendamentosPorMedico")
    public List<Agenda> listarAgendamentosPorMedico(Medico medico){
        return services.listarAgendamentosPorMedico(medico);
    }

    @GetMapping(value = "/buscarDadosCep")
    public Endereco buscarDadosCep(String cep){
        return services.buscarDadosCep(cep);
    }
}
