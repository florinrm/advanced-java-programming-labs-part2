package com.luxoft.bankapp.domain;

import java.io.Serializable;

public class Currency implements Serializable {
	private String code;
	private String country;

	public Currency (String code) {
       this.code = code;
    }

    public String getCode() {
	    return code;
	}
    
    public String getCountry() {
		return country;
	}
    
    public void setCode(String code) {
		this.code = code;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
