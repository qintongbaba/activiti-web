package org.wuqinghua.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wuqinghua.service.LoginService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImpl implements LoginService {

	@Override
	public boolean login(String name) {
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(name, "123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}

}
