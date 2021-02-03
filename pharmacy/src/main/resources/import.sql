insert into pharmacy (address, name) values ('Fejes Klare 34.', 'Jankovic');
insert into pharmacy (address, name) values ('Fejes Klare 34.', 'Benu');
insert into pharmacy (address, name) values ('Fejes Klare 34.', 'Zdravlje');
insert into pharmacy (address, name) values ('Fejes Klare 34.', 'ApotekaPlus');
insert into pharmacy (address, name) values ('Fejes Klare 34.', 'Pharmacy');
insert into pharmacy (address, name) values ('Fejes Klare 34.', 'Nova');

-- Schedule
insert into schedule(start_date, end_date, start_time, end_time)values('2021-02-01', '2021-02-07', '08:00:00', '14:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-07', '14:00:00', '20:00:00');

-- PharmacyAdmin

--insert into pharmacy_admin(user_id, pharmacy_id, is_first_log) values (9,1,true);
--insert into pharmacy_admin(user_id, pharmacy_id, is_first_log) values (10,2,true);


-- WorkSchedule
--insert into work_schedule(schedule_id) values(1);
--insert into work_schedule(schedule_id) values(2);

-- Patient
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Suboticka 23', 'Novi Sad', 'Srbija', 'maja@gmail.com', 'Maja', 'maja', '076/468965', 'Stamenic', 0, true);
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Rumenacka 23', 'Novi Sad', 'Srbija', 'gojko@gmail.com', 'Gojko', 'gojko', '076/468965', 'Novcic', 0, true);
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Temerinska 23', 'Novi Sad', 'Srbija', 'tasa@gmail.com', 'Tasa', 'tasa', '076/468965', 'Damjanac', 0, true);
-- Supplier
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Ticanova 23', 'Novi Sad', 'Srbija', 'masa@gmail.com', 'Masa', 'masa', '076/468965', 'Milanovic', 4, true);
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Gagarinova 83', 'Novi Sad', 'Srbija', 'marko@gmail.com', 'Marko', 'marko', '065/468965', 'Markovic', 4, true);
-- Admin
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Marka Kraljevica 2', 'Novi Sad', 'Srbija', 'mara@gmail.com', 'Mara', 'mara', '062/468965', 'Marovic', 1, true);
-- Dermatologist
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Somborska 37', 'Novi Sad', 'Srbija', 'milica@gmail.com', 'Milica', 'milica', '063/468965', 'Milicic', 2, true);
-- Pharmacist
insert into app_user (address, city, country, email, name, password, phone, surname, role, active) values('Futoska 101', 'Novi Sad', 'Srbija', 'luka@gmail.com', 'Luka', 'luka', '067/468965', 'Lukic', 3, true);
--insert into pharmacist(is_first_log, pharmacy_id, user_id, work_schedule_id) values(true, 5, 8, 1);

-- Hospital
INSERT INTO hospital( email, name) VALUES ('peraperic@gmail.com', 'Lalala');

INSERT INTO medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition)VALUES (62542, 0, 'Galenika', 'Brufen', 'Beleska 1', 0, 'Lek za temperaturu', 'sastav1');
INSERT INTO medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition)VALUES (66042, 1, 'Optisorb', 'Panadol', 'Beleska 2', 1, 'Lek za bolove', 'sastav2');
INSERT INTO medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition)VALUES (62217, 2, 'Bayer', 'Aspirin', 'Beleska 3', 0, 'Lek za bolove i prehladu', 'sastav3');

insert into app_order( end_date, end_time) values ('2021-02-07', '08:00:00');
insert into app_order(end_date, end_time) values ('2021-03-07', '04:00:00');

-- Za apoteku sa id=1
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.50, 2350, 1, 1);
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (2.00, 2985, 2, 1);
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.75, 1420, 3, 1);
-- Za apoteku sa id=2
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.44, 15, 1, 2);
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.90, 18, 2, 2);

INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (1, 1);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (2, 2);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (3, 3);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (1, 4);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (2, 5);

INSERT INTO public.medicine_replacement_medicines(medicine_id, replacement_medicines)VALUES (1, 62217);
INSERT INTO public.medicine_replacement_medicines(medicine_id, replacement_medicines)VALUES (2, 66042);

INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (1, 1);
INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (1, 2);
INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (1, 3);

INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (2, 4);
INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (2, 5);

INSERT INTO public.medicineeprescription( code, name, quantity)VALUES ( 2, 'brufen', 123419);
INSERT INTO public.medicineeprescription(code, name, quantity)VALUES ( 8, 'panadol', 6839093);

INSERT INTO public.eprescription( code, date_of_issue, file_text, patient_name)VALUES ( 24363, null, 'Brufen, Panadol', 'Marko Markovic');
INSERT INTO public.eprescription(code, date_of_issue, file_text, patient_name)VALUES ( 246663, null, 'Brufen', 'Petar Petrovic');

INSERT INTO public.eprescription_list_of_medication(eprescription_id, list_of_medication_id) VALUES (1, 1);
INSERT INTO public.eprescription_list_of_medication(eprescription_id, list_of_medication_id) VALUES (1, 2);