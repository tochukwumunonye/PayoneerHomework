package com.tochukwu.payoneerhomework.adapter;

import static org.junit.Assert.*;

import android.os.Bundle;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.core.app.RemoteInput;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.filters.MediumTest;

import com.tochukwu.payoneerhomework.HiltExt;
import com.tochukwu.payoneerhomework.R;
import com.tochukwu.payoneerhomework.ui.PaymentFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

@HiltAndroidTest
@MediumTest
public class PaymentAdapterTest {



    @Rule
    InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();


    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Before
    public void setup(){
       hiltRule.inject();
    }


    @Test
    public void checkIfDataIsSuccessfullyFetched(){
        /*FragmentScenario<PaymentFragment> scenario = FragmentScenario.launchInContainer(PaymentFragment.class);
        HiltExt.launchInHiltContainer(PaymentFragment.class, new Bundle(),
                R.style.FragmentScenarioEmptyFragmentActivityTheme, paymentFragmentFactory);*/
    }

}

/*
  //FragmentScenario<PaymentFragment> scenario = FragmentScenario.launchInContainer(PaymentFragment.class);
        HiltExt.launchInHiltContainer(PaymentFragment.class, new Bundle(),
         R.style.FragmentScenarioEmptyFragmentActivityTheme, paymentFragmentFactory);
        onView(withId(R.id.))

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory: ShoppingFragmentFactory

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun clickImage_popBackStackAndSetImageUrl() {
        val navController = mock(NavController::class.java)
        val imageUrl = "TEST"
        val testViewModel = ShoppingViewModel(FakeShoppingRepositoryAndroidTest())
        launchFragmentInHiltsContainer<ImagePickFragment> (fragmentFactory = fragmentFactory) {
            Navigation.setViewNavController(requireView(), navController)
            imageAdapter.images = listOf(imageUrl)
            viewModel = testViewModel
        }

        onView(withId(R.id.rvImages)).perform(
                RecyclerViewActions.actionOnItemAtPosition<ImageAdapter.ImageViewHolder>(
                    0,
                    click()
                )

                )
        verify(navController).popBackStack()
        assertThat(testViewModel.curImageUrl.getOrAwaitValue()).isEqualTo(imageUrl)
 */