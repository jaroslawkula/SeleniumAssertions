package assertions;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.*;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {
    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement element) {
        return new WebElementAssert(element);
    }

    public WebElementAssert isDisplayed() {
        isNotNull();
        if (!actual.isDisplayed()) failWithMessage("Expected element was not displayed");
        return this;
    }

    public WebElementAssert isEnabled() {
        isNotNull();
        if (!actual.isEnabled()) failWithMessage("Expected element was not enabled");
        return this;
    }

    public WebElementAssert isNotEnabled() {
        isNotNull();
        if (actual.isEnabled()) failWithMessage("Expected element was enabled");
        return this;
    }

    public WebElementAssert isSelected() {
        isNotNull();
        if (!actual.isSelected()) failWithMessage("Expected element was not selected");
        return this;
    }

    public WebElementAssert isNotSelected() {
        isNotNull();
        if (actual.isSelected()) failWithMessage("Expected element was selected");
        return this;
    }

    public WebElementAssert hasAttributeValue(String attribute, String expectedValue) {
        isNotNull();
        String message = "Expected element to have attribute <%s> value as <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!actualValue.equals(expectedValue)) failWithMessage(message, attribute, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert attributeValueEndsWith(String attribute, String suffix) {
        isNotNull();
        String message = "Expected element to have attribute <%s> value ends with <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!actualValue.endsWith(suffix)) failWithMessage(message, attribute, suffix, actualValue);
        return this;
    }

    public WebElementAssert attributeValueStartsWith(String attribute, String prefix) {
        isNotNull();
        String message = "Expected element to have attribute <%s> value ends with <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!actualValue.endsWith(prefix)) failWithMessage(message, attribute, prefix, actualValue);
        return this;
    }

    public WebElementAssert attributeValueStartsWithAnyOf(String attribute, String... prefixes) {
        isNotNull();
        String message = "Expected element to have attr <%s> value starts with any of <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!StringUtils.startsWithAny(attribute, prefixes))
            failWithMessage(message, attribute, Arrays.toString(prefixes), actualValue);
        return this;
    }

    public WebElementAssert valueAttributeHas(String expectedValue) {
        isNotNull();
        String message = "Expected element to have <value> attribute <%s>. But was <%s>";
        String actualValue = actual.getAttribute("value");
        if (!actualValue.equals(expectedValue)) failWithMessage(message, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert cssAttributeHasValue(String cssAttribute, String expectedValue) {
        isNotNull();
        String message = "Expected element to have css attribute <%s> value <%s>. But was <%s>";
        String actualValue = actual.getCssValue(cssAttribute);
        if (!actualValue.equals(expectedValue)) failWithMessage(message, cssAttribute, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert hasAttribute(String attribute) {
        isNotNull();
        if (Objects.isNull(actual.getAttribute(attribute))) {
            failWithMessage("Element has no attribute <%s>", attribute);
        }
        return this;
    }

    public WebElementAssert hasText(String expectedValue) {
        isNotNull();
        String message = "Expected element to contain text <%s>. But was <%s>";
        String actualValue = actual.getText();
        if (!actualValue.equals(expectedValue)) failWithMessage(message, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert isEmpty() {
        isNotNull();
        String message = "Expected element to contain no text. But contained <%s>";
        String actualValue = actual.getText();
        if (StringUtils.isNotEmpty(actualValue)) failWithMessage(message, actualValue);
        return this;
    }

    public WebElementAssert isNotEmpty() {
        isNotNull();
        String message = "Expected element to contain text. But contained no text";
        String actualValue = actual.getText();
        if (StringUtils.isEmpty(actualValue)) failWithMessage(message);
        return this;
    }

    public WebElementAssert isBlank() {
        isNotNull();
        String message = "Expected element to be empty string, null or whitespace characters only. But contained <%s>";
        String actualValue = actual.getText();
        if (StringUtils.isNotBlank(actualValue)) failWithMessage(message, actualValue);
        return this;
    }

    public WebElementAssert isNotBlank() {
        isNotNull();
        String message = "Expected element to be not empty string, not null, and not whitespace characters only. But contained <%s>";
        String actualValue = actual.getText();
        if (StringUtils.isBlank(actualValue)) failWithMessage(message, actualValue);
        return this;
    }
}