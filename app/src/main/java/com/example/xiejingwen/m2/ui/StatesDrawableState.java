package com.example.xiejingwen.m2.ui;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by xiejingwen on 2017/11/19.
 */

public class StatesDrawableState implements DrawableState {
    int[][] mStateSets;
    Drawable[] mDrawables;
    int mNumChildren;
    
    public StatesDrawableState() {
        mDrawables = new Drawable[10];
        mStateSets = new int[10][];
        mNumChildren = 0;
    }
    
    public StatesDrawableState addStateSet(int[] stateSet, Drawable drawable) {
        final int pos = addChild(drawable);
        mStateSets[pos] = stateSet;
        return this;
    }
    
    private final int addChild(Drawable dr) {
        final int pos = mNumChildren;
        if (pos >= mDrawables.length) {
            growArray(pos, pos + 10);
        }
        mDrawables[pos] = dr;
        mNumChildren++;
        return pos;
    }
    
    private void growArray(int oldSize, int newSize) {
        Drawable[] newDrawables = new Drawable[newSize];
        System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
        mDrawables = newDrawables;
        final int[][] newStateSets = new int[newSize][];
        System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
        mStateSets = newStateSets;
    }
    
    public StateListDrawable newDrawable() {
        return newDrawable(false);
    }
    
    public StateListDrawable newDrawable(boolean ignoreCached) {
        StateListDrawable stateListDrawable = null;
        if (!ignoreCached) {
            stateListDrawable = DrawableFactory.findCachedStateListGradientDrawable(this);
        }
        if (stateListDrawable == null) {
            stateListDrawable = createDrawable();
            DrawableFactory.put(this, stateListDrawable);
        }
        return stateListDrawable;
    }
    
    private StateListDrawable createDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int length = mDrawables.length;
        for (int i = 0; i < length; i++) {
            Drawable drawable = mDrawables[i];
            if (drawable != null) {
                stateListDrawable.addState(mStateSets[i], drawable);
            }
        }
        return stateListDrawable;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
//        if (obj instanceof StatesDrawableState) {
//            StatesDrawableState statesDrawableState = (StatesDrawableState) obj;
//            return equalsDrawable(statesDrawableState)
//                    && equalsStates(statesDrawableState);
//        }
        return false;
    }
    
    private boolean equalsDrawable(StatesDrawableState statesDrawableState) {
        int length = mDrawables.length;
        if (length != statesDrawableState.mDrawables.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (mDrawables[i] != statesDrawableState.mDrawables[i]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean equalsStates(StatesDrawableState statesDrawableState) {
        int length = mStateSets.length;
        if (length != statesDrawableState.mStateSets.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int[] state = mStateSets[i];
            int[] oState = statesDrawableState.mStateSets[i];
            if (state != null && oState != null) {
                int l = state.length;
                if (l != oState.length) {
                    return false;
                }
                for (int j = 0; j < l; j++) {
                    if (state[j] != oState[j]) {
                        return false;
                    }
                }
            }
            if (state == null && oState == null) {
                continue;
            }

        }
        return true;
    }
}
