package com.cefet.clinicamedica.repository;

import com.cefet.clinicamedica.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
}