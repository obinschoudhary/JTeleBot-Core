/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package com.roadtonerdvana.jtelebot.mapper.json;


import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;



public enum MapperHandler {
	INSTANCE;
	
	private ObjectMapper objectMapper;
	
	private MapperHandler(){
		initMapper();
	}
	
	private void initMapper(){
		objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	}
	
	public ObjectMapper getObjectMapper(){
		if(objectMapper==null){
			initMapper();
		}
		return objectMapper;
	}

}
