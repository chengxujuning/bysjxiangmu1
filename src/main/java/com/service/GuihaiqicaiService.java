package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuihaiqicaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuihaiqicaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuihaiqicaiView;


/**
 * 归还器材
 *
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
public interface GuihaiqicaiService extends IService<GuihaiqicaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuihaiqicaiVO> selectListVO(Wrapper<GuihaiqicaiEntity> wrapper);
   	
   	GuihaiqicaiVO selectVO(@Param("ew") Wrapper<GuihaiqicaiEntity> wrapper);
   	
   	List<GuihaiqicaiView> selectListView(Wrapper<GuihaiqicaiEntity> wrapper);
   	
   	GuihaiqicaiView selectView(@Param("ew") Wrapper<GuihaiqicaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuihaiqicaiEntity> wrapper);

   	

}

