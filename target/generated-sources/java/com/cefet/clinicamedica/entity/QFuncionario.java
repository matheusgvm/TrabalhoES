package com.cefet.clinicamedica.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFuncionario is a Querydsl query type for Funcionario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFuncionario extends EntityPathBase<Funcionario> {

    private static final long serialVersionUID = -1306680046L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFuncionario funcionario = new QFuncionario("funcionario");

    public final NumberPath<Long> codigo = createNumber("codigo", Long.class);

    public final StringPath dataContrato = createString("dataContrato");

    public final QPessoa pessoa;

    public final StringPath salario = createString("salario");

    public final StringPath senhaHash = createString("senhaHash");

    public QFuncionario(String variable) {
        this(Funcionario.class, forVariable(variable), INITS);
    }

    public QFuncionario(Path<? extends Funcionario> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFuncionario(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFuncionario(PathMetadata metadata, PathInits inits) {
        this(Funcionario.class, metadata, inits);
    }

    public QFuncionario(Class<? extends Funcionario> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pessoa = inits.isInitialized("pessoa") ? new QPessoa(forProperty("pessoa")) : null;
    }

}

