package com.thales.empmgmt.resource;

import com.thales.empmgmt.exceptions.NoSuchEmployeeException;
import com.thales.empmgmt.model.Employee;
import com.thales.empmgmt.service.EmployeeService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/employees")
public class EmployeeResource {
    @Inject
    EmployeeService employeeService;

//    EmployeeService employeeService = new EmployeeService();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee createEmployee(Employee employee){
        employeeService.createEmployee(employee);
        return employee;
    }

    @GET
    @Path("/{tgi}")
    @Produces(MediaType.APPLICATION_JSON)
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Employee found", response = Employee.class),
//            @ApiResponse(code = 404, message = NoSuchEmployeeException.message),})

    public Employee getEmployeeDetails(@PathParam("tgi") String tgi) throws NoSuchEmployeeException {

        return employeeService.getEmployeeDetails(tgi);

    }

    @PUT
    @Path("/{tgi}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployeeDetails(@PathParam("tgi") String tgi, Employee employee){
        return employeeService.updateEmployeeDetails(employee);
    }

    @DELETE
    @Path("/{tgi}")
    public void removeEmployee(@PathParam("tgi") String tgi){
        employeeService.removeEmployee(tgi);
    }

}
