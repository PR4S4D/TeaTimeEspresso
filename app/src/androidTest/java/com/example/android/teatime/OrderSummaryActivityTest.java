package com.example.android.teatime;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Lakshmiprasad on 06-09-2017.
 */

@RunWith(AndroidJUnit4.class)
public class OrderSummaryActivityTest {

    private static final String emailMessage = "I just ordered a delicious tea from TeaTime. Next time you are craving a tea, check them out!";


    @Rule public IntentsTestRule<OrderSummaryActivity> activityTestRule = new IntentsTestRule<>(OrderSummaryActivity.class);

    @Before
    public void stubAllExternalIntents(){
        // all external intent calls will be blocked
        Intents.intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK,null));
    }

    @Test
    public void clickSendEmailButton_SendMail(){
        Espresso.onView(ViewMatchers.withId(R.id.send_email_button)).perform(ViewActions.click());
        Intents.intended(Matchers.allOf(hasAction(Intent.ACTION_SENDTO), hasExtra(Intent.EXTRA_TEXT, emailMessage)));

    }
}
