package com.change.kranti;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class KrantiTest {

    @Test
    public void shouldHaveCorrectAppName() {
        String appName = new HomeActivity().getResources().getString(R.string.app_name);
        assertThat(appName, equalTo("Kranti"));
    }
}
