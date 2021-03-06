package com.example.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class ExampleTests {
    @BeforeAll
    static void setUp() {
       //Configuration.headless = true;
        //Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "com.example.tests.ChromeWebdriverProvider";
    }

    @Test
    public void testCanSignIn(){
        Selenide.open("https://angular.realworld.io");
        $("body > app-root > app-layout-header > nav > div > ul > li:nth-child(2) > a").click();
        $("body > app-root > app-auth-page > div > div > div > div > form > fieldset > fieldset:nth-child(2) > input").setValue("ergerg");
        $("body > app-root > app-auth-page > div > div > div > div > form > fieldset > fieldset:nth-child(3) > input").setValue("gewwg");
        $("body > app-root > app-auth-page > div > div > div > div > form > fieldset > button").click();
        $("body > app-root > app-auth-page > div > div > div > div > app-list-errors > ul > li").shouldHave(Condition.exactText(" email or password is invalid "));
    }

}
