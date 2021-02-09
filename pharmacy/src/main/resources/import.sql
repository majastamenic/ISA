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
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Toma', 'Zdravkovic', 'toma@gmail.com', 'toma', 'Jastrebacka 11', 'Aleksinac', 'Srbija', '065/338799', 0, true);
    -- Patient
    insert into patient(loyalty_points, verification_code, user_id) values(10, 'AVG-EE-FTG', 1);
    insert into patient(loyalty_points, verification_code, user_id) values(15, 'A45-RE-BNA', 2);
    insert into patient(loyalty_points, verification_code, user_id) values(20, '498-WT-B5S', 3);
    insert into patient(loyalty_points, verification_code, user_id) values(25, 'VB4-QR-5BG', 4);
    insert into patient(loyalty_points, verification_code, user_id) values(5,  'QPO-4S-VBG', 5);
    insert into patient(loyalty_points, verification_code, user_id) values(10, 'AS-TRV-T1W', 6);
-- User: Pharmacist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Marija', 'Milanovic', 'masa@gmail.com', 'masa', 'Ticanova 23', 'Novi Sad', 'Srbija', '069/7798654', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milan', 'Knezevic', 'milan@gmail.com', 'milan', 'Gagarinova 83', 'Novi Sad', 'Srbija', '065/963565', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nikola', 'Antonic', 'antonic@gmail.com', 'antonic', 'Bulevar Oslobodjenja 78', 'Novi Sad', 'Srbija', '065/789101', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mirko', 'Plavsic', 'mirko@gmail.com', 'mirko', 'Pa Pavla 14', 'Novi Sad', 'Srbija', '069/8765432', 3, true);
    -- Pharmacist
    insert into pharmacist(pharmacy_id, user_id) values(5, 7);
    insert into pharmacist(pharmacy_id, user_id) values(6, 8);
    insert into pharmacist(pharmacy_id, user_id) values(4, 9);
    insert into pharmacist(pharmacy_id, user_id) values(5, 10);
-- User: Admin
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nikola', 'Luburic', 'nikola@uns.ac.rs', 'nikola', 'Marka Kraljevica 2', 'Novi Sad', 'Srbija', '062/468965', 1, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Rade', 'Doroslovacki', 'rade@uns.ac.rs', 'rade', 'Marka Kraljevica 15', 'Novi Sad', 'Srbija', '062/779635', 1, true);
-- User: Dermatologist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milica', 'Pavlovic', 'milica@gmail.com', 'milica', 'Somborska 37', 'Novi Sad', 'Srbija', '063/887345', 2, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Darko', 'Milicic', 'dare@gmail.com', 'dare', 'Zmaj Jovina 56', 'Novi Sad', 'Srbija', '061/1116555', 2, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Acim', 'Maravic', 'acim@gmail.com', 'acim', 'Bulevar Cara Lazara 15', 'Novi Sad', 'Srbija', '063/555333', 2, true);
    -- Dermatologist
    insert into dermatologist(user_id) values(13);
    insert into dermatologist(user_id) values(14);
    insert into dermatologist(user_id) values(15);
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
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '14:00:00', '14:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '14:30:00', '15:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '15:00:00', '15:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '15:30:00', '16:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '16:00:00', '16:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '16:30:00', '17:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '17:00:00', '17:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '17:30:00', '18:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '18:00:00', '18:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '18:30:00', '19:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '19:00:00', '19:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-22', '19:30:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-22', '19:30:00', '20:00:00');

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

--Loyalty group
insert into loyalty_group(points, type) values (3, 0);
insert into loyalty_group(points, type) values (4, 1);
insert into loyalty_group(points, type) values (10, 2);
insert into loyalty_group(points, type) values (20, 3);
insert into loyalty_group(points, type) values (50, 4);

-- Prescriptions

-- Examinations
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(10, 11, 1, 1, 1, 1, false);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(15, 11, 1, 1, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(20, 12, 1, 1, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(20, 13, 1, 1, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id) values(15, 20, 1, 1, 1, 2);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(20, 15, 2, 1, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id) values(40, 16, 2, 1, 1,2);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id) values(30, 17, 2, 1, 1,3);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(25, 18, 3, 2, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(25, 19, 3, 2, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id) values(25, 20, 3, 2, 1, 6);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(25, 21, 1, 2, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(25, 22, 1, 2, 1);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id) values(25, 23, 3, 2, 1);

--Medicine
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62542, 'cochenillrot, laktoza, monohidrat', 0, 5,'Galenika', 'Brufen', 'Beleska 1', 0, 'Lek za temperaturu');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (66042, 'kalijum-sorbat, prečišćeni talk', 1, 10, 'Optisorb', 'Panadol', 'Beleska 2', 1, 'Lek za bolove');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62217, 'skrob, trietil-citrat', 2, 15, 'Bayer', 'Aspirin', 'Beleska 3', 0, 'Lek za bolove i prehladu');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62921, 'natrijum-laurilsulfat, akacija, laktoza', 2, 12, 'Hemofarm A.D.', 'Bromazepam', 'Beleska 3', 0, 'Lek za smirenje');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62922, 'diazepam, monohidrat, laktoza', 2, 16, 'Galenika A.D.', 'Bensedin', 'Beleska 3', 0, 'Lek za smirenje');

-- Patient Allergies
insert into patient_allergic_medicines(patient_id, allergic_medicines) values (2, 'Brufen');
insert into patient_allergic_medicines(patient_id, allergic_medicines) values (2, 'Panadol');
insert into patient_allergic_medicines(patient_id, allergic_medicines) values (1, 'Aspirin');

-- MedicinePharmacy: Jankovic
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.50, 2350, 1, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(2.00, 2985, 2, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.75, 1420, 3, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.00, 0, 4, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.25, 2150, 5, 1);
-- MedicinePharmacy: Benu
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.44, 15, 1, 2);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.90, 18, 2, 2);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.00, 110, 4, 2);

-- ??????????????
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 1);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 2);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 3);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 4);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 5);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 6);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 7);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 8);
----------------------

-- Orders
insert into app_order(end_date, end_time) values ('2021-02-07', '08:00:00');
insert into app_order(end_date, end_time) values ('2021-03-07', '04:00:00');

-- MedicineReplacement
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(1, 62217);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(2, 66042);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(3, 66042);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(4, 66042);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(4, 62922);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(5, 66042);

-- MedicinePrescription
insert into medicineeprescription(code, name, quantity) values(2, 'brufen', 123419);
insert into medicineeprescription(code, name, quantity) values(8, 'panadol', 6839093);

-- EPrescription
insert into eprescription(code, date_of_issue, file_text, patient_name) values(24363, null, 'Brufen, Panadol', 'Marko Markovic');
insert into eprescription(code, date_of_issue, file_text, patient_name) values(246663, null, 'Brufen', 'Petar Petrovic');
    -- EPrescription: Medications
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(1, 1);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(1, 2);


-- Diagnosis
insert into diagnosis(name)values('Cholera');
insert into diagnosis(name)values('Sickness');
insert into diagnosis(name)values('Infection');
insert into diagnosis(name)values('Poisoning');
insert into diagnosis(name)values('Anxiety');
insert into diagnosis(name)values('Back pain');
insert into diagnosis(name)values('Hypertension');

-- Complaints
insert into complaint(complaint_message, response_complaint, patient_id)values ('Losa usluga', '...', 1);
insert into complaint(complaint_message, patient_id)values ('Guzva', 2);
