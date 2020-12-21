package com.hlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hlecture.app.sentity.Notice;
import com.hlecture.app.service.NoticeService;

public class NoticeConsole {

	private NoticeService service;
	private int page;
	private String searchOption;
	private String searchQuery;
	
	public NoticeConsole() {
		service = new NoticeService();
		page =1;
		searchOption = "";
		searchQuery =  "";
	}

	public void printNoticeList() throws SQLException {
		int count;
		int lastPage;
		count = service.getCount();
		lastPage = count%10 == 0 ? count/10 : (count/10)+1;
		
		List<Notice> list = service.getList(page, searchOption,searchQuery);
		System.out.println("-----------------------------");
		System.out.printf("<공지사항> 총%d 개의 게시글\n", count);
		System.out.println("-----------------------------");
		for(Notice n : list) {
		System.out.printf("%d. %s / %s / %s\n",
				n.getId(),
				n.getTitle(),
				n.getContent() ,
				n.getRegDate());
		}
		System.out.println("-----------------------------");
		System.out.printf("\t %d/%d pages\n", page, lastPage);
	}
	
	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		String menu;
		System.out.print("1.상세조회 / 2.이전 / 3.다음 / 4.추가 / 5.검색 / 6.종료 > ");
		menu = scan.nextLine();
		int chkMenu = Integer.parseInt(menu);
		return chkMenu;
	}
	
	public void previewPage() {
		if(page == 1) {
			System.out.println("=================");
			System.out.println("이전페이지가 없습니다");
			return;
		}
		page--;
	}

	public void nextPage() throws SQLException {
		
		int count = service.getCount();
		int lastPage = count%10 == 0 ? count/10 : (count/10)+1;
		if(page == lastPage) {
			System.out.println("=================");
			System.out.println("다음페이지가 없습니다");
			return; //nextPage 메서드를 빠져나가겠다
		}
		page++;
	}

	public void searchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 옵션 : Title / Content / writer_Id 중 하나를 입력해 주세요." );
		
		System.out.print(" > ");
		searchOption  = scan.nextLine();
		
		System.out.println("검색단어를 입력해 주세요");
		System.out.print(" > ");
		searchQuery = scan.nextLine();
	}

}
