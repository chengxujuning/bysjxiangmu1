package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SheyingqicaiDao;
import com.entity.SheyingqicaiEntity;
import com.service.SheyingqicaiService;
import com.entity.vo.SheyingqicaiVO;
import com.entity.view.SheyingqicaiView;

@Service("sheyingqicaiService")
public class SheyingqicaiServiceImpl extends ServiceImpl<SheyingqicaiDao, SheyingqicaiEntity> implements SheyingqicaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SheyingqicaiEntity> page = this.selectPage(
                new Query<SheyingqicaiEntity>(params).getPage(),
                new EntityWrapper<SheyingqicaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SheyingqicaiEntity> wrapper) {
		  Page<SheyingqicaiView> page =new Query<SheyingqicaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SheyingqicaiVO> selectListVO(Wrapper<SheyingqicaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SheyingqicaiVO selectVO(Wrapper<SheyingqicaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SheyingqicaiView> selectListView(Wrapper<SheyingqicaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SheyingqicaiView selectView(Wrapper<SheyingqicaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<SheyingqicaiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<SheyingqicaiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<SheyingqicaiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
