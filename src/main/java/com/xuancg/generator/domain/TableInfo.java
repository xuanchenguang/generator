package com.xuancg.generator.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ry 数据库表
 * 
 * @author xuancg
 */
public class TableInfo implements Serializable{

	/** 搜索值 */
	private String searchValue;

	/** 创建者 */
	private String createBy;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/** 更新者 */
	private String updateBy;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/** 备注 */
	private String remark;

	/** 请求参数 */
	private Map<String, Object> params;

	/** 表名称 */
	private String tableName;

	/** 表描述 */
	private String tableComment;

	/** 表的主键列信息 */
	private ColumnInfo primaryKey;

	/** 表的列名(不包含主键) */
	private List<ColumnInfo> columns;

	/** 类名(第一个字母大写) */
	private String className;

	/** 类名(第一个字母小写) */
	private String classname;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public List<ColumnInfo> getColumns() {
		return columns;
	}

	public ColumnInfo getColumnsLast() {
		ColumnInfo columnInfo = null;
		if (null != columns && columns.size() > 0) {
			columnInfo = columns.get(0);
		}
		return columnInfo;
	}

	public void setColumns(List<ColumnInfo> columns) {
		this.columns = columns;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public ColumnInfo getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ColumnInfo primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "TableInfo [searchValue=" + searchValue + ", createBy=" + createBy + ", createTime=" + createTime
				+ ", updateBy=" + updateBy + ", updateTime=" + updateTime + ", remark=" + remark + ", params=" + params
				+ ", tableName=" + tableName + ", tableComment=" + tableComment + ", primaryKey=" + primaryKey
				+ ", columns=" + columns + ", className=" + className + ", classname=" + classname + "]";
	}

 
	
	
	
}
