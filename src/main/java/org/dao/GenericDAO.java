package org.dao;

import org.connection.ConnectionFactory;
import org.idao.IDaoBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericDAO implements IDaoBase {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

}
