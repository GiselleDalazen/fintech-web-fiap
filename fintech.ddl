CREATE TABLE t_fin_usuario (
    ds_email   VARCHAR2(100) NOT NULL,
    nm_usuario VARCHAR2(100) NOT NULL,
    ds_senha   VARCHAR2(50) NOT NULL
);

ALTER TABLE t_fin_usuario ADD CONSTRAINT t_fin_usuario_pk PRIMARY KEY ( ds_email );


CREATE TABLE t_fin_banco (
    nr_banco INTEGER NOT NULL,
    nm_banco VARCHAR2(20) NOT NULL
);

ALTER TABLE t_fin_banco ADD CONSTRAINT t_fin_banco_pk PRIMARY KEY ( nr_banco );

CREATE TABLE t_fin_conta (
    id_conta               NUMBER NOT NULL,
    t_fin_usuario_ds_email VARCHAR2(100),
    t_fin_banco_nr_banco   INTEGER NOT NULL,
    nr_agencia             NUMBER NOT NULL,
    nr_conta               NUMBER NOT NULL
);

CREATE UNIQUE INDEX t_fin_conta__idx ON
    t_fin_conta (
        t_fin_banco_nr_banco
    ASC );

ALTER TABLE t_fin_conta ADD CONSTRAINT t_fin_conta_pk PRIMARY KEY ( id_conta );

CREATE TABLE t_fin_despesas (
    cd_despesa             INTEGER NOT NULL,
    t_fin_usuario_ds_email VARCHAR2(100) NOT NULL,
    vl_despesa             FLOAT(2) NOT NULL,
    nm_despesa             VARCHAR2(50) NOT NULL
);

ALTER TABLE t_fin_despesas ADD CONSTRAINT t_fin_despesas_pk PRIMARY KEY ( cd_despesa );

CREATE TABLE t_fin_investimento (
    cd_investimento        NUMBER NOT NULL,
    t_fin_usuario_ds_email VARCHAR2(100) NOT NULL,
    vl_investimento        FLOAT(2) NOT NULL,
    dt_inicial             DATE NOT NULL,
    dt_resgate             DATE
);

ALTER TABLE t_fin_investimento ADD CONSTRAINT t_fin_investimento_pk PRIMARY KEY ( cd_investimento );

CREATE TABLE t_fin_login (
    t_fin_usuario_ds_email VARCHAR2(100) NOT NULL,
    senha                  VARCHAR2(20) NOT NULL
);

ALTER TABLE t_fin_login ADD CONSTRAINT t_fin_login_pk PRIMARY KEY ( t_fin_usuario_ds_email );

CREATE TABLE t_fin_objetivos (
    cd_objetivo            INTEGER NOT NULL,
    t_fin_usuario_ds_email VARCHAR2(100) NOT NULL,
    nm_objetivo            VARCHAR2(50) NOT NULL,
    vl_meta                FLOAT(2) NOT NULL,
    dt_objetivo            DATE
);

ALTER TABLE t_fin_objetivos ADD CONSTRAINT t_fin_objetivos_pk PRIMARY KEY ( cd_objetivo );

CREATE TABLE t_fin_receitas (
    cd_recebimento         NUMBER NOT NULL,
    t_fin_usuario_ds_email VARCHAR2(100) NOT NULL,
    ds_recebimento         VARCHAR2(100) NOT NULL,
    st_recorrencia         CHAR(1),
    vl_recebimento         FLOAT(2) NOT NULL
);

ALTER TABLE t_fin_receitas ADD CONSTRAINT t_fin_receitas_pk PRIMARY KEY ( cd_recebimento );


ALTER TABLE t_fin_conta
    ADD CONSTRAINT t_fin_conta_t_fin_banco_fk FOREIGN KEY ( t_fin_banco_nr_banco )
        REFERENCES t_fin_banco ( nr_banco );

ALTER TABLE t_fin_conta
    ADD CONSTRAINT t_fin_conta_t_fin_usuario_fk FOREIGN KEY ( t_fin_usuario_ds_email )
        REFERENCES t_fin_usuario ( ds_email );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE t_fin_despesas
    ADD CONSTRAINT t_fin_despesas_t_fin_usuario_fk FOREIGN KEY ( t_fin_usuario_ds_email )
        REFERENCES t_fin_usuario ( ds_email );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE t_fin_investimento
    ADD CONSTRAINT t_fin_investimento_t_fin_usuario_fk FOREIGN KEY ( t_fin_usuario_ds_email )
        REFERENCES t_fin_usuario ( ds_email );

ALTER TABLE t_fin_login
    ADD CONSTRAINT t_fin_login_t_fin_usuario_fk FOREIGN KEY ( t_fin_usuario_ds_email )
        REFERENCES t_fin_usuario ( ds_email );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE t_fin_objetivos
    ADD CONSTRAINT t_fin_objetivos_t_fin_usuario_fk FOREIGN KEY ( t_fin_usuario_ds_email )
        REFERENCES t_fin_usuario ( ds_email );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE t_fin_receitas
    ADD CONSTRAINT t_fin_receitas_t_fin_usuario_fk FOREIGN KEY ( t_fin_usuario_ds_email )
        REFERENCES t_fin_usuario ( ds_email );