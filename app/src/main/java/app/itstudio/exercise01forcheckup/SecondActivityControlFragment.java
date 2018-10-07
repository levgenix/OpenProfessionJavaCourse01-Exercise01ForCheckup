/*
 * Created by Evgeny V. Lobach on 07.10.18 3:56
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 07.10.18 3:56
 */

package app.itstudio.exercise01forcheckup;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivityControlFragment extends Fragment {

    Button bGoogle;
    final static String BASE_GOOGLE_URL = "https://www.google.com/search?q=";

    public static SecondActivityControlFragment newInstance() {
        Bundle args = new Bundle();

        SecondActivityControlFragment fragment = new SecondActivityControlFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_second, container, false);

        Activity activity = getActivity();
        if (activity.getIntent().hasExtra(MainActivity.NAME_FROM_TEXT_VIEW)) {
            TextView tvName = view.findViewById(R.id.textViewId);
            Bundle bundle = activity.getIntent().getExtras();

            final String name = (String) bundle.get(MainActivity.NAME_FROM_TEXT_VIEW);
            if (null != name) {
                tvName.setText(name);
            }

            bGoogle = view.findViewById(R.id.googleButtonId);
            bGoogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Передаем адрес страницы в браузер системы
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.google.com/search?q=" + name));
                    startActivity(intent);
                }
            });
        }
        return view;
    }
}
