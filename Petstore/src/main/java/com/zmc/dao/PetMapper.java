package com.zmc.dao;

import com.zmc.model.Pet;
import java.util.List;

public interface PetMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Pet record);

    Pet selectByPrimaryKey(Integer pId);

    List<Pet> selectAll();

    int updateByPrimaryKey(Pet record);
}