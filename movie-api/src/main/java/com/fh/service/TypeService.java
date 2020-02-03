package com.fh.service;

import com.fh.model.DataTableResult;
import com.fh.model.Type;
import com.fh.model.TypeQuery;

public interface TypeService {
    DataTableResult queryTypeList(TypeQuery typeQuery);

    void addType(Type type);

    Type toUpdateType(Integer id);

    void updateType(Type type);

    void deleteType(Integer id);
}
