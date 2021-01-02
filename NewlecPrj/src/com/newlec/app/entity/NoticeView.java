package com.newlec.app.entity;

import java.util.Date;

public class NoticeView extends Notice {

	private int cmtcnt;

	public NoticeView() {
	}
	
	public NoticeView(int id, String title, String writerId, Date date, int hit, String files, int cmtcnt) {
		super(id, title, writerId, date, hit, files, null);
		this.cmtcnt = cmtcnt;
	}

	public int getCmtcnt() {
		return cmtcnt;
	}

	public void setCmtcnt(int cmtcnt) {
		this.cmtcnt = cmtcnt;
	}
	
}
