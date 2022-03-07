package com.example.guestbook;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataProvider {
    private static DataSource dataSource;

    private DataProvider() {} // prywatny konstruktor zabezpiecza przed możliwością tworzenia dodatkowych połączeń poza pulą

    static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/guestbook");
        }
        return dataSource;
    }
}
