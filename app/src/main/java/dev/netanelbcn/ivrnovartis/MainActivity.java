package dev.netanelbcn.ivrnovartis;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import dev.netanelbcn.ivrcall.Api.myApi;
import dev.netanelbcn.ivrcall.Models.ApiResponse;
import dev.netanelbcn.ivrcall.Models.CallDetails;
import dev.netanelbcn.ivrcall.Models.CallPreferences;
import dev.netanelbcn.ivrcall.Models.IvrResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText ET_main_phoneNumber;
    private RadioButton RB_main_optionOneMonth;
    private MaterialButton MB_main_loginButton;
    private CallPreferences preferences;
    private MaterialTextView MTV_main_Error;
    private RadioGroup RG_main_recordTemplate;
    private int templateNum;
    private String phoneNumber;
    private ProgressBar mySpinner;
    private String baseURl="YOUR URL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        myApi api = new myApi(baseURl);
        connectUI();
        MB_main_loginButton.setOnClickListener(v -> {
            ET_main_phoneNumber.setEnabled(false);
            mySpinner.setVisibility(View.VISIBLE);
            phoneNumber = ET_main_phoneNumber.getText().toString();
            if (!phoneNumberFormatOK(phoneNumber)) {
                MTV_main_Error.setText("Phone number should be in format: 05XXXXXXXX");
            } else {
                int selectedButtonId = RG_main_recordTemplate.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedButtonId);
                if (selectedRadioButton == RB_main_optionOneMonth)
                    templateNum = 1;
                else
                    templateNum = 2;
            }
            preferences = new CallPreferences()
                    .setRecordTemplate(templateNum+"")
                    .setPhoneNumber(phoneNumber);
            api.makeCall(preferences, new Callback<ApiResponse>() {
                Intent intent=new Intent(MainActivity.this,SummaryActivity.class);
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        ApiResponse apiResponse = response.body();
                        CallDetails details = apiResponse.getData();
                        if (details != null) {
                            System.out.println("Number: " + details.getNumber());
                            System.out.println("Record Template: " + details.getRecordTemplate());
                            intent.putExtra("Number",details.getNumber()+"");
                            intent.putExtra("Record Template",details.getRecordTemplate()+"");
                            IvrResponse ivrResponse = details.getIvrResponse();
                            if (ivrResponse != null) {

                                System.out.println("HTTP Code: " + ivrResponse.getHttpCode());
                                System.out.println("Response: " + ivrResponse.getResponse());
                                intent.putExtra("HTTP Code",ivrResponse.getHttpCode()+"");
                                intent.putExtra("Response",ivrResponse.getResponse()+"");

                            } else {
                                System.out.println("No IVR response received.");
                            }
                        } else {
                            System.err.println("No data received in the response.");
                        }
                    } else {
                        System.err.println("Failed to get a successful response. Code: " + response.code());
                    }
                    ET_main_phoneNumber.setEnabled(true);
                    mySpinner.setVisibility(View.INVISIBLE);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    System.err.println("API call failed: " + t.getMessage());
                }
            });


        });

    }

    public void connectUI() {
        ET_main_phoneNumber = findViewById(R.id.ET_main_phoneNumber);
        RB_main_optionOneMonth = findViewById(R.id.RB_main_optionOneMonth);
        RB_main_optionOneMonth.setChecked(true);
        MB_main_loginButton = findViewById(R.id.MB_main_loginButton);
        RG_main_recordTemplate = findViewById(R.id.RG_main_recordTemplate);
        MTV_main_Error = findViewById(R.id.MTV_main_Error);
        mySpinner = findViewById(R.id.mySpinner);
    }

    public boolean phoneNumberFormatOK(String phoneNumber) {
        // Check the length and prefix
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '5') {
            // Ensure all characters are digits
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) {
                    return false; // Return false if a non-digit character is found
                }
            }
            return true; // All checks passed
        } else {
            return false; // Length or prefix doesn't match
        }
    }

}