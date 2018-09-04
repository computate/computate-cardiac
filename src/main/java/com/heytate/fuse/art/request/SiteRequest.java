package com.heytate.fuse.art.request;

import java.io.PrintWriter;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteRequest {

	/////////////////
	// siteRequest //
	/////////////////
	public SiteRequest siteRequest;
	protected void siteRequestInitialize() throws Exception {
		this.siteRequest = this;
	}

	//////////////
	// xmlStack //
	//////////////
	public Stack<String> xmlStack = new Stack<String>();
	protected void xmlStackInitialize() throws Exception {
	}

	/////////////
	// request //
	/////////////
	public HttpServletRequest request;
	protected void requestInitialize() throws Exception {
	}

	//////////////
	// response //
	//////////////
	public HttpServletResponse response;
	protected void responseInitialize() throws Exception {
	}

	////////////
	// writer //
	////////////
	public PrintWriter writer;
	protected void writerInitialize() throws Exception {
		if(response != null) {
			response.setCharacterEncoding("UTF-8");
			this.writer = response.getWriter();
		}
	}

	public void siteRequestSiteRequest(SiteRequest siteRequest) throws Exception {
	}

	public void initializeDeepSiteRequest(SiteRequest siteRequest) throws Exception {
		siteRequestSiteRequest(siteRequest);
		initializeDeepSiteRequest();
	}
	public void initializeDeepSiteRequest() throws Exception {
		siteRequestInitialize();
		xmlStackInitialize();
		requestInitialize();
		responseInitialize();
		writerInitialize();
	}

	public void initializeDeepForClass(SiteRequest siteRequest) throws Exception {
		initializeDeepSiteRequest(siteRequest);
	}

	public SiteRequest getSiteRequest() {
		return siteRequest;
	}

	public void setSiteRequest(SiteRequest siteRequest) {
		this.siteRequest = siteRequest;
	}
}
