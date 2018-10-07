/*
 * Created by Evgeny V. Lobach on 04.10.18 5:00
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 03.10.18 19:46
 */

package app.itstudio.exercise01forcheckup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName;
    Button bPush, bToSecond;

    public static final String NAME_FROM_TEXT_VIEW = "nameFromTextView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.editTextId);
        bPush = findViewById(R.id.buttonId);
        bToSecond = findViewById(R.id.toSecondButtonId);

        bPush.setOnClickListener(this);
        bToSecond.setOnClickListener(this);
    }

    // Обработчик нажатий на кнопки
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonId:
                if (!tvName.getText().toString().isEmpty()) {
                    //Toast.makeText(getApplicationContext(), tvName.getText().toString(), Toast.LENGTH_SHORT).show();
                    showCustomToast(tvName.getText().toString());
                }
                break;
            case R.id.toSecondButtonId: // Переход на второй экран с передачей значения из TextView
                if (tvName.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.enter_name_message), Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent.putExtra(NAME_FROM_TEXT_VIEW, tvName.getText().toString()));
                }
                break;
        }
    }

    // Отображение custom Toast
    public void showCustomToast(String message) {
        View layout = getLayoutInflater().inflate(R.layout.custom_toast, null, false);
        TextView text = layout.findViewById(R.id.messageId);
        text.setText(message);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}