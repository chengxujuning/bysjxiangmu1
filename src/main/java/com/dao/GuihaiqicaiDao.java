package com.dao;

import com.entity.GuihaiqicaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuihaiqicaiVO;
import com.entity.view.GuihaiqicaiView;


/**
 * 归还器材
 * 
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
public interface GuihaiqicaiDao extends BaseMapper<GuihaiqicaiEntity> {
	
	List<GuihaiqicaiVO> selectListVO(@Param("ew") Wrapper<GuihaiqicaiEntity> wrapper);
	
	GuihaiqicaiVO selectVO(@Param("ew") Wrapper<GuihaiqicaiEntity> wrapper);
	
	List<GuihaiqicaiView> selectListView(@Param("ew") Wrapper<GuihaiqicaiEntity> wrapper);

	List<GuihaiqicaiView> selectListView(Pagination page,@Param("ew") Wrapper<GuihaiqicaiEntity> wrapper);

	
	GuihaiqicaiView selectView(@Param("ew") Wrapper<GuihaiqicaiEntity> wrapper);
	

}
