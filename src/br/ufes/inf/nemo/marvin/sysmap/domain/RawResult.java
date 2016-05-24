package br.ufes.inf.nemo.marvin.sysmap.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class RawResult extends PersistentObjectSupport implements Comparable<RawResult> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The source of the publication */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String source;
	
	/** The year of the publication */
	@Basic
	@NotNull
	protected Long year;
	
	/** The title of the publication */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String title;
	
	/** The authors of the publication */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String authors;

	/** The venue of the publication */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String venue;	
	
	/** The Digital Object Identifier of the publication */
	@Basic
	@Size(max = 100)
	protected String DOI;	
	
	/** The abstract of the publication */
	@Lob
	protected String publicationAbstract;
	
	/** The keywords of the publication */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String keywords;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getDOI() {
		return DOI;
	}

	public void setDOI(String dOI) {
		DOI = dOI;
	}

	public String getPublicationAbstract() {
		return publicationAbstract;
	}

	public void setPublicationAbstract(String publicationAbstract) {
		this.publicationAbstract = publicationAbstract;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	@Override
	public int compareTo(RawResult o) {
		return uuid.compareTo(o.uuid);
	}
}
