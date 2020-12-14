insert into app_user (address, city, country, email, name, password, phone, surname, dtype) values('Suboticka 23', 'Novi Sad', 'Srbija', 'maja@gmail.com', 'Maja', 'maja', '076/468965', 'Stamenic', 'User');
insert into app_user (address, city, country, email, name, password, phone, surname, dtype) values('Rumenacka 23', 'Novi Sad', 'Srbija', 'gojko@gmail.com', 'Gojko', 'gojko', '076/468965', 'Novcic', 'User');
insert into app_user (address, city, country, email, name, password, phone, surname, dtype) values('Temerinska 23', 'Novi Sad', 'Srbija', 'tasa@gmail.com', 'Tasa', 'tasa', '076/468965', 'Damjanac', 'User');
insert into app_user (address, city, country, email, name, password, phone, surname, dtype) values('Ticanova 23', 'Novi Sad', 'Srbija', 'masa@gmail.com', 'Masa', 'masa', '076/468965', 'Milanovic', 'User');

insert into pharmacy (id, address, api_key, name) values (1, 'Fejes Klare 34.', 'Jankovic45', 'Jankovic');
insert into pharmacy (id, address, api_key, name) values (2, 'Fejes Klare 34.', 'Benu67', 'Benu');
insert into pharmacy (id, address, api_key, name) values (3, 'Fejes Klare 34.', 'Zdravo', 'Zdravlje');
insert into pharmacy (id, address, api_key, name) values (4, 'Fejes Klare 34.', 'lalala', 'Apoteka+');
insert into pharmacy (id, address, api_key, name) values (5, 'Fejes Klare 34.', 'lalala', 'Pharmacy');
insert into pharmacy (id, address, api_key, name) values (6, 'Fejes Klare 34.', 'lalalala', 'Nova');

INSERT INTO hospital(id, email, name) VALUES (5, 'peraperic@gmail.com', 'Lalala');
INSERT INTO hospital_pharmacies(hospital_id, pharmacies_id) VALUES (5, 1); 
INSERT INTO hospital_pharmacies(hospital_id, pharmacies_id) VALUES (5, 2);
INSERT INTO hospital_pharmacies(hospital_id, pharmacies_id) VALUES (5, 3);
INSERT INTO hospital_pharmacies(hospital_id, pharmacies_id) VALUES (5, 4);
INSERT INTO hospital_pharmacies(hospital_id, pharmacies_id) VALUES (5, 5);
INSERT INTO hospital_pharmacies(hospital_id, pharmacies_id) VALUES (5, 6);

INSERT INTO public.medicine(id, code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine)VALUES (1, 62542, 'lala', 'lalal', 'brufen', 'lala', 'WITHOUT_PRESCRIPTION', 'lalala');
INSERT INTO public.medicine(id, code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine)VALUES (2, 66042, 'lala', 'lalal', 'panadol', 'lala', 'WITHOUT_PRESCRIPTION', 'lalala');

INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (1, 'lala');
INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (1, 'blabla');
INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (2, 'toto');
INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (2, 'ieie');

INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (1, 150, 2345, 1, 1);
INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (2, 200, 2985, 2, 1);

INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (4, 144, 5, 1, 2);
INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (5, 190, 8, 2, 2);

INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (1, 1);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (2, 2);

INSERT INTO public.medicine_replacement_medicines(medicine_id, replacement_medicines)VALUES (1, 'aspirin');
INSERT INTO public.medicine_replacement_medicines(medicine_id, replacement_medicines)VALUES (2, 'nimulid');

INSERT INTO public.pharmacy_medicine_pharmaciest(pharmacy_id, medicine_pharmaciest_id)VALUES (1, 1);
INSERT INTO public.pharmacy_medicine_pharmaciest(pharmacy_id, medicine_pharmaciest_id)VALUES (1, 4);


INSERT INTO public.pharmacy_hospitals(pharmacy_id, hospitals_id)VALUES (1, 5);

INSERT INTO public.medicineeprescription(id, code, name, quantity)VALUES (1, 2, 'brufen', 123419);
INSERT INTO public.medicineeprescription(id, code, name, quantity)VALUES (2, 8, 'panadol', 6839093);

INSERT INTO public.eprescription(id, code, date_of_issue, file_text, patient_name)VALUES (1, '24363', null, 'brufen, panadol', 'Marko Markovic');
INSERT INTO public.eprescription(id, code, date_of_issue, file_text, patient_name)VALUES (2, '246663', null, 'brufen', 'Petar Petrovic');

INSERT INTO public.eprescription_list_of_medication(eprescription_id, list_of_medication_id) VALUES (1, 1);
INSERT INTO public.eprescription_list_of_medication(eprescription_id, list_of_medication_id) VALUES (1, 2);