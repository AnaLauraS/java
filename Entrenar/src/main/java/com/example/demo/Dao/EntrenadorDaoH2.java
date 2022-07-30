package com.example.demo.Dao;

import com.example.demo.Model.Entrenador;
import org.springframework.context.annotation.Bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDaoH2 implements IDao<Entrenador>{

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/Entrenadores","sa","");
    }

    @Override
    public List<Entrenador> listarEntrenadores() {

        Connection connection = null;
        List<Entrenador> listaEntrenadores = new ArrayList<>();
        try{

            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM entrenadores");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Entrenador entrenador = new Entrenador(rs.getLong("id"),rs.getString("nombre"));
                listaEntrenadores.add(entrenador);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listaEntrenadores;
    }
}
