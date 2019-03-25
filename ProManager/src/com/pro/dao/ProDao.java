package com.pro.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pro.bean.Pro;
import com.pro.bean.Pro;
import com.pro.mapper.ProMapper;
import com.pro.bean.Pro;
import com.pro.mapper.ProMapper;

public class ProDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
}


public List<Pro> queryAll() {
	String sql = "select * from  pro";
	List<Pro> proList = new ArrayList<Pro>();

	proList = jdbcTemplate.query(sql, new ProMapper());

	return proList;
}
public List<Pro> queryByName(String name) {
	String sql = "select * from  pro where name like '%" + name + "%'";
	List<Pro> proList = new ArrayList<Pro>();

	proList = jdbcTemplate.query(sql, new ProMapper());

	return proList;
}
public boolean addPro(Pro pro) {
	String sql = "insert into pro(id,name,birthday,team,goal,assist,card)values(0,?,?,?,?,?,?)";
	return jdbcTemplate.update(sql,
			new Object[] { pro.getName(), pro.getBirthday(), pro.getTeam(),pro.getGoal(),pro.getAssist(),pro.getCard() },
			new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR }) == 1;

}
public boolean deletePro(Integer id) {
	//编辑sql数据库语句
	String sql = "delete from pro where id = ?";
	//利用jdbc将执行完的数据库语句返回
	return jdbcTemplate.update(sql,id)==1;

}

public boolean updatePro(Pro pro) {
	String sql = "update pro set name=？,birthday=? ,team=?, assist=?, card=? where id=?";
	Object stuObj[] = new Object[] { pro.getName(), pro.getBirthday(), pro.getTeam(),pro.getGoal(),pro.getAssist(),pro.getCard(),pro.getId() };
	return jdbcTemplate.update(sql, stuObj) == 1;
}
public boolean checkname(String name) {
	String sql = "SELECT id,name,birthday,team,goal,assist,card FROM pro WHERE name = '"+name+"'";
	List<Pro>proList = jdbcTemplate.query(sql,new ProMapper());
	if(proList.size()>0) {
		return true;
	}else {
		return false;
	}

}
}