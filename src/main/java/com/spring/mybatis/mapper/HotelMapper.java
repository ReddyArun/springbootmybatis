package com.spring.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.mybatis.model.Hotel;

@Mapper
public interface HotelMapper {
	Hotel selectByCityId(int city_id);
}
