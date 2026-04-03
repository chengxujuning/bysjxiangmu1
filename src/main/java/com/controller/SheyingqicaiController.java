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

import com.entity.SheyingqicaiEntity;
import com.entity.view.SheyingqicaiView;

import com.service.SheyingqicaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 摄影器材
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
@RestController
@RequestMapping("/sheyingqicai")
public class SheyingqicaiController {
    @Autowired
    private SheyingqicaiService sheyingqicaiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SheyingqicaiEntity sheyingqicai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongyingshang")) {
			sheyingqicai.setGongyingshanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();


        //查询结果
		PageUtils page = sheyingqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingqicai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SheyingqicaiEntity sheyingqicai, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();

        //查询结果
		PageUtils page = sheyingqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingqicai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SheyingqicaiEntity sheyingqicai){
       	EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sheyingqicai, "sheyingqicai")); 
        return R.ok().put("data", sheyingqicaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SheyingqicaiEntity sheyingqicai){
        EntityWrapper< SheyingqicaiEntity> ew = new EntityWrapper< SheyingqicaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sheyingqicai, "sheyingqicai")); 
		SheyingqicaiView sheyingqicaiView =  sheyingqicaiService.selectView(ew);
		return R.ok("查询摄影器材成功").put("data", sheyingqicaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SheyingqicaiEntity sheyingqicai = sheyingqicaiService.selectById(id);
		sheyingqicai.setClicktime(new Date());
		sheyingqicaiService.updateById(sheyingqicai);
        sheyingqicai = sheyingqicaiService.selectView(new EntityWrapper<SheyingqicaiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(sheyingqicai,deSens);
        return R.ok().put("data", sheyingqicai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SheyingqicaiEntity sheyingqicai = sheyingqicaiService.selectById(id);
		sheyingqicai.setClicktime(new Date());
		sheyingqicaiService.updateById(sheyingqicai);
        sheyingqicai = sheyingqicaiService.selectView(new EntityWrapper<SheyingqicaiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(sheyingqicai,deSens);
        return R.ok().put("data", sheyingqicai);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        SheyingqicaiEntity sheyingqicai = sheyingqicaiService.selectById(id);
        if(type.equals("1")) {
        	sheyingqicai.setThumbsupnum(sheyingqicai.getThumbsupnum()+1);
        } else {
        	sheyingqicai.setCrazilynum(sheyingqicai.getCrazilynum()+1);
        }
        sheyingqicaiService.updateById(sheyingqicai);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SheyingqicaiEntity sheyingqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheyingqicai);
        sheyingqicaiService.insert(sheyingqicai);
        return R.ok().put("data",sheyingqicai.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SheyingqicaiEntity sheyingqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheyingqicai);
        sheyingqicaiService.insert(sheyingqicai);
        return R.ok().put("data",sheyingqicai.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SheyingqicaiEntity sheyingqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheyingqicai);
        //全部更新
        sheyingqicaiService.updateById(sheyingqicai);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sheyingqicaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SheyingqicaiEntity sheyingqicai, HttpServletRequest request,String pre){
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = sheyingqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingqicai), params), params));
        return R.ok().put("data", page);
    }






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_sheyingqicai_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
                                                    if(tableName.equals("gongyingshang")) {
            ew.eq("gongyingshanghao", (String)request.getSession().getAttribute("username"));
        }
                                        //获取结果
        List<Map<String, Object>> result = sheyingqicaiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_sheyingqicai_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("gongyingshang")) {
            ew.eq("gongyingshanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = sheyingqicaiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_sheyingqicai_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("gongyingshang")) {
            ew.eq("gongyingshanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = sheyingqicaiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_sheyingqicai_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("gongyingshang")) {
            ew.eq("gongyingshanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = sheyingqicaiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("group_sheyingqicai_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("gongyingshang")) {
            ew.eq("gongyingshanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = sheyingqicaiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,SheyingqicaiEntity sheyingqicai, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("gongyingshang")) {
            sheyingqicai.setGongyingshanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<SheyingqicaiEntity> ew = new EntityWrapper<SheyingqicaiEntity>();
        int count = sheyingqicaiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingqicai), params), params));
        return R.ok().put("data", count);
    }

}
