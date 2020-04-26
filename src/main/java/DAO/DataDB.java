package DAO;
import java.util.ArrayList;
import java.util.Map;

public interface DataDB {

    /**
     * Given a sql query its param it will return a String with the first value.
     * @param sql query with params
     * @param values params concatenated by "|"
     * @return The first value of the query.
     * @throws DAOException
     */
    String find (String sql, String... values) throws DAOException;
    /**
     * Given a sql query with its params it will return a Map with the name of the column
     * and the value of the one Row from the query.
     * @param sql query with params
     * @param values params concatenated by "|"
     * @return The a row of the query in a Map.
     * @throws DAOException
     */
    Map<String, String> search(String sql, String... values) throws DAOException;

    /**
     * Given a sql query it will return all registers in an ArrayList of a String Collection.
     * @param sql query with params
     * @param values params concatenated by "|"
     * @return An ArraList<String[]> of all values.
     * @throws DAOException
     */
    ArrayList<String[]> list(String sql, String... values) throws DAOException;

    /**
     * This method is a merged between find and list.
     * Given a SQL query it will return all values of the first column found in an ArrayList
     * @param sql
     * @param values
     * @return
     * @throws DAOException
     */
    ArrayList<String> findList(String sql, String... values) throws DAOException;

    int update(String sql, String... values) throws IllegalArgumentException, DAOException;

    int merge(String sql, String... values) throws  IllegalArgumentException, DAOException;

    long insert(String sql, String... values) throws IllegalArgumentException, DAOException;
}
