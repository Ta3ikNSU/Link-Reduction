CREATE TABLE link (
              id NUMBER,
              key VARCHAR2(8) UNIQUE,
              url VARCHAR2(2000),
              CONSTRAINT pk_link PRIMARY KEY (id)
);
