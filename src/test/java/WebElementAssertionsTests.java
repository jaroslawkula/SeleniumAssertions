import assertions.WebElementAssert;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class WebElementAssertionsTests {

    private final Class<AssertionError> clasz = AssertionError.class;

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
                .hasMessage("Expected element was not displayed, but should be...");

        Mockito.when(element.isDisplayed())
                .thenReturn(true);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isDisplayed())
                .doesNotThrowAnyException();
    }

    public void isNotDisplayed() {
        Mockito.when(element.isDisplayed())
                .thenReturn(true);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isNotDisplayed())
                .isInstanceOf(clasz)
                .hasMessage("Expected element was displayed, but should not be...");

        Mockito.when(element.isDisplayed())
                .thenReturn(false);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isNotDisplayed())
                .doesNotThrowAnyException();
    }

    public void isEnabled() {
        Mockito.when(element.isEnabled())
                .thenReturn(false);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isEnabled())
                .isInstanceOf(clasz)
                .hasMessage("Expected element was not enabled, but should be...");

        Mockito.when(element.isEnabled())
                .thenReturn(true);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isEnabled())
                .doesNotThrowAnyException();
    }

    public void isNotEnabled() {
        Mockito.when(element.isEnabled())
                .thenReturn(true);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isNotEnabled())
                .isInstanceOf(clasz)
                .hasMessage("Expected element was enabled, but should not be...");

        Mockito.when(element.isEnabled())
                .thenReturn(false);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isNotEnabled())
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

    public void isButton() {
        Mockito.when(element.getAttribute("type"))
                .thenReturn("button");
        Mockito.when(element.getTagName())
                .thenReturn("a");

        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isButton())
                .doesNotThrowAnyException();

        Mockito.when(element.getTagName())
                .thenReturn("button");

        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isButton())
                .doesNotThrowAnyException();

        Mockito.when(element.getAttribute("type"))
                .thenReturn("other");
        Mockito.when(element.getTagName())
                .thenReturn("a");

        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isButton())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to be a button, but was not...");
    }

    public void isLink() {
        Mockito.when(element.getTagName())
                .thenReturn("not_a_link");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isLink())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to be a link, but was not...");

        Mockito.when(element.getTagName())
                .thenReturn("a");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isLink())
                .doesNotThrowAnyException();
    }

    public void hasAttributeValue() {
        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasAttributeValue("attribute", "other_value"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element to have attribute <attribute> value as <other_value>. But was <attribute_value>");

        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .hasAttributeValue("attribute", "attribute_value"))
                .doesNotThrowAnyException();

        Mockito.when(element.getAttribute("non_existing"))
                .thenReturn(null);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasAttributeValue("non_existing", "attribute_value"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element has no attribute <non_existing>");
    }

    public void hasAttribute() {
        Mockito.when(element.getAttribute("attribute"))
                .thenReturn(null);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasAttribute("attribute"))
                .isInstanceOf(clasz)
                .hasMessage("Element has no attribute <attribute>");

        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .hasAttribute("attribute"))
                .doesNotThrowAnyException();
    }

    public void hasNoAttribute() {
        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasNoAttribute("attribute"))
                .isInstanceOf(clasz)
                .hasMessage("Element has attribute <attribute>");

        Mockito.when(element.getAttribute("attribute"))
                .thenReturn(null);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .hasNoAttribute("attribute"))
                .doesNotThrowAnyException();
    }

    public void attributeValueEndsWith() {
        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .attributeValueEndsWith("attribute", "suffix"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element to have attribute <attribute> value ends with <suffix>. But was <attribute_value>");

        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value_suffix");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .attributeValueEndsWith("attribute", "suffix"))
                .doesNotThrowAnyException();
    }

    public void attributeValueEndsWithAnyOf() {
        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .attributeValueEndsWithAnyOf("attribute", "suffix1", "suffix2"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element to have attr <attribute> value ends with any of <[suffix1, suffix2]>. But was <attribute_value>");

        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value_suffix2");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .attributeValueEndsWithAnyOf("attribute", "suffix1", "suffix2"))
                .doesNotThrowAnyException();
    }

    public void attributeValueStartsWith() {
        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .attributeValueStartsWith("attribute", "prefix"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element to have attribute <attribute> value starts with <prefix>. But was <attribute_value>");

        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("prefix_attribute_value");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .attributeValueStartsWith("attribute", "prefix"))
                .doesNotThrowAnyException();
    }

    public void attributeValueStartsWithAnyOf() {
        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .attributeValueStartsWithAnyOf("attribute", "prefix1", "prefix2"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element to have attr <attribute> value starts with any of <[prefix1, prefix2]>. But was <attribute_value>");

        Mockito.when(element.getAttribute("attribute"))
                .thenReturn("prefix1_attribute_value");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .attributeValueStartsWithAnyOf("attribute", "prefix1", "prefix2"))
                .doesNotThrowAnyException();
    }

    public void hasValueAttribute() {
        Mockito.when(element.getAttribute("value"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasValueAttribute("other_value"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element to have <value> attribute <other_value>. But was <attribute_value>");

        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .hasValueAttribute("attribute_value"))
                .doesNotThrowAnyException();
    }

    public void hasCssValue() {
        Mockito.when(element.getCssValue("attribute"))
                .thenReturn("attribute_value");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasCssValue("attribute", "other_value"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element attribute <attribute> to have css value <other_value>. But was <attribute_value>");

        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .hasCssValue("attribute", "attribute_value"))
                .doesNotThrowAnyException();
    }

    public void hasTextIgnoringCase() {
        Mockito.when(element.getText())
                .thenReturn("ignorinG_Case");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .hasTextIgnoringCase("not_matching"))
                .isInstanceOf(clasz)
                .hasMessage("Expected element to contain text <not_matching> ignoring case. But was <ignorinG_Case>");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .hasTextIgnoringCase("IGNOring_cASE"))
                .doesNotThrowAnyException();
    }

    public void isEmpty() {
        Mockito.when(element.getText())
                .thenReturn("text");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isEmpty())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to contain no text. But contained <text>");
        Mockito.when(element.getText())
                .thenReturn(StringUtils.EMPTY);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isEmpty())
                .doesNotThrowAnyException();
    }

    public void isNotEmpty() {
        Mockito.when(element.getText())
                .thenReturn(StringUtils.EMPTY);
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isNotEmpty())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to contain text. But contained no text");
        Mockito.when(element.getText())
                .thenReturn("text");
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isNotEmpty())
                .doesNotThrowAnyException();
    }

    public void isBlank() {
        Mockito.when(element.getText())
                .thenReturn("text");
        Assertions.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isBlank())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to be empty string, null or whitespace characters only. But contained <text>");

        Mockito.when(element.getText())
                .thenReturn(null);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isBlank())
                .doesNotThrowAnyException();

        Mockito.when(element.getText())
                .thenReturn(StringUtils.EMPTY);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isBlank())
                .doesNotThrowAnyException();

        Mockito.when(element.getText())
                .thenReturn(StringUtils.SPACE);
        Assertions.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isBlank())
                .doesNotThrowAnyException();
    }

    public void isNotBlank() {
        SoftAssertions softly = new SoftAssertions();
        Mockito.when(element.getText())
                .thenReturn(null);
        softly.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isNotBlank())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to be not empty string, not null, and not whitespace characters only. But contained <null>");

        Mockito.when(element.getText())
                .thenReturn(StringUtils.EMPTY);
        softly.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isNotBlank())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to be not empty string, not null, and not whitespace characters only. But contained <>");

        Mockito.when(element.getText())
                .thenReturn(StringUtils.SPACE);
        softly.assertThatThrownBy(() -> WebElementAssert.assertThat(element)
                .isNotBlank())
                .isInstanceOf(clasz)
                .hasMessage("Expected element to be not empty string, not null, and not whitespace characters only. But contained < >");

        Mockito.when(element.getText())
                .thenReturn("text");
        softly.assertThatCode(() -> WebElementAssert.assertThat(element)
                .isNotBlank())
                .doesNotThrowAnyException();

        softly.assertAll();
    }
}
