package com.cefet.clinicamedica.repository;

import com.cefet.clinicamedica.entity.Medico;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends CrudRepository<Medico, Long> {
}