package DAO;

import Biblioteca.Model.Libro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class represents a DAO factory for a SQL database. You can use
 * to obtain a new instance for the given database name. The specific instance returned depends on
 * the properties file configuration. You can obtain DAO's for the DAO factory instance using the
 * DAO getters.
 * <p>
 * This class requires a properties file named 'dao.properties' in the classpath with among others
 * the following properties:
 * <pre>
 * name.url *
 * name.driver
 * name.username
 * name.password
 * </pre>
 * Those marked with * are required, others are optional and can be left away or empty. Only the
 * username is required when any password is specified.
 * <ul>
 * <li>The 'name' must represent the database name in .</li>
 * <li>The 'name.url' must represent either the JDBC URL or JNDI name of the database.</li>
 * <li>The 'name.driver' must represent the full qualified class name of the JDBC driver.</li>
 * <li>The 'name.username' must represent the username of the database login.</li>
 * <li>The 'name.password' must represent the password of the database login.</li>
 * </ul>
 * If you specify the driver property, then the url property will be assumed as JDBC URL. If you
 * omit the driver property, then the url property will be assumed as JNDI name. When using JNDI
 * with username/password preconfigured, you can omit the username and password properties as well.
 * <p>
 * Here are basic examples of valid properties for a database with the name 'javabase':
 * <pre>
 * javabase.jdbc.url = jdbc:mysql://localhost:3306/javabase
 * javabase.jdbc.driver = com.mysql.jdbc.Driver
 * javabase.jdbc.username = java
 * javabase.jdbc.password = d$7hF_r!9Y
 * </pre>
 * <pre>
 * javabase.jndi.url = jdbc/javabase
 * </pre>
 * Here is a basic use example:
 * <pre>
 * DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
 * UserDAO userDAO = javabase.getUserDAO();
 * </pre>
 *
 */
public abstract class DAOFactory {

    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns a new DAOFactory instance for the given database name.
     * @return A new DAOFactory instance for the given database name.
     * @throws DAOConfigurationException If the database name is null, or if the properties file is
     * missing in the classpath or cannot be loaded, or if a required property is missing in the
     * properties file, or if either the driver cannot be loaded or the datasource cannot be found.
     */

    public static DAOFactory getInstance(){
        LoadProperties properties = null;
        properties = new LoadProperties();
        try {
            return getInstance(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DAOFactory getInstance(LoadProperties properties) {

        String url = properties.getStrURLConnection();
        String driverClassName = properties.getDriverClass();
        String password = properties.getPass();
        String username = properties.getUser();

        DAOFactory instance;

        // If driver is specified, then load it to let it register itself with DriverManager.
        if (driverClassName != null) {
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                throw new DAOConfigurationException(
                        "Driver class '" + driverClassName + "' is missing in classpath.", e);
            }
            instance = new DriverManagerDAOFactory(url, username, password);
        }
        else {
            instance = null;
        }

        return instance;
    }

    /**
     * Returns a connection to the database. Package private so that it can be used inside the DAO
     * package only.
     * @return A connection to the database.
     * @throws SQLException If acquiring the connection fails.
     */
    abstract Connection getConnection() throws SQLException;

    // DAO implementation getters -----------------------------------------------------------------

    /**
     * Returns the User DAO associated with the current DAOFactory.
     * @return The User DAO associated with the current DAOFactory.
     */
    public DataDB getDataDB() {
        return new DataDBimpl(this);
    }
    public DAO<Libro> getLibroDAO() {
        return new LibroDAOImpl(this);
    }

    // You can add more DAO implementation getters here.

}

// Default DAOFactory implementations -------------------------------------------------------------

/**
 * The DriverManager based DAOFactory.
 */
class DriverManagerDAOFactory extends DAOFactory {
    private String url;
    private String username;
    private String password;

    DriverManagerDAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}



