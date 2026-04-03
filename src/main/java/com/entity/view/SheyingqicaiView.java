package com.entity.view;

import com.entity.SheyingqicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 摄影器材
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
@TableName("sheyingqicai")
public class SheyingqicaiView  extends SheyingqicaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SheyingqicaiView(){
	}
 
 	public SheyingqicaiView(SheyingqicaiEntity sheyingqicaiEntity){
 	try {
			BeanUtils.copyProperties(this, sheyingqicaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
