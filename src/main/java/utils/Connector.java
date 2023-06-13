package utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@AllArgsConstructor
@NoArgsConstructor
public class Connector {
    private String userName = "aapiuser1";
    private String password = "antigoibarber";
    private String dbms = "mysql";
    private String serverName = "agendabarba-db-1.cfdb0dd5xmmb.us-east-2.rds.amazonaws.com";
    private String dbName = "agenda_barba_db";
    private Integer portNumber = 3306;

    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.serverName +
                            ":" + this.portNumber + "/" + this.dbName,
                    connectionProps);
        } else if (this.dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":" +
                            this.dbName +
                            ";create=true",
                    connectionProps);
        }
        return conn;
    }
}
