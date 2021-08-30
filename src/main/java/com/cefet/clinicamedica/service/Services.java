package com.cefet.clinicamedica.service;

import com.cefet.clinicamedica.entity.*;
import com.cefet.clinicamedica.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    private QPessoa qPessoa = QPessoa.pessoa;
    private QAgenda qAgenda = QAgenda.agenda;
    private QEndereco qEndereco = QEndereco.endereco;
    private QFuncionario qFuncionario = QFuncionario.funcionario;
    private QMedico qMedico = QMedico.medico;
    private QPaciente qPaciente = QPaciente.paciente;

    public Boolean verificarLogin(String email, String senha){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        if(query.selectFrom(qFuncionario).where(qFuncionario.pessoa.email.eq(email).and(qFuncionario.senhaHash.eq(senha))) != null){
            return true;
        }else return false;
    }

    //Supondo nomes unicos -> checar com a rebeca
    public List<String> listarHorariosDisponiveis(String nomeMedico, String data){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        List<String> horariosAgendados = query.select(qAgenda.horario).from(qAgenda).where(qAgenda.horario.eq(data).and(qAgenda.medico.funcionario.pessoa.nome.eq(nomeMedico))).fetch();
        List<String> horariosDisponiveis = new ArrayList<>();

        for(int i = 8; i < 18; i++){
            horariosDisponiveis.add(i + ":00");
        }

        for(String horario : horariosAgendados){
            horariosDisponiveis.remove(horario);
        }

        return horariosDisponiveis;
    }

    public List<String> listarEspecialidades(){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.select(qMedico.especialidade).from(qMedico).fetch();
    }

    public List<String> listarMedicosPorEspecialidade(String especialidade){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.select(qMedico.funcionario.pessoa.nome).from(qMedico).where(qMedico.especialidade.eq(especialidade)).fetch();
    }

    public List<Funcionario> listarFuncionarios(){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qFuncionario).fetch();
    }

    public List<Paciente> listarPacientes(){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qPaciente).fetch();
    }

    public List<Endereco> listarEnderecos(){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qEndereco).fetch();
    }

    public List<Agenda> listarAgendamentos(){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qAgenda).fetch();
    }

    public List<Agenda> listarAgendamentosPorMedico(Medico medico){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qAgenda).where(qAgenda.medico.eq(medico)).fetch();
    }

    public void cadastrarEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
    }

    //não deve funcionar
    public void cadastrarAgendamento(Agenda agenda){
        agendaRepository.save(agenda);
    }

    public void cadastrarFuncionario(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Funcionario funcionario = objectMapper.readValue(json, Funcionario.class);
            pessoaRepository.save(funcionario.getPessoa());
            funcionarioRepository.save(funcionario);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarMedico(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Medico medico = objectMapper.readValue(json, Medico.class);
            pessoaRepository.save(medico.getFuncionario().getPessoa());
            funcionarioRepository.save(medico.getFuncionario());
            medicoRepository.save(medico);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public Endereco buscarDadosCep(String cep){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qEndereco).where(qEndereco.cep.eq(cep)).fetchFirst();
    }

}
