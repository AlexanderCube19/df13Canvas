package com.force.aus.erp.canvas.servlets;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.force.aus.erp.canvas.listeners.EMFListener;

public class SimpleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5176898343732039432L;
	private Logger logger;
	@Resource //TODO figure out how to inject this from web.xml configuration?
	private EntityManager em;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		em = EMFListener.createEntityManager();
		logger = LoggerFactory.getLogger(this.getClass());
		logger.info("We have called out to the Simple Servlet {}", new Date());
		resp.getWriter().write("We have a servlet running.");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}
	
	
	
}
