package com.team02.groupware.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team02.groupware.dto.EmployeeDto;
import com.team02.groupware.service.LoginService;
import com.team02.groupware.service.MessengerService;

/*
 * @file MainController.java
 * @brief 포트폴리오, index view 가는 컨트롤러 모음
 * @author team02 (김건훈,김정훈,김연지,이원준)
 */

@Controller
public class MainController {

	@Autowired
	private LoginService loginService;

	/*
	 * @method portfolio()
	 * 
	 * @brief 포트폴리오 화면
	 * 
	 * @author 김건훈
	 */
	@GetMapping("/")
	public String portfolio() {

		return "portfolio";
	}

	/*
	 * @method index()
	 * 
	 * @brief index 화면
	 * 
	 * @author team02 (김건훈,김정훈,김연지,이원준)
	 */
	@RequestMapping("/index")
	public String index(Model model, HttpSession session, EmployeeDto eDto) {

		
				
		
		return "index";
	}
	
	// 로그인 체크
	@RequestMapping("/loginCheck")
	public String loginCheck(Model model, HttpSession session, EmployeeDto eDto, RedirectAttributes redirectA) {

		String returnURL = "";
		EmployeeDto empDto = loginService.selectEmployee(eDto);
		
		if(empDto != null) {		// 로그인 성공시
			
			session.setAttribute("userId", empDto.getUserId());
			session.setAttribute("userName", empDto.getUserName());
			session.setAttribute("userNickName", empDto.getUserNickName());
			session.setAttribute("userLevel", empDto.getUserLevel());
			session.setAttribute("userCode", empDto.getUserCode());
			session.setAttribute("login", "ok");
			/*
			 * redirectA.addAttribute("userId", empDto.getUserId());
			 * redirectA.addAttribute("userName", empDto.getUserName());
			 * redirectA.addAttribute("userNickName", empDto.getUserNickName());
			 * redirectA.addAttribute("userCode", empDto.getUserCode());
			 * redirectA.addAttribute("userLevel", empDto.getUserLevel());
			 */
			
			returnURL = "redirect:/index";
			
		}else {		// 로그인 실패시
			returnURL = "redirect:/loginPage";
		}
		
		return returnURL;
	}
	
	
	@GetMapping("/loginPage")
	public String loginPage() {

		return "loginPage";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/loginPage";
	}

	@GetMapping("/test")
	public String test() {

		return "test";
	}

}
