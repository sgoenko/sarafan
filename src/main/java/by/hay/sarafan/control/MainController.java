package by.hay.sarafan.control;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.hay.sarafan.domain.User;
import by.hay.sarafan.repo.MessageRepo;

@Controller
@RequestMapping("/")
public class MainController {
	private final MessageRepo messageRepo;
	
	@Autowired
	public MainController(MessageRepo messageRepo) {
		this.messageRepo = messageRepo;
	}

	@GetMapping
	public String main(Model model, @AuthenticationPrincipal User user) {
		
		HashMap<Object, Object> data = new HashMap<>();
		
		data.put("profile", user);
		data.put("messages",messageRepo.findAll());
		
		model.addAttribute("frontendData", data);
		return "index";
	}
}
