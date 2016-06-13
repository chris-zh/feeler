package com.qiandaibaobao.auth;

import com.mysql.jdbc.log.LogFactory;
import com.qiandaibaobao.util.Utils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class LoginBO implements AuthService {

    private static Logger logger = Logger.getLogger(LoginBO.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User login(String username, String passwd) {
		String sql = "select name,password from user where name = ? and password = ? ";
        User user =  null;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{username, passwd},User.class);
        }catch (DataAccessException e){
            logger.error(Utils.utf8String("查询失败"), e);
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
