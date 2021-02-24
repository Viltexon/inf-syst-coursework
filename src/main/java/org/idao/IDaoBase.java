package org.idao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDaoBase {

    Connection getConnection() throws SQLException;

}
