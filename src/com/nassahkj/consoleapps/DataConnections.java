package com.nassahkj.consoleapps;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnections {

    private static Connection conn; //the class variable as a return type for the database connection method
    private static final String connUrl = "jdbc:mysql://localhost:3306/kammwanyi_investments?useSSL = false";
    private static final String usrName = "root";
    private static final String dbPassword = "@Hassan24Global";


    //All database connections are handled in this file
    public static Connection getDbConnection(){
        try{
            /*
             * Notice that the class.forName(); has not been invoked to register the db drivers
             * The reason is that,for newer versions, this is invoked automatically
             */
            conn = DriverManager.getConnection(connUrl, usrName, dbPassword);
            
            

        }catch(Exception ex){
            ex.printStackTrace();
        }


        return conn;

    }
    
}
