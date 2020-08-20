package edu.hbuas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UpLoadFileServlet
 */
@WebServlet("/UpLoadFile")
public class UpLoadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SmartUpload su=new SmartUpload();
		//PageContext pageContext=request.
		//初始化
		su.initialize(this.getServletConfig(), request, response);
		try {
			//设置编码格式：
			su.setCharset("utf-8");
			//上传
			su.upload();
			//HttpServletRequest sureq=(HttpServletRequest) su.getRequest();
			String username=su.getRequest().getParameter("username");
			System.out.println(username);
			//获取文件
			Files files=su.getFiles();//获取多个文件
			//保存文件
			for (int i = 0; i < files.getCount(); i++) {
				//su.save("uploadfile");
				File file=files.getFile(i);
				if(file.isMissing()) continue;
				// 取得文件名  
				String fileName = file.getFileName();  
				// 取得文件全名  
				String filePathName = file.getFilePathName();  
				// 取得文件扩展名  
				String fileExtName = file.getFileExt();  
				
				file.saveAs("/uploadfile/"+fileName,su.SAVE_VIRTUAL);
			}
			
		} catch (ServletException | IOException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HttpServletRequest sureq=(HttpServletRequest) su.getRequest();
		//String username=sureq.getParameter("username");
		//String username=request.getParameter("username");
		
		response.sendRedirect("upload.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
