CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL,
    name VARCHAR(64) NOT NULL,
    email TEXT NOT NULL,
    last_change TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    CONSTRAINT user_pk
        PRIMARY KEY (id)
);

CREATE INDEX user_email_index ON users (email);