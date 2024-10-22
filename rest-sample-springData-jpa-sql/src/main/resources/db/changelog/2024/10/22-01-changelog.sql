-- liquibase formatted sql

-- changeset potato:1729604791167-1
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 50;

-- changeset potato:1729604791167-2
CREATE SEQUENCE post_seq START WITH 1 INCREMENT BY 50;

-- changeset potato:1729604791167-3
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 50;

-- changeset potato:1729604791167-4
CREATE TABLE comment
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    author_name VARCHAR(255),
    body        VARCHAR(255),
    created_on  TIMESTAMP,
    updated_on  TIMESTAMP,
    post_id     BIGINT,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

-- changeset potato:1729604791167-5
CREATE TABLE post
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    body        VARCHAR(255),
    slug        VARCHAR(255),
    post_status SMALLINT,
    created_on  TIMESTAMP,
    updated_on  TIMESTAMP,
    CONSTRAINT pk_post PRIMARY KEY (id)
);

-- changeset potato:1729604791167-6
CREATE TABLE "user"
(
    id   BIGINT NOT NULL,
    name NVARCHAR(75) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

-- changeset potato:1729604791167-7
ALTER TABLE "user"
    ADD CONSTRAINT uc_user_name UNIQUE (name);

-- changeset potato:1729604791167-8
ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_POST FOREIGN KEY (post_id) REFERENCES post (id);

