package com.qiandaibaobao.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class LoginBO implements AuthService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User login(String username, String passwd) {
		
		StringBuilder sql = new StringBuilder();
//		sql.append(" INSERT INTO USERS(NAME, PASSWORD) VALUES ('chris','123') ");
//		sql.append("create table users(name text,password text)");
		sql.append("select name,password from users where name = ? ");
		User user = jdbcTemplate.query(sql.toString(),
						new Object[] { "chris" },
						(rs, rowNum) -> new User(rs.getString("name"), rs.getString("password"))).get(0);
//		jdbcTemplate.execute(sql.toString());
//		jdbcTemplate.execute(sql.toString());
//		makeDB();

        return user;
	}
	private void makeDB(){
		StringBuilder sql = new StringBuilder();
		sql.append("create table users(name text,password text)");
		jdbcTemplate.execute(sql.toString());
	}
}
