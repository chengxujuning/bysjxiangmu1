package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusssheyingqicaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusssheyingqicaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusssheyingqicaiView;


/**
 * 摄影器材评论表
 *
 * @author 
 * @email 
 * @date 2025-03-26 16:51:39
 */
public interface DiscusssheyingqicaiService extends IService<DiscusssheyingqicaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssheyingqicaiVO> selectListVO(Wrapper<DiscusssheyingqicaiEntity> wrapper);
   	
   	DiscusssheyingqicaiVO selectVO(@Param("ew") Wrapper<DiscusssheyingqicaiEntity> wrapper);
   	
   	List<DiscusssheyingqicaiView> selectListView(Wrapper<DiscusssheyingqicaiEntity> wrapper);
   	
   	DiscusssheyingqicaiView selectView(@Param("ew") Wrapper<DiscusssheyingqicaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssheyingqicaiEntity> wrapper);

   	

}

