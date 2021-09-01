package com.cefet.clinicamedica.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAgenda is a Querydsl query type for Agenda
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAgenda extends EntityPathBase<Agenda> {

    private static final long serialVersionUID = 1081847413L;

    public static final QAgenda agenda = new QAgenda("agenda");

    public final NumberPath<Long> codigo = createNumber("codigo", Long.class);

    public final StringPath data = createString("data");

    public final StringPath email = createString("email");

    public final StringPath horario = createString("horario");

    public final NumberPath<Long> idMedico = createNumber("idMedico", Long.class);

    public final StringPath nome = createString("nome");

    public final StringPath telefone = createString("telefone");

    public QAgenda(String variable) {
        super(Agenda.class, forVariable(variable));
    }

    public QAgenda(Path<? extends Agenda> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgenda(PathMetadata metadata) {
        super(Agenda.class, metadata);
    }

}

