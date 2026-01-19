package com.adorno.services;

import org.springframework.stereotype.Service;

//Esto se declara aqui con una anotacion para que lo reconozca Spring
@Service
public class UserService {
	private int users=5;

	public int getNumUsers() {
		return users++;
	}
}
