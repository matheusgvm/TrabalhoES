package com.cefet.clinicamedica.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMedico is a Querydsl query type for Medico
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMedico extends EntityPathBase<Medico> {

    private static final long serialVersionUID = 1423515570L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMedico medico = new QMedico("medico");

    public final NumberPath<Long> codigo = createNumber("codigo", Long.class);

    public final StringPath crm = createString("crm");

    public final StringPath especialidade = createString("especialidade");

    public final QFuncionario funcionario;

    public QMedico(String variable) {
        this(Medico.class, forVariable(variable), INITS);
    }

    public QMedico(Path<? extends Medico> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMedico(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMedico(PathMetadata metadata, PathInits inits) {
        this(Medico.class, metadata, inits);
    }

    public QMedico(Class<? extends Medico> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.funcionario = inits.isInitialized("funcionario") ? new QFuncionario(forProperty("funcionario"), inits.get("funcionario")) : null;
    }

}

