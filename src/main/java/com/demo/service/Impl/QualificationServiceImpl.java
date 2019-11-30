package com.demo.service.Impl;

import com.demo.dao.QualificationMapper;
import com.demo.dao.SysUserMapper;
import com.demo.entity.Qualification;
import com.demo.entity.SysUser;
import com.demo.service.QualificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QualificationServiceImpl extends IServiceImpl<Qualification> implements QualificationService {

    @Autowired
    SysUserMapper userMapper;

    @Value("${imgPath}")
    String imgPath;

    /**
     *
     * @param params pageNum pageSize BeginTime开始时间 EndTime结束时间 type状态 check 资源类型
     * @return
     */
    @Override
    public PageInfo<Qualification> selectCondition(Map<String, Object> params) {

        if (StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));

        Example example = new Example(Qualification.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("delFlag","0");
        if (!StringUtils.isEmpty(params.get("type"))){
            criteria.andEqualTo("type",params.get("type"));
        }
        if (!StringUtils.isEmpty(params.get("check"))){
            criteria.andEqualTo("check",params.get("check"));
        }
        if (!StringUtils.isEmpty(params.get("BeginTime"))){
            criteria.andEqualTo("updateDate",params.get("updateDate"));
        }
        if (!StringUtils.isEmpty(params.get("EndTime"))){
            criteria.andEqualTo("updateDate",params.get("updateDate"));
        }
        List<Qualification> qualifications = mapper.selectByExample(example);

        QualificationMapper qualificationMapper = (QualificationMapper) mapper;

        //根据qualifications中的uploadUserId和checkUserId查询数据
        for (Qualification qualification : qualifications) {
            Map<String, Object> names = qualificationMapper.selectNames(qualification.getId());
            qualification.setCheckUserName((String) names.get("checkUserName"));
            qualification.setUploadUserName((String)names.get("uploadUserName"));
        }
        return  new PageInfo<Qualification>(qualifications);
    }
    @Override
    public Qualification selectByPrimaryKey(Object key) {
        //根据上传用户id关联用户表查询office_id
        Qualification qualification = mapper.selectByPrimaryKey(key);
        SysUser sysUser = userMapper.selectByPrimaryKey(qualification.getUploadUserId());
        // uploads/企业id/用户图片名
        qualification.setAddress(imgPath+sysUser.getOfficeId()+ File.separator+qualification.getAddress());
        return qualification;
    }
}
