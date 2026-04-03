package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheyingqicaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SheyingqicaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SheyingqicaiView;


/**
 * 摄影器材
 *
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
public interface SheyingqicaiService extends IService<SheyingqicaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SheyingqicaiVO> selectListVO(Wrapper<SheyingqicaiEntity> wrapper);
   	
   	SheyingqicaiVO selectVO(@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);
   	
   	List<SheyingqicaiView> selectListView(Wrapper<SheyingqicaiEntity> wrapper);
   	
   	SheyingqicaiView selectView(@Param("ew") Wrapper<SheyingqicaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SheyingqicaiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<SheyingqicaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<SheyingqicaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<SheyingqicaiEntity> wrapper);



}

