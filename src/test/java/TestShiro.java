import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vanki on 2017/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestShiro {

    @Test
    public void test1() {
        UsernamePasswordToken token = new UsernamePasswordToken("zoufanqi", "123456");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        Session session = subject.getSession();
        System.out.println(session.getId());
        System.out.println(session.getHost());
    }
}
