package com.hm.woo.domain.model;

public class CustomRole {
	
	private String rolename;
	private int basicHp;
	private int basicAtk;
	private int basicDef;
	
	private int incrHp;
	private int incrAtk;
	private int incrDef;
	
	public CustomRole(String rolename, int basicHp, int basicAtk, int basicDef,
			int incrHp, int incrAtk, int incrDef) {
		super();
		this.rolename = rolename;
		this.basicHp = basicHp;
		this.basicAtk = basicAtk;
		this.basicDef = basicDef;
		this.incrHp = incrHp;
		this.incrAtk = incrAtk;
		this.incrDef = incrDef;
	}

	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public int getBasicHp() {
		return basicHp;
	}
	public void setBasicHp(int basicHp) {
		this.basicHp = basicHp;
	}
	public int getBasicAtk() {
		return basicAtk;
	}
	public void setBasicAtk(int basicAtk) {
		this.basicAtk = basicAtk;
	}
	public int getBasicDef() {
		return basicDef;
	}
	public void setBasicDef(int basicDef) {
		this.basicDef = basicDef;
	}
	public int getIncrHp() {
		return incrHp;
	}
	public void setIncrHp(int incrHp) {
		this.incrHp = incrHp;
	}
	public int getIncrAtk() {
		return incrAtk;
	}
	public void setIncrAtk(int incrAtk) {
		this.incrAtk = incrAtk;
	}
	public int getIncrDef() {
		return incrDef;
	}
	public void setIncrDef(int incrDef) {
		this.incrDef = incrDef;
	}
	
	

}
