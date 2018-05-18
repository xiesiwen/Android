package com.example.xiejingwen.m2.ui;

import android.graphics.drawable.GradientDrawable;

/**
 * Created by xiejingwen on 2017/11/19.
 */

public class GradientState implements DrawableState {
    int mSolidColor;
    int mStrokeColor;
    int mStrokeWidth = -1; // if >= 0 use stroking.
    float mRadius = 0.0f; // use this if mRadiusArray is null
    float[] mRadiusArray = null;
    
    public GradientState() {
        
    }
    
    public GradientState setSolidColor(int color) {
        mSolidColor = color;
        return this;
    }
    
    public GradientState setStroke(int width, int color) {
        mStrokeWidth = width;
        mStrokeColor = color;
        return this;
    }
    
    public GradientState setCornerRadius(float radius) {
        if (radius < 0) {
            radius = 0;
        }
        mRadius = radius;
        mRadiusArray = null;
        return this;
    }
    
    public GradientState setCornerRadii(float[] radii) {
        mRadiusArray = radii;
        if (radii == null) {
            mRadius = 0;
        }
        return this;
    }
    
    public GradientDrawable newDrawable() {
        return newDrawable(false);
    }
    
    public GradientDrawable newDrawable(boolean ignoreCached) {
        GradientDrawable gradientDrawable = null;
        if (!ignoreCached) {
            gradientDrawable = DrawableFactory.findCachedGradientDrawable(this);
        }
        if (gradientDrawable == null) {
            gradientDrawable = createDrawable();
            DrawableFactory.put(this, gradientDrawable);
        }
        return gradientDrawable;
    }
    
    private GradientDrawable createDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(mSolidColor);
        gradientDrawable.setStroke(mStrokeWidth, mStrokeColor);
        gradientDrawable.setCornerRadii(mRadiusArray);
        gradientDrawable.setCornerRadius(mRadius);
        return gradientDrawable;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GradientState) {
            GradientState gradientState = (GradientState) obj;
            if (mSolidColor == gradientState.mSolidColor
                    && mStrokeColor == gradientState.mStrokeColor
                    && mStrokeWidth == gradientState.mStrokeWidth
                    && mRadius == gradientState.mRadius) {
                if (mRadiusArray == null && gradientState.mRadiusArray == null) {
                    return true;
                }
                if (mRadiusArray != null && gradientState.mRadiusArray != null) {
                    if (mRadiusArray.length == gradientState.mRadiusArray.length) {
                        int length = mRadiusArray.length;
                        for (int i = 0; i < length; i++) {
                            if (mRadiusArray[i] != gradientState.mRadiusArray[i]) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
        
    }
    
}
