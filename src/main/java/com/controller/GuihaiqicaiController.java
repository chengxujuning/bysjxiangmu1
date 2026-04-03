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

import com.entity.GuihaiqicaiEntity;
import com.entity.view.GuihaiqicaiView;

import com.service.GuihaiqicaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 归还器材
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
@RestController
@RequestMapping("/guihaiqicai")
public class GuihaiqicaiController {
    @Autowired
    private GuihaiqicaiService guihaiqicaiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuihaiqicaiEntity guihaiqicai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			guihaiqicai.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongyingshang")) {
			guihaiqicai.setGongyingshanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GuihaiqicaiEntity> ew = new EntityWrapper<GuihaiqicaiEntity>();


        //查询结果
		PageUtils page = guihaiqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaiqicai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuihaiqicaiEntity guihaiqicai, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			guihaiqicai.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongyingshang")) {
			guihaiqicai.setGongyingshanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GuihaiqicaiEntity> ew = new EntityWrapper<GuihaiqicaiEntity>();

        //查询结果
		PageUtils page = guihaiqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaiqicai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuihaiqicaiEntity guihaiqicai){
       	EntityWrapper<GuihaiqicaiEntity> ew = new EntityWrapper<GuihaiqicaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guihaiqicai, "guihaiqicai")); 
        return R.ok().put("data", guihaiqicaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuihaiqicaiEntity guihaiqicai){
        EntityWrapper< GuihaiqicaiEntity> ew = new EntityWrapper< GuihaiqicaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guihaiqicai, "guihaiqicai")); 
		GuihaiqicaiView guihaiqicaiView =  guihaiqicaiService.selectView(ew);
		return R.ok("查询归还器材成功").put("data", guihaiqicaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuihaiqicaiEntity guihaiqicai = guihaiqicaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guihaiqicai,deSens);
        return R.ok().put("data", guihaiqicai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuihaiqicaiEntity guihaiqicai = guihaiqicaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guihaiqicai,deSens);
        return R.ok().put("data", guihaiqicai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuihaiqicaiEntity guihaiqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaiqicai);
        guihaiqicaiService.insert(guihaiqicai);
        return R.ok().put("data",guihaiqicai.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuihaiqicaiEntity guihaiqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaiqicai);
    	guihaiqicai.setUserid((Long)request.getSession().getAttribute("userId"));
        guihaiqicaiService.insert(guihaiqicai);
        return R.ok().put("data",guihaiqicai.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuihaiqicaiEntity guihaiqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaiqicai);
        //全部更新
        guihaiqicaiService.updateById(guihaiqicai);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<GuihaiqicaiEntity> list = new ArrayList<GuihaiqicaiEntity>();
        for(Long id : ids) {
            GuihaiqicaiEntity guihaiqicai = guihaiqicaiService.selectById(id);
            guihaiqicai.setSfsh(sfsh);
            guihaiqicai.setShhf(shhf);
            list.add(guihaiqicai);
        }
        guihaiqicaiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guihaiqicaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
