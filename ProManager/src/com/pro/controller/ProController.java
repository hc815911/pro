package com.pro.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.dao.ProDao;
import com.pro.bean.Pro;
import com.pro.dao.ProDao;
import com.pro.bean.Pro;
import com.pro.dao.ProDao;
import com.pro.bean.Pro;
import com.pro.dao.ProDao;
import com.pro.bean.Pro;
import com.pro.dao.ProDao;

@Controller
public class ProController {

	@RequestMapping(value="/gotoallpage")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		List<Pro> proList = new ArrayList<Pro>();
		proList = dao.queryAll();
		model.addAttribute("pro", proList);
		return "pro";
	}
	@RequestMapping(value = "/queryByName")
	public String queryByName(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		List<Pro> proList = new ArrayList<Pro>();
		proList = dao.queryByName(name);
		model.addAttribute("pro", proList);
		return "pro";
	}
	@RequestMapping(value="/searchpro")
	public String goToNewPage(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		List<Pro> proList = new ArrayList<Pro>();
		proList = dao.queryAll();
		model.addAttribute("pro", proList);

		return "searchpro";
	}
	@RequestMapping(value = "/add")
	public String Addpro(String name, String birthday, String team, String goal,String assist,String card,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		Pro pro = new Pro();
		pro.setName(name);
		pro.setBirthday(birthday);
		pro.setTeam(team);
		pro.setGoal(Integer.parseInt(goal));
		pro.setAssist(Integer.parseInt(assist));
		pro.setCard(Integer.parseInt(card));
		boolean result = dao.addPro(pro);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("不ok");
		}
		model.addAttribute("pro", dao.queryAll());
		return "pro";
	}
	@RequestMapping(value="/addpro")
	public String goToAddPage(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		List<Pro> proList = new ArrayList<Pro>();
		proList = dao.queryAll();
		model.addAttribute("pro", proList);

		return "addpro";
	}
	@RequestMapping(value="/login.do")
	public String goToPage(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		List<Pro> proList = new ArrayList<Pro>();
		proList = dao.queryAll();
		model.addAttribute("pro", proList);

		return "pro";
	}
	@RequestMapping(value="/delete")
	public String deleteById(String id,Model model) {
		//连接Dao层，运用applicationcontext方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		//建立一个boolean变量，对本次操作数据库的结果进行判断；
		boolean result = dao.deletePro(Integer.parseInt(id));
		if (result) {
			System.out.println("消除成功");
		} else {
			System.out.println("消除失败");
		}
		model.addAttribute("pro", dao.queryAll());
       //将最新的数据库信息返回到前台JSP页面；
		return "delpro";
	}

	@RequestMapping(value="/delpro")
	public String goTodelPage(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		List<Pro> proList = new ArrayList<Pro>();
		proList = dao.queryAll();
		model.addAttribute("pro", proList);

		return "delpro";
	}

	@RequestMapping(value = "/update")
	public String Updatepro(String name, String birthday, String team, String goal,String assist,String card,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		Pro pro = new Pro();
		pro.setName(name);
		pro.setBirthday(birthday);
		pro.setTeam(team);
		pro.setGoal(Integer.parseInt(goal));
		pro.setAssist(Integer.parseInt(assist));
		pro.setCard(Integer.parseInt(card));
		boolean result = dao.addPro(pro);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("不ok");
		}
		model.addAttribute("pro", dao.queryAll());
		return "updatepro";
	}
	@RequestMapping(value="/updatepro")
	public String goToupdatePage(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		List<Pro> proList = new ArrayList<Pro>();
		proList = dao.queryAll();
		model.addAttribute("pro", proList);

		return "updatepro";
	}
	@RequestMapping(value="/checkname.do")
	protected void checkname(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		String name = request.getParameter("name");
		boolean answer = dao.checkname(name);
		String result  = null;
		if (answer==true){
			result = "<font color ='red'>名字不可使用</font>";
		}else {
			result = "<font color = 'green'>名字可以使用</font>";
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);

	}
	@RequestMapping(value = "/getOutPutToCsv")
	public String getOutPutToWord(Model model) {
		// 使用ApplicationContext方法，链接dao层，获取查询数据库的相关方法
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 创建一个StudentDao类型的变量，将使用context方法获取到的applicationContext.xml配置文件里的dao层的路径；
		ProDao dao = (ProDao) context.getBean("dao");
		// 创建集合，将从数据库查询到的信息存放到集合中
		List<Pro> proList = new ArrayList<>();
		// 调取dao层里的queryAll方法，获取数据库总信息
		proList = dao.queryAll();
		// 使用model方法，将获取到的信息，返回到前台jsp页面
		// 其中addAttribute括号内，第一个参数是用来指定将查询信息返回到jsp页面的具体位置，第二个参数，是用来指定查询结果来返回
		model.addAttribute("pro", proList);
		// 返回student.jsp页面
		// TODO:OutputToWord
		File outputFilePath = new File("C:\\Users\\admin\\Desktop\\output");
		System.out.println(outputFilePath);
		try {
			outputFilePath = getWordFileByProList(proList);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		model.addAttribute("outputFilePath", outputFilePath);
		return "pro";
	}

	private File getWordFileByProList(List<Pro> proList) throws FileNotFoundException  {
		// TODO 自動生成
		File csvFile = null;
		String fileName = "pro";
		BufferedWriter csvFileOutputStream = null;
		try {
			File file = new File("C:\\Users\\admin\\Desktop\\output");
			if (!file.exists()) {
				file.mkdir();
			}
			// 定义文件名格式并创建
			csvFile = File.createTempFile(fileName, ".csv", new File("C:\\Users\\admin\\Desktop\\output"));
			System.out.println("csvFile：" + csvFile);
			// UTF-8使正确读取分隔符","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GBK"),
					1024);
			System.out.println("csvFileOutputStream：" + csvFileOutputStream);
			// foreach（拡張for文）での書き方
			// 学生の1個ずつ取り出す
			for (Pro value : proList) {
				// 学生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
				csvFileOutputStream.write(value.getId()+",");
				csvFileOutputStream.write(value.getName()+",");
				csvFileOutputStream.write(value.getBirthday()+",");
				csvFileOutputStream.write(value.getTeam()+",");
				csvFileOutputStream.write(value.getGoal()+",");
				csvFileOutputStream.write(value.getAssist()+",");
				csvFileOutputStream.write(value.getCard()+",");
				csvFileOutputStream.write("\r\n");
			}
			// 写入文件头部
			// for (Iterator propertyIterator = ((Map) studentList).entrySet().iterator();
			// propertyIterator.hasNext();) {
			// java.util.Map.Entry propertyEntry = (java.util.Map.Entry)
			// propertyIterator.next();
			// csvFileOutputStream.write((String) propertyEntry.getValue() != null
			// ? new String(((String) propertyEntry.getValue()).getBytes("GBK"), "GBK")
			// : "");
			// if (propertyIterator.hasNext()) {
			// csvFileOutputStream.write(",");
			// }
			// System.out.println(new String(((String)
			// propertyEntry.getValue()).getBytes("GBK"), "GBK"));
			// }
			// csvFileOutputStream.write("\r\n");
			// 写入文件内容
			// for (Iterator<Student> iterator = studentList.iterator();
			// iterator.hasNext();) {
			// Object row = (Object) iterator.next();
			// for (Iterator propertyIterator = ((Map) studentList).entrySet().iterator();
			// propertyIterator.hasNext();) {
			// java.util.Map.Entry propertyEntry = (java.util.Map.Entry)
			// propertyIterator.next();
			// csvFileOutputStream.write((String) BeanUtils.getProperty(row,
			// ((String) propertyEntry.getKey()) != null ? (String) propertyEntry.getKey() :
			// ""));
			// if (propertyIterator.hasNext()) {
			// csvFileOutputStream.write(",");
			// }
			// }
			// if (iterator.hasNext()) {
			// csvFileOutputStream.write("\r\n");
			// }
			// }
			csvFileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;



	}





	}
