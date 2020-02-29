package com.app.sb.sbservices.Utils;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class ClanProTextView extends AppCompatTextView {


    public ClanProTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if(!isInEditMode())
            applyFont(context);
    }

    private void applyFont(Context context){
        setTypeface(Typefaces.get(context, "MontserratAlternates-Medium.otf"));
    }


}