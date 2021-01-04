package com.newlec.app.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlec.app.entity.Notice;
import com.newlec.app.service.NoticeService;
import com.sun.corba.se.spi.orbutil.fsm.Input;

@MultipartConfig(
	//location = "/tmp",
	fileSizeThreshold=1024*1024, //1MB
	maxFileSize=1024*1024*50, //50MB
	maxRequestSize=1024*1024*50*5 //250MB
)
@WebServlet("/admin/board/notice/reg")
public class RegNoticeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String open = request.getParameter("open");
		Part files = request.getPart("file");
		
		String realPath = request.getServletContext().getRealPath("/upload"); //root/upload
		String filaPath = realPath + File.separator +files.getSubmittedFileName(); //realPath + 파일명
		InputStream fls = files.getInputStream();
		FileOutputStream fos = new FileOutputStream(filaPath);
		
		byte[] buffer = new byte[1024]; 
		int size = 0;
		while( (size = fls.read(buffer)) != -1) {
			System.out.println(size);
			fos.write(buffer,0, size);
		}
		fos.close();
		fls.close();
		
		boolean pub = false;
		if(open != null) pub = true;
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriterId("newlec");
		//notice.setFiles(files);
		notice.setContent(content);
		notice.setPub(pub);
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("list");
		
	}
}
