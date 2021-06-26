package selenium_notes;

// selenium testing tools cookbook - second edition

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Book1 {

    // chapter - 2 - finding elements
    private class Chapter2 {

        WebDriver driver = new ChromeDriver();

        private void notes() {
            // firebug add on can be used for locating elements in firefox browser
            // chrome has in-built tool called developer tool for inspecting the element

            // finding elements in selenium web driver is done by using findElement() and findElements() methods provided
            // by the WebDriver and WebElement interface

            // findElement takes locator object as argument

            // finding elements using id, name, class is preferred

            // id cannot be used everywhere,
            // -> not all the elements on a page have the id attribute specified
            // -> id attribute is not specified for key elements on a page
            // -> if id attributes are dynamically generated

            // if multiple class name are present use any one
            // <input class="classname textfield"></input>
            // we can use either classname or text field

            // selenium returns first matching element from DOM structure if multiple elements are present

            // WebElement interface also supports find methods that find child elements.
            // search for parent element and then use that context to search for child elements within the parent element

            // findElement() method throws NoSuchElementFoundException, when no element is found
            // findElements() method returns empty list when it does not find elements matching the locator

            // using findElements() we can find multiple elements with the same search criteria
            // this method is useful when we want to work with a group of similar elements
            // finding all the links, finding all the rows in the table ....

            // links on a page can be searched using text or partial text
            // when links are dynamic then we can use partial text locator
            // both linkText and partialLinkText are case sensitive

            // locating elements based on text can cause issues while testing applications in multiple locales
            // if multiple text are there then we can use xpath or css locators

            // Xpath -> XML path language is a query language to select nodes from an XML document
            // Xpath language is based on a tree representation of the XML document and provides the ability to navigate
            // around the tree and to select nodes using a variety of criteria
            // we can locate the elements using the Xpath query

            // the main difference between xpath and css is that xpath can be used to search elements in both
            // forward and backward directions where as using css we can only go with forward direction

            // Xpath terminology
            // -> Nodes - DOM represents an HTML document as trees of nodes
            //            - html - root node
            //            - title - element node
            //            - id="hello" - attributes and values
            // -> Atomic Values - Atomic values are nodes with no parents or childrens
            // -> Parent element
            // -> Child Element
            // -> Siblings - nodes that have same parent
            // Ancestor - a node parent or parent's parent and so on are called as ancestors
            // Descendants - a node children or children's children and so on are called as descendants

            // selecting nodes
            // nodenames - selects all the nodes with nodename specified
            // /(slash) - defines ancestor and descendants relationships
            //          - eg: /htm/body/div -> selects all the div tags under body tag
            // //(double slash) - defines a descendant relationship
            // .(dot) - represents the current node
            // ..(double dot) - this will select the parent of the current node
            //                - //table/..
            // @ - represents an attribute
            //   - //@id, //img/@alt

            // we can use something called as xpath functions
            // input[starts-with(@id,ctrl)]
            // input[ends-with(@id,'_username')]
            // input[contains(@id,'username')]

            // //table/tr[1]
            // //table/tr[last()]
            // //table/tr[last()-1]
            // //table/tr[position()>4]
            // //table/tr[td>40]
            // /table/*
            // //*
            // //*[@class='price']
            // //td[@*]
            // //table/node() - selects all the child nodes of the table

            // selecting several paths
            // 1. //div/p | //div/span 2. //p | // span

            // locating the elements with xpath axes
            // xpath helps to find elements based on the elements relationships with other elements in a document
            // not used much, if to know about it (https://www.w3schools.com/xpath/xpath_axes.asp)

            // css partial match
            // input[attribute^='value'] - starts with
            // input[attribute$='value'] - ends with
            // input[attribute*='value'] - anywhere

            // css and xpath provide the methods with which to find elements based on their text contents

            // advanced css selectors
            // -> form#loginForm>input
            // -> form#loginForm:first-child
            // -> form#loginForm:lase-child
            // -> form#loginForm:nth-child(2)
            // -> div#top5>p+p - immediate sibling after p tag
            // action pseudo classes
            // -> input:focus
            // ui state pseudo-classes
            // -> input:enabled
            // -> input:disabled
            // -> input:checked

            // jQuery selectors are used where the css selectors are not supported natively by the browsers - codeBlock4

        }

        // locators examples
        private void codeBlocks1() {
//             driver.findElement(By.id(<element ID>);
//             driver.findElement(By.name(<element name>));
//             driver.findElement(By.className(<element class>));
//             driver.findElement(By.tagName(<html tag name>));
//             driver.findElement(By.linkText(<link text>));
//             driver.findElement(By.partialLinkText(<partial link text>));
//             driver.findElement(By.cssSelector(<css selector>));
//             driver.findElement(By.xpath(<xpath of the element>));

//            WebElement username=driver.findElement(By.id("username"));
//            WebElement password=driver.findElement(By.id("password"));

//            WebElement username=driver.findElement(By.name("username"));
//            WebElement password=driver.findElement(By.name("password"));

//            WebElement username=driver.findElement(By.className("username"));
//            WebElement password=driver.findElement(By.className("password"));

//            WebElement div=driver.findElement(By.id("div1"));
//            WebElement topLink=div.findElement(By.linkText("top"));
//            or
//            WebElement topLink=driver.findElement(By.id("div1")).findElement(By.linkText("top"));

//            WebElement loginButton=driver.findElement(By.tagName("button"));
//            loginButton.click();
//            WebElement table=driver.findElement(By.id("summaryTable"));
//            List<WebElement> rows=table.findElements(By.tagName("tr"));

            // absolute path - disadvantage is if the structure is changed then it fails to locate the element
//            WebElement userName=driver.findElement(By.xpath("/html/body/div/div/form/input"));

            // relative path we can locate the element irrespective of its location
//            WebElement userName=driver.findElement(By.xpath("//input"));

            // finding the elements using predicates
//            WebElement userName=driver.findElement(By.xpath("//input[2]"));

            // finding elements using attribute values
//            WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
//            WebElement previousButton=driver.findElement(By.xpath("//img[@alt='Previous']"));
//            WebElement previousElement=driver.findElement(By.xpath("//input[@type='submit'][@value='Login']"))
//            WebElement previousElement=driver.findElement(By.xpath("//input[@type='submit' and @value='Login']"))
//            WebElement previousElement=driver.findElement(By.xpath("//input[@type='submit' or @value='Login']"))

            // finding elements using attributes - specific attribute defined on them not attribute value
//            List<WebElement> imageWithAlt=driver.findElements(By.xpath("//img[@alt]")); // searches all the img tags with alt tags defined
//            List<WebElement> imageWithNoAlt=driver.findElements(By.xpath("//img[not(@alt)]")); // searches all the img tags with alt tags not defined

            // matching any attribute using a value
//            WebElement userName=driver.findElement(By.xpath("//input[@*='username']"));

            // absolute paths
//            WebElement userName=driver.findElement(By.cssSelector("html body div div form input"));
//            WebElement userName=driver.findElement(By.cssSelector("html>body>div>div>form>input"));

            // relative paths
//            WebElement userName=driver.findElement(By.cssSelector("input"));
            // <input class="login"/>
//            WebElement login=driver.findElement(By.cssSelector("input.login"));
//            WebElement login=driver.findElement(By.cssSelector(".login"));
            // <input id="login"/>
//            WebElement login= driver.findElement(By.cssSelector("input#login"));
//            WebElement login= driver.findElement(By.cssSelector("#login"));
//            WebElement login=driver.findElement(By.cssSelector("input[name='username']"));
//            WebElement login= driver.findElement(By.cssSelector("input[type='submit'][value='login']"));
//            WebElement login=driver.findElement(By.cssSelector("img[alt]"));
//            WebElement login=driver.findElement(By.cssSelector("img:not([alt])"));

            // we can select multiple paths with css selector
//            List<WebElement> login= driver.findElements(By.cssSelector("div, p"));
//            List<WebElement> login= driver.findElements(By.cssSelector("div.first, div.last"));

            // there are situations where no attributes are used then we can use text
//            WebElement element=driver.findElement(By.xpath("//tr[contains(text(),'partial text containing')]"));
//            WebElement elements=driver.findElement(By.cssSelector("tr:contains('text containing')"));
            // to match the exact text
//            WebElement element=driver.findElement(By.xpath("//tr[.='text']"));
        }

        // find elements code block
        private void codeBlock2() {
//            List<WebElement> links=driver.findElements(By.tagName("a"));
//            for(WebElement link:links){
//                System.out.println(link.getAttribute("href"));
//            }
        }

        // partial text code block
        private void codeBlock3() {
//            WebElement gmailLink=driver.findElement(By.linkText("gmail"));
//            // full link text is - Sign In
//            WebElement inboxLink=driver.findElement(By.partialLinkText("Sign"));
//            System.out.println(inboxLink.getText());
        }

        // jQuery selector code block
        // checking if the check boxes are checked when the page is displayed
        // we have to make sure that jQuery Api is loaded before using jQuery selectors
        private void codeBlock4() {
//            JavascriptExecutor js=(JavascriptExecutor) driver;
//            List<WebElement> elements=(List<WebElement>)js.executeScript("return jQuery.find(':checked')");
//            for(WebElement element:elements){
//                System.out.println(element.getAttribute("id"));
//            }

        }

    }

}
