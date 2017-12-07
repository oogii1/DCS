delete from setting;
INSERT INTO setting (`type`, var_key, var_value) VALUES
('ROLE_TYPE', 'Patient', 'Patient'),
('ROLE_TYPE', 'Doctor', 'Doctor'),
('ROLE_TYPE', 'Admin', 'Admin'),
('ROLE_TYPE', 'Receptionlist', 'Receptionlist'),
('CERT_TYPE', 'C1', 'Master'),
('CERT_TYPE', 'C2', 'Doctor'),
('CERT_TYPE', 'C3', 'Post-Doctory');