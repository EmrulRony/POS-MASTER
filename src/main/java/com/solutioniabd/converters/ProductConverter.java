package com.solutioniabd.converters;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import com.solutioniabd.controller.ProductController;
import com.solutioniabd.entity.Product;

//@FacesConverter("productConverter")
@Named
@RequestScoped
public class ProductConverter implements Converter {
	@Inject
	private ProductController service;

//	@Override
//	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
//		if (value != null && value.trim().length() > 0) {
//
//			try {
//				ProductController service = (ProductController) fc.getExternalContext().getApplicationMap()
//						.get("productController");
//
//				return service.getProductList().get(Integer.parseInt(value));
//			} catch (NumberFormatException e) {
//				throw new ConverterException(
//						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
//			}
//		} else {
//			return null;
//		}
//
//	}
	
	public ProductController getService() {
		return service;
	}

	public void setService(ProductController service) {
		this.service = service;
	}

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		for (Product product: service.getProductList()){
			if (Integer.toString(product.getProductId()).equals(value)) {
				return product;
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
//		if (object != null) {
//			return String.valueOf(((Product) object).getProductId());
//		} else {
//			return null;
//		}
		
		if (object instanceof Product) {
			Product product = (Product) object;
			
			return Integer.toString(product.getProductId());
		}
		return " ";
	}
	

}
