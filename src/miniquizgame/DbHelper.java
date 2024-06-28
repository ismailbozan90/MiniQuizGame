
package miniquizgame;

import java.sql.*;

/**
 *
 * @author ismail
 */
public class DbHelper {

    private final String userName = "root";
    private final String password = "123456";
    private final String host = "localhost";
    private final String port = "3306";
    private final String database = "miniquizgame";

    public Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage(SQLException exception, String methodName) {
        System.out.println(methodName + " - " + exception.getMessage());
        System.out.println(methodName + " - " + exception.getErrorCode());
    }

}
