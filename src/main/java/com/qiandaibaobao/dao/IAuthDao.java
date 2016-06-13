package com.qiandaibaobao.dao;

import com.qiandaibaobao.pojo.User;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public interface IAuthDao {
    User findUserById(int id);
}
