CREATE TABLE specification
(
    id            SERIAL PRIMARY KEY,
    created       TIMESTAMP,
    updated       TIMESTAMP,
    serial_number VARCHAR(255),
    ip            VARCHAR(255),
    manufacturer  VARCHAR(50),
    status        VARCHAR(50)
);

CREATE INDEX idx_specification_serial_number ON specification (serial_number);