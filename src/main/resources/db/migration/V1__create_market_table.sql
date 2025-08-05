CREATE TABLE market
(
    id        SERIAL PRIMARY KEY,
    created   TIMESTAMP,
    updated   TIMESTAMP,
    market_id UUID NOT NULL,
    address   TEXT NOT NULL,
    city      TEXT NOT NULL,
    country   TEXT NOT NULL,
    brand     TEXT NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_market_city
    ON market (city);