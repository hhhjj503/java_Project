package com.newlec.app.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlec.app.entity.Notice;
import com.newlec.app.service.NoticeService;

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
		Collection<Part> files = request.getParts();
		StringBuilder builder = new StringBuilder();
		for(Part p : files) {
			if(!p.getName().equals("file")) continue;
			if(p.getSize() == 0 ) continue;
		Part file = p;
		String realPath = request.getServletContext().getRealPath("/upload"); //root/upload
		File path = new File(realPath);
		if(!path.exists()) path.mkdirs();
		
		String fileName = file.getSubmittedFileName();
		String filePath = realPath + File.separator +fileName; //realPath + 파일명
		File name = new File(filePath);
		
		while(name.exists()) {
			String fileOrigin = fileName.substring(0, fileName.lastIndexOf("."));
			String extension = fileName.substring(fileName.lastIndexOf(".")+1);
			int f = fileOrigin.lastIndexOf("(");
			int b = fileOrigin.lastIndexOf(")");
			int n = 1;
			if(f > -1 && b > -1) {
				String front = fileName.substring(0, (fileName.lastIndexOf("(")+1));
				String middle = fileName.substring((fileName.lastIndexOf("(")+1), fileName.lastIndexOf(")"));
				int mid = Integer.parseInt(middle);
				fileOrigin = front + (mid + n) + ")";
				fileName = fileOrigin + "." + extension;
				filePath = realPath + File.separator +fileName;
			} else {
				fileName = fileOrigin + "(" + n + ")." + extension;
				filePath = realPath + File.separator +fileName;
			}
			name = new File(filePath);
		}
		
		builder.append(fileName);
		builder.append(",");
		InputStream fls = file.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		
		byte[] buffer = new byte[1024]; 
		int size = 0;
		while( (size = fls.read(buffer)) != -1) {
			System.out.println(size);
			fos.write(buffer,0, size);
		}
		fos.close();
		fls.close();
		}
		if(!builder.toString().equals("")) builder.delete(builder.length()-1, builder.length());
		boolean pub = false;
		if(open != null) pub = true;
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriterId("newlec");
		notice.setFiles(builder.toString());
		notice.setContent(content);
		notice.setPub(pub);
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("list");
		
	}
}
