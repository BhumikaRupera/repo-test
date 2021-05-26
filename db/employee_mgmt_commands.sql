//creating keyspace

	create keyspace employee_mgmt
		with replication = {
		'class' : 'SimpleStrategy', 
		'replication_factor' : 3
		};
		
// creating employee table

	use employee_mgmt;
	create table employee (
		bucket text,
		tgi text,
		first_name text,
		last_name text,
		user_name text,
		password text,
		phone_number text,
		house_number text,
		locality text,
		city text,
		state text,
		designation text,
		manager text,
		joining_date date,
		years_of_experience text,
		skillset map<text, text>,
		PRIMARY KEY (bucket, emp_id);
		
//inserting records
insert into employee (bucket, tgi, first_name, last_name, user_name, password, phone_number, house_number, locality, city, state, designation, manager, joining_date, years_of_experience, skill_set)
values ('all', 't0251371', 'Bhumika', 'Rupera', 'bhumi1@rupera', 'xyzabc', 7891987926, '56', 'Mansarovar', 'Jaipur', 'Rajasthan', 'Intern', 'Akram Raza Khan', '2021-02-22', '0y', {'java': 'intermediate', 'python': 'basic', docker: 'entry', 'kubernetes': 'entry'});
	


insert into employee (bucket, tgi, first_name, last_name, user_name, password, phone_number, house_number, locality, city, state, designation, manager, joining_date, years_of_experience, skill_set)
values ('all', 't0251372', 'Varsha', 'Saraf', 'saraf@123', 'xyzdef', 7891986526, '76', 'Mansarovar', 'Jaipur', 'Rajasthan', 'Intern', 'Wasim Khan', '2021-02-22', '0y', {'java': 'intermediate', 'python': 'basic', 'react': intermediate});

// create employee_by_designation table

	CREATE TABLE employee_mgmt.employee_by_designation (
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
		user_name text,
		years_of_experience text,
		PRIMARY KEY (designation, tgi);

// create employee_by_skill table

	CREATE TABLE employee_mgmt.employee_by_skill (
		skill text,
		level text,
		tgi text,
		city text,
		designation text,
		first_name text,

// create employee_by_first_name table

	CREATE TABLE employee_mgmt.employee_by_first_name (
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
		PRIMARY KEY (first_name, tgi);

	
// Alter table

	ALTER TABLE employee ALTER phone TYPE text;