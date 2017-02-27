package cloud.simple.service.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.service.domain.UserService;
import cloud.simple.service.model.User;

@RestController
@Controller
@RefreshScope
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> readUserInfo(){
		
		//request.getLocalName()
		//request.getServerName()
		List<User> ls=userService.searchAll();
		User user = new User();
		user.setUsername("rrr");
		ls.add(user);
		return ls;
	}
}
