package com.hms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID=1L;
	
	private String resourceName;
	private String filedName;
	private Object fieldValue;
	private String name;
	
	public ResourceNotFoundException(String resourceName,String filedName,Object fieldValue) {
		super(String.format("%s not found with %s : '%s'",resourceName,filedName,fieldValue));
		this.resourceName=resourceName;
		this.filedName=filedName;
		this.fieldValue=fieldValue;
	}
	public ResourceNotFoundException(String name) {
		super(String.format("%s",name));
		this.name=name;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFiledName() {
		return filedName;
	}
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
