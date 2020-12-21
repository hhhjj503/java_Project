package ex1;

import java.sql.SQLException;

import com.hlecture.app.console.NoticeConsole;

public class Program5 {

	public static void main(String[] args) throws SQLException {
		NoticeConsole console = new NoticeConsole();
		boolean chk = true;
		
		
		exit : while(chk) {	
			console.printNoticeList();
			int menu = console.inputNoticeMenu();
			
			switch(menu) {
			case 1 : //상세조회
				break;
			case 2 : //이전
				//page--
				console.previewPage();
				break;
			case 3 : //다음
				//page++
				console.nextPage();
				break;
			case 4 : //새글쓰기
				
				break;
			case 5 : //검색
				console.searchWord();
				break;
			case 6 : //종료
				System.out.println("종료합니다 Bye ~");
				break exit;
			default :
				System.out.println("1~5 까지만 입력해주세요.");
				break;
			}
		}
		
	}

}
