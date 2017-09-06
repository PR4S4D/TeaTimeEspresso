package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.anything;

/**
 * Created by Lakshmiprasad on 06-09-2017.
 */

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {
    @Rule
    public ActivityTestRule<MenuActivity> activityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void testGridView() {
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());
       // onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());
        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Green Tea")));

        /*onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());

        // Checks that the OrderActivity opens with the correct tea name displayed
        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Green Tea")));*/
    }

}
