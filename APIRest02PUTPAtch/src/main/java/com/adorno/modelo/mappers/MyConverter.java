package com.adorno.modelo.mappers;

public interface MyConverter <T,S>{
	public void convert(T t, S s);
}
