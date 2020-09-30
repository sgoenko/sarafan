package by.hay.sarafan.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.hay.sarafan.exceptions.NotFoundException;

@RestController
@RequestMapping("message")
public class MessageController {
	private int counter = 4;
	private List<Map<String,String>> messages = new ArrayList<Map<String,String>>() {{
		add(new HashMap<String,String>() {{put("id","1"); put("text","First message");}});
		add(new HashMap<String,String>() {{put("id","2"); put("text","Second message");}});
		add(new HashMap<String,String>() {{put("id","3"); put("text","Thirt message");}});
	}};

	@GetMapping()
	public List<Map<String,String>> list() {
		return messages;
	}
	
	@GetMapping("{id}")
	public Map<String,String> getOne(@PathVariable String id) {
		return getMessage(id);
	}
	
	public Map<String,String> getMessage(@PathVariable String id) {
		return messages.stream()
				.filter(message -> message.get("id").equals(id))
				.findFirst().orElseThrow(NotFoundException::new);
	}
	
	@PostMapping
	public Map<String,String> create(@RequestBody Map<String,String>message) {
		message.put("id", String.valueOf(counter++));
		messages.add(message);
		return message;
	}
	
	@PutMapping("{id}")
	public Map<String,String> update(@PathVariable String id, @RequestBody Map<String,String>message) {
		Map<String,String>messageFromDb = getMessage(id);
		
		messageFromDb.putAll(message);
		messageFromDb.put("id", id);
		
		return messageFromDb;
	}
	
	@DeleteMapping("{id}")
	public void delete (@PathVariable String id) {
		Map<String,String> message = getMessage(id);
		
		messages.remove(message);
	}

}
