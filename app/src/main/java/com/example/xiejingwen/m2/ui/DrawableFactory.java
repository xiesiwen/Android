package com.example.xiejingwen.m2.ui;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.LruCache;

import java.util.Map;
import java.util.Set;

/**
 * Created by xiejingwen on 2017/11/18.
 */

public class DrawableFactory {
    private final static int MAX_CACHED = 20;
    private static LruCache<GradientState, GradientDrawable> sGradientDrawableCache = new LruCache<>(
            20);

    private static LruCache<StatesDrawableState, StateListDrawable> sStateListDrawableCache = new LruCache<>(
            20);
    
    public static GradientState buildDrawable() {
        return new GradientState();
    }
    
    public static StatesDrawableState buildStatesDrawable() {
        return new StatesDrawableState();
    }
    
    static GradientDrawable findCachedGradientDrawable(DrawableState drawableState) {
        Map<GradientState, GradientDrawable> map = sGradientDrawableCache.snapshot();
        Set<GradientState> keys = map.keySet();
        for (GradientState key : keys) {
            if (key.equals(drawableState)) {
                return map.get(key);
            }
        }
        return null;
    }

    static void put(GradientState gradientState, GradientDrawable gradientDrawable){
        sGradientDrawableCache.put(gradientState, gradientDrawable);
    }

    static StateListDrawable findCachedStateListGradientDrawable(DrawableState drawableState) {
        Map<StatesDrawableState, StateListDrawable> map = sStateListDrawableCache.snapshot();
        Set<StatesDrawableState> keys = map.keySet();
        for (StatesDrawableState key : keys) {
            if (key.equals(drawableState)) {
                return map.get(key);
            }
        }
        return null;
    }

    static void put(StatesDrawableState statesDrawableState, StateListDrawable stateListDrawable){
        sStateListDrawableCache.put(statesDrawableState, stateListDrawable);
    }
    
}
