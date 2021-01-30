package forgotPassword;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class forgotPasswordTests extends BaseTest {

    @Test
    public void testRetrievePassword() {
        var retrievePage = homePage.clickForgotPassword();
        retrievePage.setEmail("test@gmail.com");
        retrievePage.clickRetrievePasswordButton();

        assertEquals(retrievePage.emailSentGetText(),
                "Your e-mail's been sent!",
                "Confirmation text is incorrect");
    }
}
