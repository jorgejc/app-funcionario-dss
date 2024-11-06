package com.iudigital.mavenproject2.dao;

import com.iudigital.mavenproject2.domain.Movie;
import com.iudigital.mavenproject2.util.ConnectionConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
   
    private static final String GET_MOVIES = "select movie.*, genre.name "
            + "from movie "
            + "inner join genre on movie.genre_id = genre.genre_id";
    private static final String CREATE_MOVIES = "insert into movie(titulo, anio, actor,"
            + "genre_id, fecha_creacion) values(?, ?, ?, ?, ?)";
    private static final String GET_MOVIE_BY_ID = "select movie.*, genre.name "
            + "from movie "
            + "inner join genre on movie.genre_id = genre.genre_id "
            + "where movie.movie_id = ?";
    private static final String UPDATE_MOVIE = "update movie set titulo = ? , anio = ?, "
            + "actor = ?, genre_id  = ?, fecha_creacion = ? where movie_id = ?";
    
    private static final String DELETE_MOVIE = "delete from movie where movie_id = ?";
    
    
        public List<Movie> getMovies() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movies = new ArrayList<>();
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_MOVIES);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovieId(resultSet.getInt("movie_id"));
                movie.setTitle(resultSet.getString("titulo"));
                movie.setYear(resultSet.getString("anio"));
                movie.setActor(resultSet.getString("actor"));
                movie.setGenre(resultSet.getString("genre_id"));
                movie.setGenreName(resultSet.getString("genre.name"));
                movie.setCreatedAt(resultSet.getObject("fecha_creacion", LocalDateTime.class));
                movies.add(movie);
            }
            return movies;
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
