package com.qiandaibaobao.bo;

import com.qiandaibaobao.dao.UserDAO;
import com.qiandaibaobao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2016/6/13 0013.
 */
@Service
public class AuthBOImpl implements IAuthBO {
    @Autowired
    private UserDAO dao;
    public User fetchUserByNameAndPassword(User user){
        return dao.fetchUserByNameAndPassword(user);
    }
}
