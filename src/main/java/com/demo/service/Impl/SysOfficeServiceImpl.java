package com.demo.service.Impl;

import com.demo.dao.SysOfficeMapper;
import com.demo.entity.SysOffice;
import com.demo.service.SysOfficeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysOfficeServiceImpl extends IServiceImpl<SysOffice> implements SysOfficeService {
}
