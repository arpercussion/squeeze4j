package com.obscured.squeeze4j.api;

import org.junit.Ignore;
import org.junit.Test;
import org.sqlite.Function;

import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.util.regex.Pattern;

@Ignore
public class SlimServerDBTest {

	@Test
	public void sqlite() {
		Connection conn = null;
		try {
			Instant start = Instant.now();

			String url = "jdbc:sqlite:/Users/aromano/temp/library.db";
			//DriverManager.registerDriver(new org.sqlite.JDBC());
			conn = DriverManager.getConnection(url);

			// CREATE FUNCTION
			Function.create(conn, "REGEXP", new Function() {
				@Override
				protected void xFunc() throws SQLException {
					String expression = value_text(0);
					String value = value_text(1);
					if (value == null) {
						value = "";
					}
					Pattern pattern = Pattern.compile(expression);
					result(pattern.matcher(value).find() ? 1 : 0);
				}
			});

			String sql = "SELECT * FROM tracks" +
			             " WHERE audio = 1" +
			             " AND tracks.title REGEXP 'Abattoir'" +
			             " ORDER by titlesort;";
//			PreparedStatement pstmt  = conn.prepareStatement(sql);

//			pstmt.setString(1, "%Justice%");

			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);

			Duration duration = Duration.between(start, Instant.now());
			System.out.println("OPERATION TOOK " + duration.toMillis());

			// loop through the result set
			int count = 0;
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("TITLE: " + rs.getString("title"));
				System.out.println("URL: " + rs.getString("url"));
				System.out.println("------------------------");
				count += 1;
			}
			System.out.println(count);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Opened database successfully");
	}
}
