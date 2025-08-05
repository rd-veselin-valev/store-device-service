CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DO $$
DECLARE
i INT := 1;
    spec_id INT;
    types TEXT[] := ARRAY['RVM', 'ADVERTISEMENT', 'CHECKOUT'];
    manufacturers TEXT[] := ARRAY['MAN_1', 'MAN_2', 'MAN_3'];
    statuses TEXT[] := ARRAY['OPERATIONAL', 'MAINTENANCE', 'OFFLINE'];
BEGIN
    WHILE i <= 15000 LOOP
        INSERT INTO specification(serial_number, ip, manufacturer, status, created, updated)
        VALUES (
            'SN-' || i,
            '192.168.1.' || (i % 255),
            manufacturers[floor(random() * 3 + 1)::int],
            statuses[floor(random() * 3 + 1)::int],
            now(),
            now()
        )
        RETURNING id INTO spec_id;

INSERT INTO device(id, type, market_id, specification_id, created, updated)
VALUES (
           uuid_generate_v4(),
           types[floor(random() * 3 + 1)::int],
           null, -- Placeholder market_id
           spec_id,
           now(),
           now()
       );

i := i + 1;
END LOOP;
END $$;
