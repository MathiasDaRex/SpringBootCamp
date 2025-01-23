-- Táblák törlése (ha már léteznek)
DROP TABLE IF EXISTS rental;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS bike;

-- Bike tábla létrehozása
CREATE TABLE bike (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    size VARCHAR(20) NOT NULL,
    daily_rate DECIMAL(10, 2) NOT NULL,
    purchase_date DATE NOT NULL
);

-- Customer tábla létrehozása
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    id_number VARCHAR(20) NOT NULL UNIQUE,
    registration_date DATE NOT NULL
);

-- Rental tábla létrehozása
CREATE TABLE rental (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bike_id INT NOT NULL,
    customer_id INT NOT NULL,
    rental_start DATETIME NOT NULL,
    planned_return DATETIME NOT NULL,
    actual_return DATETIME,
    status ENUM('active', 'closed', 'overdue') NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (bike_id) REFERENCES bike(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- 15 bicikli hozzáadása (4 MTB, 4 E-MTB, 4 országúti, 3 városi)
INSERT INTO bike (type, brand, model, size, daily_rate, purchase_date) VALUES
('MTB', 'Trek', 'Fuel EX 8', 'M', 4000.00, '2023-01-15'),
('MTB', 'Specialized', 'Stumpjumper', 'L', 4200.00, '2023-02-10'),
('MTB', 'Giant', 'Trance X', 'M', 3800.00, '2023-03-05'),
('MTB', 'Cannondale', 'Habit', 'L', 4100.00, '2023-04-01'),
('E-MTB', 'Cube', 'Stereo Hybrid 140', 'M', 5500.00, '2023-01-20'),
('E-MTB', 'Haibike', 'XDURO AllMtn', 'L', 5800.00, '2023-02-15'),
('E-MTB', 'Scott', 'Genius eRIDE', 'M', 6000.00, '2023-03-10'),
('E-MTB', 'Merida', 'eOne-Sixty', 'L', 5700.00, '2023-04-05'),
('Országúti', 'Bianchi', 'Oltre XR4', 'M', 4500.00, '2023-01-25'),
('Országúti', 'Pinarello', 'Dogma F', 'L', 5000.00, '2023-02-20'),
('Országúti', 'Colnago', 'C64', 'M', 4800.00, '2023-03-15'),
('Országúti', 'Canyon', 'Ultimate CF SLX', 'L', 4700.00, '2023-04-10'),
('Városi', 'Csepel', 'Rapid', 'M', 2500.00, '2023-01-30'),
('Városi', 'Schwinn', 'Cruiser', 'L', 2300.00, '2023-02-25'),
('Városi', 'Gepida', 'Alboin', 'M', 2700.00, '2023-03-20');

-- 10 ügyfél hozzáadása
INSERT INTO customer (name, email, phone, address, id_number, registration_date) VALUES
('Nagy János', 'nagy.janos@email.hu', '+36201234567', 'Budapest, Petőfi u. 1.', 'AB123456', '2023-01-15'),
('Kiss Éva', 'kiss.eva@email.hu', '+36301234567', 'Debrecen, Kossuth tér 2.', 'CD234567', '2023-02-01'),
('Kovács Péter', 'kovacs.peter@email.hu', '+36701234567', 'Szeged, Dóm tér 3.', 'EF345678', '2023-02-15'),
('Szabó Katalin', 'szabo.katalin@email.hu', '+36201234568', 'Pécs, Széchenyi tér 4.', 'GH456789', '2023-03-01'),
('Horváth Tamás', 'horvath.tamas@email.hu', '+36301234568', 'Győr, Baross út 5.', 'IJ567890', '2023-03-15'),
('Tóth Zsuzsanna', 'toth.zsuzsanna@email.hu', '+36701234568', 'Miskolc, Városház tér 6.', 'KL678901', '2023-04-01'),
('Balogh Gábor', 'balogh.gabor@email.hu', '+36201234569', 'Székesfehérvár, Fő utca 7.', 'MN789012', '2023-04-15'),
('Mészáros Ildikó', 'meszaros.ildiko@email.hu', '+36301234569', 'Kecskemét, Szabadság tér 8.', 'OP890123', '2023-05-01'),
('Varga László', 'varga.laszlo@email.hu', '+36701234569', 'Nyíregyháza, Kossuth tér 9.', 'QR901234', '2023-05-15'),
('Fekete Andrea', 'fekete.andrea@email.hu', '+36201234570', 'Szombathely, Fő tér 10.', 'ST012345', '2023-06-01');

