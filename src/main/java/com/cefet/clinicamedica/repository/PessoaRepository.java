package com.cefet.clinicamedica.repository;

import com.cefet.clinicamedica.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}