package com.qiandaibaobao.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginBO implements AuthService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User login(String username, String passwd) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select T.EMP_NAME user_name ,T.ROLE passwd from EBAO_TP_STAFF T where T.EMP_NAME = ? ");
		User user = jdbcTemplate.query(sql.toString(),
						new Object[] { "Ğì¿ªÇÚ" },
						(rs, rowNum) -> new User(rs.getString("user_name"), rs.getString("passwd"))).get(0);
		return user;
	}
}
