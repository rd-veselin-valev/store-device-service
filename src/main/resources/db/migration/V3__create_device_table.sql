CREATE TABLE device
(
    id               UUID PRIMARY KEY,
    type             VARCHAR(50) NOT NULL,
    market_id        INTEGER,
    specification_id INTEGER,
    created          TIMESTAMP,
    updated          TIMESTAMP,

    CONSTRAINT fk_device_market FOREIGN KEY (market_id)
        REFERENCES market (id)
        ON DELETE SET NULL,

    CONSTRAINT fk_device_specification FOREIGN KEY (specification_id)
        REFERENCES specification (id)
        ON DELETE SET NULL
);

CREATE INDEX idx_device_market_id ON device (market_id);