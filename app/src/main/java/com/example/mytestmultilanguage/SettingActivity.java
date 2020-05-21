package com.example.mytestmultilanguage;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        findViewById(R.id.follow_system).setOnClickListener(this);
        findViewById(R.id.english).setOnClickListener(this);
        findViewById(R.id.chinese).setOnClickListener(this);
        findViewById(R.id.get_system_locale).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.follow_system:
                setNewLocale(LocaleManager.LANGUAGE_DEFAULT);
                break;
            case R.id.english:
                setNewLocale(LocaleManager.LANGUAGE_ENGLISH);
                break;
            case R.id.chinese:
                setNewLocale(LocaleManager.LANGUAGE_CHINESE);
                break;
            case R.id.get_system_locale:
//                String language = LocaleManager.getLocale(getResources()).getLanguage();
                String language = Resources.getSystem().getConfiguration().locale.getLanguage();
                Toast.makeText(this, language, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void setNewLocale(String language) {
        App.localeManager.setNewLocale(this, language);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
