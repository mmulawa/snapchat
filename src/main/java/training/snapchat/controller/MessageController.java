package training.snapchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String index(Model model) {
		List<Message> list = this.messageService.list();
		model.addAttribute("list", list);
		return "message/index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HttpEntity<Message> add(@RequestBody Message message) {
		message = this.messageService.save(message);
		return new HttpEntity<Message>(message);
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public HttpEntity<List<Message>> newMessages(@RequestBody Message lastMessage) {
		List<Message> newMessages = this.messageService.getNewMessages(lastMessage);
		return new HttpEntity<List<Message>>(newMessages);
	}

}
