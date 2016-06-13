package com.qiandaibaobao.bo;

import com.qiandaibaobao.pojo.User;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public interface IAuthBO {
    User findUserById(int id);
}
