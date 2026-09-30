USE bus_ticket_machine;

-- -------------------------------------------------------------
-- 1. Bus 128K (Mofussil Ordinary - 11 Stages)
-- -------------------------------------------------------------
INSERT INTO bus (region_name, sub_region, depot_name, service_number, bus_category, bus_type, vehicle_reg_no, luggage_fare, ticket_class)
VALUES ('TNSTC Coimbatore Ltd.', 'Coimbatore Region', 'HO Branch Depot', '128K', 'MOFUSSIL', 'Mofussil Ordinary', 'TN37N2055', 10.00, 'GENERAL');

SET @bus_128k = LAST_INSERT_ID();

INSERT INTO stage (bus_id, stage_no, stage_name, distance_from_origin) VALUES
(@bus_128k, 1, 'Coimbatore', 0.00),
(@bus_128k, 2, 'Sitra', 10.60),
(@bus_128k, 3, 'Chinniyampalayam', 14.00),
(@bus_128k, 4, 'Neelambur', 17.00),
(@bus_128k, 5, 'Sulur Pirivu', 19.00),
(@bus_128k, 6, 'Kaniyur', 24.90),
(@bus_128k, 7, 'Karumathampatti', 28.40),
(@bus_128k, 8, 'Thekkalur', 34.70),
(@bus_128k, 9, 'Avinashi', 43.80),
(@bus_128k, 10, 'Thirumuruganpoondi', 47.20),
(@bus_128k, 11, 'Tirupur', 56.30);

INSERT INTO fare_matrix (bus_id, from_stage_no, to_stage_no, fare) VALUES
(@bus_128k, 1, 2, 8.00), (@bus_128k, 1, 3, 10.00), (@bus_128k, 1, 4, 12.00), (@bus_128k, 1, 5, 14.00), (@bus_128k, 1, 6, 16.00), (@bus_128k, 1, 7, 18.00), (@bus_128k, 1, 8, 23.00), (@bus_128k, 1, 9, 28.00), (@bus_128k, 1, 10, 31.00), (@bus_128k, 1, 11, 36.00),
(@bus_128k, 2, 3, 6.00), (@bus_128k, 2, 4, 8.00), (@bus_128k, 2, 5, 10.00), (@bus_128k, 2, 6, 11.00), (@bus_128k, 2, 7, 12.00), (@bus_128k, 2, 8, 15.00), (@bus_128k, 2, 9, 22.00), (@bus_128k, 2, 10, 27.00), (@bus_128k, 2, 11, 32.00),
(@bus_128k, 3, 4, 6.00), (@bus_128k, 3, 5, 8.00), (@bus_128k, 3, 6, 9.00), (@bus_128k, 3, 7, 10.00), (@bus_128k, 3, 8, 13.00), (@bus_128k, 3, 9, 20.00), (@bus_128k, 3, 10, 25.00), (@bus_128k, 3, 11, 30.00),
(@bus_128k, 4, 5, 6.00), (@bus_128k, 4, 6, 7.00), (@bus_128k, 4, 7, 8.00), (@bus_128k, 4, 8, 11.00), (@bus_128k, 4, 9, 18.00), (@bus_128k, 4, 10, 23.00), (@bus_128k, 4, 11, 28.00),
(@bus_128k, 5, 6, 6.00), (@bus_128k, 5, 7, 7.00), (@bus_128k, 5, 8, 10.00), (@bus_128k, 5, 9, 17.00), (@bus_128k, 5, 10, 22.00), (@bus_128k, 5, 11, 25.00),
(@bus_128k, 6, 7, 6.00), (@bus_128k, 6, 8, 9.00), (@bus_128k, 6, 9, 16.00), (@bus_128k, 6, 10, 21.00), (@bus_128k, 6, 11, 23.00),
(@bus_128k, 7, 8, 6.00), (@bus_128k, 7, 9, 11.00), (@bus_128k, 7, 10, 15.00), (@bus_128k, 7, 11, 19.00),
(@bus_128k, 8, 9, 6.00), (@bus_128k, 8, 10, 9.00), (@bus_128k, 8, 11, 15.00),
(@bus_128k, 9, 10, 6.00), (@bus_128k, 9, 11, 8.00),
(@bus_128k, 10, 11, 6.00);

-- -------------------------------------------------------------
-- 2. Bus 128E (Coimbatore-Erode Route - 19 Stages)
-- -------------------------------------------------------------
INSERT INTO bus (region_name, sub_region, depot_name, service_number, bus_category, bus_type, vehicle_reg_no, luggage_fare, ticket_class)
VALUES ('TNSTC Coimbatore Ltd.', 'Coimbatore Region', 'HO Branch Depot', '128E', 'MOFUSSIL', 'Mofussil Ordinary', 'TN37N2056', 10.00, 'GENERAL');

SET @ero1 = LAST_INSERT_ID();

INSERT INTO stage (bus_id, stage_no, stage_name, distance_from_origin) VALUES
(@ero1, 1, 'Coimbatore', 0.00),
(@ero1, 2, 'Sitra', 10.60),
(@ero1, 3, 'Chinniyampalayam', 14.00),
(@ero1, 4, 'Neelambur', 17.00),
(@ero1, 5, 'Sulur Pirivu', 19.00),
(@ero1, 6, 'Kaniyur', 24.90),
(@ero1, 7, 'Karumathampatti', 28.40),
(@ero1, 8, 'Thekkalur', 34.70),
(@ero1, 9, 'Avinashi', 43.80),
(@ero1, 10, 'Perumanallur', 54.00),
(@ero1, 11, 'Chengapalli', 61.70),
(@ero1, 12, 'Pallagoundenpalayam', 67.50),
(@ero1, 13, 'Vijayamangalam', 72.20),
(@ero1, 14, 'Saralai', 80.10),
(@ero1, 15, 'Sipcot', 80.70),
(@ero1, 16, 'Perundurai', 81.50),
(@ero1, 17, 'Veppampalayam', 91.40),
(@ero1, 18, 'Thindal', 94.30),
(@ero1, 19, 'Erode', 100.00);

INSERT INTO fare_matrix (bus_id, from_stage_no, to_stage_no, fare) VALUES
(@ero1, 1, 2, 10.00), (@ero1, 1, 3, 12.00), (@ero1, 1, 4, 14.00), (@ero1, 1, 5, 16.00), (@ero1, 1, 6, 18.00), (@ero1, 1, 7, 23.00), (@ero1, 1, 8, 28.00), (@ero1, 1, 9, 35.00), (@ero1, 1, 10, 45.00), (@ero1, 1, 11, 53.00), (@ero1, 1, 12, 57.00), (@ero1, 1, 13, 61.00), (@ero1, 1, 14, 70.00), (@ero1, 1, 15, 70.00), (@ero1, 1, 16, 70.00), (@ero1, 1, 17, 79.00), (@ero1, 1, 18, 79.00), (@ero1, 1, 19, 83.00),
(@ero1, 2, 3, 8.00), (@ero1, 2, 4, 8.00), (@ero1, 2, 5, 10.00), (@ero1, 2, 6, 12.00), (@ero1, 2, 7, 15.00), (@ero1, 2, 8, 18.00), (@ero1, 2, 9, 26.00), (@ero1, 2, 10, 35.00), (@ero1, 2, 11, 45.00), (@ero1, 2, 12, 50.00), (@ero1, 2, 13, 53.00), (@ero1, 2, 14, 57.00), (@ero1, 2, 15, 61.00), (@ero1, 2, 16, 61.00), (@ero1, 2, 17, 70.00), (@ero1, 2, 18, 70.00), (@ero1, 2, 19, 75.00),
(@ero1, 3, 4, 6.00), (@ero1, 3, 5, 8.00), (@ero1, 3, 6, 10.00), (@ero1, 3, 7, 12.00), (@ero1, 3, 8, 18.00), (@ero1, 3, 9, 22.00), (@ero1, 3, 10, 30.00), (@ero1, 3, 11, 40.00), (@ero1, 3, 12, 45.00), (@ero1, 3, 13, 50.00), (@ero1, 3, 14, 57.00), (@ero1, 3, 15, 57.00), (@ero1, 3, 16, 57.00), (@ero1, 3, 17, 65.00), (@ero1, 3, 18, 70.00), (@ero1, 3, 19, 75.00),
(@ero1, 4, 5, 6.00), (@ero1, 4, 6, 10.00), (@ero1, 4, 7, 10.00), (@ero1, 4, 8, 15.00), (@ero1, 4, 9, 22.00), (@ero1, 4, 10, 30.00), (@ero1, 4, 11, 35.00), (@ero1, 4, 12, 45.00), (@ero1, 4, 13, 50.00), (@ero1, 4, 14, 53.00), (@ero1, 4, 15, 53.00), (@ero1, 4, 16, 53.00), (@ero1, 4, 17, 61.00), (@ero1, 4, 18, 65.00), (@ero1, 4, 19, 70.00),
(@ero1, 5, 6, 8.00), (@ero1, 5, 7, 10.00), (@ero1, 5, 8, 12.00), (@ero1, 5, 9, 18.00), (@ero1, 5, 10, 26.00), (@ero1, 5, 11, 35.00), (@ero1, 5, 12, 40.00), (@ero1, 5, 13, 45.00), (@ero1, 5, 14, 53.00), (@ero1, 5, 15, 53.00), (@ero1, 5, 16, 53.00), (@ero1, 5, 17, 61.00), (@ero1, 5, 18, 65.00), (@ero1, 5, 19, 70.00),
(@ero1, 6, 7, 8.00), (@ero1, 6, 8, 10.00), (@ero1, 6, 9, 15.00), (@ero1, 6, 10, 22.00), (@ero1, 6, 11, 30.00), (@ero1, 6, 12, 35.00), (@ero1, 6, 13, 40.00), (@ero1, 6, 14, 50.00), (@ero1, 6, 15, 50.00), (@ero1, 6, 16, 50.00), (@ero1, 6, 17, 57.00), (@ero1, 6, 18, 57.00), (@ero1, 6, 19, 65.00),
(@ero1, 7, 8, 8.00), (@ero1, 7, 9, 12.00), (@ero1, 7, 10, 22.00), (@ero1, 7, 11, 26.00), (@ero1, 7, 12, 30.00), (@ero1, 7, 13, 35.00), (@ero1, 7, 14, 45.00), (@ero1, 7, 15, 45.00), (@ero1, 7, 16, 45.00), (@ero1, 7, 17, 53.00), (@ero1, 7, 18, 57.00), (@ero1, 7, 19, 61.00),
(@ero1, 8, 9, 10.00), (@ero1, 8, 10, 15.00), (@ero1, 8, 11, 22.00), (@ero1, 8, 12, 26.00), (@ero1, 8, 13, 30.00), (@ero1, 8, 14, 40.00), (@ero1, 8, 15, 40.00), (@ero1, 8, 16, 40.00), (@ero1, 8, 17, 50.00), (@ero1, 8, 18, 50.00), (@ero1, 8, 19, 57.00),
(@ero1, 9, 10, 10.00), (@ero1, 9, 11, 15.00), (@ero1, 9, 12, 18.00), (@ero1, 9, 13, 22.00), (@ero1, 9, 14, 30.00), (@ero1, 9, 15, 30.00), (@ero1, 9, 16, 30.00), (@ero1, 9, 17, 40.00), (@ero1, 9, 18, 45.00), (@ero1, 9, 19, 50.00),
(@ero1, 10, 11, 10.00), (@ero1, 10, 12, 12.00), (@ero1, 10, 13, 15.00), (@ero1, 10, 14, 22.00), (@ero1, 10, 15, 22.00), (@ero1, 10, 16, 22.00), (@ero1, 10, 17, 30.00), (@ero1, 10, 18, 35.00), (@ero1, 10, 19, 40.00),
(@ero1, 11, 12, 8.00), (@ero1, 11, 13, 10.00), (@ero1, 11, 14, 15.00), (@ero1, 11, 15, 15.00), (@ero1, 11, 16, 15.00), (@ero1, 11, 17, 22.00), (@ero1, 11, 18, 26.00), (@ero1, 11, 19, 30.00),
(@ero1, 12, 13, 8.00), (@ero1, 12, 14, 12.00), (@ero1, 12, 15, 12.00), (@ero1, 12, 16, 12.00), (@ero1, 12, 17, 18.00), (@ero1, 12, 18, 22.00), (@ero1, 12, 19, 26.00),
(@ero1, 13, 14, 10.00), (@ero1, 13, 15, 10.00), (@ero1, 13, 16, 10.00), (@ero1, 13, 17, 15.00), (@ero1, 13, 18, 18.00), (@ero1, 13, 19, 22.00),
(@ero1, 14, 15, 6.00), (@ero1, 14, 16, 6.00), (@ero1, 14, 17, 10.00), (@ero1, 14, 18, 12.00), (@ero1, 14, 19, 15.00),
(@ero1, 15, 16, 6.00), (@ero1, 15, 17, 10.00), (@ero1, 15, 18, 12.00), (@ero1, 15, 19, 15.00),
(@ero1, 16, 17, 10.00), (@ero1, 16, 18, 12.00), (@ero1, 16, 19, 15.00),
(@ero1, 17, 18, 6.00), (@ero1, 17, 19, 10.00),
(@ero1, 18, 19, 8.00);

-- -------------------------------------------------------------
-- 3. Bus 131PP (Tirunelveli Region - 4 Stages)
-- -------------------------------------------------------------
INSERT INTO bus (region_name, sub_region, depot_name, service_number, bus_category, bus_type, vehicle_reg_no, luggage_fare, ticket_class)
VALUES ('TNSTC Tirunelveli Ltd.', 'Tirunelveli Region', 'Papanasam Depot', '131PP', 'MOFUSSIL', 'Mofussil Deluxe', 'TN72N2048', 20.00, 'DELUXE');

SET @tnv1 = LAST_INSERT_ID();

INSERT INTO stage (bus_id, stage_no, stage_name, distance_from_origin) VALUES
(@tnv1, 1, 'Tirunelveli', 0.00),
(@tnv1, 2, 'Melapalayam', 2.60),
(@tnv1, 3, 'Ambasamudram', 36.70),
(@tnv1, 4, 'Papanasam', 47.00);

INSERT INTO fare_matrix (bus_id, from_stage_no, to_stage_no, fare) VALUES
(@tnv1, 1, 2, 10.00), (@tnv1, 1, 3, 45.00), (@tnv1, 1, 4, 48.00),
(@tnv1, 2, 3, 40.00), (@tnv1, 2, 4, 45.00), (@tnv1, 3, 4, 10.00);

-- -------------------------------------------------------------
-- 4. Bus 70 (Town Deluxe - 9 Stages)
-- -------------------------------------------------------------
INSERT INTO bus (region_name, sub_region, depot_name, service_number, bus_category, bus_type, vehicle_reg_no, luggage_fare, ticket_class)
VALUES ('TNSTC Coimbatore Ltd.', 'Coimbatore Region', 'Marudhamalai Depot', '70', 'TOWN', 'Town Deluxe', 'TN37N2050', 15.00, 'DELUXE');

SET @mmi1 = LAST_INSERT_ID();

INSERT INTO stage (bus_id, stage_no, stage_name, distance_from_origin) VALUES
(@mmi1, 1, 'Gandhipuram', 0.00),
(@mmi1, 2, 'Sivanandha Colony', 2.50),
(@mmi1, 3, 'Saibaba Colony', 4.00),
(@mmi1, 4, 'Lawley Road', 6.50),
(@mmi1, 5, 'P N Pudur', 8.00),
(@mmi1, 6, 'Vadavalli', 10.50),
(@mmi1, 7, 'Kalveerampalayam', 12.00),
(@mmi1, 8, 'Bharathiyar University', 13.50),
(@mmi1, 9, 'Maruthamalai', 15.00);

INSERT INTO fare_matrix (bus_id, from_stage_no, to_stage_no, fare) VALUES
(@mmi1, 1, 2, 11.00), (@mmi1, 1, 3, 13.00), (@mmi1, 1, 4, 15.00), (@mmi1, 1, 5, 17.00), (@mmi1, 1, 6, 19.00), (@mmi1, 1, 7, 21.00), (@mmi1, 1, 8, 23.00), (@mmi1, 1, 9, 25.00),
(@mmi1, 2, 3, 11.00), (@mmi1, 2, 4, 13.00), (@mmi1, 2, 5, 15.00), (@mmi1, 2, 6, 17.00), (@mmi1, 2, 7, 19.00), (@mmi1, 2, 8, 21.00), (@mmi1, 2, 9, 23.00),
(@mmi1, 3, 4, 11.00), (@mmi1, 3, 5, 13.00), (@mmi1, 3, 6, 15.00), (@mmi1, 3, 7, 17.00), (@mmi1, 3, 8, 19.00), (@mmi1, 3, 9, 21.00),
(@mmi1, 4, 5, 11.00), (@mmi1, 4, 6, 13.00), (@mmi1, 4, 7, 15.00), (@mmi1, 4, 8, 17.00), (@mmi1, 4, 9, 19.00),
(@mmi1, 5, 6, 11.00), (@mmi1, 5, 7, 13.00), (@mmi1, 5, 8, 15.00), (@mmi1, 5, 9, 17.00),
(@mmi1, 6, 7, 11.00), (@mmi1, 6, 8, 13.00), (@mmi1, 6, 9, 15.00),
(@mmi1, 7, 8, 11.00), (@mmi1, 7, 9, 13.00),
(@mmi1, 8, 9, 11.00);