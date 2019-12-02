package com.longge.dao.impl;

import com.longge.dao.ProvinceDao;
import com.longge.domain.Province;
import com.longge.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author longge
 * @create 2019-12-02 下午4:20
 */
public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = template.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
