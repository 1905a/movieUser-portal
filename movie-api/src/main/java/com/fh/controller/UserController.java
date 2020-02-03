package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.DataTableResult;
import com.fh.model.User;
import com.fh.model.UserQuery;
import com.fh.service.UserService;
import com.fh.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("UserController")
public class UserController {

    @Autowired
    private UserService userService;


    //查询 UserController/selectUserList.do
    @RequestMapping("selectUserList")
    public ServerResponse selectUserList(UserQuery userQuery){
        DataTableResult dataTableResult = userService.selectUserList(userQuery);
        return ServerResponse.success(dataTableResult);
    }

    //图片  UserController/uploadPhoto.do
    @RequestMapping("uploadPhoto")
    public Map<String,Object> uploadPhoto(@RequestParam(value="photos") MultipartFile photos, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            //获取绝对路径
            String realPath = request.getServletContext().getRealPath("/images");
            //判断文件夹是否存在
            File file = new File(realPath);
            if(!file.exists()){
                file.mkdir();
            }
            //给上传的文件重命名(获取文件后缀   起名)
            String fileName = photos.getOriginalFilename();
            String houzhui = fileName.substring(fileName.lastIndexOf("."));

            String newFileName = UUID.randomUUID().toString() + houzhui;
            //上传
            photos.transferTo(new File(realPath + "/" + newFileName));

            map.put("success", true);
            map.put("filePath", "images/" + newFileName);

            System.out.println("images/" + newFileName);

        } catch (Exception e) {
            map.put("success",false);
            e.printStackTrace();
        }

        return map;
    }

    //添加 UserController/addUserOnOnePage.do
    @RequestMapping("addUserOnOnePage")
    public ServerResponse addUserOnOnePage(User user){
            userService.addUserOnOnePage(user);
        return ServerResponse.success();
    }


    //回显(通过id查询单条数据) UserController/toUpdateUserOnOnePage.do
    @RequestMapping("toUpdateUserOnOnePage")
    public ServerResponse toUpdateUserOnOnePage(Integer id){
        User user = userService.toUpdateUserOnOnePage(id);
        return ServerResponse.success(user);
    }

    //修改  /UserController/updateUserOnOnePage.do
    @RequestMapping("updateUserOnOnePage")
    public ServerResponse updateUserOnOnePage(User user){
        userService.updateUserOnOnePage(user);
        return ServerResponse.success();
    }


    //单个删除  UserController/deleteUser.do
    @RequestMapping("deleteUser")
    public ServerResponse deleteUser(Integer id,HttpServletRequest request){

        User oldUser = userService.toUpdateUserOnOnePage(id);
        if(StringUtils.isNoneBlank(oldUser.getFilePath())){
            FileUtil.deleteFile(request,oldUser.getFilePath());
        }
        userService.deleteUser(id);

        return ServerResponse.success();
    }

    //批量删除 UserController/batchDelete.do
    @RequestMapping("batchDelete")
    public ServerResponse batchDelete(String idList,HttpServletRequest request){
        String [] ids = idList.split(",");
        for(String  id: ids){
            User oldUser =  userService.toUpdateUserOnOnePage(Integer.parseInt(id));
            if(StringUtils.isNoneBlank(oldUser.getFilePath())){
                FileUtil.deleteFile(request,oldUser.getFilePath());
            }
            userService.deleteUser(Integer.parseInt(id));
        }
        return ServerResponse.success();
    }

}
