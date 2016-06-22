package br.ufes.inf.nemo.marvin.sysmap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageSysMapService;
import br.ufes.inf.nemo.marvin.sysmap.domain.SysMap;
import br.ufes.inf.nemo.marvin.sysmap.persistence.SysMapDAO;

@WebServlet(urlPatterns = { "/core/manageSysMap" })
public class ListSysMapInRdfServlet extends HttpServlet {
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM- dd'T'HH:mm:ss");
	
	
	
	@EJB 
	private SysMapDAO sysMapDAO;
	
	@EJB 
	private ManageSysMapService manageSysMapService;
	
	@Inject 
	private ManageSysMapController manageSysMapController;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
	
	Long SM = Long.valueOf(req.getParameter("SM"));	
		
	resp.setContentType("text/xml");
	List<SysMap> maps = new ArrayList<SysMap>();
	maps.add(manageSysMapService.retrieve(SM));
	
	//List<SysMap> maps = sysMapDAO.retrieveAll();
	Model model = ModelFactory.createDefaultModel();
	String myNS = "http://localhost:8080/Marvin/core/manageSysMap";
	String grNS = "http://purl.org/goodrelations/v1#";
	model.setNsPrefix("gr", grNS);
	Resource grOffering = ResourceFactory.createResource(grNS + "SysMap");
	Property period = ResourceFactory.createProperty(grNS + "periodo");
	Property area = ResourceFactory.createProperty(grNS + "area");
	Property publication_types = ResourceFactory.createProperty(grNS + "publication");
	Property objective = ResourceFactory.createProperty(grNS + "objective");
	Property search_string = ResourceFactory.createProperty(grNS + "search_string");
	/*Resource grPriceSpecification = ResourceFactory.createResource(grNS +
	"PriceSpecification");
	Property gravailabilityStarts = ResourceFactory.createProperty(grNS +
	"availabilityStarts");
	Property gravailabilityEnds = ResourceFactory.createProperty(grNS +
	"availabilityEnds");
	Property grhasPriceSpecification = ResourceFactory.createProperty(grNS +
	"hasPriceSpecification");
	Property grhasCurrencyValue = ResourceFactory.createProperty(grNS +
	"hasCurrencyValue");*/
	for (SysMap map : maps) {
		model.createResource(myNS + "?SM=" + SM)
			.addProperty(RDF.type, grOffering)
			.addProperty(RDFS.label, map.getName())
			.addProperty(period, map.getPeriod())
			.addProperty(area, map.getArea())
			.addProperty(publication_types, map.getPublicationTypes())
			.addProperty(objective, map.getObjective())
			.addProperty(search_string, map.getSearchString());
		/*.addProperty(RDFS.comment, map.getDescription())
		.addLiteral(gravailabilityStarts,
		ResourceFactory.createTypedLiteral(df.format(map.getBegin()),
		XSDDatatype.XSDdateTime))
		.addLiteral(gravailabilityEnds,
		ResourceFactory.createTypedLiteral(df.format(map.getEnd()),
		XSDDatatype.XSDdateTime))
		.addProperty(grhasPriceSpecification, model.createResource()
		.addProperty(RDF.type, grPriceSpecification)
		.addLiteral(grhasCurrencyValue, map.getPrice().floatValue()));*/
	}
		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
}
