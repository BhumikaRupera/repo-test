package com.thales.empmgmt.dao;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.Statement;


//import javax.servlet.ServletContextListener;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.net.InetSocketAddress;

@ApplicationScoped
public class CassandraConnection {
    private static String contactPoint = "10.160.165.234";
    private static int port = 9042;
    private static String keySpace = "employee_mgmt";
    private static String dataCenter = "datacenter1";
    public static CqlSession session;

    @Produces
    public void createCqlSession() {

        try {
            session = CqlSession.builder().addContactPoint(new InetSocketAddress(contactPoint, port)).withKeyspace(keySpace).withLocalDatacenter(dataCenter).build();
            ResultSet rs = session.execute("select * from employee_mgmt.employee limit 5");
            for (Row row : rs.all()) {
                System.out.println(row.getString("tgi"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public CqlSession getCqlSession(){
        if(session == null){
            createCqlSession();
            return session;
        }
        return session;
    }

    public String getKeySpace(){
        return keySpace;
    }

    public ResultSet execute(Statement statement) {
        ResultSet resultSet = null;

        try {
            resultSet = session.execute(statement);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return resultSet;
    }


}
