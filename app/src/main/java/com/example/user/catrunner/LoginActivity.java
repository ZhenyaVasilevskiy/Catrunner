package com.example.user.catrunner;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public static Typeface typefaceBebasNeue, typefaceOpenSansBold, typefaceOpenSansRegular;
    public Button btnSignIn, btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        typefaceBebasNeue = Typeface.createFromAsset(getAssets(), "fonts/BebasNeue_Regular.otf");
        typefaceOpenSansBold = Typeface.createFromAsset(getAssets(), "fonts/OpenSans_Bold.ttf");
        typefaceOpenSansRegular = Typeface.createFromAsset(getAssets(), "fonts/OpenSans_Regular.ttf");

        TextView helloText = findViewById(R.id.txt_hello);
        final SpannableStringBuilder text = new SpannableStringBuilder(getResources().getString(R.string.txt_hello));
        final ForegroundColorSpan style = new ForegroundColorSpan(getResources().getColor(R.color.colorAccentPink));
        text.setSpan(style, 5, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        helloText.setText(text);
        helloText.setTypeface(typefaceOpenSansBold);

        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setTypeface(typefaceOpenSansBold);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnCreateAccount = findViewById(R.id.btn_create_account);
        btnCreateAccount.setTypeface(typefaceOpenSansBold);
    }
}
