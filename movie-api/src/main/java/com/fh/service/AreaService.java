package com.fh.service;

import com.fh.model.Area;
import com.fh.model.AreaQuery;
import com.fh.model.DataTableResult;

public interface AreaService {

    DataTableResult queryAreaList(AreaQuery areaQuery);

    void addArea(Area area);

    Area toUpdateArea(Integer id);

    void updateArea(Area area);

    void deleteArea(Integer id);
}
