package com.cefet.clinicamedica.repository;

import com.cefet.clinicamedica.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}