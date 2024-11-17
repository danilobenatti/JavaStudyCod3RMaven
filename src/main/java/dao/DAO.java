package dao;

import static java.sql.Date.valueOf;
import static java.sql.Timestamp.valueOf;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jdbc.ConnectionFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DAO {
	
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
	
	private Connection getConn() {
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ConnectionFactory.getConnection();
	}
	
	public int include(String sql, Object... objects) {
		try (PreparedStatement ps = getConn().prepareStatement(sql,
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
			throw new RuntimeException();
		}
	}
	
	public static void setAttributes(PreparedStatement ps, Object... attributes)
			throws SQLException {
		int index = 1;
		for (Object obj : attributes) {
			switch (obj) {
				case Integer i -> ps.setInt(index, i);
				case Long l -> ps.setLong(index, l);
				case String s -> ps.setString(index, s);
				case Character c -> ps.setString(index, String.valueOf(c));
				case Float f -> ps.setFloat(index, f);
				case Double d -> ps.setDouble(index, d);
				case Date dt -> ps.setDate(index, dt);
				case LocalDate ld -> ps.setDate(index, valueOf(ld));
				case LocalDateTime ldt -> ps.setTimestamp(index, valueOf(ldt));
				case null -> ps.setNull(index, Types.NULL);
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + obj);
			}
			index++;
		}
	}
	
}
