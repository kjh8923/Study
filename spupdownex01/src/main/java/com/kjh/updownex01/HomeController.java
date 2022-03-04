package com.kjh.updownex01;


import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * Handles requests for the application home page.
 */
@Controller
//@MultipartConfig(maxFileSize = 1024*1024*5)
//콘트롤라에서 어노테이션 @MultipartConfig을 이용하여 설정해주어도 됨 
public class HomeController {
	
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//return "home";
		return "upload";
	}
	
	@RequestMapping("/uploadSingle")
	public String uploadSingle(MultipartHttpServletRequest mtpRequest, Model model) {
		//업로드 파일 처리를 위해서는 MultipartHttpServletRequest객체를 사용해야 한다
		String src = mtpRequest.getParameter("src"); //올린사람 이름
		//HttpServletRequest처럼 form에서 보낸 파라메타는 getParameter("form의 name속성명")
		System.out.println("올린사람 : " + src);
		
		MultipartFile mf = mtpRequest.getFile("file");
		//MultipartHttpServletRequest의 getFile("name속성명")은 MultipartFile객체를 반환
		//업로드된 파일의 저장 경로(이클립스 프로젝트의 저장 경로)
		String path1 = "D:/kjh/eclipse-jee-2021-03-R-win32-x86_64/workspaceWEB/spupdownex01/src/main/webapp/resources/upimage/";
		//이클립스 프로젝트로 시험시 이미지가 안보이는 경우를 대비한 저장 경로(임시)
		String path2 = "D:/kjh/apache-tomcat-9.0.56/wtpwebapps/spupdownex01/resources/upimage";
		//원래의 파일명(브라우저에서 보낸 파일명)
		String originFileName = mf.getOriginalFilename();
		//원래 파일의 파일 사이즈(long형 바이트 단위)
		long fileSize = mf.getSize();
		System.out.println("orginFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);
		
		//업로드된 파일들은 동일한 이름을 갖는 경우가 많으므로 유일한 이름으로 변경하여 저장해야 함
		//유일 구분자로 System.currentTimeMillis()를 파일명 앞에 붙임
		long pfix = System.currentTimeMillis();
		String safeFile1 = path1 + pfix + originFileName;
		String safeFile2 = path2 + pfix + originFileName;
		//저장 파일이름은 pfix + originFileName
		String dfile = pfix + originFileName; //download시 사용하기 위한 파일
		try {
			//MultipartFile의 transferTo(File dest) throws IOException, IllegalStateException
			//메서드는 전달받은 객체를 파라메타의 파일 객체로 저장
			mf.transferTo(new File(safeFile1));
			mf.transferTo(new File(safeFile2));
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		//이동할 페이지 download.jsp에서 사용할 데이터 값
		model.addAttribute("author", src);
		model.addAttribute("fileName", dfile);
		model.addAttribute("fileSize", fileSize);
		
		return "download";
	}
	
	@RequestMapping("/uploadMulti")
	public String uploadMulti(MultipartHttpServletRequest mtpRequest, Model model) {
		List<MultipartFile> fileList = mtpRequest.getFiles("file"); 
		//getFiles()는 List객체로 반환
		String src = mtpRequest.getParameter("src");
		System.out.println("올린사람 : " + src);
		
		String path1 = "D:/kjh/eclipse-jee-2021-03-R-win32-x86_64/workspaceWEB/spupdownex01/src/main/webapp/resources/upimage/";
		String path2 = "D:/kjh/apache-tomcat-9.0.56/wtpwebapps/spupdownex01/resources/upimage";
		
		for(MultipartFile mf : fileList) { //list에 저장된 MultipartFile객체를 객체별로 반복 처리
			String originFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			System.out.println("orginFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);
			
			long pfix = System.currentTimeMillis();
			String safeFile1 = path1 + pfix + originFileName;
			String safeFile2 = path2 + pfix + originFileName;
			
			String dfile = pfix + originFileName;
			try {
				mf.transferTo(new File(safeFile1));
				mf.transferTo(new File(safeFile2));
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return "complete";
	}
	
	@RequestMapping("/download")
	   public void download(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
	      System.out.println("download");
	      //<a href="download?file_name= 으로 요청한 것의 parameter를 반환
	      String fileName = request.getParameter("file_name");
	      String sDownloadPath = "C:/ecl/workspaceWEB/spupdownex01/src/main/webapp/resources/upimage/";
	      String sFilePath = sDownloadPath + fileName; //파일 경로
	      
	      byte b[] = new byte[4096]; //파일을 읽어와 바이트로 저장하는 배열(이미지등은 텍스트로는 못받아서 stream으로 받음)
	      //파일로 부터 읽어오는 InputStream(byte형태로 읽어옴)
	      FileInputStream fileInputStream = new FileInputStream(sFilePath);
	      String sMimeType = request.getServletContext().getMimeType(sFilePath);
	      //파일의 형태를 나타내는 MimeType을 구함 type/subtype로 구성되며 type은 카테고리 subtype은 각각의 타입
	      //text/plain, text/html, image/jpeg
	      if(sMimeType == null)
	         sMimeType = "application/octet-stream";
	      String sEncoding = new String(fileName.getBytes("UTF-8"), "8859_1");
	      //fileName에서 UTF-8형태로 된 byte값을 8859-1로 인코딩하여 변환
	      //파일에서 읽어온 바이트스트림에 대한 인코딩방식을 response객체에 설정
	      response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
	      //읽어온 바이트스트림을 출력 스트림에 써주면 client로 전달
	      ServletOutputStream servletOutStream = response.getOutputStream();
	      int numRead;
	      while((numRead = fileInputStream.read(b,0,b.length))!= -1) {
	         //read(저장바이트배열,시작색인번호,최대 개수)는 파일인풋스트림에서 총 읽은 바이트 숫자를 반환
	         //-1은 읽은 값이 없음( -1값은 EOF(파일의 끝을 나타내는 숫자)인데 이것이 나올때 까지 반복 해라)
	         servletOutStream.write(b,0,numRead);
	      }
	      servletOutStream.flush(); //buffer clear
	      
	      servletOutStream.close();
	      fileInputStream.close();
	   }
}
