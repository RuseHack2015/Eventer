package com.eventer.connection;

import java.sql.*;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by simeon on 5/30/15.
 */
public class DBconnenter {

    private  String  dbUrl = "jdbc:mysql://www.strappable.com/strappab_wp853'";
    private String userName ="strappab_dev1";
    private String password= "Jumpstart2015";

    private java.sql.Connection connection;

    public Connection connnect()throws  ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection =  DriverManager.getConnection(dbUrl,userName,password);
        return connection;
        }

    public void closeConnetion()throws  SQLException{
        connection.close();
    }
    }
