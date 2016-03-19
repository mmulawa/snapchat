package training.snapchat.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.snapchat.entity.Message;
import training.snapchat.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Autowired
    GenderResolver genderResolver;

    public Message save(Message message) {
        message.setDate(new Date());
        if (message.getFirstName() != null) {
            message.setGender(genderResolver.resolveGender(message.getFirstName()));
        }
        return this.repository.save(message);
    }

    public List<Message> list() {
        return this.repository.findAll();
    }

    public List<Message> getNewMessages(Message lastDate) {
        long curTimeInMs = lastDate.getDate().getTime();
        Date afterAddingMins = new Date(curTimeInMs + (1 * 60000));

        return this.repository.getNewMessages(afterAddingMins);
    }

}