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

import net.arnx.jsonic.JSON;


public class OutJSONResult implements Result {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(OutJSONResult.class);
	
	private String contentType;
	private String encoding;
	private String value;

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);
       
        ValueStack vs = invocation.getStack();
        
        if (null == value) {
        	return;
        }
    	
        Object o = vs.findValue(value);
        
        if (null == o) {
        	LOG.debug("value [" + value + "] is null in ValueStack. ");
        }
        
        String json = JSON.encode(o, false);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("[JSON]\n" + JSON.encode(o, true));
        }
        
        response.setContentType(contentType + ";charset=" + encoding);
        response.setContentLength(json.getBytes(encoding).length);
        PrintWriter out = response.getWriter();
        out.print(json);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getContentType() {
		return CommonUtil.isEmpty(contentType) ? "application/json" : contentType;
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
