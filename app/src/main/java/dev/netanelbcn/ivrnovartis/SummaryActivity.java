package dev.netanelbcn.ivrnovartis;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.textview.MaterialTextView;

public class SummaryActivity extends AppCompatActivity {
    private String httpCode;
    private String phoneNumber;
    private String recordTemplate;
    private String response;
    private MaterialTextView MTV_summary_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_summary);
        MTV_summary_result = findViewById(R.id.MTV_summary_result);
        Intent intent = getIntent();
        httpCode = intent.getStringExtra("HTTP Code");
        phoneNumber = intent.getStringExtra("Number");
        recordTemplate = intent.getStringExtra("Record Template");
        response = intent.getStringExtra("Response");
        SpannableStringBuilder formattedText = new SpannableStringBuilder();
        formattedText.append("HTTP Code: ")
                .append(httpCode, new StyleSpan(android.graphics.Typeface.BOLD), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                .append("\n");
        formattedText.append("Phone Number: ")
                .append(phoneNumber, new StyleSpan(android.graphics.Typeface.BOLD), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                .append("\n");

        formattedText.append("Record Template: ")
                .append(recordTemplate, new StyleSpan(android.graphics.Typeface.BOLD), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                .append("\n\n");
        formattedText.append("Original Response Body From API: ")
                .append(response, new StyleSpan(android.graphics.Typeface.BOLD), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        MTV_summary_result.setText(formattedText);
    }
}
