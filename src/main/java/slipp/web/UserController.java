package slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import slipp.model.User;
import slipp.model.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PutMapping("/{id}")
	public String update(@PathVariable Long id, User user) {
		User dbUser = userRepository.findOne(id);
		dbUser.update(user);
		userRepository.save(dbUser);
		return "redirect:/users";
	}

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.findOne(id));
		return "/user/updateForm";
	}
	
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}
	
	@PostMapping("")
	public String create(User user, Model model) {
		System.out.println("user : " + user);
		userRepository.save(user);
		return "redirect:/users";
	}
}
