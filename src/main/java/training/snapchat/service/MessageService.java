package training.snapchat.service;

import java.util.List;

import training.snapchat.entity.Message;

public interface MessageService {
	
	List<Message> list();
	
	Message save(Message message);

	List<Message> getNewMessages(Message lastMessage);

}
