package com.fh.mapper;

import com.fh.model.*;

import java.util.List;

public interface MovieMapper {
    Long selectMovieListCount(MovieQuery movieQuery);

    List<Movie> selectMovieList(MovieQuery movieQuery);

    void addMovie(Movie movie);

    Movie toUpdateMovie(Integer id);

    void updateMovie(Movie movie);

    void deleteMovie(Integer id);

    List<Type> selectTypeList();

    List<Area> selectAreaList();

    void addMovieAreaRelation(MovieArea movieArea);

    void addMovieTypeRelation(MovieType movieType);

    void deleteMovieArea(Integer id);

    void deleteMovieType(Integer id);
}
