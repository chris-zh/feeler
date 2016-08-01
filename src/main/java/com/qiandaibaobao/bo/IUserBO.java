package com.qiandaibaobao.bo;

import com.qiandaibaobao.pojo.User;


public interface IUserBO {
    /**
     * 查询User
     * @param userName
     * @param password
     * @return
     */
    User user(String userName, String password);
    User user(int id);
    boolean register(String userName, String password);
    void changePassword(String userName, String password);
//    boolean saveAvatar(int id, String avatar, String projectPath);

}
