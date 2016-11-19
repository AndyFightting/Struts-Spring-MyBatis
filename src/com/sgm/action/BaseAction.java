package com.sgm.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.sgm.service.ServiceProvider;

//通过serviceProvider对象获取不同的 service, serviceProvider也是通过Spring配置文件注入
// 必须要有set方法，Spring注入要用
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//用来放jps错误信息提示的
	public Map<String, String> errMap = new HashMap<String, String>();
	//用于api返回值
	protected Map<String, Object> result=new HashMap<String , Object>();
	
	private ServiceProvider serviceProvider;

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Map<String, String> getErrMap() {
		return errMap;
	}

	public void setErrMap(Map<String, String> errMap) {
		this.errMap = errMap;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
