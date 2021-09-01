package com.cefet.clinicamedica.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPessoa is a Querydsl query type for Pessoa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPessoa extends EntityPathBase<Pessoa> {

    private static final long serialVersionUID = 1509859856L;

    public static final QPessoa pessoa = new QPessoa("pessoa");

    public final StringPath bairro = createString("bairro");

    public final StringPath cep = createString("cep");

    public final StringPath cidade = createString("cidade");

    public final NumberPath<Long> codigo = createNumber("codigo", Long.class);

    public final StringPath email = createString("email");

    public final StringPath estado = createString("estado");

    public final StringPath logradouro = createString("logradouro");

    public final StringPath nome = createString("nome");

    public final StringPath telefone = createString("telefone");

    public QPessoa(String variable) {
        super(Pessoa.class, forVariable(variable));
    }

    public QPessoa(Path<? extends Pessoa> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPessoa(PathMetadata metadata) {
        super(Pessoa.class, metadata);
    }

}

