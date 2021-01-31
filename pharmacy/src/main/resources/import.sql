insert into app_user (address, city, country, email, name, password, phone, surname, dtype, active) values('Suboticka 23', 'Novi Sad', 'Srbija', 'maja@gmail.com', 'Maja', 'maja', '076/468965', 'Stamenic', 'User', true);
insert into app_user (address, city, country, email, name, password, phone, surname, dtype, active) values('Rumenacka 23', 'Novi Sad', 'Srbija', 'gojko@gmail.com', 'Gojko', 'gojko', '076/468965', 'Novcic', 'User', true);
insert into app_user (address, city, country, email, name, password, phone, surname, dtype, active) values('Temerinska 23', 'Novi Sad', 'Srbija', 'tasa@gmail.com', 'Tasa', 'tasa', '076/468965', 'Damjanac', 'User', true);
insert into app_user (address, city, country, email, name, password, phone, surname, dtype, active) values('Ticanova 23', 'Novi Sad', 'Srbija', 'masa@gmail.com', 'Masa', 'masa', '076/468965', 'Milanovic', 'User', true);

insert into pharmacy (id, address, name) values (1, 'Fejes Klare 34.', 'Jankovic');
insert into pharmacy (id, address, name) values (2, 'Fejes Klare 34.', 'Benu');
insert into pharmacy (id, address, name) values (3, 'Fejes Klare 34.', 'Zdravlje');
insert into pharmacy (id, address, name) values (4, 'Fejes Klare 34.', 'ApotekaPlus');
insert into pharmacy (id, address, name) values (5, 'Fejes Klare 34.', 'Pharmacy');
insert into pharmacy (id, address, name) values (6, 'Fejes Klare 34.', 'Nova');

INSERT INTO hospital(id, email, name) VALUES (5, 'peraperic@gmail.com', 'Lalala');

INSERT INTO public.medicine(id, code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine)VALUES (1, 62542, 'tableta', 'Galenika', 'Brufen', 'Beleska 1', 'WITHOUT_PRESCRIPTION', 'Lek za temperaturu');
INSERT INTO public.medicine(id, code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine)VALUES (2, 66042, 'tableta', 'Optisorb', 'Panadol', 'Beleska 2', 'WITHOUT_PRESCRIPTION', 'Lek za bolove');
INSERT INTO public.medicine(id, code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine)VALUES (3, 62217, 'tableta', 'Bayer', 'Aspirin', 'Beleska 3', 'WITHOUT_PRESCRIPTION', 'Lek za bolove i prehladu');


INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (1, 'lala');
INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (1, 'blabla');
INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (2, 'toto');
INSERT INTO public.medicine_composition(medicine_id, composition)VALUES (2, 'ieie');

-- Za apoteku sa id=1
INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (1, 1.50, 2350, 1, 1);
INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (2, 2.00, 2985, 2, 1);
INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (3, 1.75, 1420, 3, 1);
-- Za apoteku sa id=2
INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (4, 1.44, 15, 1, 2);
INSERT INTO public.medicine_pharmacy(id, price, quantity, medicine_id, pharmacy_id)VALUES (5, 1.90, 18, 2, 2);

INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (1, 1);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (2, 2);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (3, 3);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (1, 4);
INSERT INTO public.medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)VALUES (2, 5);

INSERT INTO public.medicine_replacement_medicines(medicine_id, replacement_medicines)VALUES (1, 'Aspirin');
INSERT INTO public.medicine_replacement_medicines(medicine_id, replacement_medicines)VALUES (2, 'Nimulid');

INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (1, 1);
INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (1, 2);
INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (1, 3);

INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (2, 4);
INSERT INTO public.pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id)VALUES (2, 5);

INSERT INTO public.medicineeprescription(id, code, name, quantity)VALUES (1, 2, 'brufen', 123419);
INSERT INTO public.medicineeprescription(id, code, name, quantity)VALUES (2, 8, 'panadol', 6839093);

INSERT INTO public.eprescription(id, code, date_of_issue, file_text, patient_name)VALUES (1, '24363', null, 'Brufen, Panadol', 'Marko Markovic');
INSERT INTO public.eprescription(id, code, date_of_issue, file_text, patient_name)VALUES (2, '246663', null, 'Brufen', 'Petar Petrovic');

INSERT INTO public.eprescription_list_of_medication(eprescription_id, list_of_medication_id) VALUES (1, 1);
INSERT INTO public.eprescription_list_of_medication(eprescription_id, list_of_medication_id) VALUES (1, 2);