package com.upaxer.serverless.IServiceDao;


import com.upaxer.serverless.entity.UserLogin;
import com.upaxer.serverless.models.RequestModel;

public interface IDaoHttp {

	public String Auth(UserLogin user)throws Exception;


	public String Conv_What_nat_templ(String requestJson) throws Exception;
}
