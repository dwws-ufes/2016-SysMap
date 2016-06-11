package br.ufes.inf.nemo.marvin.sysmap.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageRawResultService;
import br.ufes.inf.nemo.marvin.sysmap.domain.RawResult;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageRawResultController extends CrudController<RawResult> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageRawResultService manageRawResultService;
	
	@Override
	protected CrudService<RawResult> getCrudService() {
		return manageRawResultService;
	}

	@Override
	protected RawResult createNewEntity() {
		return new RawResult();
	}
	
	public ManageRawResultController() {
	    viewPath = "/core/manageRawResult/";
	    bundleName = "msgsSM";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
	}
	
	public void suggestDescription(){
		String title = this.selectedEntity.getTitle();
		if (title != null && title.length() > 3) {
			if(title.charAt(title.length()-1) != '.'){
				title += ".";
			}
			String query = 
					"PREFIX id:   <http://dblp.rkbexplorer.com/id/> " +
					"PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
					"PREFIX akt:  <http://www.aktors.org/ontology/portal#> " +
					"PREFIX owl:  <http://www.w3.org/2002/07/owl#> " +
					"PREFIX akt:  <http://www.aktors.org/ontology/portal#> " +
					"PREFIX akts: <http://www.aktors.org/ontology/support#> " +

					
					"SELECT ?year ?name ?title " +
					"WHERE {" +
					"  ?artigo akt:has-title \"" + title + "\" ." +
					"  ?artigo akt:has-date ?date . " +
					"  ?date akts:year-of ?year . " +
					"  ?artigo akt:has-author ?author ." +
					"  ?author akt:full-name ?name . " +
					"  ?artigo akt:article-of-journal ?venue ."+
					"  ?venue akt:has-title ?title ."+
					"}";
			QueryExecution queryExecution =
			QueryExecutionFactory.sparqlService("http://dblp.rkbexplorer.com/sparql", query);
			ResultSet results = queryExecution.execSelect();
			System.out.println("resultado?");
			String author = "";
			String authors = "";
			if (results.hasNext()) {
				System.out.println("tem resultado");
				QuerySolution querySolution = results.next();
				Literal name = querySolution.getLiteral("name");
				Literal year = querySolution.getLiteral("year");
				Literal venue = querySolution.getLiteral("title");

				author = name.getString();
				authors += author;
				System.out.println(author);
				this.selectedEntity.setYear(year.getLong());			
				this.selectedEntity.setVenue(venue.getString());			

				while(results.hasNext()){
					querySolution = results.next();
					name = querySolution.getLiteral("name");
					if(!name.getString().equals(author)){
						author = name.getString();
						authors = authors + "; " + author;
					}
				}				
				this.selectedEntity.setAuthors(authors);
			}
		}
	
	}
}
