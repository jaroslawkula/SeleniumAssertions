import assertions.WebElementAssert;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class WebElementAssertionsTests {

    private Class clasz = AssertionError.class;

    @Mock
    WebElement element;

    public WebElementAssertionsTests() {
        MockitoAnnotations.initMocks(this);
    }

    public void hasText() {
        String dummyText = RandomStringUtils.randomAlphabetic(10);
        String expectedDummyText = RandomStringUtils.randomAlphabetic(10);
        String expectedMessage = "Expected element to contain text <" + expectedDummyText + ">. But was <" + dummyText + ">";

        Mockito.when(element.getText())
                .thenReturn(dummyText);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasText(expectedDummyText))
                .isInstanceOf(clasz)
                .hasMessage(expectedMessage);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .hasText(dummyText))
                .doesNotThrowAnyException();
    }

    public void isDisplayed() {
        Mockito.when(element.isDisplayed())
                .thenReturn(false);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isDisplayed())
                .isInstanceOf(clasz)
                .hasMessage("Expected element was not displayed");

        Mockito.when(element.isDisplayed())
                .thenReturn(true);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isDisplayed())
                .doesNotThrowAnyException();
    }

    public void isEnabled() {
        Mockito.when(element.isEnabled())
                .thenReturn(false);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isEnabled())
                .isInstanceOf(clasz)
                .hasMessage("Expected element was not enabled");

        Mockito.when(element.isEnabled())
                .thenReturn(true);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isEnabled())
                .doesNotThrowAnyException();
    }

    public void isSelected() {
        Mockito.when(element.isSelected())
                .thenReturn(false);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isSelected())
                .isInstanceOf(clasz)
                .hasMessage("Expected element was not selected");

        Mockito.when(element.isSelected())
                .thenReturn(true);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isSelected())
                .doesNotThrowAnyException();
    }

    public void isNotSelected() {
        Mockito.when(element.isSelected())
                .thenReturn(true);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isNotSelected())
                .isInstanceOf(clasz)
                .hasMessage("Expected element was selected");

        Mockito.when(element.isSelected())
                .thenReturn(false);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isNotSelected())
                .doesNotThrowAnyException();
    }
}
