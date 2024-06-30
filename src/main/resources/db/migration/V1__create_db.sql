CREATE TABLE client(
    id BIGSERIAL,
    name VARCHAR,
    CONSTRAINT client_PK PRIMARY KEY (id)
);

CREATE TABLE planet(
    id VARCHAR,
    name VARCHAR,
    CONSTRAINT planet_PK PRIMARY KEY (id)
);

CREATE TABLE ticket(
    id BIGSERIAL,
    created_at TIMESTAMP,
    client_id BIGSERIAL,
    from_planet_id VARCHAR,
    to_planet_id VARCHAR,
    CONSTRAINT ticket_PK PRIMARY KEY (id),
    CONSTRAINT ticket_client_id_FK FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT ticket_from_planet_FK FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    CONSTRAINT ticket_to_planet_FK FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
