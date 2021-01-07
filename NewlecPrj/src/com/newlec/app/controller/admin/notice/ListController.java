package com.newlec.app.controller.admin.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.app.entity.NoticeView;
import com.newlec.app.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {

	//403 권한이 없다 (권한 오류)
	//404 pagenotfound (url 오류)
	//405 요청 method 에 맞는 get 또는 post 가 없다 (메서드오류)
	//500 데이터 오류
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//null 값일 경경우를 대비해 일단 임시변수에 꺼낸다
			String field_ = request.getParameter("f");
			String query_ = request.getParameter("q");
			String page_ = request.getParameter("p");
			int page = 1;
			//꺼낸값이 null 값일 경우를 대비한 원본값
			String field ="title";
			String query ="";
			
			if(field_ != null && !field_.equals("")) field = field_;
			if(query_ != null && !query_.equals("")) query = query_;
			if(page_ != null && !page_.equals("")) page = Integer.parseInt(page_);
			
			NoticeService service = new NoticeService();
			int count = service.getNoticeViewCount(field, query);
			List<NoticeView> list = service.getNoticeViewList(field,query,page);
			 
			request.setAttribute("list", list);
			request.setAttribute("count", count);
					
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		String[] openIds = request.getParameterValues("open-Id"); //3,4,5
		String[] delIds = request.getParameterValues("del-Id");
		String cmd = request.getParameter("cmd");
		String ids__ = request.getParameter("ids");
		String[] ids_ = ids__.trim().split(" "); //1,2,3,4,5,6,7,8,9,10
		NoticeService service = new NoticeService();
		
		switch(cmd) {
		case "일괄공개" :
			List<String> oids = Arrays.asList(openIds);
			List<String> cids = new ArrayList(Arrays.asList(ids_));
			cids.removeAll(oids);
			
			System.out.println(Arrays.asList(ids_));
			System.out.println(oids);
			System.out.println(cids);
			
			// transaction
			service.pubNoticeAll(oids, cids);
			//service.closeNoticeAll(closeids);
			break;
		case "일괄삭제" :
			int[] idsD = new int[delIds.length];
			for(int i = 0; i < delIds.length;i++) 
				idsD[i] = Integer.parseInt(delIds[i]);
			int resultD = service.removeNoticeAll(idsD);
			System.out.println(resultD);
			break;
		}
		response.sendRedirect("list");
	}
}
