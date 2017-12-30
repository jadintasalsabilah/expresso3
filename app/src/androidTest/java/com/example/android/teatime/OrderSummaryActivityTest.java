/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.teatime;

// TODO (1) Add annotation to specify AndroidJUnitRunner class as the default test runner
public class OrderSummaryActivityTest {

    // TODO (2) Add the rule that indicates we want to use Espresso-Intents APIs in functional UI tests


    // TODO (3) Finish this method which runs before each test and will stub all external
    // intents so all external intents will be blocked

    @RunWith(AndroidJUnit4.class)
    public class OrderSummaryActivityTest {

        private static final String emailMessage = "I just ordered a delicious tea from TeaTime. Next time you are craving a tea, check them out!";


    public void clickSendEmailButton_SendsEmail() {

        @Rule
        public IntentsTestRule<OrderSummaryActivity> mActivityRule = new IntentsTestRule<>(
                OrderSummaryActivity.class);

        @Before
        public void stubAllExternalIntents () {
            // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
            // every test run. In this case all external Intents will be blocked.
            intending(not(isInternal())).respondWith(new ActivityResult(Activity.RESULT_OK, null));
        }

        @Test

                onView(withId(R.id.send_email_button)).perform(click());
        // intended(Matcher<Intent> matcher) asserts the given matcher matches one and only one
        // intent sent by the application.
        intended(allOf(
                hasAction(Intent.ACTION_SENDTO),
                hasExtra(Intent.EXTRA_TEXT, emailMessage)));
    }
}