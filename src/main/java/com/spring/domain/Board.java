package com.spring.domain;

import java.util.Date;

public class Board {

	int idx;
	int parent_idx;
	String title;
	String contents;
	int hit_cnt;
	String del_gb;
	Date reg_dtm;
	String reg_id;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getParent_idx() {
		return parent_idx;
	}
	public void setParent_idx(int parent_idx) {
		this.parent_idx = parent_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit_cnt() {
		return hit_cnt;
	}
	public void setHit_cnt(int hit_cnt) {
		this.hit_cnt = hit_cnt;
	}
	public String getDel_gb() {
		return del_gb;
	}
	public void setDel_gb(String del_gb) {
		this.del_gb = del_gb;
	}
	public Date getReg_dtm() {
		return reg_dtm;
	}
	public void setReg_dtm(Date reg_dtm) {
		this.reg_dtm = reg_dtm;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
		
}
