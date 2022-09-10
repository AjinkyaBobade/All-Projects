package com.StockNews.blog.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourcenotFoundException extends RuntimeException{

	String resourceName;
	
	String fieldName;
	
	long fieldValue;

	public ResourcenotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with :%1",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
}
