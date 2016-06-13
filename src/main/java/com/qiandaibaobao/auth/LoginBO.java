package com.qiandaibaobao.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class LoginBO implements AuthService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User login(String username, String passwd) {
		String sql = "select name,password from user where name = ? and password = ? ";
        User user =  null;
        try {
            jdbcTemplate.queryForObject(sql, new Object[]{username, passwd},User.class);
        }catch (DataAccessException e){
            System.out.println("e = " + e.getMessage());
        }
        return user;
	}

    @Override
    public void register(String username, String password) {
        String sql = "insert into user (name, password) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{username, password});
    }

    private void makeDB(){

	}
}
