package dataBaseDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static dataBaseDAO.DAOUtil.prepareStatement;
import static java.lang.String.valueOf;

public class DataDBimpl implements DataDB{

	private DAOFactory daoFactory;

	/**
	 * Constructor
	 *
	 */
	public DataDBimpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

    @Override
	public String find(String sql, String... values) throws DAOException {
		String result = null;
		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, false, concateList(values));
				ResultSet resultSet = statement.executeQuery()
		) {
			if (resultSet.next()) {
				result = resultSet.getString(1);
			}
		} catch (SQLException e) {
			throw new DAOException( e.getMessage() + e.getCause());
		}
		return result;
	}

	@Override
	public Map search(String sql, String... values) throws DAOException {
		Map<String, String> result = new HashMap<>();
		ResultSetMetaData rsmd;
		String nameColumn;
		String value;
		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, false, concateList(values));
				ResultSet resultSet = statement.executeQuery()
		) {
			rsmd = resultSet.getMetaData();
			resultSet.next();
			for (int j = 1; j <= rsmd.getColumnCount(); j++) {
				nameColumn = rsmd.getColumnName(j);
				value = resultSet.getString(j);
				result.put(nameColumn, value);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return result;
	}


	@Override
	public ArrayList<String[]> list(String sql, String... values) throws DAOException {
		ArrayList<String[]> result = new ArrayList<>();
		String[] row;
		ResultSetMetaData rsmd;

		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, false, concateList(values));
				ResultSet resultSet = statement.executeQuery()
		) {
			rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			row = new String[columnCount];

			for (int i = 1; i<= columnCount; i++){
				row[i - 1] = rsmd.getColumnName(i);
			}
			result.add(row);

			while (resultSet.next()) {
				row = new String[columnCount];
				for (int j = 1; j <= columnCount; j++) {
					row[j-1] = resultSet.getString(j);
				}
				result.add(row);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return result;
	}
	
	@Override
	public ArrayList<String> findList(String sql, String... values) throws DAOException {
		ArrayList<String> list = new ArrayList<String>();
		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, false, concateList(values));
				ResultSet resultSet = statement.executeQuery()
		) {

			while(resultSet.next()){
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public int update(String sql, String... values) throws IllegalArgumentException, DAOException {
		int affectedRows;
		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, false, concateList(values));
		) {
			affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Updating user failed, no rows affected.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return affectedRows;
	}

	@Override
	public int merge(String sql, String... values) throws IllegalArgumentException, DAOException {
		int affectedRows;
		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, false, concateList(values));
		) {
			affectedRows = statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return affectedRows;
	}

	@Override
	public long insert(String sql, String... values) throws IllegalArgumentException, DAOException {
		Long generatedKey;
		sql = "BEGIN " + sql + "; END;";
		try (
				Connection connection = daoFactory.getConnection();
				CallableStatement statement = connection.prepareCall(sql)
		) {
			int i = 1;
			for (Object value : values){
				statement.setObject(i++, value);
			}
			statement.registerOutParameter(i, Types.NUMERIC);
			statement.execute();
			generatedKey = statement.getLong(i);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return generatedKey;
	}

	private String concateList(String... values){
		String result = "";
        int i = 0;
		for (Object value : values) {
			result = result.concat(valueOf(value) + "|");
		}
		return result;
	}
}
