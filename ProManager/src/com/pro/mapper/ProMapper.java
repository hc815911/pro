package com.pro.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pro.bean.Pro;

public class ProMapper implements RowMapper<Pro> {
	public Pro mapRow(ResultSet rs, int num) throws SQLException {
		Pro pro = new Pro();
		pro.setId(rs.getInt("id"));
		pro.setName(rs.getString("name"));
		pro.setBirthday(rs.getString("birthday"));
		pro.setTeam(rs.getString("team"));
		pro.setGoal(rs.getInt("goal"));
		pro.setAssist(rs.getInt("assist"));
		pro.setCard(rs.getInt("card"));
		return pro;
}
}
