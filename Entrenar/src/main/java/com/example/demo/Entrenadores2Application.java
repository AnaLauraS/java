package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Entrenadores2Application {
	private static void cargarBD(){
		Connection connection = null;
		try{
			Class.forName("org.h2.Driver").newInstance();
			connection= DriverManager.getConnection("jdbc:h2:~/entrenadores;INIT=RUNSCRIPT FROM 'create.sql'","sa","");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				connection.close();
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		cargarBD();
		SpringApplication.run(Entrenadores2Application.class, args);
	}

}
