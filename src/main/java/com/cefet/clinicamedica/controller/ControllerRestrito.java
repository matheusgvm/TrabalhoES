package com.cefet.clinicamedica.controller;

import com.cefet.clinicamedica.entity.*;
import com.cefet.clinicamedica.repository.FuncionarioRepository;
import com.cefet.clinicamedica.service.Services;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerRestrito {

    @Autowired
    private Services services;

    @PostMapping(value = "/cadastrarFuncionario")
    public void cadastrarFuncionario(@RequestBody HttpEntity<String> httpEntity){
        services.cadastrarFuncionario(httpEntity.getBody());
    }

    @PostMapping(value = "/cadastrarMedico")
    public void cadastrarMedico(@RequestBody HttpEntity<String> httpEntity){
        services.cadastrarMedico(httpEntity.getBody());
    }

    @PostMapping(value = "/cadastrarPaciente")
    public void cadastrarPaciente(HttpEntity<String> httpEntity){
        services.cadastrarPaciente(httpEntity.getBody());
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
    public List<Agenda> listarAgendamentosPorMedico(String idMedico){
        return services.listarAgendamentosPorMedico(idMedico);
    }

    @GetMapping(value = "/buscarDadosCep")
    public Endereco buscarDadosCep(String cep){
        return services.buscarDadosCep(cep);
    }
}
