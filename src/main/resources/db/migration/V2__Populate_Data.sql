INSERT INTO country (name, iso_code) VALUES
    ('Spain', 'ES'),
    ('Portugal', 'PT'),
    ('United Kingdon', 'UK'),
    ('United States of America', 'US'),
    ('Canada', 'CA'),
    ('Germany', 'DE');

INSERT INTO state (name, iso_code, country_id) VALUES
    ('Zaragoza', 'Z', 1),
    ('Madrid', 'M', 1),
    ('Barcelona', 'B', 1),
    ('Greater London', 'JS', 3),
    ('Texas', 'TX', 4),
    ('Ontario', 'ON', 5),
    ('Hesse', 'HE', 6),
    ('Bavaria', 'BY', 6),
    ('Lisboa', 'LI', 2);

INSERT INTO city (name, state_id, iata) VALUES
    ('Zaragoza', 1, 'ZAZ'),
    ('Madrid', 2, 'MAD'),
    ('Barcelona', 3, 'BCN'),
    ('London', 4, 'LHR'),
    ('Dallas', 5, 'DFW'),
    ('Toronto', 6, 'YYZ'),
    ('Frankfurt', 7, 'FRA'),
    ('Munich', 8, 'MUC'),
    ('Lisboa', 9, 'LIS');

INSERT INTO route (origin_city_id, destiny_city_id, departure_time, arrival_time) VALUES
    (1, 9, '10:23:34', '11:30:10'),
    (1, 4, '10:04:15', '12:09:32'),
    (2, 3, '04:45:01', '05:47:22'),
    (3, 2, '02:15:39', '03:17:52'),
    (2, 4, '10:23:34', '11:50:10'),
    (4, 5, '09:15:12', '18:17:08'),
    (4, 5, '17:15:39', '02:17:43'),
    (7, 2, '02:15:19', '03:16:26'),
    (7, 6, '12:34:12', '22:24:24'),
    (7, 8, '15:00:19', '16:02:01'),
    (8, 4, '20:07:19', '21:37:52'),
    (8, 4, '21:08:19', '22:39:10'),
    (8, 4, '12:23:19', '13:57:00'),
    (8, 4, '09:13:54', '10:44:31'),
    (4, 9, '23:53:24', '01:10:09');

