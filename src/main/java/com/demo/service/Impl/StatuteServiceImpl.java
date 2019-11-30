package com.demo.service.Impl;

import com.demo.dao.StatuteMapper;
import com.demo.entity.Statute;
import com.demo.service.StatuteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.AssociationOverride;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StatuteServiceImpl extends IServiceImpl<Statute> implements StatuteService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public PageInfo<Statute> selectAll(Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));

        StatuteMapper statuteMapper = (StatuteMapper) mapper;
        List<Statute> statutes = statuteMapper.selectCondition(params);
        PageInfo<Statute> statutePageInfo = new PageInfo<>(statutes);
        return statutePageInfo;
    }

    /*@Override
    public List<Statute> selectAll() {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey("StatutesServiceImpl:selectAll")){
            return (List<Statute>) valueOperations.get("StatutesServiceImpl:selectAll");
        }

        List<Statute> statutes = super.selectAll();
        valueOperations.set("StatutesServiceImpl:selectAll",statutes);

        return statutes;
    }*/

    @Cacheable(value = "Statute",key = "'StatuteServiceImpl:selectAll'")
    @Override
    public List<Statute> selectAll() {
        return super.selectAll();
    }
}
