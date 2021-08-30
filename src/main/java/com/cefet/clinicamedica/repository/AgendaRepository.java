package com.cefet.clinicamedica.repository;

import com.cefet.clinicamedica.entity.Agenda;
import org.springframework.data.repository.CrudRepository;

public interface AgendaRepository extends CrudRepository<Agenda, Long> {
}