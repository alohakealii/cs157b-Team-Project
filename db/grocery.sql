# mysql -u root -p --local-infile < grocery.sql

drop database if exists grocery;
create database grocery;
use grocery;

create table product(
	product_key int primary key auto_increment,
	description varchar(30),
	full_description varchar(50),
	sku_number char(11),
	package_size varchar(10),
	brand varchar(30),
	subcategory varchar(30),
	category varchar(30),
	department varchar(20),
	package_type varchar(20),
	diet_type varchar(20),
	weight int,
	weight_unit_of_measure varchar(10),
	units_per_shipping_case int,
	cases_per_pallet int,
	shelf_width_cm int,
	shelf_height_cm int,
	shelf_depth_cm int
);

create table store(
	store_key int primary key auto_increment,
	name varchar (20),
	store_number int,
	store_street_address varchar(50),
	city varchar(30),
	store_county varchar(30),
	store_state char(2),
	store_zip int,
	sales_district varchar(30),
	sales_region varchar(20),
	store_manager varchar(30),
	store_phone char(14),
	store_fax char(14),
	floor_plan_type varchar(20),
	photo_processing_type varchar(20),
	finance_services_type varchar(20),
	first_opened_date date,
	last_remodel_date date,
	store_sqft int,
	grocery_sqft int,
	frozen_sqft int,
	meat_sqft int
);

create table time(
	time_key int primary key auto_increment,
	the_date date,
	day_of_week varchar(10),
	day_number_in_month int,
	day_number_overall int,
	week_number_in_year int,
	week_number_overall int,
	month int,
	quarter int,
	fiscal_period char(4),
	year int,
	holiday_flag varchar(11)
);

create table sales_fact(
	id int primary key auto_increment,
	time_key int references time(time_key),
	product_key int references product(product_key),
	promotion_key int references promotion(promotion_key),
	store_key int references store(store_key),
	dollar_sales decimal(10,2),
	unit_sales int,
	dollar_cost decimal(10,2),
	customer_count int 
);

LOAD DATA LOCAL INFILE 'Product.csv'
INTO TABLE product
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'Store.csv'
INTO TABLE store
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(store_key,name,store_number,store_street_address,city,store_county,store_state,store_zip,sales_district,sales_region,store_manager,store_phone,store_FAX,floor_plan_type,photo_processing_type,finance_services_type,@first_opened,@last_remodel,store_sqft,grocery_sqft,frozen_sqft,meat_sqft)
SET first_opened_date = STR_TO_DATE(@first_opened, '%m/%d/%Y'),
last_remodel_date = STR_TO_DATE(@last_remodel, '%m/%d/%Y');

LOAD DATA LOCAL INFILE 'Time.csv'
INTO TABLE time
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(time_key,@the_date,day_of_week,day_number_in_month,day_number_overall,week_number_in_year,week_number_overall,Month,quarter,fiscal_period,year,holiday_flag)
SET the_date = STR_TO_DATE(@the_date, '%m/%d/%Y');

LOAD DATA LOCAL INFILE 'Sales Fact.csv'
INTO TABLE sales_fact
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;