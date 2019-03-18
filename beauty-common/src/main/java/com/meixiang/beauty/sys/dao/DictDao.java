/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import java.util.List;

import com.meixiang.beauty.common.persistence.CrudDao;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.sys.entity.Dict;

/**
 * 字典DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> findTypeList(Dict dict);

	public List findListByInfo(Dict dict);
}
