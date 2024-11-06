package com.iudigital.mavenproject2.controller;

import com.iudigital.mavenproject2.dao.GenreDao;
import com.iudigital.mavenproject2.domain.Genre;
import java.sql.SQLException;
import java.util.List;

public class GenreController {
    
    private GenreDao genreDao;
    
    public GenreController() {
        genreDao = new GenreDao();
    }
    
    public List<Genre> getGenres() throws SQLException {
        return genreDao.getGenres();
    }
}
