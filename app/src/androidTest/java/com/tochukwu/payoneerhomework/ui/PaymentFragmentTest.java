package com.tochukwu.payoneerhomework.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.tochukwu.payoneerhomework.other.Utils.atPosition;

import static org.hamcrest.Matchers.not;

import android.os.Bundle;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.google.gson.Gson;
import com.tochukwu.payoneerhomework.HiltExt;
import com.tochukwu.payoneerhomework.R;
import com.tochukwu.payoneerhomework.Repository.FakeRepository;
import com.tochukwu.payoneerhomework.data.Applicable;
import com.tochukwu.payoneerhomework.data.Model;
import com.tochukwu.payoneerhomework.other.Constant;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

@HiltAndroidTest
@LargeTest
@RunWith(AndroidJUnit4.class)
public class PaymentFragmentTest {

    @Inject
    PaymentFragmentFactory paymentFragmentFactory;


    @Rule
    public HiltAndroidRule  hiltRule = new HiltAndroidRule(this);

    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();
    @Test
    public void testSuccessState() {
        String json = Constant.constantsJson;
        Applicable applicable = new Gson().fromJson(json, Model.class).getNetworks().getApplicable().get(0);
        //FragmentScenario<PaymentFragment> scenario = FragmentScenario.launchInContainer(PaymentFragment.class);
        HiltExt.launchInHiltContainer(PaymentFragment.class, new Bundle(), R.style.FragmentScenarioEmptyFragmentActivityTheme, paymentFragmentFactory);

        //onView(withId(R.id.button_retry)).check(doesNotExist());
        onView(withId(R.id.button_retry)).check(matches(not(isDisplayed())));

        onView(withId(R.id.recycler))
                .check(matches(atPosition(0, withText(applicable.getLabel()))));


    }

    @Test
    public void testErrorState(){
        FakeRepository.error = true;
        HiltExt.launchInHiltContainer(PaymentFragment.class, new Bundle(), R.style.FragmentScenarioEmptyFragmentActivityTheme, paymentFragmentFactory);

       /* onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(isDisplayed())); */


       // onView(withId(R.id.recycler)).check(matches(not(isDisplayed())));
        onView(withId(R.id.text_view_error)).check(matches(isDisplayed()));
        onView(withId(R.id.button_retry)).check(matches(isDisplayed()));

    }


















































































    /**
     *    // For Robolectric tests.
     *     testImplementation 'com.google.dagger:hilt-android-testing:2.38.1'
     *     // ...with Kotlin.
     *     kaptTest 'com.google.dagger:hilt-android-compiler:2.38.1'
     *     // ...with Java.
     *     testAnnotationProcessor 'com.google.dagger:hilt-android-compiler:2.38.1'
     *
     *
     *     // For instrumented tests.
     *     androidTestImplementation 'com.google.dagger:hilt-android-testing:2.38.1'
     *     // ...with Kotlin.
     *     kaptAndroidTest 'com.google.dagger:hilt-android-compiler:2.38.1'
     *     // ...with Java.
     *     androidTestAnnotationProcessor 'com.google.dagger:hilt-android-compiler:2.38.1'
     *
     *     // Instrumented Unit Tests
     *     debugImplementation "androidx.fragment:fragment-testing:1.3.6"
     *
     *    //androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0-alpha02'
     *     //androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0' //EXPRESSO
     *     //androidTestImplementation 'androidx.test.espresso:espresso-intents:3.4.0'
     *
     *
     *     androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
     *     androidTestImplementation 'androidx.test:runner:1.4.0'
     *     androidTestImplementation 'androidx.test:rules:1.4.0'
     *     androidTestImplementation "junit:junit:4.13.2"
     *     androidTestImplementation "androidx.arch.core:core-testing:2.1.0"
     *
     *
     *     androidTestImplementation "com.google.truth:truth:1.1.3"
     *     androidTestImplementation 'androidx.test.ext:junit:1.1.3'
     *
     *     androidTestImplementation "com.squareup.okhttp3:mockwebserver:4.9.1"
     *     androidTestImplementation "io.mockk:mockk-android:1.10.5"
     *
     *
     *     androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.4.0'
     *     androidTestImplementation "org.mockito:mockito-core:3.12.4"
     *
     *    // androidTestImplementation "it.xabaras.android.espresso:recyclerview-child-actions:1.0"
     *
     *
     *     androidTestImplementation "com.linkedin.dexmaker:dexmaker-mockito:2.12.1"
     *
     *    // debugImplementation "androidx.fragment:fragment-testing:1.3.0-alpha08"
     */

}