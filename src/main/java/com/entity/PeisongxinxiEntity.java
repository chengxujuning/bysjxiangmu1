package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 配送信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-26 16:51:37
 */
@TableName("peisongxinxi")
public class PeisongxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PeisongxinxiEntity() {
		
	}
	
	public PeisongxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
	/**
	 * 器材名称
	 */
					
	private String qicaimingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 设备分类
	 */
					
	private String shebeifenlei;
	
	/**
	 * 租用说明
	 */
					
	private String zuyongshuoming;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 每天单价
	 */
					
	private Integer meitiandanjia;
	
	/**
	 * 租用天数
	 */
					
	private Integer zuyongtianshu;
	
	/**
	 * 总费用
	 */
					
	private Integer zongfeiyong;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 地址
	 */
					
	private String dizhi;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 器材状态
	 */
					
	private String qicaizhuangtai;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	/**
	 * 供应商名
	 */
					
	private String gongyingshangming;
	
	/**
	 * 供应商号
	 */
					
	private String gongyingshanghao;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
	/**
	 * 设置：器材名称
	 */
	public void setQicaimingcheng(String qicaimingcheng) {
		this.qicaimingcheng = qicaimingcheng;
	}
	/**
	 * 获取：器材名称
	 */
	public String getQicaimingcheng() {
		return qicaimingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：设备分类
	 */
	public void setShebeifenlei(String shebeifenlei) {
		this.shebeifenlei = shebeifenlei;
	}
	/**
	 * 获取：设备分类
	 */
	public String getShebeifenlei() {
		return shebeifenlei;
	}
	/**
	 * 设置：租用说明
	 */
	public void setZuyongshuoming(String zuyongshuoming) {
		this.zuyongshuoming = zuyongshuoming;
	}
	/**
	 * 获取：租用说明
	 */
	public String getZuyongshuoming() {
		return zuyongshuoming;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：每天单价
	 */
	public void setMeitiandanjia(Integer meitiandanjia) {
		this.meitiandanjia = meitiandanjia;
	}
	/**
	 * 获取：每天单价
	 */
	public Integer getMeitiandanjia() {
		return meitiandanjia;
	}
	/**
	 * 设置：租用天数
	 */
	public void setZuyongtianshu(Integer zuyongtianshu) {
		this.zuyongtianshu = zuyongtianshu;
	}
	/**
	 * 获取：租用天数
	 */
	public Integer getZuyongtianshu() {
		return zuyongtianshu;
	}
	/**
	 * 设置：总费用
	 */
	public void setZongfeiyong(Integer zongfeiyong) {
		this.zongfeiyong = zongfeiyong;
	}
	/**
	 * 获取：总费用
	 */
	public Integer getZongfeiyong() {
		return zongfeiyong;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：地址
	 */
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：器材状态
	 */
	public void setQicaizhuangtai(String qicaizhuangtai) {
		this.qicaizhuangtai = qicaizhuangtai;
	}
	/**
	 * 获取：器材状态
	 */
	public String getQicaizhuangtai() {
		return qicaizhuangtai;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
	/**
	 * 设置：供应商名
	 */
	public void setGongyingshangming(String gongyingshangming) {
		this.gongyingshangming = gongyingshangming;
	}
	/**
	 * 获取：供应商名
	 */
	public String getGongyingshangming() {
		return gongyingshangming;
	}
	/**
	 * 设置：供应商号
	 */
	public void setGongyingshanghao(String gongyingshanghao) {
		this.gongyingshanghao = gongyingshanghao;
	}
	/**
	 * 获取：供应商号
	 */
	public String getGongyingshanghao() {
		return gongyingshanghao;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
