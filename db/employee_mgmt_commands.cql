//creating keyspace employee_mgmt
CREATE KEYSPACE employee_mgmt
	with replication = {
	'class' : 'SimpleStrategy', 
	'replication_factor' : 3
	};

//using keyspace employee_mgmt		
USE employee_mgmt;
		
//creating table employee
CREATE TABLE employee (
    bucket text,
    tgi text,
    city text,
    designation text,
    first_name text,
    house_number text,
    joining_date date,
    last_name text,
    locality text,
    manager text,
    password text,
    phone_number text,
    skill_set map<text, text>,
    state text,
    years_of_experience text,
    PRIMARY KEY (bucket, tgi));
		
//inserting records into employee 
INSERT INTO employee (bucket, tgi, first_name, last_name, password, phone_number, house_number, locality, city, state, designation, manager, joining_date, years_of_experience, skill_set)
VALUES ('all', 't0251371', 'Bhumika', 'Rupera', 'xyzabc', '7891987926', '56', 'Mansarovar', 'Jaipur', 'Rajasthan', 'Intern', 'Akram Raza Khan', '2021-02-22', '0y', {'java': 'intermediate', 'python': 'basic', 'docker': 'entry', 'kubernetes': 'entry'});
	

INSERT INTO employee (bucket, tgi, first_name, last_name, password, phone_number, house_number, locality, city, state, designation, manager, joining_date, years_of_experience, skill_set)
VALUES ('all', 't0251372', 'Varsha', 'Saraf', 'xyzdef', '7891986526', '76', 'Mansarovar', 'Jaipur', 'Rajasthan', 'Intern', 'Wasim Khan', '2021-02-22', '0y', {'java': 'intermediate', 'python': 'basic', 'react': 'intermediate'});


//create table employee_by_designation
CREATE TABLE employee_by_designation (
	designation text,
	tgi text,
	city text,
	first_name text,
	house_number text,
	joining_date date,
	last_name text,
	locality text,
	manager text,
	password text,
	phone_number text,
	skill_set map<text, text>,
	state text,
	years_of_experience text,
	PRIMARY KEY (designation, tgi));

//create table employee_by_skill 
CREATE TABLE employee_by_skill (
	skill text,
	level text,
	tgi text,
	city text,
	designation text,
	first_name text,
	house_number text,
	joining_date date,
	last_name text,
	locality text,
	manager text,
	password text,
	phone_number text,
	state text,
	years_of_experience text,
	PRIMARY KEY (skill, level, tgi));

//create table employee_by_first_name 
CREATE TABLE employee_by_first_name (
	first_name text,
	tgi text,
	city text,
	designation text,
	house_number text,
	joining_date date,
	last_name text,
	locality text,
	manager text,
	password text,
	phone_number text,
	skill_set map<text, text>,
	state text,
	years_of_experience text,
	PRIMARY KEY (first_name, tgi));
	
//create table employee_by_manager
CREATE TABLE employee_by_manager (
	manager text,
	tgi text,
	city text,
	designation text,
	first_name text,
	house_number text,
	joining_date date,
	last_name text,
	locality text,
	password text,
	phone_number text,
	skill_set map<text, text>,
	state text,
	years_of_experience text,
	PRIMARY KEY (manager, tgi));

//create table employee_by_city
CREATE TABLE employee_by_city (
	city text,
	tgi text,
	designation text,
	first_name text,
	house_number text,
	joining_date date,
	last_name text,
	locality text,
	manager text,
	password text,
	phone_number text,
	skill_set map<text, text>,
	state text,
	years_of_experience text,
	PRIMARY KEY (city, tgi));
