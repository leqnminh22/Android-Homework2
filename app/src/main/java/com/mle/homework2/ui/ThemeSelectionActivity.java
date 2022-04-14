package com.mle.homework2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mle.homework2.R;
import com.mle.homework2.storage.Theme;
import com.mle.homework2.storage.ThemeStorage;

public class ThemeSelectionActivity extends AppCompatActivity {

    public static final String SELECTED_THEME = "SELECTED_THEME";
    public static final String CHOSEN_THEME = "CHOSEN_THEME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);

        Theme selectedTheme = (Theme) getIntent().getSerializableExtra(SELECTED_THEME);

        LinearLayout root = findViewById(R.id.root);

        for (Theme theme: Theme.values()) {
            // переделываем xml в java
            View itemView = getLayoutInflater().inflate(R.layout.item_theme, root, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(CHOSEN_THEME, theme);
                    setResult(Activity.RESULT_OK,resultIntent);
                    finish(); // закрыть активити
                }
            });

            TextView title = itemView.findViewById(R.id.theme_title);
            ImageView checked = itemView.findViewById(R.id.theme_checked);
            title.setText(theme.getTitle());

            if(theme.equals(selectedTheme)) {
                checked.setVisibility(View.VISIBLE);
            } else {
                checked.setVisibility(View.GONE);
            }

            root.addView(itemView);
        }
    }
}
