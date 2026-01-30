package com.adorno.modelo.mappers;

public interface MyMapper<T, S> {
	public T map(S s);
}
