package com.example.addaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class EnterAddress extends AppCompatActivity {

    //static String finalAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_address);

        EditText editText = (EditText) findViewById(R.id.editText);
        Intent intent = getIntent();
        final String address = intent.getStringExtra("place");
        final int position = intent.getIntExtra("position", 0);

        editText.setText(address);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                if(String.valueOf(s)!="")
                    MainActivity.places.set(position, String.valueOf(s));
                else
                    MainActivity.places.set(position, address);
                MainActivity.arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
