CREATE SEQUENCE key_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 308915776
    CYCLE;

CREATE TABLE link (
                      id NUMBER GENERATED ALWAYS AS IDENTITY,
                      key VARCHAR2(8) UNIQUE,
                      url VARCHAR2(2000),
                      CONSTRAINT pk_link PRIMARY KEY (id)
);

CREATE OR REPLACE TRIGGER trg_link_key
    BEFORE INSERT ON link
    FOR EACH ROW
BEGIN
    :NEW.key := 'K' || LPAD(to_char(key_seq.NEXTVAL + 96), 7, 'a');
END;
/