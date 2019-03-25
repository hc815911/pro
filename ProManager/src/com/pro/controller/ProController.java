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
			System.out.println("��ok");
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
		//����Dao�㣬����applicationcontext����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProDao dao = (ProDao) context.getBean("dao");
		//����һ��boolean�������Ա��β������ݿ�Ľ�������жϣ�
		boolean result = dao.deletePro(Integer.parseInt(id));
		if (result) {
			System.out.println("�����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
		model.addAttribute("pro", dao.queryAll());
       //�����µ����ݿ���Ϣ���ص�ǰ̨JSPҳ�棻
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
			System.out.println("��ok");
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
			result = "<font color ='red'>���ֲ���ʹ��</font>";
		}else {
			result = "<font color = 'green'>���ֿ���ʹ��</font>";
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);

	}
	@RequestMapping(value = "/getOutPutToCsv")
	public String getOutPutToWord(Model model) {
		// ʹ��ApplicationContext����������dao�㣬��ȡ��ѯ���ݿ����ط���
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ����һ��StudentDao���͵ı�������ʹ��context������ȡ����applicationContext.xml�����ļ����dao���·����
		ProDao dao = (ProDao) context.getBean("dao");
		// �������ϣ��������ݿ��ѯ������Ϣ��ŵ�������
		List<Pro> proList = new ArrayList<>();
		// ��ȡdao�����queryAll��������ȡ���ݿ�����Ϣ
		proList = dao.queryAll();
		// ʹ��model����������ȡ������Ϣ�����ص�ǰ̨jspҳ��
		// ����addAttribute�����ڣ���һ������������ָ������ѯ��Ϣ���ص�jspҳ��ľ���λ�ã��ڶ���������������ָ����ѯ���������
		model.addAttribute("pro", proList);
		// ����student.jspҳ��
		// TODO:OutputToWord
		File outputFilePath = new File("C:\\Users\\admin\\Desktop\\output");
		System.out.println(outputFilePath);
		try {
			outputFilePath = getWordFileByProList(proList);
		} catch (FileNotFoundException e) {
			// TODO �Ԅ����ɤ��줿 catch �֥�å�
			e.printStackTrace();
		}
		model.addAttribute("outputFilePath", outputFilePath);
		return "pro";
	}

	private File getWordFileByProList(List<Pro> proList) throws FileNotFoundException  {
		// TODO �Ԅ�����
		File csvFile = null;
		String fileName = "pro";
		BufferedWriter csvFileOutputStream = null;
		try {
			File file = new File("C:\\Users\\admin\\Desktop\\output");
			if (!file.exists()) {
				file.mkdir();
			}
			// �����ļ�����ʽ������
			csvFile = File.createTempFile(fileName, ".csv", new File("C:\\Users\\admin\\Desktop\\output"));
			System.out.println("csvFile��" + csvFile);
			// UTF-8ʹ��ȷ��ȡ�ָ���","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GBK"),
					1024);
			System.out.println("csvFileOutputStream��" + csvFileOutputStream);
			// foreach������for�ģ��ǤΕ�����
			// ѧ����1������ȡ�����
			for (Pro value : proList) {
				// ѧ����1�����Ķɤ���PrintStudent�᥽�åɤ���ӳ�������ʾ�I��
				csvFileOutputStream.write(value.getId()+",");
				csvFileOutputStream.write(value.getName()+",");
				csvFileOutputStream.write(value.getBirthday()+",");
				csvFileOutputStream.write(value.getTeam()+",");
				csvFileOutputStream.write(value.getGoal()+",");
				csvFileOutputStream.write(value.getAssist()+",");
				csvFileOutputStream.write(value.getCard()+",");
				csvFileOutputStream.write("\r\n");
			}
			// д���ļ�ͷ��
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
			// д���ļ�����
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
