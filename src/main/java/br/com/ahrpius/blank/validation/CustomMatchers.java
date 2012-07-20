package br.com.ahrpius.blank.validation;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatchers {

   private static TypeSafeMatcher<String> EMPTY = new TypeSafeMatcher<String>() {

       @Override
       protected void describeMismatchSafely(String item, Description mismatchDescription) {
           mismatchDescription.appendText(" " + item);
       }

       @Override
       protected boolean matchesSafely(String item) {
           return item != null && !item.equals("");
       }

       public void describeTo(Description description) {
           description.appendText(" not empty");
       }

   };

   /**
    * matches if the given string is not empty. This matcher is null-safe.
    * @return
    */
   public static TypeSafeMatcher<String> notEmpty() {
       return EMPTY;
   }

}