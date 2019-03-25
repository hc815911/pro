package com.pro.bean;

public class Pro {
	public int id;
	public String name;
	public String birthday;
	public String team;
	public int goal;
	public int assist;
	public int card;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return team
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * @param team セットする team
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	/**
	 * @return goal
	 */
	public int getGoal() {
		return goal;
	}
	/**
	 * @param goal セットする goal
	 */
	public void setGoal(int goal) {
		this.goal = goal;
	}
	/**
	 * @return assist
	 */
	public int getAssist() {
		return assist;
	}
	/**
	 * @param assist セットする assist
	 */
	public void setAssist(int assist) {
		this.assist = assist;
	}
	/**
	 * @return card
	 */
	public int getCard() {
		return card;
	}
	/**
	 * @param card セットする card
	 */
	public void setCard(int card) {
		this.card = card;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "pro [id=" + id + ", name=" + name + ", birthday=" + birthday + ", team=" + team + ", goal=" + goal
				+ ", assist=" + assist + ", card=" + card + "]";
	}
	public Pro(int id, String name, String birthday, String team, int goal, int assist, int card) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.team = team;
		this.goal = goal;
		this.assist = assist;
		this.card = card;
	}
	public Pro() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
