package com.cefet.clinicamedica.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEndereco is a Querydsl query type for Endereco
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEndereco extends EntityPathBase<Endereco> {

    private static final long serialVersionUID = 535626738L;

    public static final QEndereco endereco = new QEndereco("endereco");

    public final StringPath bairro = createString("bairro");

    public final StringPath cep = createString("cep");

    public final StringPath cidade = createString("cidade");

    public final StringPath estado = createString("estado");

    public final StringPath logradouro = createString("logradouro");

    public QEndereco(String variable) {
        super(Endereco.class, forVariable(variable));
    }

    public QEndereco(Path<? extends Endereco> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEndereco(PathMetadata metadata) {
        super(Endereco.class, metadata);
    }

}

