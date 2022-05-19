package com.hcl.UserManagement.web;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.UserManagement.domain.User;
import com.hcl.UserManagement.service.UserService;

@RestController
@RequestMapping("/api/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registration")
	public User registerNewUser(@RequestBody User user ) {
		User savedUser = userService.registration(user);
		return savedUser;
	}
	@PutMapping("/update/{id}")
    public User update(@RequestParam String username,@PathVariable("id") Long id) {
    	return userService.update(username, id);
    }
	@GetMapping("/login")
    
    public ModelAndView User() {
     ModelAndView mav = new ModelAndView("User");
        mav.addObject("user", new User());
        return mav;
    }
 
    @PostMapping("/login")
    public String User(@RequestBody User user ) {
    
     User oauthUser = userService.user(user.getUsername(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
  
     return "redirect:/";
    
    
     } else {
     return "redirect:/login";
    
    
     }
 
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
  
        return "redirect:/login";
    }
 
}


