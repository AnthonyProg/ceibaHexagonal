DROP TABLE IF EXISTS vehicletype;
 
CREATE TABLE vehicletype (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  vehicle_type VARCHAR(250) NOT NULL
);
 
INSERT INTO vehicletype (vehicle_type) VALUES
  ('CARRO'),
  ('MOTO');