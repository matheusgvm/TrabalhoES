package com.cefet.clinicamedica.controller;

import com.cefet.clinicamedica.entity.*;
import com.cefet.clinicamedica.repository.EnderecoRepository;
import com.cefet.clinicamedica.repository.FuncionarioRepository;
import com.cefet.clinicamedica.service.Services;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    public void cadastrarEndereco(@RequestBody HttpEntity<String> endereco){
        services.cadastrarEndereco(endereco.getBody());
    }

    @PostMapping(value = "/cadastrarAgendamento")
    public void cadastrarAgendamento(@RequestBody HttpEntity<String> httpEntity){
        services.cadastrarAgendamento(httpEntity.getBody());
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
    public List<Medico> listarMedicosPorEspecialidade(String especialidade){
        return services.listarMedicosPorEspecialidade(especialidade);
    }

    @GetMapping(value = "/listarHorariosDisponiveis")
    public List<String> listarHorariosDisponiveis(String idMedico, String data){
        return services.listarHorariosDisponiveis(idMedico, data);
    }

    @GetMapping(value = "/buscarLogin")
    public Funcionario buscarFuncionario(String email) {
        return services.buscarFuncionario(email);
    }

    @GetMapping(value = "/isMedico")
    public Medico isMedico(String funcionarioId) {
        return services.isMedico(funcionarioId);
    }
}
