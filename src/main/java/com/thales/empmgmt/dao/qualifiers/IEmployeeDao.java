package com.thales.empmgmt.dao.qualifiers;

import com.thales.empmgmt.dao.entities.EmployeeEntity;

import java.time.LocalDate;
import java.util.Map;

public interface IEmployeeDao {

    EmployeeEntity getEmployeeEntity(String tgi);

    void deleteEmployeeEntity(String tgi);

    void prepareStatements();

    EmployeeEntity createEmployee(String tgi, String first_name, String last_name, String password, String phone_number, String house_number, String locality, String city, String state, String designation, String manager, LocalDate joining_date, String years_of_experience, Map<String, String> skill_set);

    EmployeeEntity updateEmployee(String tgi, String first_name, String last_name, String password, String phone_number,
                                         String house_number, String locality, String city, String state, String designation,
                                         String manager, LocalDate joining_date, String years_of_experience, Map<String, String>skill_set);


    }


