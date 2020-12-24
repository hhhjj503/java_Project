package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingfilter implements Filter {

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("before Filter");
		request.setCharacterEncoding("UTF-8"); //filter 를 거치기 전에 할작업
		response.setCharacterEncoding("UTF-8"); //filter를 거친후 할 작업
		response.setContentType("text/html; charset=UTF-8");
		chain.doFilter(request, response); //기본 filter 가 끝난후 이어서 또 할 Filter 작업
		System.out.println("after Filter");
	}

}
