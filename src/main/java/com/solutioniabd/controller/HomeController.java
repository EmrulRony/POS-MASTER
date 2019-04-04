package com.solutioniabd.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class HomeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String customerManagementBtn() {
		return "customer_management";
	}
}
