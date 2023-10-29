
-- changeset liquibase:1
CREATE TABLE customer (id SERIAL PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255));
-- rollback drop table customer;

-- changeset liquibase:2
CREATE TABLE book (
                      id                  BIGSERIAL PRIMARY KEY NOT NULL,
                      author              varchar(255) NOT NULL,
                      isbn                varchar(255) UNIQUE NOT NULL,
                      price               float8 NOT NULL,
                      title               varchar(255) NOT NULL,
                      version             integer NOT NULL
);
-- rollback drop table book;