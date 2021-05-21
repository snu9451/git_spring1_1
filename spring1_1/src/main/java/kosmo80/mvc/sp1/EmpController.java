package kosmo80.mvc.sp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmpController extends MultiActionController {
	Logger logger = Logger.getLogger(EmpController.class);
	private EmpLogic empLogic = null;
	//setter 객체 주입코드
	public void setEmpLogic(EmpLogic empLogic) {
		this.empLogic = empLogic;
	}
	
	// webapp/WEB-INF/views/di/getEmpList.jsp 를 보게됨
	public ModelAndView getEmpList(HttpServletRequest req
			, HttpServletResponse res) {
		logger.info("getEmpList  호출 성공");
		ModelAndView mav = new ModelAndView();
		/*
		<property name="prefix" value="/WEB-INF/views/"/>
		<property name="suffix" value=".jsp"/>
		/WEB-INF/views/getEmpList.jsp
		 */
		List<Map<String,Object>> empList = new ArrayList<>();
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("mem_name", "이순신장군");
		empList.add(rmap);
		//NPE가 안 일어남.
		empList = empLogic.getEmpList();
		//ModelAndView는 scope속성이 request이다.
		mav.addObject("empList", empList);
		mav.setViewName("di/getEmpList");
		
		return mav;
		//return "redirect:getEmpList.jsp";
	}
	
	// webapp/di/getEmpList.jsp 를 보게됨
//	public void getEmpList(HttpServletRequest req
//			, HttpServletResponse res) throws Exception {
//		logger.info("getEmpList  호출 성공");
//		List<Map<String,Object>> empList = new ArrayList<>();
//		empList = empLogic.getEmpList();
//		req.setAttribute("empList", empList);
////		res.sendRedirect("getEmpList.jsp"); // 요청이 끊어진다. 유지가 안 된다.
//		RequestDispatcher view = req.getRequestDispatcher("getEmpList.jsp");
//		view.forward(req, res);
//	}
//	public void empInsert(HttpServletRequest req
//			            , HttpServletResponse res) 
//	throws Exception
//	{
//		logger.info("empInsert  호출 성공");
//		res.sendRedirect("/di/empInsertOk.jsp");
//	}
}
