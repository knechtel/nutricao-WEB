package br.com;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;




@RequestScoped
@Named("editor")
public class EditorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String value = "This editor is provided by PrimeFaces";

	
	private String test;

	
	
	public EditorBean() {

	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}





	public String getTest() {
		return "fir ";
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}