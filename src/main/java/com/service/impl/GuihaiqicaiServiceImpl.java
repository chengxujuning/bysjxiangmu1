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


import com.dao.GuihaiqicaiDao;
import com.entity.GuihaiqicaiEntity;
import com.service.GuihaiqicaiService;
import com.entity.vo.GuihaiqicaiVO;
import com.entity.view.GuihaiqicaiView;

@Service("guihaiqicaiService")
public class GuihaiqicaiServiceImpl extends ServiceImpl<GuihaiqicaiDao, GuihaiqicaiEntity> implements GuihaiqicaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuihaiqicaiEntity> page = this.selectPage(
                new Query<GuihaiqicaiEntity>(params).getPage(),
                new EntityWrapper<GuihaiqicaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuihaiqicaiEntity> wrapper) {
		  Page<GuihaiqicaiView> page =new Query<GuihaiqicaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuihaiqicaiVO> selectListVO(Wrapper<GuihaiqicaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuihaiqicaiVO selectVO(Wrapper<GuihaiqicaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuihaiqicaiView> selectListView(Wrapper<GuihaiqicaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuihaiqicaiView selectView(Wrapper<GuihaiqicaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
