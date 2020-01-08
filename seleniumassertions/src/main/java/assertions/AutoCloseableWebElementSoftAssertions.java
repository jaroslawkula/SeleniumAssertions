package assertions;

import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.openqa.selenium.WebElement;

public class AutoCloseableWebElementSoftAssertions extends AutoCloseableSoftAssertions {
    public WebElementAssert assertThat(WebElement actual){
        return proxy(WebElementAssert.class, WebElement.class, actual);
    }
}
