package com.fh.service.impl;

import com.fh.code.ServerResponse;
import com.fh.mapper.MovieMapper;
import com.fh.model.*;
import com.fh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public DataTableResult queryMovieList(MovieQuery movieQuery) {
        Long movieLong = movieMapper.selectMovieListCount(movieQuery);

        List<Movie> movieList = movieMapper.selectMovieList(movieQuery);

        DataTableResult dataTableResult = new DataTableResult(movieQuery.getDraw(),movieLong,movieLong,movieList);

        return dataTableResult;
    }

    @Override
    public void addMovie(Movie movie) {
        movie.setCreateTime(new Date());
        movieMapper.addMovie(movie);
    }

    @Override
    public Movie toUpdateMovie(Integer id) {
        return movieMapper.toUpdateMovie(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        movie.setUpdateTime(new Date());
        movieMapper.updateMovie(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieMapper.deleteMovie(id);
    }

    @Override
    public List<Type> selectTypeList() {
        return movieMapper.selectTypeList();
    }

    @Override
    public List<Area> selectAreaList() {
        return movieMapper.selectAreaList();
    }

    @Override
    public void addMovieAreaRelation(MovieArea movieArea) {
        movieMapper.addMovieAreaRelation(movieArea);
    }

    @Override
    public void addMovieTypeRelation(MovieType movieType) {
        movieMapper.addMovieTypeRelation(movieType);
    }

    @Override
    public void deleteMovieArea(Integer id) {
        movieMapper.deleteMovieArea(id);
    }

    @Override
    public void deleteMovieType(Integer id) {
        movieMapper.deleteMovieType(id);
    }
}
