package com.dao;

import com.entity.SheyingqicaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheyingqicaiVO;
import com.entity.view.SheyingqicaiView;


/**
 * 摄影器材
 * 
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
public interface SheyingqicaiDao extends BaseMapper<SheyingqicaiEntity> {
	
	List<SheyingqicaiVO> selectListVO(@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);
	
	SheyingqicaiVO selectVO(@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);
	
	List<SheyingqicaiView> selectListView(@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);

	List<SheyingqicaiView> selectListView(Pagination page,@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);

	
	SheyingqicaiView selectView(@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);



}
