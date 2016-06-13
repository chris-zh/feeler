package com.qiandaibaobao.auth;

public interface AuthService {
	User login(String username, String password);
	void register(String username, String password);
}
