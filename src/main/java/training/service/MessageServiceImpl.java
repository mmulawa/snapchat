package training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.repository.MessageRepository;
import training.snapchat.entity.Message;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository repository;

	@Override
	public Message save(Message message) {
		
		return this.repository.save(message);

	}

}
pa