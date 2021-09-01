package com.cefet.clinicamedica.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaciente is a Querydsl query type for Paciente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaciente extends EntityPathBase<Paciente> {

    private static final long serialVersionUID = -446255206L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaciente paciente = new QPaciente("paciente");

    public final StringPath altura = createString("altura");

    public final NumberPath<Long> codigo = createNumber("codigo", Long.class);

    public final StringPath peso = createString("peso");

    public final QPessoa pessoa;

    public final StringPath tipoSanguineo = createString("tipoSanguineo");

    public QPaciente(String variable) {
        this(Paciente.class, forVariable(variable), INITS);
    }

    public QPaciente(Path<? extends Paciente> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaciente(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaciente(PathMetadata metadata, PathInits inits) {
        this(Paciente.class, metadata, inits);
    }

    public QPaciente(Class<? extends Paciente> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pessoa = inits.isInitialized("pessoa") ? new QPessoa(forProperty("pessoa")) : null;
    }

}

