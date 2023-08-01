--liquibase formatted sql

--changeset versao:1


	
	-----------------------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.empresa
(
    oid_empresa bigint NOT NULL,
    ds_endereco character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nm_empresa character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nr_cnpj character varying(20) COLLATE pg_catalog."default" NOT NULL,
    nr_telefone character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT empresa_pkey PRIMARY KEY (oid_empresa)
);

	
	---------------------------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.centro_custo
(
    oid_centros_custos bigint NOT NULL,
    ds_centro_custo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    vr_custo_aprovado bigint NOT NULL,
    vr_custo_previsto bigint NOT NULL,
    CONSTRAINT centro_custo_pkey PRIMARY KEY (oid_centros_custos)
);

----------------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.recursos
(
    oid_recursos bigint NOT NULL,
    nm_recursos character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT recursos_pkey PRIMARY KEY (oid_recursos)
);

	
---------------------------------------------------------------


CREATE TABLE db_projetos_ib.tipo_atividades
(
    oid_tipo_atividade bigint NOT NULL,
    nm_tipo_atividade character varying(100) COLLATE pg_catalog."default" NOT NULL,
    vr_atividade bigint NOT NULL,
    CONSTRAINT tipo_atividades_pkey PRIMARY KEY (oid_tipo_atividade)
);
	---------------------------------------------------------------------------
	
CREATE TABLE db_projetos_ib.usuario
(
    oid_usuario bigint NOT NULL ,
    ds_senha character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nr_cpf character varying(100) COLLATE pg_catalog."default" NOT NULL,
	oid_recursos bigint ,
    CONSTRAINT usuarios_pkey PRIMARY KEY (oid_usuario),
    CONSTRAINT fkeq3yi8d47655iadahbilak475 FOREIGN KEY (oid_recursos)
        REFERENCES db_projetos_ib.recursos (oid_recursos) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

/*CREATE TABLE db_projetos_ib.usuario
(
    oid_usuario bigint NOT NULL ,
    ds_senha character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nr_cpf character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuarios_pkey PRIMARY KEY (oid_usuario),
    CONSTRAINT fk_prog_recursos FOREIGN KEY ("oid_recursos_recursos")
        REFERENCES db_projetos_ib.recursos (oid_recursos) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

*/
--------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.projetos
(
    oid_projetos bigint NOT NULL,
    ds_descricao_projeto character varying(100) COLLATE pg_catalog."default" NOT NULL,
    dt_projeto_final timestamp without time zone NOT NULL,
    dt_projeto_inicio timestamp without time zone NOT NULL,
    nm_projetos character varying(100) COLLATE pg_catalog."default" NOT NULL,
    oid_centros_custos bigint,
    oid_empresa bigint ,
    CONSTRAINT projetos_pkey PRIMARY KEY (oid_projetos),
    CONSTRAINT fk4mraglnmkna29umk1noi62cr FOREIGN KEY (oid_centros_custos)
        REFERENCES db_projetos_ib.centro_custo (oid_centros_custos) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fke72jgjdeg9afdo6nkf7pfg628 FOREIGN KEY (oid_empresa)
        REFERENCES db_projetos_ib.empresa (oid_empresa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.atividades
(
    oid_atividade bigint NOT NULL,
    dt_final timestamp without time zone NOT NULL,
    dt_inicio timestamp without time zone NOT NULL,
    nr_horas_atividade character varying(100) COLLATE pg_catalog."default" NOT NULL,
    oid_projetos bigint,
    oid_recursos bigint ,
    CONSTRAINT atividades_pkey PRIMARY KEY (oid_atividade),
    CONSTRAINT fk61bjdd3hhimsrkscawsq6d9li FOREIGN KEY (oid_projetos)
        REFERENCES db_projetos_ib.projetos (oid_projetos) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkir5ljbh4wjlxbdewc1e5makyv FOREIGN KEY (oid_recursos)
        REFERENCES db_projetos_ib.recursos (oid_recursos) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.apontamentos
(
    oid_apontamento bigint NOT NULL,
    dt_apontamento timestamp without time zone NOT NULL,
    dt_lancamento timestamp without time zone NOT NULL,
    nr_apontamento bigint NOT NULL,
    vr_atividade bigint NOT NULL,
    oid_atividade bigint,
    CONSTRAINT apontamentos_pkey PRIMARY KEY (oid_apontamento),
    CONSTRAINT fkgvlg3huvfvds7r4y9fod11vli FOREIGN KEY (oid_atividade)
        REFERENCES db_projetos_ib.atividades (oid_atividade) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);