DROP TABLE IF EXISTS vehicletype;
 
CREATE TABLE vehicletype (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  vehicle_type VARCHAR(250) NOT NULL
);
 
INSERT INTO vehicletype (vehicle_type) VALUES
  ('CARRO'),
  ('MOTO');
  
INSERT INTO vehicleRegistration (check_in_time,check_out_time,vehicle_plate,brand,model,color,vehicle_type) VALUES
  							--CARROS
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--1
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--2
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--3
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--4
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--5
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--6
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--7
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--8
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--9
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--10
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--11
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--12
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--13
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--14
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--15
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--16
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--17
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--18
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--19
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',1),--20
  							--MOTOS
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--1 
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--2
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--3
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--4
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--5
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--6
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--7
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2),--8
  (1557703751000,0,'AAAAAA','MARCAX','MODELOX','COLORX',2);--9
  
  