package com.staff.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.staff.entity.Account;
import com.staff.entity.Attendance;
import com.staff.service.AccountService;
import com.staff.service.AttendanceService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/account")
public class AccountController{
	@Autowired
	private AccountService accountService;
	@Autowired
	private AttendanceService attendanceService;
	
	JSONObject result;

	@RequestMapping(value="/selectAll")
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		List<Account> accounts = accountService.selectAll();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(accounts);
		response.getWriter().append(json);
	}

	@RequestMapping("/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		result = new JSONObject();
		Account account = new Account(
			null,
			Integer.valueOf(request.getParameter("accountNumber")),
			request.getParameter("name"),
			MessageDigestUtil.getMD5(request.getParameter("password")),
			request.getParameter("position")
			);
		Integer row = accountService.insert(account);
		if(row == 1){
			result.put("success", true);
		}else{
			result.put("errorMsg", "增加失败");
		}
		response.getWriter().append(result.toString());
	}

	@RequestMapping(value="/update")
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		result = new JSONObject();
		Account account = new Account(
					null,
					Integer.valueOf(request.getParameter("accountNumber")),
					request.getParameter("name"),
					request.getParameter("password"),
					request.getParameter("position")
					);
		Integer row = accountService.update(account);
		if(row == 1){
			result.put("success", true);
		}else{
			result.put("errorMsg", "修改失败");
		}
		response.getWriter().append(result.toString());
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		result = new JSONObject();
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer row = accountService.delete(id);
		if(row == 1){
			result.put("success", true);
		}else{
			result.put("errorMsg", "删除失败");
		}
		System.out.println("result:"+result.toString());
		response.getWriter().append(result.toString());
	}

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dbh");
		result = new JSONObject();
		String name = request.getParameter("username");
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		password = MessageDigestUtil.getMD5(password);
		String position = request.getParameter("position");
		Account account = new Account(null, null, name, password, position);
		Integer row = accountService.login(account);
		if(row != null){
			session.setAttribute("name", name);
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		response.getWriter().append(result.toString());
	}

	@RequestMapping("/register")
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		result = new JSONObject();
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		Integer id = jsonObject.getInt("id");
		if(accountService.selectById(id) == null){
			String name = jsonObject.getString("username");
			String password = jsonObject.getString("password");
			password = MessageDigestUtil.getMD5(password);
			Account account = new Account(null, id, name, password, "staff");
			Integer row2 = accountService.insert(account);
			if(row2 != null){
				result.put("success", true);
			}else{
				result.put("success", false);
			}
		}else{
			result.put("Msg", "ID已存在");
		}
		response.getWriter().append(result.toString());
	}

	@RequestMapping("/attendance")
	public void attendance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		result = new JSONObject();
		String name = request.getParameter("name");
		String checkType = request.getParameter("checkType"); 
		String charType = request.getParameter("charType");
		String time = request.getParameter("time");
        Date d = new Date();
        java.sql.Timestamp  date=new java.sql.Timestamp(d.getTime());
        java.sql.Date dt = new java.sql.Date(d.getTime());
        if("up".equals(checkType)){
			if("str".equals(charType)){
				if(accountService.selectName(name) != null){
					List<Integer> ids = accountService.selectName(name);
					Iterator<Integer> it = ids.iterator();
					int i=0;
					Integer nameId = null;
					while(it.hasNext()){
						nameId = it.next();
						i++;
					}
					if(i>1){
						result.put("Msg", "此用户重名请输入ID");
					}else{
						if(attendanceService.selectIdAndDate(nameId, dt) != null){
				        	if(attendanceService.idAndCheckIn(nameId, dt) == null){
								Integer row = attendanceService.updateCheckInTime(date,nameId);
								if(row != null){
									result.put("success", true);
								}else{
									result.put("success", false);
								}
				        	}else{
								result.put("Msg", "您已签到");
				        	}
						}else{
							Attendance attendance = new Attendance(null ,nameId, name, dt, date, null, null);
							Integer row = attendanceService.insert(attendance);
							if(row != null){
								result.put("success", true);
							}else{
								result.put("success", false);
							}
						}
		        	}
				}else{
					result.put("Msg", "此用户不存在");
				}
			}else{
				if(accountService.selectById(Integer.valueOf(name)) != null){
					Integer id = Integer.valueOf(name);
					if(attendanceService.selectIdAndDate(id, dt) != null){
			        	if(attendanceService.idAndCheckIn(id, dt) == null){
							Integer row = attendanceService.updateCheckInTime(date,id);
							if(row != null){
								result.put("success", true);
							}else{
								result.put("success", false);
							}
			        	}else{
							result.put("Msg", "您已签到");
			        	}
					}else{
						Attendance attendance = new Attendance(null, id, name, dt, date, null, null);
						Integer row = attendanceService.insert(attendance);
						if(row != null){
							result.put("success", true);
						}else{
							result.put("success", false);
						}
					}
				}else {
					result.put("Msg", "此用户不存在");
				}
				
			}
        }else{
			if("str".equals(charType)){
				if(accountService.selectName(name) != null){
					List<Integer> ids = accountService.selectName(name);
					Iterator<Integer> it = ids.iterator();
					int i=0;
					Integer nameId = null;
					while(it.hasNext()){
						nameId = it.next();
						i++;
					}
					if(i>1){
						result.put("Msg", "此用户重名请输入ID");
					}else{
						if(attendanceService.selectIdAndDate(nameId, dt) != null){
				        	if(attendanceService.idAndReturn(nameId, dt) == null){
								Integer row = attendanceService.updateDate(date,nameId);
								if(row != null){
									result.put("success", true);
								}else{
									result.put("success", false);
								}
				        	}else{
								result.put("Msg", "您已签退");
				        	}
						}else{
							Attendance attendance = new Attendance(null, nameId, name, dt, null, date, null);
							Integer row = attendanceService.insert(attendance);
							if(row != null){
								result.put("success", true);
							}else{
								result.put("success", false);
							}
						}
					}
				}else{
					result.put("Msg", "此用户不存在");
				}
			}else{
				if(accountService.selectById(Integer.valueOf(name)) != null){
					Integer id = Integer.valueOf(name);
					name = accountService.selectById(id);
					if(attendanceService.selectIdAndDate(id, dt) != null){
			        	if(attendanceService.idAndReturn(id, dt) == null){
							Integer row = attendanceService.updateDate(date,id);
							if(row != null){
								result.put("success", true);
							}else{
								result.put("success", false);
							}
			        	}else{
							result.put("Msg", "您已签退");
			        	}
					}else{
						Attendance attendance = new Attendance(null, id, name, dt, null, date, null);
						Integer row = attendanceService.insert(attendance);
						if(row != null){
							result.put("success", true);
						}else{
							result.put("success", false);
						}
					}
				}else {
					result.put("Msg", "此用户不存在");
				}
				
			}
        }
		response.getWriter().append(result.toString());
	}
}
