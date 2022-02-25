package com.thales.empmgmt.dao;

import com.datastax.oss.driver.api.core.cql.*;
import com.thales.empmgmt.dao.entities.EmployeeEntity;
import com.thales.empmgmt.dao.qualifiers.IEmployeeDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Map;

@ApplicationScoped
public class EmployeeDao implements IEmployeeDao {

    @Inject
    private EmployeeAccessor employeeAccessor;

    @Inject
    private CassandraConnection connection;

    public void prepareStatements(){
        employeeAccessor.prepareStatements();
    }

    public EmployeeEntity getEmployeeEntity(final String tgi) {
        final PreparedStatement preparedStatement = employeeAccessor.getSelectEmployeeByTgiPreparedStatement();
        BoundStatement boundStatement = preparedStatement.bind().setString(EmployeeAccessor.TGI_COLUMN, tgi);

        final ResultSet resultSet = connection.execute(boundStatement);
        final Row row = resultSet.one();

        if (row == null) {
            return null;
        } else {
            return employeeAccessor.toEntity(row);
        }
    }

    public void deleteEmployeeEntity(final String tgi) {
        final PreparedStatement preparedStatement = employeeAccessor.getDeleteEmployeeByTgiPreparedStatement();
        BoundStatement boundStatement = preparedStatement.bind().setString(EmployeeAccessor.TGI_COLUMN, tgi);

        connection.execute(boundStatement);
    }


    public EmployeeEntity createEmployee(String tgi, String first_name, String last_name, String password, String phone_number,
                                         String house_number, String locality, String city, String state, String designation,
                                         String manager, LocalDate joining_date, String years_of_experience, Map<String, String>skill_set){
        final PreparedStatement preparedStatement = employeeAccessor.getInsertEmployeePreparedStatement();
        return getEmployeeEntity(tgi, first_name, last_name, password, phone_number, house_number, locality, city, state, designation, manager, joining_date, years_of_experience, skill_set, preparedStatement);
    }

    private EmployeeEntity getEmployeeEntity(String tgi, String first_name, String last_name, String password, String phone_number, String house_number, String locality, String city, String state, String designation, String manager, LocalDate joining_date, String years_of_experience, Map<String, String> skill_set, PreparedStatement preparedStatement) {
        BoundStatement boundStatement = preparedStatement.bind()
                .setString(EmployeeAccessor.TGI_COLUMN, tgi)
                .setString(EmployeeAccessor.FIRST_NAME_COLUMN, first_name)
                .setString(EmployeeAccessor.LAST_NAME_COLUMN, last_name)
                .setString(EmployeeAccessor.PASSWORD_COLUMN, password)
                .setString(EmployeeAccessor.PHONE_NUMBER_COLUMN, phone_number)
                .setString(EmployeeAccessor.HOUSE_NUMBER_COLUMN, house_number)
                .setString(EmployeeAccessor.LOCALITY_COLUMN, locality)
                .setString(EmployeeAccessor.CITY_COLUMN, city)
                .setString(EmployeeAccessor.STATE_COLUMN, state)
                .setString(EmployeeAccessor.DESIGNATION_COLUMN, designation)
                .setString(EmployeeAccessor.MANAGER_COLUMN, manager)
                .setLocalDate(EmployeeAccessor.JOINING_DATE_COLUMN, joining_date)
                .setString(EmployeeAccessor.YEARS_OF_EXPERIENCE_COLUMN, years_of_experience)
                .setMap(EmployeeAccessor.SKILL_SET_COLUMN, skill_set, String.class, String.class);

        connection.execute(boundStatement);
        return getEmployeeEntity(tgi);
    }

    public EmployeeEntity updateEmployee(String tgi, String first_name, String last_name, String password, String phone_number,
                                         String house_number, String locality, String city, String state, String designation,
                                         String manager, LocalDate joining_date, String years_of_experience, Map<String, String>skill_set){

        final PreparedStatement preparedStatement = employeeAccessor.getUpdateEmployeePreparedStatement();
        return getEmployeeEntity(tgi, first_name, last_name, password, phone_number, house_number, locality, city, state, designation, manager, joining_date, years_of_experience, skill_set, preparedStatement);

    }

}
