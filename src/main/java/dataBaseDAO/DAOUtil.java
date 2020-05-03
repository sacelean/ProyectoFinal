package dataBaseDAO;

import java.sql.*;
import java.util.regex.Pattern;

/**
 * Utility class for DAO's. This class contains commonly used DAO logic which is been refactored in
 * single static methods. As far it contains a PreparedStatement values setter and a
 * <code>java.util.Date</code> to <code>java.sql.Date</code> converter.
 *
 */
public final class DAOUtil {

    // Constructors -------------------------------------------------------------------------------

    private DAOUtil() {
        // Utility class, hide constructor.
    }

    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns a PreparedStatement of the given connection, set with the given SQL query and the
     * given parameter values.
     * @param connection The SimpleFactory.Connection to create the PreparedStatement from.
     * @param sql The SQL query to construct the PreparedStatement with.
     * @param returnGeneratedKeys Set whether to return generated keys or not.
     * @param values The parameter values to be set in the created PreparedStatement.
     * @throws SQLException If something fails during creating the PreparedStatement.
     */
    public static PreparedStatement prepareStatement
        (Connection connection, String sql, boolean returnGeneratedKeys, String values)
            throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement(sql,
                returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);

        croppString(statement, values);
        return statement;
    }

    public static void croppString(PreparedStatement statement, String values){
        String[] result = values.split(Pattern.quote("|"));
        try {
            setValues(statement, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the given parameter values in the given PreparedStatement.
     * @param values The parameter values to be set in the created PreparedStatement.
     * @throws SQLException If something fails during setting the PreparedStatement values.
     */
    public static void setValues(PreparedStatement statement, String[] values) //values = ""
            throws SQLException
    {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("")) break;
            statement.setObject(i + 1, values[i]);
        }
    }


    /**
     * Will replace '(%s) with (?,?,?,?,?,...) depending on size to accommodate lists of parameters in an SQL query
     *
     * @param length length of list of placeholders to be prepared
     */
    public static String preparePlaceHolders( int length ) {
        StringBuilder builder = new StringBuilder( length * 2 - 1 );
        for ( int i = 0; i < length; i++ ) {
            if ( i > 0 ) builder.append( ',' );
            builder.append( '?' );
        }
        return builder.toString();
    }

    /**
     * Converts the given java.util.Date to java.sql.Date.
     * @param date The java.util.Date to be converted to java.sql.Date.
     * @return The converted java.sql.Date.
     */
    public static Date toSqlDate(java.util.Date date) {
        return (date != null) ? new Date(date.getTime()) : null;
    }

}