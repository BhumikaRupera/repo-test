package com.thales.empmgmt.service;

import com.thales.empmgmt.dao.entities.EmployeeEntity;
import com.thales.empmgmt.dao.qualifiers.IEmployeeDao;
import com.thales.empmgmt.exceptions.NoSuchEmployeeException;
import com.thales.empmgmt.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class EmployeeService {
//    private Map<String, Employee> employeeDetails = EmployeeDao.getEmployeeDetails();
//    employeeDetails.put("t0251371", new Employee("all", "t0251371", "Jaipur", " ", "Bhumika", "56", new Date(), "Rupera", "Mansarovar", "Akram", "xyzabc", "7891987926", skill_set, "Rajasthan", "0y"));
//    employeeDetails.put("t0251372", new Employee("all", "t0251372", "Noida", " ", "Varsha", "71", new Date(), "Saraf", "Gautam Buddha Nagar", "Wasim", "xyzabcdef", "7891987943", skill_set, "Delhi", "1y"));

    @Inject
    IEmployeeDao employeeDao;

//    IEmployeeDao employeeDao = new EmployeeDao();

    @Inject
    public EmployeeService(){
        employeeDao.prepareStatements();
    }

    public Employee createEmployee(Employee employee){
        EmployeeEntity employeeEntity = employeeDao.createEmployee(employee.getTgi(), employee.getFirstName(), employee.getLastName(), employee.getPassword(),
                employee.getPhoneNumber(), employee.getHouse_number(), employee.getLocality(), employee.getCity(),
                employee.getState(), employee.getDesignation(), employee.getManager(), employee.getJoiningDate(),
                employee.getYearsOfExperience(), employee.getSkillSet());

        return employee;
    }

    public Employee getEmployeeDetails(String tgi){


        final EmployeeEntity employeeEntity = employeeDao.getEmployeeEntity(tgi);
        try {
            if (employeeEntity == null) {
                throw new NoSuchEmployeeException("employee with tgi " + tgi + " not found");
            }
        }
        catch (NoSuchEmployeeException e){
            System.out.println(e.getMessage());
        }

        final Employee employee = new Employee();
        buildEmployee(employeeEntity, employee);

        return employee;
    }

    public Employee updateEmployeeDetails(Employee employee){
        EmployeeEntity employeeEntity = employeeDao.updateEmployee(employee.getTgi(), employee.getFirstName(), employee.getLastName(), employee.getPassword(),
                employee.getPhoneNumber(), employee.getHouse_number(), employee.getLocality(), employee.getCity(),
                employee.getState(), employee.getDesignation(), employee.getManager(), employee.getJoiningDate(),
                employee.getYearsOfExperience(), employee.getSkillSet());

        return employee;
    }

    public void removeEmployee(String tgi){
        employeeDao.deleteEmployeeEntity(tgi);
    }

    private void buildEmployee(EmployeeEntity employeeEntity, Employee employee){
        employee.setTgi(employeeEntity.getTgi());
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setCity(employeeEntity.getCity());
        employee.setLocality(employeeEntity.getLocality());
        employee.setState(employeeEntity.getState());
        employee.setHouse_number(employeeEntity.getHouse_number());
        employee.setDesignation(employeeEntity.getDesignation());
        employee.setManager(employeeEntity.getManager());
        employee.setPassword(employeeEntity.getPassword());
        employee.setJoiningDate(employeeEntity.getJoiningDate());
        employee.setPhoneNumber(employeeEntity.getPhoneNumber());
        employee.setYearsOfExperience(employeeEntity.getYearsOfExperience());
        employee.setSkillSet(employeeEntity.getSkillSet());

    }
}


