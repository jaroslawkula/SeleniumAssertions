[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.jaroslawkula/seleniumassertions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.jaroslawkula/seleniumassertions)

# SeleniumAssertions
#### AssertJ based assertions to assert Selenium WebElements

- isDisplayed
- isNotDisplayed
- isEnabled
- isNotEnabled
- isSelected
- isNotSelected
- isButton
- isLink
- hasAttributeValue
- attributeValueEndsWith
- attributeValueEndsWithAnyOf
- attributeValueStartsWith
- attributeValueStartsWithAnyOf
- hasValueAttribute
- hasCssValue
- hasAttribute
- hasNoAttribute
- hasText
- hasTextIgnoringCase
- isEmpty
- isNotEmpty
- isBlank
- isNotBlank


#### Create assertions in easy way
```
WebElementAssert.assertThat(page.getTitle()).hasText(title);
WebElementAssert.assertThat(page.getSaveButton()).isNotEnabled();
```

#### Or softly - there is not need to assertAll at the end as soft assertions extend: 
`<AutoCloseableSoftAssertions>`
```
var softly = new WebElementSoftAssertions();
softly.assertThat(page.getTitle()).hasText(title);
softly.assertThat(page.getSaveButton()).isNotEnabled();
```
