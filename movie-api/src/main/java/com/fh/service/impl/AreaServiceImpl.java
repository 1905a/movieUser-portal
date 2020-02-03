package com.fh.service.impl;

import com.fh.mapper.AreaMapper;
import com.fh.model.Area;
import com.fh.model.AreaQuery;
import com.fh.model.DataTableResult;
import com.fh.model.Type;
import com.fh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public DataTableResult queryAreaList(AreaQuery areaQuery) {
        Long areaLong = areaMapper.selectAreaListCount(areaQuery);

        List<Area> areaList = areaMapper.selectAreaList(areaQuery);

        DataTableResult dataTableResult = new DataTableResult(areaQuery.getDraw(),areaLong,areaLong,areaList);

        return dataTableResult;
       
    }

    @Override
    public void addArea(Area area) {
        areaMapper.addArea(area);
    }

    @Override
    public Area toUpdateArea(Integer id) {
        return areaMapper.toUpdateArea(id);
    }

    @Override
    public void updateArea(Area area) {
        areaMapper.updateArea(area);
    }

    @Override
    public void deleteArea(Integer id) {
        areaMapper.deleteArea(id);
    }
}
