package com.cefet.clinicamedica.controller;

import com.cefet.clinicamedica.entity.*;
import com.cefet.clinicamedica.repository.EnderecoRepository;
import com.cefet.clinicamedica.repository.FuncionarioRepository;
import com.cefet.clinicamedica.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;


@RestController
public class ControllerPublico {

    @Autowired
    private Services services;

    @PostMapping(value = "/cadastrarEndereco")
    public void cadastrarEndereco(Endereco endereco){
        services.cadastrarEndereco(endereco);
    }

    @PostMapping(value = "/cadastrarAgendamento")
    public void cadastrarAgendamento(Agenda agenda){
        services.cadastrarAgendamento(agenda);
    }

    @GetMapping(value = "/verificarLogin")
    public Boolean verificarLogin(String email, String senha){
        return services.verificarLogin(email, senha);
    }

    @GetMapping(value = "/listarEspecialidades")
    public List<String> listarEspecialidades(){
        return services.listarEspecialidades();
    }

    @GetMapping(value = "/listarMedicosPorEspecialidade")
    public List<String> listarMedicosPorEspecialidade(String especialidade){
        return services.listarMedicosPorEspecialidade(especialidade);
    }

    @GetMapping(value = "/listarHorariosDisponiveis")
    public List<String> listarHorariosDisponiveis(String nomeMedico, String data){
        return services.listarHorariosDisponiveis(nomeMedico, data);
    }


}
