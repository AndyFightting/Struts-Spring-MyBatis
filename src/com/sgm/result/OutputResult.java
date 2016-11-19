package com.sgm.result;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.sgm.util.CommonUtil;


public class OutputResult implements Result {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(OutputResult.class);
	
	private String contentType;
	private String encoding;

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		
		HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
        
        ValueStack vs = invocation.getStack();
        
        String code = invocation.getResultCode();

    	LOG.debug("Output String [" + code + "]");
        
        response.setContentType(contentType + ";charset=" + encoding);
        response.setContentLength(code.getBytes(encoding).length);
        PrintWriter out = response.getWriter();
        out.print(code);
	}

	public String getContentType() {
		return CommonUtil.isEmpty(contentType) ? "text/html" : contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getEncoding() {
		return CommonUtil.isEmpty(encoding) ? CharEncoding.UTF_8 : encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

}
