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
    public List<String> listarHorariosDisponiveis(String idMedico, String data){
        Long id = Long.parseLong(idMedico);
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        List<String> horariosAgendados = query.select(qAgenda.horario).from(qAgenda).where(qAgenda.horario.eq(data).and(qAgenda.idMedico.eq(id))).fetch();
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

    public List<Medico> listarMedicosPorEspecialidade(String especialidade){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.select(qMedico).from(qMedico).where(qMedico.especialidade.eq(especialidade)).fetch();
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

    public List<Agenda> listarAgendamentosPorMedico(String idMedico){
        Long id = Long.parseLong(idMedico);
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qAgenda).where(qAgenda.idMedico.eq(id)).fetch();
    }

    public void cadastrarEndereco(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Endereco endereco = objectMapper.readValue(json, Endereco.class);
            enderecoRepository.save(endereco);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarAgendamento(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Agenda agenda = objectMapper.readValue(json, Agenda.class);
            agendaRepository.save(agenda);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarFuncionario(String  json){
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

    public void cadastrarPaciente(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Paciente paciente = objectMapper.readValue(json, Paciente.class);
            pessoaRepository.save(paciente.getPessoa());
            pacienteRepository.save(paciente);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Endereco buscarDadosCep(String cep){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        return query.selectFrom(qEndereco).where(qEndereco.cep.eq(cep)).fetchFirst();
    }

    public Funcionario buscarFuncionario(String email){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        return query.selectFrom(qFuncionario).where(qFuncionario.pessoa.email.eq(email)).fetchFirst();
    }

    public Medico isMedico(String funcionarioId){
        Long id = Long.parseLong(funcionarioId);
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        return query.selectFrom(qMedico).where(qMedico.funcionario.pessoa.codigo.eq(id)).fetchFirst();
    }
}
