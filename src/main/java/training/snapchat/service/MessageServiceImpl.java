package training.snapchat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.snapchat.entity.Message;
import training.snapchat.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository repository;

	@Override
	public Message save(Message message) {
		
		return this.repository.save(message);

	}

}