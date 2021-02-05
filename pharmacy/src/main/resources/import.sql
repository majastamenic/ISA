-- Pharmacies
insert into pharmacy (address, name) values('Rumenacka 15, Novi Sad', 'Jankovic');
insert into pharmacy (address, name) values('Hajduk Veljkova 8, Novi Sad', 'Benu');
insert into pharmacy (address, name) values('Bulevar Cara Lazara 76, Novi Sad', 'Zelena Apoteka');
insert into pharmacy (address, name) values('Bulevar Cara Lazara 88, Novi Sad', 'Galen pharm');
insert into pharmacy (address, name) values('Rumenacka 13, Novi Sad', 'Irisfarm');
insert into pharmacy (address, name) values('Futoski Put 85A, Novi Sad', 'Tilia');

-- Hospital
insert into hospital(email, name) values('integration.adapter@gmail.com', 'WellDevClinic');

-- ********************************  USERS ****************************************************************
-- User: Patient
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Maja', 'Stamenic', 'maja@gmail.com', 'maja', 'Suboticka 23', 'Novi Sad', 'Srbija', '066/468965', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Gojko', 'Novcic', 'gojko@gmail.com', 'gojko', 'Rumenacka 23', 'Novi Sad', 'Srbija', '061/558877', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nastasja', 'Damjanac', 'tasa@gmail.com', 'tasa', 'Temerinska 23', 'Novi Sad', 'Srbija', '066/123466', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Jovana', 'Jakovljevic', 'joxy@gmail.com', 'joxy', 'Lasla Gala 15', 'Novi Sad', 'Srbija', '063/1125455', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Aca', 'Lukas', 'aca@gmail.com', 'aca', 'Vojislava Vuckovica 1', 'Beograd', 'Srbija', '069/5889522', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Toma', 'zdravkovic', 'toma@gmail.com', 'toma', 'Jastrebacka 11', 'Aleksinac', 'Srbija', '065/338799', 0, true);
    -- Patient
    insert into patient(id, verification_code, user_id) values(1, 'bgbhjjgfgggfhouytr', 1);
    insert into patient(id, verification_code, user_id) values(2, 'fdssdsdggsfgfsasgj', 2);
    insert into patient(id, verification_code, user_id) values(3, 'gdfhjgkrterfscvtyu', 3);
    insert into patient(id, verification_code, user_id) values(4, 'gdfhjgkrterfscvtyu', 4);
    insert into patient(id, verification_code, user_id) values(5, 'gdfhjgkrterfscvtyu', 5);
    insert into patient(id, verification_code, user_id) values(6, 'gdfhjgkrterfscvtyu', 6);
-- User: Pharmacist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Marija', 'Milanovic', 'masa@gmail.com', 'masa', 'Ticanova 23', 'Novi Sad', 'Srbija', '069/7798654', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milan', 'Knezevic', 'milan@gmail.com', 'milan', 'Gagarinova 83', 'Novi Sad', 'Srbija', '065/963565', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nikola', 'Antonic', 'antonic@gmail.com', 'antonic', 'Bulevar Oslobodjenja 78', 'Novi Sad', 'Srbija', '065/789101', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mirko', 'Plavsic', 'mirko@gmail.com', 'mirko', 'Pa Pavla 14', 'Novi Sad', 'Srbija', '069/8765432', 3, true);
    -- Pharmacist
    insert into pharmacist(id, pharmacy_id, user_id) values(7, 5, 7);
    insert into pharmacist(id, pharmacy_id, user_id) values(8, 6, 8);
    insert into pharmacist(id, pharmacy_id, user_id) values(9, 4, 9);
    insert into pharmacist(id, pharmacy_id, user_id) values(10, 5, 10);
-- User: Admin
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nikola', 'Luburic', 'nikola@uns.ac.rs', 'nikola', 'Marka Kraljevica 2', 'Novi Sad', 'Srbija', '062/468965', 1, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Rade', 'Doroslovacki', 'rade@uns.ac.rs', 'rade', 'Marka Kraljevica 15', 'Novi Sad', 'Srbija', '062/779635', 1, true);
-- User: Dermatologist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milica', 'Pavlovic', 'milica@gmail.com', 'milica', 'Somborska 37', 'Novi Sad', 'Srbija', '063/887345', 2, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Darko', 'Milicic', 'dare@gmail.com', 'dare', 'Zmaj Jovina 56', 'Novi Sad', 'Srbija', '061/1116555', 2, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Acim', 'Maravic', 'acim@gmail.com', 'acim', 'Bulevar Cara Lazara 15', 'Novi Sad', 'Srbija', '063/555333', 2, true);
    -- Dermatologist
    insert into dermatologist(id, user_id) values(13, 13);
    insert into dermatologist(id, user_id) values(14, 14);
    insert into dermatologist(id, user_id) values(15, 15);
-- User: Supplier
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Luka', 'Djurdjevic', 'luka@gmail.com', 'luka', 'Futoska 101', 'Novi Sad', 'Srbija', '067/823789', 4, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Simona', 'Prokic', 'simona@gmail.com', 'simona', 'Fruskogorska 12', 'Novi Sad', 'Srbija', '067/114885', 4, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mitar', 'Miric', 'mitar@gmail.com', 'mitar', 'Futoski put 105', 'Novi Sad', 'Srbija', '067/335658', 4, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Ana', 'Nikolic', 'ana@gmail.com', 'ana', 'Bulevar Cara Dusana 18', 'Novi Sad', 'Srbija', '064/127865', 4, true);

-- User: PharmacyAdmin
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mikica', 'Djurdjevic', 'mikica@gmail.com', 'mikica', 'Futoska 101', 'Novi Sad', 'Srbija', '067/823789', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Marko', 'Markovic', 'mare@gmail.com', 'mare', 'Fruskogorska 15', 'Novi Sad', 'Srbija', '067/114885', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milos', 'Djuric', 'milos@gmail.com', 'milos', 'Dunavska 89', 'Novi Sad', 'Srbija', '067/114885', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Marija', 'Vucevic', 'marija@gmail.com', 'marija', 'Narodnog Fronta 78', 'Novi Sad', 'Srbija', '063/659898', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mirjana', 'Radojcic', 'mima@gmail.com', 'mima', 'Zeleznicka 18', 'Novi Sad', 'Srbija', '061/1112565', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Ivana', 'Ivanovic', 'ivana@gmail.com', 'ivana', 'Vojvodjanskih Brigada 2', 'Novi Sad', 'Srbija', '069/3355668', 5, true);
    -- PharmacyAdmin
    insert into pharmacy_admin(user_id, pharmacy_id) values (20,1);
    insert into pharmacy_admin(user_id, pharmacy_id) values (21,2);
    insert into pharmacy_admin(user_id, pharmacy_id) values (22,3);
    insert into pharmacy_admin(user_id, pharmacy_id) values (23,4);
    insert into pharmacy_admin(user_id, pharmacy_id) values (24,5);
    insert into pharmacy_admin(user_id, pharmacy_id) values (25,6);
-- *********************************************************************************************************

-- Schedule: for work time
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-07', '08:00:00', '14:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-07', '14:00:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-08', '2021-02-14', '08:00:00', '14:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-08', '2021-02-14', '14:00:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-21', '08:00:00', '14:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-21', '14:00:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-22', '2021-02-28', '08:00:00', '14:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-22', '2021-02-28', '14:00:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-01', '2021-03-07', '08:00:00', '14:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-01', '2021-03-07', '14:00:00', '20:00:00');
-- Schedule: Examination
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '14:00:00', '14:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '14:30:00', '15:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '15:00:00', '15:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '15:30:00', '16:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '16:00:00', '16:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '16:30:00', '17:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '17:00:00', '17:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '17:30:00', '18:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '18:00:00', '18:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '18:30:00', '19:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '19:00:00', '19:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '19:30:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-01', '19:30:00', '20:00:00');

-- WorkSchedule
insert into work_schedule(schedule_id) values(1);
insert into work_schedule(schedule_id) values(2);
insert into work_schedule(schedule_id) values(3);
insert into work_schedule(schedule_id) values(4);
insert into work_schedule(schedule_id) values(5);
insert into work_schedule(schedule_id) values(6);
insert into work_schedule(schedule_id) values(7);
insert into work_schedule(schedule_id) values(8);
insert into work_schedule(schedule_id) values(9);
insert into work_schedule(schedule_id) values(10);

-- Examinations
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(1, 15, 11, 13, 1);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(2, 20, 12, 13, 1);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(3, 20, 13, 13, 1);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id, patient_id) values(4, 15, 14, 13, 1, 1);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(5, 20, 15, 13, 1);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id, patient_id) values(6, 40, 16, 13, 1, 2);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id, patient_id) values(7, 30, 17, 13, 1, 3);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(8, 25, 18, 13, 2);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(9, 25, 19, 13, 2);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id, patient_id) values(10, 25, 20, 13, 2, 6);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(11, 25, 21, 13, 2);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(12, 25, 22, 13, 2);
insert into examination(id, price, schedule_id, dermatologist_id, pharmacy_id) values(13, 25, 23, 13, 2);

-- Medicines
insert into medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition) values(62542, 0, 'Galenika', 'Brufen', 'Beleska 1', 0, 'Lek za temperaturu', 'cochenillrot, laktoza, monohidrat');
insert into medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition) values(66042, 1, 'Optisorb', 'Panadol', 'Beleska 2', 1, 'Lek za bolove', 'kalijum-sorbat, prečišćeni talk');
insert into medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition) values(62217, 2, 'Bayer', 'Aspirin', 'Beleska 3', 0, 'Lek za bolove i prehladu', 'skrob, trietil-citrat');

-- MedicinePharmacy: Jankovic
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.50, 2350, 1, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(2.00, 2985, 2, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.75, 1420, 3, 1);
-- MedicinePharmacy: Benu
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.44, 15, 1, 2);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.90, 18, 2, 2);

-- Orders
insert into app_order( end_date, end_time) values ('2021-02-07', '08:00:00');
insert into app_order(end_date, end_time) values ('2021-03-07', '04:00:00');

-- MedicineReplacement
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(1, 62217);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(2, 66042);

-- ??????????????
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 1);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 2);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 3);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 4);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 5);
----------------------

insert into medicineeprescription(code, name, quantity) values(2, 'brufen', 123419);
insert into medicineeprescription(code, name, quantity) values(8, 'panadol', 6839093);

-- EPrescription
insert into eprescription(code, date_of_issue, file_text, patient_name) values(24363, null, 'Brufen, Panadol', 'Marko Markovic');
insert into eprescription(code, date_of_issue, file_text, patient_name) values(246663, null, 'Brufen', 'Petar Petrovic');
    -- EPrescription: Medications
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(1, 1);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(1, 2);

-- PatientAllergicMedicines
insert into patient_allergic_medicines(patient_id, allergic_medicines_id) values(1, 1);
insert into patient_allergic_medicines(patient_id, allergic_medicines_id) values(1, 2);