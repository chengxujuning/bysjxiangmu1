package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PeisongxinxiEntity;
import com.entity.view.PeisongxinxiView;

import com.service.PeisongxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 配送信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
@RestController
@RequestMapping("/peisongxinxi")
public class PeisongxinxiController {
    @Autowired
    private PeisongxinxiService peisongxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeisongxinxiEntity peisongxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			peisongxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongyingshang")) {
			peisongxinxi.setGongyingshanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<PeisongxinxiEntity> ew = new EntityWrapper<PeisongxinxiEntity>();


        //查询结果
		PageUtils page = peisongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeisongxinxiEntity peisongxinxi, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			peisongxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongyingshang")) {
			peisongxinxi.setGongyingshanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<PeisongxinxiEntity> ew = new EntityWrapper<PeisongxinxiEntity>();

        //查询结果
		PageUtils page = peisongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeisongxinxiEntity peisongxinxi){
       	EntityWrapper<PeisongxinxiEntity> ew = new EntityWrapper<PeisongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peisongxinxi, "peisongxinxi")); 
        return R.ok().put("data", peisongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeisongxinxiEntity peisongxinxi){
        EntityWrapper< PeisongxinxiEntity> ew = new EntityWrapper< PeisongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peisongxinxi, "peisongxinxi")); 
		PeisongxinxiView peisongxinxiView =  peisongxinxiService.selectView(ew);
		return R.ok("查询配送信息成功").put("data", peisongxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeisongxinxiEntity peisongxinxi = peisongxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(peisongxinxi,deSens);
        return R.ok().put("data", peisongxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeisongxinxiEntity peisongxinxi = peisongxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(peisongxinxi,deSens);
        return R.ok().put("data", peisongxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeisongxinxiEntity peisongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongxinxi);
        peisongxinxiService.insert(peisongxinxi);
        return R.ok().put("data",peisongxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeisongxinxiEntity peisongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongxinxi);
    	peisongxinxi.setUserid((Long)request.getSession().getAttribute("userId"));
        peisongxinxiService.insert(peisongxinxi);
        return R.ok().put("data",peisongxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeisongxinxiEntity peisongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongxinxi);
        //全部更新
        peisongxinxiService.updateById(peisongxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peisongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
