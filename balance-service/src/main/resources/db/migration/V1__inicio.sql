CREATE TABLE IF NOT EXISTS saldos (
    id bigint NOT NULL,
    usuario_id integer NOT NULL,
    total numeric NOT NULL,
    CONSTRAINT saldos_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS saldos_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER TABLE saldos ALTER COLUMN id SET DEFAULT nextval('saldos_id_seq');