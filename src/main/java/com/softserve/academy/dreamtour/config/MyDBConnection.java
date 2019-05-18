package com.softserve.academy.dreamtour.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyDBConnection {

    public static Connection getConnection() throws NamingException, SQLException {
        InitialContext ctx = new InitialContext();
        Context initCtx  = (Context) ctx.lookup("java:/comp/env");
        DataSource ds = (DataSource) initCtx.lookup("jdbc/DreamTourDB");
        Connection conn = ds.getConnection();
        return conn;
    }


}
