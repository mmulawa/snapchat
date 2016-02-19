package training.snapchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training.snapchat.entity.Message;
import training.snapchat.service.MessageService;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "message/index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String add(@RequestBody Message message) {
		this.messageService.save(message);

		return "redirect:/message";
	}

}
