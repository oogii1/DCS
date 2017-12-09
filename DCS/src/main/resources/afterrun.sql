delete from setting;
INSERT INTO setting (`type`, var_key, var_value) VALUES
('ROLE_TYPE', 'Patient', 'Patient'),
('ROLE_TYPE', 'Doctor', 'Doctor'),
('ROLE_TYPE', 'Admin', 'Admin'),
('ROLE_TYPE', 'Receptionlist', 'Receptionlist'),
('CERT_TYPE', 'C1', 'Master'),
('CERT_TYPE', 'C2', 'Doctor'),
('CERT_TYPE', 'C3', 'Post-Doctory');



INSERT INTO `dcs`.`setting` (`type`, `var_key`, `var_value`) VALUES ('APT_TIME', 'T1', '9:00');
INSERT INTO `dcs`.`setting` (`type`, `var_key`, `var_value`) VALUES ('APT_TIME', 'T2', '10:00');


INSERT INTO `dcs`.`appointment` (`aptmnt_date`, `insert_date`, 
`prescription`, `symptom`, `treatment`, `aptmnt_time`, `doctor_id`, `patient_id`) 
VALUES ('2017-10-10', '2017-10-10', 'DFSAF', 'SDFAS', 'ADFSF', '11', '1', '1');


INSERT INTO `dcs`.`treatment` (`advice`, `prescription`, `price`, `symptom`, 
`treatment`, `aptmnt_id`, `doctor_id`, `patient_id`, `tooth_no`) 
VALUES ('sdfasf', 'sdfas', '123', 'dsfasdf', 'dsfdaf', '3', '1', '1', '8');

