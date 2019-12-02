package com.longge.service;

import com.longge.domain.Province;

import java.util.List;

/**
 * @author longge
 * @create 2019-12-02 下午4:21
 */
public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
