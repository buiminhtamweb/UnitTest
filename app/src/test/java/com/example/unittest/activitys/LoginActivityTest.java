package com.example.unittest.activitys;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.EditText;

import com.example.unittest.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class LoginActivityTest {
    LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);

    }

    @Test
    public void validate_goodPass() {
        activity.findViewById(R.id.btn_sign_in).performClick();
        activity.editTextPhone.setText("0123456789");
        activity.editTextPass.setText("0123456");

        assertTrue(activity.validate());
    }

    @Test
    public void validate_badPass() {
        activity.findViewById(R.id.btn_sign_in).performClick();
        activity.editTextPhone.setText("0123456789");
        activity.editTextPass.setText("123");

        assertFalse(activity.validate());
    }


    @Test
    public void signIn_wrongPass() {

        activity.editTextPhone.setText("0987654321");
        activity.editTextPass.setText("0123456");
        activity.findViewById(R.id.btn_sign_in).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        if (activity.validate() && actual != null)
            assertNotEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @Test
    public void signIn_wrongPhone() {

        activity.editTextPhone.setText("0123456789");
        activity.editTextPass.setText("654321");
        activity.findViewById(R.id.btn_sign_in).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        if (activity.validate() && actual != null)
            assertNotEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @Test
    public void signIn_wrongAll() {

        activity.editTextPhone.setText("97968769898");
        activity.editTextPass.setText("1123");
        activity.findViewById(R.id.btn_sign_in).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        if (activity.validate() && actual != null)
            assertNotEquals(expectedIntent.getComponent(), actual.getComponent());

        assertEquals(activity.tvErr.getVisibility(), View.VISIBLE);
    }

    @Test
    public void signIn_accCorrect() {

        activity.editTextPhone.setText("0987654321");
        activity.editTextPass.setText("654321");
        activity.findViewById(R.id.btn_sign_in).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        if (activity.validate() && actual != null)
            assertEquals(expectedIntent.getComponent(), actual.getComponent());

        assertEquals(activity.tvErr.getVisibility(), View.GONE);

    }



}