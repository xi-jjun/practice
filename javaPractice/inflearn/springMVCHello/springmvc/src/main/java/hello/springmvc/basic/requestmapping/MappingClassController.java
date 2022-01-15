package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class MappingClassController {
	//	@GetMapping("/users/{userId}")
//	public String user(@PathVariable("userId") String userId) {
//		log.info("get user id = {}", userId);
//		return "get users";
//	}
//
//	@GetMapping("/users")
//	public String users() {
//		return "get users";
//	}
//
//	@PostMapping("/users/new")
//	public String addUser(HttpServletRequest request) {
//		String username = request.getParameter("username");
//		int age = Integer.parseInt(request.getParameter("age"));
//		log.info("name is {}", username);
//		log.info("age is {}", age);
//		return "add user";
//	}
//
//	@PostMapping("/users/{userId}/delete")
//	public String deleteUser(@PathVariable("userId") String userId) {
//		log.info("delete userId = {}", userId);
//		return "delete user";
//	}
//
//	@PostMapping("/users/{userId}/edit")
//	public String updateUser(@PathVariable("userId") String id) {
//		log.info("modify id = {}", id);
//		return "update user";
//	}
	@GetMapping("/mapping/users")
	public String user() {
		return "get users";
	}

	@PostMapping("/mapping/users") // control URI 가 아닌, 처음에 배웠던 HTTP method 를 이용한 API 설계를 체험하기 위해
	public String addUser() {
		return "post user";
	}

	@GetMapping("/mapping/users/{userId}")
	public String findUser(@PathVariable("userId") String userId) {
		return "get User " + userId;
	}

	@PatchMapping("/mapping/users/{userId}")
	public String updateUser(@PathVariable("userId") String userId) {
		return "update user " + userId;
	}

	@DeleteMapping("/mapping/users/{userId}")
	public String deleteUser(@PathVariable("userId") String userId) {
		return "delete user " + userId;
	}
}
