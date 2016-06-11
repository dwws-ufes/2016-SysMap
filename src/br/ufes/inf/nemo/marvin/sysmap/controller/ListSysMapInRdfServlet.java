package br.ufes.inf.nemo.marvin.sysmap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.ufes.inf.nemo.marvin.sysmap.persistence.SysMapDAO;

@WebServlet(urlPatterns = { "/core/manageSysMap" })
public class ListSysMapInRdfServlet extends HttpServlet {
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM- dd'T'HH:mm:ss");
	
	@EJB 
	private SysMapDAO sysMapDAO;
}
