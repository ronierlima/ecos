CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';

  create table if not exists anexo
(
    id               bigserial not null,
    codigo           uuid,
    content_type     varchar(255),
    data_atualizacao timestamp,
    data_cadastro    timestamp,
    nome_arquivo     varchar(255),
    tamanho          int8,
    primary key (id)
);

 create table if not exists anexo_aud
(
    id               int8 not null,
    rev              int4 not null,
    revtype          int2,
    codigo           uuid,
    content_type     varchar(255),
    data_atualizacao timestamp,
    data_cadastro    timestamp,
    nome_arquivo     varchar(255),
    tamanho          int8,
    primary key (id, rev),
    constraint anexo_aud_fkey foreign key (rev) references revinfo
);

 create table if not exists foto_usuario
(
    content_type varchar(255),
    descricao    varchar(255),
    nome_arquivo varchar(255),
    tamanho      int8,
    usuario_id   int8 not null,
    primary key (usuario_id),
    constraint foto_usuario_fkey foreign key (usuario_id) references usuario
);

 create table if not exists grupo
(
    id               bigserial not null,
    ativo            boolean,
    codigo           uuid,
    data_atualizacao timestamp,
    data_cadastro    timestamp,
    nome             varchar(255),
    primary key (id)
);

 create table if not exists grupo_aud
(
    id               int8 not null,
    rev              int4 not null,
    revtype          int2,
    ativo            boolean,
    codigo           uuid,
    data_atualizacao timestamp,
    data_cadastro    timestamp,
    nome             varchar(255),
    primary key (id, rev),
    constraint grupo_aud_fkey foreign key (rev) references revinfo
);

 create table if not exists grupo_permissao
(
    grupo_id     int8 not null,
    permissao_id int8 not null,
    primary key (grupo_id, permissao_id)
);

 create table if not exists grupo_permissao_aud
(
    rev          int4 not null,
    grupo_id     int8 not null,
    permissao_id int8 not null,
    revtype      int2,
    primary key (rev, grupo_id, permissao_id)
);

 create table if not exists modelo
(
    id         bigserial not null,
    codigo     uuid,
    descricao  varchar(255),
    titulo     varchar(255),
    usuario_id int8      not null,
    primary key (id),
    constraint modelo_usuario_fkey foreign key (usuario_id) references usuario
);

 create table if not exists modelo_aud
(
    id         int8 not null,
    rev        int4 not null,
    revtype    int2,
    codigo     uuid,
    descricao  varchar(255),
    titulo     varchar(255),
    usuario_id int8,
    primary key (id, rev),
    constraint modelo_aud_fkey foreign key (rev) references revinfo
);

 create table if not exists revinfo
(
    id             int4 not null,
    timestamp      int8 not null,
    codigo_usuario uuid,
    data_cadastro  timestamp,
    nome_usuario   varchar(255),
    primary key (id)
);

 create table if not exists usuario
(
    id               bigserial not null,
    ativo            boolean default true,
    codigo           uuid,
    data_atualizacao timestamp,
    data_cadastro    timestamp,
    email            varchar(255),
    instituicao      varchar(255),
    login            varchar(255),
    nome             varchar(255),
    senha            varchar(255),
    primary key (id)
);

 create table if not exists usuario_aud
(
    id               int8 not null,
    rev              int4 not null,
    revtype          int2,
    ativo            boolean,
    codigo           uuid,
    data_atualizacao timestamp,
    data_cadastro    timestamp,
    email            varchar(255),
    instituicao      varchar(255),
    login            varchar(255),
    nome             varchar(255),
    senha            varchar(255),
    primary key (id, rev),
    constraint usuario_aud_fkey foreign key (rev) references revinfo
);

 create table if not exists usuario_grupo
(
    usuario_id integer not null,
    grupo_id   integer not null,
    primary key (usuario_id, grupo_id),
    constraint usuario_grupo_grupo_fkey foreign key (grupo_id) references grupo,
    constraint usuario_grupo_usuario_fkey foreign key (usuario_id) references usuario
);

 create table if not exists usuario_grupo_aud
(
    rev        integer not null,
    usuario_id bigint  not null,
    grupo_id   bigint  not null,
    revtype    smallint,
    primary key (rev, usuario_id, grupo_id),
    constraint usuario_grupo_aud_fkey foreign key (rev) references revinfo
);