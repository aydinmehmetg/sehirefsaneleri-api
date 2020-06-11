package com.sehirefsaneleri.ws.error;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.sehirefsaneleri.ws.shared.Views.Base;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)                 //buradaki olay jackson gelip response olarak bişey döneceği zaman null olanları dönmüyor
public class ApiError {
	@JsonView(Base.class)
	private int status;
	@JsonView(Base.class)
	private String message;
	@JsonView(Base.class)
	private String path;
	@JsonView(Base.class)
	private long timestamp = new Date().getTime();
	
	private Map<String,String> validationErros;

	public ApiError(int status,String message,String path) {
		
		this.status =status;
		this.message=message;
		this.path =path;
	}
}
