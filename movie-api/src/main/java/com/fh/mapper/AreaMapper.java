package com.fh.mapper;

import com.fh.model.Area;
import com.fh.model.AreaQuery;

import java.util.List;

public interface AreaMapper {
    Long selectAreaListCount(AreaQuery areaQuery);

    List<Area> selectAreaList(AreaQuery areaQuery);

    void addArea(Area area);

    Area toUpdateArea(Integer id);

    void updateArea(Area area);

    void deleteArea(Integer id);
}
