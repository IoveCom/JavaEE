package edu.lnut.controller;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.lnut.po.FilmInfo;
import edu.lnut.po.Records;
import edu.lnut.po.Theme;
import edu.lnut.po.User;
import edu.lnut.service.FilmInfoService;
import edu.lnut.service.InsertUserService;
import edu.lnut.service.ThemeService;
import edu.lnut.service.UserRecordService;
import edu.lnut.service.UserService;


@Controller
public class FilmController {
	@Autowired
	private ThemeService themeService;
	@Autowired
	private FilmInfoService filmInfoService;
	@Autowired
	private UserService userService;// 查找用户信息
	@Autowired
	private UserRecordService userRecordService;
	@Autowired
	private InsertUserService insertUserService;

	@RequestMapping(value = "/index")
	public String findListTheme(Model model, HttpServletRequest request) {
		List<Theme> themes = themeService.findThemeList();
		model.addAttribute("themes", themes);
		List<Theme> themes2 = themeService.findFilmThemeList("");
		List<FilmInfo> filmInfos = new ArrayList<FilmInfo>();
		for (Theme theme : themes2) {
			for (FilmInfo filmInfo : theme.getFilmInfos()) {
				filmInfos.add(filmInfo);
			}
		}
		removeDuplicate(filmInfos);
		model.addAttribute("fileinfo", filmInfos);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		// 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
		if (user != null) {
			model.addAttribute("state", "<li><a href=\"" + request.getContextPath() + "/exit\">退出登录</a></li>");
			model.addAttribute("username", user.getUsername());
		} else {
			model.addAttribute("state", "<li><a href=\"" + request.getContextPath() + "/login\">请登录</a></li>");
			model.addAttribute("username", "用户");
		}
		// 不符合条件的给出提示信息，并转发到登录页面
		return "index";
	}

	@RequestMapping(value = "/index", params = "type")
	public String findListTypeTheme(Model model, @RequestParam(value = "type") String type,
			HttpServletRequest request) { // 按照类型查找电影
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		// 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
		if (user != null) {
			model.addAttribute("state", "<li><a href=\"" + request.getContextPath() + "/exit\">退出登录</a></li>");
			model.addAttribute("username", user.getUsername());
		} else {
			model.addAttribute("state", "<li><a href=\"" + request.getContextPath() + "/login\">请登录</a></li>");
			model.addAttribute("username", "用户");
		}
		List<Theme> themes = themeService.findThemeList();
		model.addAttribute("themes", themes);
		List<Theme> themes2 = themeService.findFilmThemeList(type);
		List<FilmInfo> filmInfos = new ArrayList<FilmInfo>();
		for (Theme theme : themes2) {
			for (FilmInfo filmInfo : theme.getFilmInfos()) {
				filmInfos.add(filmInfo);
			}
		}
		model.addAttribute("fileinfo", filmInfos);
		return "index";
	}

	

	@RequestMapping(value = "/context", params = "film_id") // 访问电影列表时进行了拦截
	public String showFilm(Model model, @RequestParam(value = "film_id") String film_id, Model model2,
			HttpSession session) {
		List<FilmInfo> filmInfos = filmInfoService.selectFilmInfoList(film_id); // 按照点击的电影查找电影信息数据库，返回电影信息列表，其中包含电影所有类型
		List<Theme> filmThemes = new ArrayList<Theme>();
		User user = (User) session.getAttribute("USER_SESSION");
		model2.addAttribute("contextUsername", user.getUsername());
		// System.out.println(filmInfos);
		for (FilmInfo filmInfo : filmInfos) {
			filmThemes = filmInfo.getThemes(); // 获取一部电影的所有类型。
		}
		model2.addAttribute("filmInfos", filmInfos);
		model2.addAttribute("filmthemes", filmThemes);
		return "context";
	}

	@RequestMapping(value = "/login")
	public String redirectlogin() {
		return "login";
	}

	@RequestMapping(value = "/userlogin", params = "id") // 验证登录信息，添加用户SESSION
	public String selectUser(Model model, @RequestParam(value = "id") String userName,
			@RequestParam(value = "passwd") String password, HttpSession session) {
		User user = userService.findUserInfo(userName);
		if (user != null) {
			if (user.getPassword().equals(password.trim())) {
				session.setAttribute("USER_SESSION", user);
//                System.out.println("用户登录成功");
				return "redirect:index.jsp";
			} else {
				model.addAttribute("msg",
						"  <div class=\"col-md-6 col-lg-offset-1 alert alert-danger alert-dismissable\" style=\"text-align: center;\">\r\n"
								+ "              <button type=\"button\" class=\"close\" data-dismiss=\"alert\"\r\n"
								+ "                      aria-hidden=\"true\">\r\n" + "                &times;\r\n"
								+ "              </button>\r\n" + "              用户名或密码错误!\r\n" + "            </div>");
				// TODO: handle exception
				return "login";
			}
		}
		model.addAttribute("msg",
				"  <div class=\"col-md-6 col-lg-offset-1 alert alert-danger alert-dismissable\" style=\"text-align: center;\">\r\n"
						+ "              <button type=\"button\" class=\"close\" data-dismiss=\"alert\"\r\n"
						+ "                      aria-hidden=\"true\">\r\n" + "                &times;\r\n"
						+ "              </button>\r\n" + "              用户不存在!\r\n" + "            </div>");
		// TODO: handle exception
		return "login";
	}

	@RequestMapping(value = "/exit")
	public String userExit(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}

	@RequestMapping(value = "/history") // 历史记录请求
	public String showHistory(HttpSession session, Model model, HttpServletRequest request) throws ParseException {
		User user = (User) session.getAttribute("USER_SESSION");
		List<Records> records = new ArrayList<Records>();

		model.addAttribute("state", "<li><a href=\"" + request.getContextPath() + "/exit\">退出登录</a></li>");
		model.addAttribute("username", user.getUsername());
		if (user != null) {
			records = userRecordService.findUserRecord(user.getUserid());
		}
		model.addAttribute("records",records);
		return "/history";
	}

	@RequestMapping(value = "/gotoregister")//注册页面
	public String gotoRegister() {
		return "register";
	}

	@RequestMapping(value = "/register")
	public String registerUser(Model model, @RequestParam(value = "id") String userName,
			@RequestParam(value = "passwd") String passwd, @RequestParam(value = "email") String email) {
		String msg = "";
		if (checkBoolean(userName, "[\u4E00-\u9FA5]{2,7}")) {
			if (checkBoolean(passwd, "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$")) {
				if (checkBoolean(email, "^\\w+@\\w+\\.\\w+$")) {
					User user = new User();
					user.setUsername(userName);
					user.setEmail(email);
					user.setPassword(passwd);
					insertUserService.insertUser(user);
					msg = "" + "注册成功,去登录↓↓↓";
					model.addAttribute("msg",
							"<div class=\"col-md-6 col-lg-offset-1 alert alert-danger alert-dismissable\" style=\"text-align: center;\">\r\n"
									+ " <button type=\"button\" class=\"close\" data-dismiss=\"alert\"\r\n"
									+ " aria-hidden=\"true\">\r\n" + " &times;\r\n" + " </button>\r\n" + " " + msg
									+ "\r\n" + " </div>");
					return "register";
				}
				msg = msg + "邮箱格式错误 ";
			}
			msg = msg + "密码格式错误 ";
		}
		msg = msg + "用户名格式错误 ";
		model.addAttribute("msg",
				"<div class=\"col-md-6 col-lg-offset-1 alert alert-danger alert-dismissable\" style=\"text-align: center;\">\r\n"
						+ "<button type=\"button\" class=\"close\" data-dismiss=\"alert\"\r\n"
						+ " aria-hidden=\"true\">\r\n" + " &times;\r\n" + " </button>\r\n" + " " + msg + "\r\n"
						+ " </div>");
		return "register";
	}

	@RequestMapping(value = "/ajax",method = RequestMethod.POST)
    @ResponseBody//这个注解通常使用在控制层(controller)的方法上，其作用是将方法的返回值以特定的格式写入到response的body区域，进而将数据返回给客户端。
    public User ajaxUser(@RequestBody User user){	
    	User tempUser = new User();
    	String userEmail = user.getEmail();
    	String userName = user.getUsername();
    
    	if(user != null) {
    		if (userEmail !=null && userEmail !="") {
    			User t = userService.findUserEmail(userEmail);
    			if (t !=null) {
    				tempUser.setEmail(t.getEmail());
    			}
        }
    		if(userName !=null &&userEmail!="") {
    			User t  = userService.findUserInfo(userName);
    			if (t !=null ) {
    				tempUser.setUsername(t.getUsername()); 
				}
    		}
    	}
        return tempUser;
    }

	public Boolean checkBoolean(String str, String pattern) {
		boolean isMatch = Pattern.matches(pattern, str);
		return isMatch;
	}
	// 利用HashSet不拥有重复值的属性删除List<Fileinfo>的重复值,重写了Bean的HasCode方法
		private void removeDuplicate(List<FilmInfo> list) {
			HashSet<FilmInfo> set = new HashSet<FilmInfo>(list.size());
			List<FilmInfo> result = new ArrayList<FilmInfo>(list.size());
			for (FilmInfo str : list) {
				if (set.add(str)) {
					result.add(str);
				}
			}
			list.clear();
			list.addAll(result);
		}
		
		
}