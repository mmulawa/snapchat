package training.snapchat.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import training.snapchat.config.ApplicationContext;
import training.snapchat.entity.Message;
import training.snapchat.service.Gender;
import training.snapchat.service.MessageService;

/**
 * Created by Marcin on 2016-03-19.
 */
public class MessageServiceTest extends TestBase {

    @Autowired
    MessageService service;

    @Test
    public void test() {
        Message message = new Message();
        message.setFirstName("Emilia");
        message.setContent("Content");
        Message saved = service.save(message);
        Assert.assertEquals(Gender.FEMALE, saved.getGender());
    }

}
