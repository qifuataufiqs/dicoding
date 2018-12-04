package com.qifuataufiqs.barvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResulf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = (EditText) findViewById(R.id.edt_width);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        edtLength = (EditText) findViewById(R.id.edt_length);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        tvResulf = (TextView) findViewById(R.id.tv_resulf);
        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResulf.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();

            boolean isEmptuFields = false;
            if (TextUtils.isEmpty(length)) {
                isEmptuFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)) {
                isEmptuFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)) {
                isEmptuFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptuFields) {
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResulf.setText(String.valueOf(volume));
            }
        }
    }

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, tvResulf.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
