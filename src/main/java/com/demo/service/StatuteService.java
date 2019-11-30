package com.demo.service;

import com.demo.entity.Statute;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
public interface StatuteService extends IService<Statute> {


    PageInfo<Statute> selectAll(Map<String,Object> params);



}
