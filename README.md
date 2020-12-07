# In Selenium's (or Selenide's) clearing process, Vue.js binding variables are not replaced.

## How to run
```
./mvn test
```

## Description

If the text field is bound in v-model as in the following sample.
```
<input id="input" class="form-control" v-model="inputText">
<span id="label">{{ inputText }}</span>
```

In the clear method, the text field is cleared but the binding variable is not replaced, so the string displayed in the span does not disappear.

```
$("#input").clear();
$("#input").should(Condition.empty);
$("#label").should(Condition.empty);    // fail
```

By using the Events.fireEvent(), you can force the JavaScript event to fire and replace the binding variable.

```
$("#input").clear();
events.fireEvent(WebDriverRunner.driver(), $("#input"), "keydown", "keypress", "input", "keyup", "change");
$("#input").should(Condition.empty);
$("#label").should(Condition.empty);
```