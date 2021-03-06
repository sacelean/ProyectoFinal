package dataBaseDAO;


import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;


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
        this.pass = "quequieres";
        this.driverClass = "com.mysql.cj.jdbc.Driver";
		this.strURLConnection = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
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
