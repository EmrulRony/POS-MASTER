package com.solutioniabd.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ValidationView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String text;
    private String description;
    private Integer integer;
    private Double doubleNumber;
    private Double money;
    private String regexText;
    private Date date;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
 
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
 
    public Integer getInteger() {
        return integer;
    }
    public void setInteger(Integer integer) {
        this.integer = integer;
    }
 
    public Double getDoubleNumber() {
        return doubleNumber;
    }
    public void setDoubleNumber(Double doubleNumber) {
        this.doubleNumber = doubleNumber;
    }
 
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
 
    public String getRegexText() {
        return regexText;
    }
    public void setRegexText(String regexText) {
        this.regexText = regexText;
    }
 
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    } 

}
