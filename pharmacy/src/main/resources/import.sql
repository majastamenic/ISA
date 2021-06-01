-- Pharmacies
insert into pharmacy (address, name, counseling_price, latitude, longitude) values('Visnjiceva 15, Beograd', 'Jankovic', 10,44.822200,20.460370);
insert into pharmacy (address, name, counseling_price, latitude, longitude) values('Hajduk Veljkova 8, Novi Sad', 'Benu', 5,45.250090,19.824650);
insert into pharmacy (address, name, counseling_price, latitude, longitude) values('Bulevar Cara Lazara 76, Novi Sad', 'Zelena Apoteka', 0,45.241619,19.831230);
insert into pharmacy (address, name, counseling_price, latitude, longitude) values('Bulevar Cara Lazara 88, Novi Sad', 'Galen pharm', 7,45.241619,19.831230);
insert into pharmacy (address, name, counseling_price, latitude, longitude) values('Rumenacka 13, Novi Sad', 'Irisfarm', 8,45.260510,19.820788);
insert into pharmacy (address, name, counseling_price, latitude, longitude) values('Futoski Put 85A, Novi Sad', 'Tilia', 3,45.246370,19.801300);

--Subscribes
    --Jankovic
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (1, 'maja@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (1, 'tasa@mailinator.com');
    --Benu
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (2, 'maja@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (2, 'tasa@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (2, 'joxy@mailinator.com');
    --ZelenaApoteka
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (3, 'aca@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (3, 'tasa@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (3, 'joxy@mailinator.com');
    --Galen pharm
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (4, 'gojko@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (4, 'toma@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (4, 'joxy@mailinator.com');
    --Irisfarm
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (5, 'gojko@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (5, 'tasa@mailinator.com');
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (5, 'joxy@mailinator.com');
    --Tilia
        insert into pharmacy_subscribed_emails(pharmacy_id, subscribed_emails)VALUES (6, 'joxy@mailinator.com');

-- Hospital
insert into hospital(email, name) values('integration.adapter@gmail.com', 'WellDevClinic');

-- ********************************  USERS ****************************************************************
-- User: Patient
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Maja', 'Stamenic', 'maja@mailinator.com', 'maja', 'Suboticka 23', 'Novi Sad', 'Srbija', '066/468965', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Gojko', 'Novcic', 'gojko@mailinator.com', 'gojko', 'Rumenacka 23', 'Novi Sad', 'Srbija', '061/558877', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nastasja', 'Damjanac', 'tasa@mailinator.com', 'tasa', 'Temerinska 23', 'Novi Sad', 'Srbija', '066/123466', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Jovana', 'Jakovljevic', 'joxy@mailinator.com', 'joxy', 'Lasla Gala 15', 'Novi Sad', 'Srbija', '063/1125455', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Aca', 'Lukas', 'aca@mailinator.com', 'aca', 'Vojislava Vuckovica 1', 'Beograd', 'Srbija', '069/5889522', 0, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Toma', 'Zdravkovic', 'toma@mailinator.com', 'toma', 'Jastrebacka 11', 'Aleksinac', 'Srbija', '065/338799', 0, true);
    -- Patient
    insert into patient(loyalty_points, verification_code, user_id, penal) values(10, 'AVG-EE-FTG', 1, 0);
    insert into patient(loyalty_points, verification_code, user_id, penal) values(15, 'A45-RE-BNA', 2, 0);
    insert into patient(loyalty_points, verification_code, user_id, penal) values(20, '498-WT-B5S', 3, 2);
    insert into patient(loyalty_points, verification_code, user_id, penal) values(25, 'VB4-QR-5BG', 4, 1);
    insert into patient(loyalty_points, verification_code, user_id, penal) values(5,  'QPO-4S-VBG', 5, 0);
    insert into patient(loyalty_points, verification_code, user_id, penal) values(10, 'AS-TRV-T1W', 6, 1);
-- User: Pharmacist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Marija', 'Milanovic', 'masa@mailinator.com', 'masa', 'Ticanova 23', 'Novi Sad', 'Srbija', '069/7798654', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milan', 'Knezevic', 'milan@mailinator.com', 'milan', 'Gagarinova 83', 'Novi Sad', 'Srbija', '065/963565', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nikola', 'Antonic', 'antonic@mailinator.com', 'antonic', 'Bulevar Oslobodjenja 78', 'Novi Sad', 'Srbija', '065/789101', 3, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mirko', 'Plavsic', 'mirko@mailinator.com', 'mirko', 'Pa Pavla 14', 'Novi Sad', 'Srbija', '069/8765432', 3, true);
    -- Pharmacist
    insert into pharmacist(pharmacy_id, user_id) values(1, 7);
    insert into pharmacist(pharmacy_id, user_id) values(2, 8);
    insert into pharmacist(pharmacy_id, user_id) values(3, 9);
    insert into pharmacist(pharmacy_id, user_id) values(4, 10);
-- User: Admin
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nikola', 'Luburic', 'nikola@yahoo.com', 'nikola', 'Marka Kraljevica 2', 'Novi Sad', 'Srbija', '062/468965', 1, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Rade', 'Doroslovacki', 'rade@yahoo.com', 'rade', 'Marka Kraljevica 15', 'Novi Sad', 'Srbija', '062/779635', 1, true);
    --Admin
    insert into admin(user_id) values (11);
    insert into admin(user_id) values (12);
-- User: Dermatologist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milica', 'Pavlovic', 'milica@mailinator.com', 'milica', 'Somborska 37', 'Novi Sad', 'Srbija', '063/887345', 2, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Darko', 'Milicic', 'dare@mailinator.com', 'dare', 'Zmaj Jovina 56', 'Novi Sad', 'Srbija', '061/1116555', 2, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Acim', 'Maravic', 'acim@mailinator.com', 'acim', 'Bulevar Cara Lazara 15', 'Novi Sad', 'Srbija', '063/555333', 2, true);
    -- Dermatologist
    insert into dermatologist(user_id) values(13);
    insert into dermatologist(user_id) values(14);
    insert into dermatologist(user_id) values(15);
-- User: Supplier
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Luka', 'Djurdjevic', 'luka@mailinator.com', 'luka', 'Futoska 101', 'Novi Sad', 'Srbija', '067/823789', 4, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Simona', 'Prokic', 'simona@mailinator.com', 'simona', 'Fruskogorska 12', 'Novi Sad', 'Srbija', '067/114885', 4, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mitar', 'Miric', 'mitar@gmail.com', 'mitar', 'Futoski put 105', 'Novi Sad', 'Srbija', '067/335658', 4, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Ana', 'Nikolic', 'ana@gmail.com', 'ana', 'Bulevar Cara Dusana 18', 'Novi Sad', 'Srbija', '064/127865', 4, true);
    --Supplier
    insert into supplier(user_id) values (16);
    insert into supplier(user_id) values (17);
    insert into supplier(user_id) values (18);
    insert into supplier(user_id) values (19);
-- User: PharmacyAdmin
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mikica', 'Djurdjevic', 'mikica@mailinator.com', 'mikica', 'Futoska 101', 'Novi Sad', 'Srbija', '067/823789', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Marko', 'Markovic', 'mare@mailinator.com', 'mare', 'Fruskogorska 15', 'Novi Sad', 'Srbija', '067/114885', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milos', 'Djuric', 'milos@gmail.com', 'milos', 'Dunavska 89', 'Novi Sad', 'Srbija', '067/114885', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Marija', 'Vucevic', 'marija@gmail.com', 'marija', 'Narodnog Fronta 78', 'Novi Sad', 'Srbija', '063/659898', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mirjana', 'Radojcic', 'mima@gmail.com', 'mima', 'Zeleznicka 18', 'Novi Sad', 'Srbija', '061/1112565', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Ivana', 'Ivanovic', 'ivana@gmail.com', 'ivana', 'Vojvodjanskih Brigada 2', 'Novi Sad', 'Srbija', '069/3355668', 5, true);
    -- PharmacyAdmin
    insert into pharmacy_admin(user_id, pharmacy_id) values (20,1);
    insert into pharmacy_admin(user_id, pharmacy_id) values (21,1);
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
insert into schedule(start_date, end_date, start_time, end_time) values('2021-06-15', '2021-06-15', '14:00:00', '14:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-05-15', '2021-05-15', '14:30:00', '15:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-04-15', '2021-04-15', '15:00:00', '15:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-15', '2021-03-15', '15:30:00', '16:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-06-15', '2021-06-15', '16:00:00', '16:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-05-15', '2021-05-15', '16:30:00', '17:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-04-15', '2021-04-15', '17:00:00', '17:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-15', '2021-03-15', '17:30:00', '18:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '18:00:00', '18:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '18:30:00', '19:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '19:00:00', '19:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-15', '2021-02-15', '19:30:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-15', '19:30:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-08', '2021-02-08', '19:30:00', '20:00:00');

insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-02', '2021-03-02', '19:00:00', '19:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-03', '2021-03-03', '19:30:00', '20:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-04', '2021-03-04', '18:30:00', '19:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-03-05', '2021-03-05', '18:00:00', '18:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-06-05', '2021-06-05', '18:00:00', '18:30:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-06-08', '2021-06-08', '19:30:00', '20:00:00');
-- WorkSchedule //////////////////////////////////////////////////////////
    // Jankovic
insert into work_schedule(schedule_id, admin_id) values(1, 1);
insert into work_schedule(schedule_id, admin_id) values(2, 1);
insert into work_schedule(schedule_id, admin_id) values(3, 1);
insert into work_schedule(schedule_id, admin_id) values(4, 1);
insert into work_schedule(schedule_id, admin_id) values(5, 1);
insert into work_schedule(schedule_id, admin_id) values(6, 1);
insert into work_schedule(schedule_id, admin_id) values(7, 1);
insert into work_schedule(schedule_id, admin_id) values(8, 1);
insert into work_schedule(schedule_id, admin_id) values(9, 1);
insert into work_schedule(schedule_id, admin_id) values(10, 1);

    // Benu
insert into work_schedule(schedule_id, admin_id) values(1, 2);
insert into work_schedule(schedule_id, admin_id) values(2, 2);
insert into work_schedule(schedule_id, admin_id) values(3, 2);
insert into work_schedule(schedule_id, admin_id) values(4, 2);
insert into work_schedule(schedule_id, admin_id) values(5, 2);
insert into work_schedule(schedule_id, admin_id) values(6, 2);
insert into work_schedule(schedule_id, admin_id) values(7, 2);
insert into work_schedule(schedule_id, admin_id) values(8, 2);
insert into work_schedule(schedule_id, admin_id) values(9, 2);
insert into work_schedule(schedule_id, admin_id) values(10, 2);

    // Zelena Apoteka
insert into work_schedule(schedule_id, admin_id) values(1, 3);
insert into work_schedule(schedule_id, admin_id) values(2, 3);
insert into work_schedule(schedule_id, admin_id) values(3, 3);
insert into work_schedule(schedule_id, admin_id) values(4, 3);
insert into work_schedule(schedule_id, admin_id) values(5, 3);
insert into work_schedule(schedule_id, admin_id) values(6, 3);
insert into work_schedule(schedule_id, admin_id) values(7, 3);
insert into work_schedule(schedule_id, admin_id) values(8, 3);
insert into work_schedule(schedule_id, admin_id) values(9, 3);
insert into work_schedule(schedule_id, admin_id) values(10, 3);

-- WorkSchedule: Dermatologist
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (1, 1);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (1, 3);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (1, 5);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (1, 7);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (1, 9);

insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (2, 2);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (2, 4);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (2, 6);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (2, 8);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (2, 10);

insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (3, 1);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (3, 4);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (3, 5);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (3, 8);
insert into dermatologist_work_schedule(dermatologist_id, work_schedule_id) values (3, 9);

--WorkSchedule: Pharmacist
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (1, 2);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (1, 3);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (1, 6);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (1, 7);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (1, 10);

insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (2, 1);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (2, 5);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (2, 9);

insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (3, 1);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (3, 3);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (3, 6);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (3, 8);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (3, 9);

insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (4, 1);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (4, 4);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (4, 5);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (4, 8);
insert into pharmacist_work_schedule(pharmacist_id, work_schedule_id) values (4, 9);

-- ////////////////////////////////////////////////////////////////////////////

--Loyalty program
insert into loyalty_group(points, type) values (3, 0);
insert into loyalty_group(points, type) values (4, 1);
insert into loyalty_group(points, type) values (10, 2);
insert into loyalty_group(points, type) values (20, 3);
insert into loyalty_group(points, type) values (50, 4);

-- Examinations
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(10, 15, 1, 1, 1, 1, false);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(15, 11, 1, 1, 1,2, false);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(20, 12, 1, 1, 1,1, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(20, 13, 1, 1, 1,3, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(15, 24, 1, 1, 1, 2, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(20, 15, 2, 1, 1,3, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(40, 16, 2, 1, 1,2, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(30, 17, 2, 1, 1,3, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(25, 18, 3, 2, 1,4, false);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(25, 19, 3, 2, 1,2, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(25, 20, 3, 2, 1, 3, false);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(25, 21, 1, 2, 1,2, true);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(25, 22, 1, 2, 1,3, false);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(25, 23, 3, 2, 1,1, false);
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(25, 30, 1, 1, 1,5, true);

insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(10, 24, 2, 1, 1, 1, true );
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(10, 25, 2, 1, 1, 2, true );
insert into examination(price, schedule_id, dermatologist_id, pharmacy_id, loyalty_group_id, patient_id, patient_came) values(10, 26, 2, 1, 1, 3, true );

-- Counselings
insert into counseling(schedule_id, pharmacist_id, patient_id, loyalty_group_id) values (11, 1, 1, 1);
insert into counseling(schedule_id, pharmacist_id, patient_id, loyalty_group_id) values (15, 2, 1, 1);
insert into counseling(schedule_id, pharmacist_id, patient_id, loyalty_group_id) values (22, 3, 1, 1);

insert into counseling(schedule_id, pharmacist_id, patient_id, loyalty_group_id) values (13, 1, 2, 1);
insert into counseling(schedule_id, pharmacist_id, patient_id, loyalty_group_id) values (16, 3, 2, 1);
insert into counseling(schedule_id, pharmacist_id, patient_id, loyalty_group_id) values (29, 1, 2, 1);


-- Medicines
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62542, 'cochenillrot, laktoza, monohidrat', 0, 5,'Galenika', 'Brufen', 'Beleska 1', 0, 'Lek za temperaturu');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (66042, 'kalijum-sorbat, prečišćeni talk', 1, 10, 'Optisorb', 'Panadol', 'Beleska 2', 1, 'Lek za bolove');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62217, 'skrob, trietil-citrat', 2, 15, 'Bayer', 'Aspirin', 'Beleska 3', 0, 'Lek za bolove i prehladu');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62921, 'natrijum-laurilsulfat, akacija, laktoza', 2, 12, 'Hemofarm A.D.', 'Bromazepam', 'Beleska 3', 0, 'Lek za smirenje');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62922, 'diazepam, monohidrat, laktoza', 2, 16, 'Galenika A.D.', 'Bensedin', 'Beleska 3', 0, 'Lek za smirenje');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62543, 'penicilin, laktoza', 0, 1,'Tovarna Zdravil', 'Elicea', 'Beleska 6', 0, 'Lek za smirenje');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (66044, 'kalijum-sorbat', 1, 2, 'Hemofarm A.D.', 'Trodon', 'Beleska 7', 0, 'Analgetik');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62215, 'trietil-citrat', 2, 2, 'Hemofarm A.D.', 'Sabax', 'Beleska 8', 0, 'Lek za zeludac');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62926, 'natrijum-laurilsulfat, laktoza', 2, 3, 'Pharmamed', 'Herbifit reuma', 'Beleska 9', 1, 'Lek za reumu');
insert into medicine(code, composition, form_of_medicine, loyalty_points, manufactured, name, note, publishing_type, type_of_medicine) values (62927, 'diazepam', 7, 6, 'SALVEO Pharma', 'Prospan', 'Beleska 10', 1, 'Lek za kasalj');

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
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.90, 5592, 6, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(2.89, 1064, 7, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.75, 825, 8, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.50, 182, 9, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(0.25, 50, 10, 1);

insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (1, 1);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (2, 2);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (3, 3);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (4, 4);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (5, 5);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (6, 6);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (7, 7);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (8, 8);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (9, 9);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (10, 10);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 1);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 2);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 3);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 4);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 5);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 6);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 7);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 8);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 9);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 10);


-- MedicinePharmacy: Benu
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.44, 16932, 1, 2);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.90, 1818, 2, 2);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.00, 1190, 4, 2);

insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (1, 11);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (2, 12);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (4, 13);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 11);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 12);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 13);


--MedicinePharmacy: Zelena Apoteka
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.14, 1917, 3, 3);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(2.90, 1718, 6, 3);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.60, 1109, 5, 3);

insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (3, 14);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (6, 15);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (5, 16);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(3, 14);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(3, 15);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(3, 16);

--MedicinePharmacy: Galen Pharmacy
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.94, 1729, 7, 4);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(5.90, 7291, 8, 4);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(4.60, 91712, 9, 4);

insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (7, 17);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (8, 18);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (9, 19);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(4, 17);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(4, 18);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(4, 19);

--MedicinePharmacy: Irisfarm
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(6.12, 2315, 10, 5);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(7.34, 9818, 8, 5);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.19, 1110, 9, 5);

insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (10, 20);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (8, 21);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (9, 22);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(5, 20);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(5, 21);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(5, 22);

--MedicinePharmacy: Tilia
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.91, 1915, 2, 6);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(6.83, 1801, 6, 6);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(3.11, 1510, 1, 6);

insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (2, 23);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (6, 24);
insert into medicine_medicine_pharmacy(medicine_id, medicine_pharmacy_id)values (1, 25);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(6, 23);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(6, 24);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(6, 25);


----------------------

-- MedicineReplacement
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(1, 62217);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(2, 66042);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(3, 66042);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(4, 66042);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(4, 62922);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(5, 66044);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(6, 66044);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(7, 66043);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(8, 66042);

-- Diagnosis
insert into diagnosis(name)values('Cholera');
insert into diagnosis(name)values('Sickness');
insert into diagnosis(name)values('Infection');
insert into diagnosis(name)values('Poisoning');
insert into diagnosis(name)values('Anxiety');
insert into diagnosis(name)values('Back pain');
insert into diagnosis(name)values('Hypertension');

-- Complaints
insert into complaint(complaint_message, response_complaint, patient_id)values ('Bad service', 'Please tell us more to improve our service.', 1);
insert into complaint(complaint_message, patient_id)values ('Too crowded', 2);

-- Orders
insert into app_order( end_date, pharmacy_admin_id, quantity, price, medicine_id, order_state) values ('2021-02-07', 1,200,100,3,0);
insert into app_order(end_date, pharmacy_admin_id, quantity, price, medicine_id, order_state) values ('2021-03-07', 1,100,100,3,0);
insert into app_order( end_date, pharmacy_admin_id, quantity, price, medicine_id, order_state) values ('2021-05-07',  2,50,50,2,0);
insert into app_order(end_date,  pharmacy_admin_id, quantity, price, medicine_id, order_state) values ('2021-03-04', 2, 20,20,1,1);
insert into app_order(end_date,  pharmacy_admin_id, quantity, price, medicine_id, order_state) values ('2021-04-04', 4, 20,20,1,0);
insert into app_order(end_date,  pharmacy_admin_id, quantity, price, medicine_id, order_state) values ('2021-05-04', 4, 20,20,1,0);


-- OrdersOffers
insert into order_offer(price, quantity, medicine_id)VALUES (10.0, 200, 1);
insert into order_offer(price, quantity, medicine_id)VALUES (21.0, 100, 2);
insert into order_offer(price, quantity, medicine_id)VALUES (29.0, 29, 3);
insert into order_offer(price, quantity, medicine_id)VALUES (12.9, 11, 10);
insert into order_offer(price, quantity, medicine_id)VALUES (17.0, 10, 9);
insert into order_offer(price, quantity, medicine_id)VALUES (12.0, 5, 8);

--SupplierOffers
insert into supplier_offer(delivery_date, total_price, type, order_id, supplier_id)values ('2021-01-01', 200, 2, 1, 1);
insert into supplier_offer(delivery_date, total_price, type, order_id, supplier_id)values ('2021-01-01', 200, 2, 1, 2);
insert into supplier_offer(delivery_date, total_price, type, order_id, supplier_id)values ('2021-02-02', 500, 1, 2, 1);
insert into supplier_offer(delivery_date, total_price, type, order_id, supplier_id)values ('2021-03-04', 430, 0, 3, 1);
insert into supplier_offer(delivery_date, total_price, type, order_id, supplier_id)values ('2021-04-04', 500, 1, 4, 1);
insert into supplier_offer(delivery_date, total_price, type, order_id, supplier_id)values ('2021-04-04', 500, 1, 5, 1);

-- VacationSchedule
    -- Dermatologist
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-03', '2021-03-10',false);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-01', '2021-03-22', false);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-04-10', '2021-04-12', false);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-04-03', '2021-04-10', true);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-04', '2021-03-17', true);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-09', '2021-03-10', true);
    -- Pharmacist
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-10', '2021-03-15', true);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-01', '2021-03-05', true);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-04-10', '2021-04-12', true);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-01', '2021-03-10', false);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-03-29', '2021-03-31', false);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-05-09', '2021-05-20', false);
insert into vacation_schedule(start_date, end_date, approved) values ('2021-06-09', '2021-06-20', false);
    -- Dermatologist_VacationSchedule
insert into dermatologist_vacation_schedules(dermatologist_id, vacation_schedules_id) values (1, 1);
insert into dermatologist_vacation_schedules(dermatologist_id, vacation_schedules_id) values (2, 2);
insert into dermatologist_vacation_schedules(dermatologist_id, vacation_schedules_id) values (3, 3);
insert into dermatologist_vacation_schedules(dermatologist_id, vacation_schedules_id) values (1, 4);
insert into dermatologist_vacation_schedules(dermatologist_id, vacation_schedules_id) values (2, 5);
insert into dermatologist_vacation_schedules(dermatologist_id, vacation_schedules_id) values (2, 6);
    -- Pharmacist_VacationSchedule
insert into pharmacist_vacation_schedules(pharmacist_id, vacation_schedules_id) values (1, 7);
insert into pharmacist_vacation_schedules(pharmacist_id, vacation_schedules_id) values (2, 8);
insert into pharmacist_vacation_schedules(pharmacist_id, vacation_schedules_id) values (3, 9);
insert into pharmacist_vacation_schedules(pharmacist_id, vacation_schedules_id) values (1, 10);
insert into pharmacist_vacation_schedules(pharmacist_id, vacation_schedules_id) values (4, 11);
insert into pharmacist_vacation_schedules(pharmacist_id, vacation_schedules_id) values (2, 12);
insert into pharmacist_vacation_schedules(pharmacist_id, vacation_schedules_id) values (1, 13);
-- EPrescription
insert into eprescription(code, date_of_issue, file_text, patient_id) values(1, '2021-01-01', 'Maja Stamenic Panadol,', 1);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(2, '2021-02-01', 'Aca Lukas Panadol,', 5);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(3, '2021-02-02', 'Toma Zdravkovic Bensedin,', 6);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(4, '2021-02-03', 'Gojko Novcic Aspirin,', 2);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(5, '2021-01-02', 'Nastasja Damjanac Brufen,', 3);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(6, '2021-02-03', 'Gojko Novcic Panadol,', 2);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(7, '2021-01-02', 'Toma Zdravkovic Aspirin,', 6);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(8, '2021-02-03', 'Aca Lukas Brufen, Bensedin,', 5);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(9, '2021-01-02', 'Maja Stamenic Brufen,', 1);
insert into eprescription(code, date_of_issue, file_text, patient_id) values(10, '2021-01-03', 'Maja Stamenic Aspirin,', 1);
    -- MedicineEPrescription
    insert into medicineeprescription(code, name, quantity) values(1, 'Panadol', 1);
    insert into medicineeprescription(code, name, quantity) values(2, 'Panadol', 2);
    insert into medicineeprescription(code, name, quantity) values(3, 'Bensedin', 3);
    insert into medicineeprescription(code, name, quantity) values(4, 'Aspirin', 4);
    insert into medicineeprescription(code, name, quantity) values(5, 'Brufen', 3);
    insert into medicineeprescription(code, name, quantity) values(6, 'Panadol', 4);
    insert into medicineeprescription(code, name, quantity) values(7, 'Aspirin', 2);
    insert into medicineeprescription(code, name, quantity) values(8, 'Brufen', 2);
    insert into medicineeprescription(code, name, quantity) values(9, 'Bensedin', 2);
    insert into medicineeprescription(code, name, quantity) values(10, 'Brufen', 1);
    insert into medicineeprescription(code, name, quantity) values(11, 'Aspirin', 5);

    -- EPrescription: Medications
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(1, 1);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(2, 2);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(3, 3);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(4, 4);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(5, 5);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(6, 6);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(7, 7);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(8, 8);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(8, 9);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(9, 10);
    insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(10, 11);

-- Rating
    --Pharmacist
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (1, 1, 1);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (1, 2, 5);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (1, 3, 5);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (1, 4, 3);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (1, 5, 4);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (1, 6, 5);

    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (2, 1, 2);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (2, 2, 2);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (2, 3, 5);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (2, 4, 1);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (2, 5, 2);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (2, 6, 3);

    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (3, 1, 5);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (3, 2, 5);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (3, 3, 3);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (3, 4, 2);

    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (4, 1, 1);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (4, 3, 1);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (4, 4, 2);
    insert into pharmacist_rating(pharmacist_id, patient_id, rate) values (4, 6, 3);

    --Dermatologist
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (1, 1, 1);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (1, 2, 5);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (1, 3, 5);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (1, 4, 3);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (1, 5, 4);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (1, 6, 5);

insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (2, 1, 2);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (2, 2, 2);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (2, 3, 5);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (2, 4, 1);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (2, 5, 2);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (2, 6, 3);

insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (3, 1, 5);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (3, 2, 5);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (3, 3, 3);
insert into dermatologist_rating(dermatologist_id, patient_id, rate) values (3, 4, 2);

insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (1, 1, 1);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (1, 2, 5);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (1, 3, 5);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (1, 4, 3);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (1, 5, 4);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (1, 6, 5);

insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (2, 1, 2);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (2, 2, 2);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (2, 3, 5);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (2, 4, 1);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (2, 5, 2);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (2, 6, 3);

insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (3, 1, 5);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (3, 2, 5);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (3, 3, 3);
insert into pharmacy_rating(pharmacy_id, patient_id, rate) values (3, 4, 2);



    insert into dermatologist_pharmacy(dermatologist_id,pharmacy_id) values(1,1);
    insert into dermatologist_pharmacy(dermatologist_id,pharmacy_id) values(2,1);
    insert into dermatologist_pharmacy(dermatologist_id,pharmacy_id) values(2,2);

    insert into work_schedule_dermatologists(work_schedule_id, dermatologists_id) values(1,1);
    insert into work_schedule_dermatologists(work_schedule_id, dermatologists_id) values(3,1);

    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(10, '2021-06-06', false, 1, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-01-06', true, 2, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(30, '2021-03-06', true, 3, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(40, '2021-05-06', true, 4, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(10, '2021-03-06', true, 5, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-01-06', true, 6, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-03-06', true, 7, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-01-06', true, 8, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-03-06', true, 11, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-05-06', true, 12, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-03-06', true, 15, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-01-06', true, 16, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-03-06', true, 18, 1);
    insert into medicine_reservation(amount, due_date, is_taken,medicine_pharmacy_id,patient_id) values(20, '2021-05-06', true, 19, 1);


    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 1);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 2);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 3);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 4);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 5);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 6);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 7);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 8);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 9);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 10);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 11);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 12);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 13);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 14);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 15);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 16);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 17);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 18);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 19);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 20);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 21);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 22);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 23);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 24);
    insert into price_list(date_from,date_to,price, medicine_pharmacy_id) values('2021-01-01','2021-12-31', 20, 25);
