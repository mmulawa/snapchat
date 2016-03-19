package training.snapchat.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import training.snapchat.config.ApplicationContext;
import training.snapchat.config.JdbcContext;
import training.snapchat.config.ServletConfigContext;
import training.snapchat.config.SpringWebConfig;

/**
 * Created by Marcin on 2016-03-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletConfigContext.class, SpringWebConfig.class, JdbcContext.class
        , ApplicationContext.class})
//@Rollback
@Transactional
@WebAppConfiguration
public abstract class TestBase {


}

