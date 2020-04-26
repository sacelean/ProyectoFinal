package DAO;


import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by bcpdm on 14/11/2017.
 */
public class LoadProperties {
    private String user;
    private String pass;
    private String strURLConnection;
    private String driverClass;
    private InputStream input;
    private OutputStream output;
    private Map<String, String> mapProperties;

	public LoadProperties() {
        this.user = "root";
        this.pass = "Anna2019+";
        this.driverClass = "com.mysql.jdbc.Driver";
		this.strURLConnection = "jdbc:mysql://localhost:3306/sga?useSSL=false";
    }


	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getStrURLConnection() {
		return strURLConnection;
	}
	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public Map<String, String> getMapProperties() {
		return mapProperties;
	}
}
