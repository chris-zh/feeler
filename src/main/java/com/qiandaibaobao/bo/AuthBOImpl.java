package com.qiandaibaobao.bo;

import com.qiandaibaobao.dao.IAuthDao;
import com.qiandaibaobao.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
@Service
public class AuthBOImpl implements IAuthBO {
    @Resource
    IAuthDao dao;
    public User findUserById(int id) {
        return null;
    }
}
