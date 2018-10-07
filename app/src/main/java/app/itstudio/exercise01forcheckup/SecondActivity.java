/*
 * Created by Evgeny V. Lobach on 04.10.18 6:09
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 04.10.18 6:09
 */

package app.itstudio.exercise01forcheckup;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SecondActivityControlFragment.newInstance())
                    .commit();
        }
    }

    /*@Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
        }
    }*/
}