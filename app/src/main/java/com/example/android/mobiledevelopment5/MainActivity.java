package com.example.android.mobiledevelopment5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mButtonHitung;
    EditText mEditPanjang, mEditLebar;
    TextView mTextHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonHitung = findViewById(R.id.button_hitung);
        mEditLebar = findViewById(R.id.edit_lebar);
        mEditPanjang = findViewById(R.id.edit_panjang);
        mTextHasil = findViewById(R.id.text_luas);

        mButtonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang, lebar;
                panjang = mEditPanjang.getText().toString().trim();
                lebar = mEditLebar.getText().toString().trim();

                if(!panjang.equals("") &&  !lebar.equals("")){
                    double nilaiPanjang = Double.parseDouble(panjang);
                    double nilaiLebar = Double.parseDouble(lebar);

                    double luas = nilaiLebar * nilaiPanjang;

                    mTextHasil.setText(String.valueOf(luas));
                    mEditLebar.setText("");
                    mEditPanjang.setText("");
                } else {
                    String notification;
                    if (panjang.equals("") && lebar.equals(""))
                        notification = "panjang dan lebar";
                    else if (panjang.equals(""))
                        notification = "panjang";
                    else
                        notification = "lebar";
                    Toast.makeText(
                            MainActivity.this,
                            "Field " + notification + " belum terisi",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
