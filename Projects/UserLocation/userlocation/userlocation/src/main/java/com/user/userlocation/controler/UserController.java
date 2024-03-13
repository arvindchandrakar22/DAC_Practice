package com.user.userlocation.controler;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.userlocation.model.User_location;
import com.user.userlocation.service.Userservice;

@RequestMapping("/user")
@RestController
@Transactional
public class UserController {

	@Autowired
	private Userservice userService;
	
	@PostMapping("/create_user")
	public ResponseEntity<User_location> create_user(@RequestBody User_location ul) {
		
		ResponseEntity<User_location> re = null;
		
		User_location localUser = this.userService.adduser(ul);
		
		if(localUser != null)
		{
			re = new ResponseEntity<User_location>(localUser, HttpStatus.OK);
		}
		else
		{
			re = new ResponseEntity<User_location>(localUser, HttpStatus.NOT_FOUND);
		}
		
		return re;
	}

	@PutMapping("/updateuser/{name}")
	public ResponseEntity<User_location> updateuser(@RequestBody User_location ul, @PathVariable("name") String name) {
		
		ResponseEntity<User_location> re = null;
		User_location update = this.userService.updateuser(ul, name);
		
		if(update != null)
		{
			re= new ResponseEntity<User_location>(update, HttpStatus.OK);
		}
		else
		{
			re= new ResponseEntity<User_location>(update, HttpStatus.NOT_FOUND);
		}
		return re;
	}

	@GetMapping("/getuser/{N}")
	public ResponseEntity<List<User_location>> getuser(@PathVariable("N") int n) {
		
		ResponseEntity<List<User_location>> re = null;
		
		List<User_location> list = this.userService.getuser(n);
		
		if(list.isEmpty())
		{
			re= new ResponseEntity<List<User_location>>(list, HttpStatus.NOT_FOUND);
		}
		else
		{
			re= new ResponseEntity<List<User_location>>(list, HttpStatus.OK);
		}
		return re;	
	}

	@DeleteMapping("/delete_User/{name}")
	public ResponseEntity<String> delete_User(@PathVariable("name") String name)
	{
		ResponseEntity<String> re = null;
		boolean bl = this.userService.deleteUser(name);
		
		if(bl)
		{
			re= new ResponseEntity<String>("User DELETED !!",HttpStatus.OK);
		}
		else
		{
			re= new ResponseEntity<String>("User NOT Found.", HttpStatus.NOT_FOUND);
		}
		return re;
		
	}
}
