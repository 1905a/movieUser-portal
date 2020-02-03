package com.fh.mapper;

import com.fh.model.Type;
import com.fh.model.TypeQuery;

import java.util.List;

public interface TypeMapper {
    
    Long selectTypeListCount(TypeQuery typeQuery);

    List<Type> selectTypeList(TypeQuery typeQuery);

    void addType(Type type);

    Type toUpdateType(Integer id);

    void updateType(Type type);

    void deleteType(Integer id);
}
