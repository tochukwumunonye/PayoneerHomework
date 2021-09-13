package com.tochukwu.payoneerhomework;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;

public class HiltExt {
    public static <T extends Fragment> void launchInHiltContainer(Class<T> fragmentType, Bundle fragmentArgs, int themeResId, FragmentFactory factory) {
        Intent mainActivityIntent = Intent.makeMainActivity(new ComponentName(ApplicationProvider.getApplicationContext(), MyHiltTestActivity.class)).putExtra(FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, themeResId);
        ActivityScenario.launch(mainActivityIntent).onActivity(new ActivityScenario.ActivityAction<Activity>() {
            @Override
            public void perform(Activity activity) {
                AppCompatActivity appCompatActivity = ((AppCompatActivity) activity);
                appCompatActivity.getSupportFragmentManager().setFragmentFactory(factory);
                Fragment fragment = appCompatActivity.getSupportFragmentManager().getFragmentFactory().instantiate(Preconditions.checkNotNull(fragmentType.getClassLoader()), fragmentType.getName());
                fragment.setArguments(fragmentArgs);
                appCompatActivity.getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, fragment, "")
                        .commitNow();
            }
        });
    }

    /*val mainActivityIntent = Intent.makeMainActivity(
            ComponentName(
                    ApplicationProvider.getApplicationContext(),
                    HiltTestActivity::class.java
        )
                ).putExtra(FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, themeResId)

    ActivityScenario.launch<HiltTestActivity>(mainActivityIntent).onActivity {activity ->
            fragmentFactory?.let {
        activity.supportFragmentManager.fragmentFactory = it
    }

        val fragment = activity.supportFragmentManager.fragmentFactory.instantiate(
                Preconditions.checkNotNull(T::class.java.classLoader),
        T::class.java.name
        )

        fragment.arguments = fragmentArgs

        activity.supportFragmentManager.beginTransaction()
                .add(android.R.id.content, fragment, "")
                .commitNow()

        (fragment as T).action()
*/
}
