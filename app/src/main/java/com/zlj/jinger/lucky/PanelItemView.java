package com.zlj.jinger.lucky;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zlj.jinger.R;

/**
 * Created by jeanboy on 2017/4/20.
 */

public class PanelItemView extends FrameLayout implements ItemView {

    private View overlay;
    private TextView tvName;

    public PanelItemView(Context context) {
        this(context, null);
    }

    public PanelItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PanelItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_panel_item, this);
        overlay = findViewById(R.id.overlay);
        tvName = findViewById(R.id.tvName);
    }

    @Override
    public void setFocus(boolean isFocused) {
        if (overlay != null) {
            overlay.setVisibility(isFocused ? INVISIBLE : VISIBLE);
        }
    }

    public void setName(String name){
        tvName.setText(name);
    }

}
