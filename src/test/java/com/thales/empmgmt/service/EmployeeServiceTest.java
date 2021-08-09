package com.thales.empmgmt.service;
import com.thales.empmgmt.dao.CassandraConnection;
import com.thales.empmgmt.dao.EmployeeDao;
import com.thales.empmgmt.dao.qualifiers.IEmployeeDao;
import org.junit.Test;

import javax.inject.Inject;


public class EmployeeServiceTest {
    String tgi= "t0251371";

    IEmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void TestGetEmployeeDetails(){
        //CassandraConnection.createCqlSession();

    }
}
