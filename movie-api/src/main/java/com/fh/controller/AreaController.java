package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.*;
import com.fh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("AreaController")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("queryAreaList")
    public ServerResponse queryAreaList(AreaQuery areaQuery){
        DataTableResult dataTableResult = areaService.queryAreaList(areaQuery);
        return ServerResponse.success(dataTableResult);
    }

    @RequestMapping("addArea")
    public ServerResponse addArea(Area area) {
        area.setCreateTime(new Date());
        areaService.addArea(area);
        return ServerResponse.success();
    }

    @RequestMapping("toUpdateArea")
    public ServerResponse toUpdateArea(Integer id) {
        Area area = areaService.toUpdateArea(id);
        return ServerResponse.success(area);
    }

    @RequestMapping("updateArea")
    public ServerResponse updateArea(Area area) {
        area.setUpdateTime(new Date());
        areaService.updateArea(area);
        return ServerResponse.success();
    }

    @RequestMapping("deleteArea")
    public ServerResponse deleteArea(Integer id) {
        areaService.deleteArea(id);
        return ServerResponse.success();
    }

    @RequestMapping("batchDeleteArea")
    public ServerResponse batchDeleteArea(@RequestParam("idArr[]")String idArr) {

        String[] ids = idArr.split(",");
        for (String id : ids) {
            areaService.deleteArea(Integer.parseInt(id));
        }
        return ServerResponse.success();
    }
}
