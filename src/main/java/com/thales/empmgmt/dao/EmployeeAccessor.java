package com.thales.empmgmt.dao;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.delete.Delete;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.update.Update;
import com.datastax.oss.driver.internal.core.type.codec.DateCodec;
import com.thales.empmgmt.dao.entities.EmployeeEntity;

import java.util.*;

public class EmployeeAccessor {

    public static final String TABLE_NAME = "employee";
    public static final String Bucket_Column = "bucket";
    public static final String TGI_COLUMN = "tgi";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
    public static final String PASSWORD_COLUMN = "password";
    public static final String PHONE_NUMBER_COLUMN = "phone_number";
    public static final String HOUSE_NUMBER_COLUMN = "house_number";
    public static final String LOCALITY_COLUMN = "locality";
    public static final String CITY_COLUMN = "city";
    public static final String STATE_COLUMN = "state";
    public static final String DESIGNATION_COLUMN = "designation";
    public static final String MANAGER_COLUMN = "manager";
    public static final String JOINING_DATE_COLUMN = "joining_date";
    public static final String YEARS_OF_EXPERIENCE_COLUMN = "years_of_experience";
    public static final String SKILL_SET_COLUMN = "skill_set";

    private PreparedStatement selectEmployeeByTgi;
    private PreparedStatement deleteEmployeeByTgi;
    private PreparedStatement insertEmployee;
    private PreparedStatement updateEmployee;

    CassandraConnection connection = new CassandraConnection();
    CqlSession session = connection.getCqlSession();
    private String bucketValue = "all";

    final List<PreparedStatement> EmployeeStatements = new ArrayList<>();

    //prepare all statements
    public void prepareStatements(){
        selectEmployeeByTgi = session.prepare(buildSelectEmployeeByTgi());
        deleteEmployeeByTgi = session.prepare(buildDeleteEmployeeByTgi());
        insertEmployee = session.prepare(buildInsertEmployee());
        updateEmployee = session.prepare(buildUpdateEmployee());
    }

    public PreparedStatement getSelectEmployeeByTgiPreparedStatement(){
        return selectEmployeeByTgi;

    }

    public PreparedStatement getDeleteEmployeeByTgiPreparedStatement(){
        return deleteEmployeeByTgi;
    }

    public PreparedStatement getInsertEmployeePreparedStatement(){ return insertEmployee; }

    public PreparedStatement getUpdateEmployeePreparedStatement(){ return updateEmployee; }

    private SimpleStatement buildSelectEmployeeByTgi(){
        final String keyspaceName = connection.getKeySpace();
        Select query = QueryBuilder.selectFrom(keyspaceName, TABLE_NAME)
                .column(TGI_COLUMN)
                .column(FIRST_NAME_COLUMN)
                .column(LAST_NAME_COLUMN)
                .column(PASSWORD_COLUMN)
                .column(PHONE_NUMBER_COLUMN)
                .column(HOUSE_NUMBER_COLUMN)
                .column(LOCALITY_COLUMN)
                .column(CITY_COLUMN)
                .column(STATE_COLUMN)
                .column(DESIGNATION_COLUMN)
                .column(MANAGER_COLUMN)
                .column(JOINING_DATE_COLUMN)
                .column(YEARS_OF_EXPERIENCE_COLUMN)
                .column(SKILL_SET_COLUMN)
                .whereColumn(TGI_COLUMN).isEqualTo(QueryBuilder.bindMarker())
                .whereColumn(Bucket_Column).isEqualTo(QueryBuilder.literal(bucketValue))
                .allowFiltering();

        return query.build();

    }

    private SimpleStatement buildDeleteEmployeeByTgi(){
        final String keyspaceName = connection.getKeySpace();
        Delete query = QueryBuilder.deleteFrom(keyspaceName, TABLE_NAME)
                .whereColumn(TGI_COLUMN).isEqualTo(QueryBuilder.bindMarker())
                .whereColumn(Bucket_Column).isEqualTo(QueryBuilder.literal(bucketValue));

        return query.build();
    }

    private SimpleStatement buildInsertEmployee(){
        final String keyspaceName = connection.getKeySpace();
        Insert query = QueryBuilder.insertInto(keyspaceName, TABLE_NAME)
                .value(Bucket_Column, QueryBuilder.literal(bucketValue))
                .value(TGI_COLUMN, QueryBuilder.bindMarker())
                .value(CITY_COLUMN, QueryBuilder.bindMarker())
                .value(DESIGNATION_COLUMN, QueryBuilder.bindMarker())
                .value(FIRST_NAME_COLUMN, QueryBuilder.bindMarker())
                .value(HOUSE_NUMBER_COLUMN, QueryBuilder.bindMarker())
                .value(JOINING_DATE_COLUMN, QueryBuilder.bindMarker())
                .value(LAST_NAME_COLUMN, QueryBuilder.bindMarker())
                .value(LOCALITY_COLUMN, QueryBuilder.bindMarker())
                .value(MANAGER_COLUMN, QueryBuilder.bindMarker())
                .value(PASSWORD_COLUMN, QueryBuilder.bindMarker())
                .value(PHONE_NUMBER_COLUMN, QueryBuilder.bindMarker())
                .value(SKILL_SET_COLUMN, QueryBuilder.bindMarker())
                .value(STATE_COLUMN, QueryBuilder.bindMarker())
                .value(YEARS_OF_EXPERIENCE_COLUMN, QueryBuilder.bindMarker());

        return query.build();
    }

    private SimpleStatement buildUpdateEmployee(){
        final String keyspaceName = connection.getKeySpace();
        Update query = QueryBuilder.update(keyspaceName, TABLE_NAME)
                .setColumn(CITY_COLUMN, QueryBuilder.bindMarker())
                .setColumn(DESIGNATION_COLUMN, QueryBuilder.bindMarker())
                .setColumn(FIRST_NAME_COLUMN, QueryBuilder.bindMarker())
                .setColumn(HOUSE_NUMBER_COLUMN, QueryBuilder.bindMarker())
                .setColumn(JOINING_DATE_COLUMN, QueryBuilder.bindMarker())
                .setColumn(LAST_NAME_COLUMN, QueryBuilder.bindMarker())
                .setColumn(LOCALITY_COLUMN, QueryBuilder.bindMarker())
                .setColumn(MANAGER_COLUMN, QueryBuilder.bindMarker())
                .setColumn(PASSWORD_COLUMN, QueryBuilder.bindMarker())
                .setColumn(PHONE_NUMBER_COLUMN, QueryBuilder.bindMarker())
                .setColumn(SKILL_SET_COLUMN, QueryBuilder.bindMarker())
                .setColumn(STATE_COLUMN, QueryBuilder.bindMarker())
                .setColumn(YEARS_OF_EXPERIENCE_COLUMN, QueryBuilder.bindMarker())
                .whereColumn(TGI_COLUMN).isEqualTo(QueryBuilder.bindMarker())
                .whereColumn(Bucket_Column).isEqualTo(QueryBuilder.literal(bucketValue));

        return query.build();

    }

    public EmployeeEntity toEntity(final Row row) {

        EmployeeEntity employeeEntity = new EmployeeEntity(
                row.getString(TGI_COLUMN),
                row.getString(CITY_COLUMN),
                row.getString(DESIGNATION_COLUMN),
                row.getString(FIRST_NAME_COLUMN),
                row.getString(HOUSE_NUMBER_COLUMN),
                row.getLocalDate(JOINING_DATE_COLUMN),
                row.getString(LAST_NAME_COLUMN),
                row.getString(LOCALITY_COLUMN),
                row.getString(MANAGER_COLUMN),
                row.getString(PASSWORD_COLUMN),
                row.getString(PHONE_NUMBER_COLUMN),
                row.getMap(SKILL_SET_COLUMN, String.class, String.class),
                row.getString(STATE_COLUMN),
                row.getString(YEARS_OF_EXPERIENCE_COLUMN));
        return employeeEntity;
    }





}
