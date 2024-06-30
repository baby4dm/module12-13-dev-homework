-- Inserting 10 clients
INSERT INTO client (name) VALUES
                              ('Alice'),
                              ('Bob'),
                              ('Charlie'),
                              ('David'),
                              ('Eva'),
                              ('Frank'),
                              ('Grace'),
                              ('Hannah'),
                              ('Ivy'),
                              ('Jack');

-- Inserting 5 planets
INSERT INTO planet (id, name) VALUES
                                  ('EARTH', 'Earth'),
                                  ('MARS', 'Mars'),
                                  ('VENUS', 'Venus'),
                                  ('JUPITER', 'Jupiter'),
                                  ('SATURN', 'Saturn');

-- Inserting 10 tickets
INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                             (NOW(), 1, 'EARTH', 'MARS'),
                                                                             (NOW(), 2, 'MARS', 'VENUS'),
                                                                             (NOW(), 3, 'VENUS', 'JUPITER'),
                                                                             (NOW(), 4, 'JUPITER', 'SATURN'),
                                                                             (NOW(), 5, 'SATURN', 'EARTH'),
                                                                             (NOW(), 6, 'EARTH', 'VENUS'),
                                                                             (NOW(), 7, 'MARS', 'JUPITER'),
                                                                             (NOW(), 8, 'VENUS', 'SATURN'),
                                                                             (NOW(), 9, 'JUPITER', 'EARTH'),
                                                                             (NOW(), 10, 'SATURN', 'MARS');
