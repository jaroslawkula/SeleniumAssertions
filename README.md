# SeleniumAssertions
#### AssertJ based assertions to assert Selenium WebElements

- isDisplayed
- isEnabled
- isNotEnabled
- isSelected
- isNotSelected
- hasAttributeValue
- attributeValueEndsWith
- attributeValueStartsWith
- attributeValueStartsWithAnyOf
- valueAttributeHas
- cssAttributeHasValue
- hasAttribute
- hasText
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
