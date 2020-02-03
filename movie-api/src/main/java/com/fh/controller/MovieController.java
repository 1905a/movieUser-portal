package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.*;
import com.fh.service.MovieService;
import com.fh.util.AliyunSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("MovieController")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @RequestMapping("queryMovieList")
    public ServerResponse queryMovieList(MovieQuery movieQuery){
        DataTableResult dataTableResult = movieService.queryMovieList(movieQuery);
        return ServerResponse.success(dataTableResult);
    }
    
    
    @RequestMapping("selectTypeList")
    public ServerResponse selectTypeList(){
        List<Type> typeList= movieService.selectTypeList();
        return ServerResponse.success(typeList);
    }

    @RequestMapping("selectAreaList")
    public ServerResponse selectAreaList(){
        List<Area> typeList= movieService.selectAreaList();
        return ServerResponse.success(typeList);
    }

    @RequestMapping("addMovie")
    public ServerResponse addMovie(Movie movie){

        MovieArea movieArea = new MovieArea();
        movieArea.setMovieId(movie.getId());
        movieArea.setAreaId(movie.getAreaId());
        movieService.addMovieAreaRelation(movieArea);


        MovieType movieType = new MovieType();
        movieType.setMovieId(movie.getId());
        movieType.setTypeId(movie.getTypeId());
        movieService.addMovieTypeRelation(movieType);

        movieService.addMovie(movie);
        return ServerResponse.success();
    }

    @RequestMapping("toUpdateMovie")
    public ServerResponse toUpdateMovie(Integer id){
        Movie movie =movieService.toUpdateMovie(id);
        return ServerResponse.success(movie);
    }

    @RequestMapping("updateMovie")
    public ServerResponse updateMovie(Movie movie){
        movieService.updateMovie(movie);


        movieService.deleteMovieArea(movie.getId());

        MovieArea movieArea = new MovieArea();
        movieArea.setMovieId(movie.getId());
        movieArea.setAreaId(movie.getAreaId());
        movieService.addMovieAreaRelation(movieArea);


        movieService.deleteMovieType(movie.getId());


        MovieType movieType = new MovieType();
        movieType.setMovieId(movie.getId());
        movieType.setTypeId(movie.getTypeId());
        movieService.addMovieTypeRelation(movieType);


        return ServerResponse.success();
    }


    @RequestMapping("deleteMovie")
    public ServerResponse deleteMovie(Integer id){
        movieService.deleteMovie(id);

        return ServerResponse.success();
    }

    @RequestMapping("batchDeleteMovie")
    public ServerResponse batchDeleteDrug(@RequestParam("idArr[]")String idArr) {

        String[] ids = idArr.split(",");
        for (String id : ids) {
            movieService.deleteMovie(Integer.parseInt(id));
        }
        return ServerResponse.success();
    }

    //上传商品图片
    @RequestMapping("uploadFile")
    public Map<String,Object> uploadFile(@RequestParam("addPhoto") MultipartFile file, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        try {

            String originalFileName = file.getOriginalFilename();
            String url = AliyunSmsUtil.uploadFile(file.getInputStream(), originalFileName, "images");
            result.put("filePath",url);
            result.put("code",200);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code",500);
        }
        return result;
    }

}


