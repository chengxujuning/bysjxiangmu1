package com.dao;

import com.entity.DiscusssheyingqicaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusssheyingqicaiVO;
import com.entity.view.DiscusssheyingqicaiView;


/**
 * 摄影器材评论表
 * 
 * @author 
 * @email 
 * @date 2025-03-26 16:51:39
 */
public interface DiscusssheyingqicaiDao extends BaseMapper<DiscusssheyingqicaiEntity> {
	
	List<DiscusssheyingqicaiVO> selectListVO(@Param("ew") Wrapper<DiscusssheyingqicaiEntity> wrapper);
	
	DiscusssheyingqicaiVO selectVO(@Param("ew") Wrapper<DiscusssheyingqicaiEntity> wrapper);
	
	List<DiscusssheyingqicaiView> selectListView(@Param("ew") Wrapper<DiscusssheyingqicaiEntity> wrapper);

	List<DiscusssheyingqicaiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssheyingqicaiEntity> wrapper);

	
	DiscusssheyingqicaiView selectView(@Param("ew") Wrapper<DiscusssheyingqicaiEntity> wrapper);
	

}
