package com.iudigital.mavenproject2.dao;

import com.iudigital.mavenproject2.domain.Genre;
import com.iudigital.mavenproject2.util.ConnectionConfig;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreDao {
    
    private static final String GET_GENRES = "select * from genre";
    
    public List<Genre> getGenres() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Genre> genres = new ArrayList<>();
        
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_GENRES);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setGereId(resultSet.getInt("genre_id"));
                genre.setName(resultSet.getString("name"));
                genres.add(genre);
            }
            return genres;
            
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }      
    }
}
