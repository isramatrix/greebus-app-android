package com.emt.sostenible.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.emt.sostenible.R;

import java.util.Date;
import java.util.Set;

public class RouteInfo extends LinearLayout {

    private TextView departure;

    private TextView arrival;

    private LinearLayout lines;

    public RouteInfo(Context context) {
        super(context);
    }

    public RouteInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RouteInfo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Finalize inflating a view from XML.  This is called as the last phase
     * of inflation, after all child views have been added.
     *
     * <p>Even if the subclass overrides onFinishInflate, they should always be
     * sure to call the super method, so that we get called.
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        LinearLayout parent = (LinearLayout) getChildAt(1);
        departure = (TextView) ((LinearLayout) parent.getChildAt(0)).getChildAt(1);
        arrival = (TextView) ((LinearLayout) parent.getChildAt(2)).getChildAt(1);
        lines = (LinearLayout) ((LinearLayout) getChildAt(0)).getChildAt(1);
    }

    public void setTimes(String departure, String arrival)
    {
        this.departure.setText(departure);
        this.arrival.setText(arrival);
    }

    public void setLines(Set<String> lins)
    {
        lines.removeAllViews();
        LayoutParams layout = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setMargins(10, 0, 10, 0);

        for (String l : lins) {
            System.out.println(l);
            inflate(this.getContext(), R.layout.line_view, lines);
            TextView lineText = (TextView) lines.getChildAt(lines.getChildCount()-1);
            lineText.setLayoutParams(layout);
            lineText.setText(l);
        }
    }

    public void show(boolean visible)
    {
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
        final int endMargin = visible ? 0 : -getHeight() + 10;
        final int startMargin = params.bottomMargin;

        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float time, Transformation t) {
                params.bottomMargin = (int) (startMargin + (endMargin - startMargin) * time);
                setLayoutParams(params);
            }
        };
        animation.setDuration(100);
        startAnimation(animation);
    }

}
