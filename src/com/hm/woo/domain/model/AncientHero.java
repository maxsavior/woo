package com.hm.woo.domain.model;

import com.hm.woo.domain.model.CustomRole;

public class AncientHero{
	
	private String name;
	private int lv;
	private int hp;
	private CustomRole role;
	
	public AncientHero(String name, int lv, int hp, CustomRole role) {
		super();
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public CustomRole getRole() {
		return role;
	}

	public void setRole(CustomRole role) {
		this.role = role;
	}
	
	public int getMaxHp() {
		CustomRole role = this.getRole();
		int lv = this.getLv();
		int role_basic_hp = role.getBasicHp();
		int role_incr_hp = role.getIncrHp();
		
		int maxhp = role_basic_hp + (lv-1)*role_incr_hp;
		return maxhp;
	}

}
