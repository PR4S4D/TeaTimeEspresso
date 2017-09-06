package com.example.android.teatime;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Created by Lakshmiprasad on 06-09-2017.
 */

@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    @Rule public ActivityTestRule<OrderActivity> mActivityTestRule = new ActivityTestRule<>(OrderActivity.class);

    @Test
    public void clickIncrementButton_ChangesQuantityAndCost(){
        onView(withId(R.id.increment_button)).perform(click());
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));

        onView(withId(R.id.decrement_button)).perform(click());
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));

    }


}
