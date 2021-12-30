package assertions;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Objects;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {
    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement element) {
        return new WebElementAssert(element);
    }

    public WebElementAssert isDisplayed() {
        isNotNull();
        if (!actual.isDisplayed()) failWithMessage("Expected element was not displayed, but should be...");
        return this;
    }

    public WebElementAssert isNotDisplayed() {
        isNotNull();
        if (actual.isDisplayed()) failWithMessage("Expected element was displayed, but should not be...");
        return this;
    }

    public WebElementAssert isEnabled() {
        isNotNull();
        if (!actual.isEnabled()) failWithMessage("Expected element was not enabled, but should be...");
        return this;
    }

    public WebElementAssert isNotEnabled() {
        isNotNull();
        if (actual.isEnabled()) failWithMessage("Expected element was enabled, but should not be...");
        return this;
    }

    public WebElementAssert isButton() {
        isNotNull();
        String message = "Expected element to be a button, but was not...";
        if (!(actual.getTagName().equalsIgnoreCase("button") || isAttributeTypeButton())) {
            failWithMessage(message);
        }
        return this;
    }

    private boolean isAttributeTypeButton() {
        String attribute = actual.getAttribute("type");
        return (Objects.nonNull(attribute) && attribute.equalsIgnoreCase("button"));
    }

    public WebElementAssert isLink() {
        isNotNull();
        String message = "Expected element to be a link, but was not...";
        if (!actual.getTagName()
                .equalsIgnoreCase("a")) failWithMessage(message);
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
        String actualValue = actual.getAttribute(attribute);
        String null_message = "Expected element has no attribute <%s>";
        if (Objects.isNull(actualValue)) failWithMessage(null_message, attribute);
        String message = "Expected element to have attribute <%s> value as <%s>. But was <%s>";
        if (!actualValue.equals(expectedValue)) failWithMessage(message, attribute, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert hasAttribute(String attribute) {
        isNotNull();
        String message = "Element has no attribute <%s>";
        if (Objects.isNull(actual.getAttribute(attribute))) failWithMessage(message, attribute);
        return this;
    }

    public WebElementAssert hasNoAttribute(String attribute) {
        isNotNull();
        String message = "Element has attribute <%s>";
        if (Objects.nonNull(actual.getAttribute(attribute))) failWithMessage(message, attribute);
        return this;
    }

    public WebElementAssert attributeValueEndsWith(String attribute, String suffix) {
        isNotNull();
        String message = "Expected element to have attribute <%s> value ends with <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!actualValue.endsWith(suffix)) failWithMessage(message, attribute, suffix, actualValue);
        return this;
    }

    public WebElementAssert attributeValueEndsWithAnyOf(String attribute, String... values) {
        isNotNull();
        String message = "Expected element to have attr <%s> value ends with any of <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!StringUtils.endsWithAny(actualValue, values))
            failWithMessage(message, attribute, Arrays.toString(values), actualValue);
        return this;
    }


    public WebElementAssert attributeValueStartsWith(String attribute, String prefix) {
        isNotNull();
        String message = "Expected element to have attribute <%s> value starts with <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!actualValue.startsWith(prefix)) failWithMessage(message, attribute, prefix, actualValue);
        return this;
    }

    public WebElementAssert attributeValueStartsWithAnyOf(String attribute, String... values) {
        isNotNull();
        String message = "Expected element to have attr <%s> value starts with any of <%s>. But was <%s>";
        String actualValue = actual.getAttribute(attribute);
        if (!StringUtils.startsWithAny(actualValue, values))
            failWithMessage(message, attribute, Arrays.toString(values), actualValue);
        return this;
    }

    public WebElementAssert hasValueAttribute(String expectedValue) {
        isNotNull();
        String message = "Expected element to have <value> attribute <%s>. But was <%s>";
        String actualValue = actual.getAttribute("value");
        if (!actualValue.equals(expectedValue)) failWithMessage(message, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert hasCssValue(String cssAttribute, String expectedValue) {
        isNotNull();
        String message = "Expected element attribute <%s> to have css value <%s>. But was <%s>";
        String actualValue = actual.getCssValue(cssAttribute);
        if (!actualValue.equals(expectedValue)) failWithMessage(message, cssAttribute, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert hasText(String expectedValue) {
        isNotNull();
        String message = "Expected element to contain text <%s>. But was <%s>";
        String actualValue = actual.getText();
        if (!actualValue.equals(expectedValue)) failWithMessage(message, expectedValue, actualValue);
        return this;
    }

    public WebElementAssert hasTextIgnoringCase(String expectedValue) {
        isNotNull();
        String message = "Expected element to contain text <%s> ignoring case. But was <%s>";
        String actualValue = actual.getText();
        if (!actualValue.equalsIgnoreCase(expectedValue)) failWithMessage(message, expectedValue, actualValue);
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