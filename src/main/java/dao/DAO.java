package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;

import util.ConnectionDatabase;

public class DAO {
	
	public DAO() {
	}

	private Connection conn;
	
	public void close() {
		try {
			getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	private Connection getConn() throws SQLException {
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ConnectionDatabase.getConnection();
	}
	
	public int include(String dml, Object... objects) {
		try (PreparedStatement ps = getConn().prepareStatement(dml,
				Statement.RETURN_GENERATED_KEYS)) {
			setAttributes(ps, objects);
			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void setAttributes(PreparedStatement ps, Object... attributes)
			throws SQLException {
		int index = 1;
		for (Object attribute : attributes) {
			switch (attribute) {
				case Short s -> ps.setShort(index, s);
				case Integer i -> ps.setInt(index, i);
				case Long l -> ps.setLong(index, l);
				case String str -> ps.setString(index, str);
				case Character c -> ps.setString(index, String.valueOf(c));
				case Float f -> ps.setFloat(index, f);
				case Double d -> ps.setDouble(index, d);
				case BigDecimal bd -> ps.setBigDecimal(index, bd);
				case Date dt -> ps.setDate(index, dt);
				case LocalDate ld -> ps.setDate(index, Date.valueOf(ld));
				case LocalDateTime ldt -> ps.setTimestamp(index, Timestamp.valueOf(ldt));
				case null -> ps.setNull(index, Types.NULL);
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + attribute);
			}
			index++;
		}
	}
	
}
