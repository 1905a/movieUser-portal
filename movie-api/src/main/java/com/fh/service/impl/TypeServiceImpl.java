package com.fh.service.impl;

import com.fh.mapper.TypeMapper;
import com.fh.model.DataTableResult;
import com.fh.model.Movie;
import com.fh.model.Type;
import com.fh.model.TypeQuery;
import com.fh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public DataTableResult queryTypeList(TypeQuery typeQuery) {
        Long typeLong = typeMapper.selectTypeListCount(typeQuery);

        List<Type> typeList = typeMapper.selectTypeList(typeQuery);

        DataTableResult dataTableResult = new DataTableResult(typeQuery.getDraw(),typeLong,typeLong,typeList);

        return dataTableResult;
       
    }

    @Override
    public void addType(Type type) {
        typeMapper.addType(type);
    }

    @Override
    public Type toUpdateType(Integer id) {
        return typeMapper.toUpdateType(id);
    }

    @Override
    public void updateType(Type type) {
        typeMapper.updateType(type);
    }

    @Override
    public void deleteType(Integer id) {
        typeMapper.deleteType(id);
    }
}
