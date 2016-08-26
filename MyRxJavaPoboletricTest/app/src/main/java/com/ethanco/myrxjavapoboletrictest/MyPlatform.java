package com.ethanco.myrxjavapoboletrictest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowView;

import java.io.PrintStream;

/**
 * Created by EthanCo on 2016/8/25.
 */
@Implements(okhttp3.internal.platform.Platform.class)
public class MyPlatform extends ShadowView {

    public MyPlatform() {
        super();
    }

    @Implementation
    @Override
    public void __constructor__(Context context, AttributeSet attributeSet, int defStyle) {
        super.__constructor__(context, attributeSet, defStyle);
    }

    @Implementation
    @Override
    protected Drawable buildDrawable(int resourceId) {
        return super.buildDrawable(resourceId);
    }

    @Implementation
    @Override
    protected String getQualifiers() {
        return super.getQualifiers();
    }

    @Implementation
    @Override
    public int getBackgroundResourceId() {
        return super.getBackgroundResourceId();
    }

    @Implementation
    @Override
    public int getBackgroundColor() {
        return super.getBackgroundColor();
    }

    @Implementation
    @Override
    public void computeOpaqueFlags() {
        super.computeOpaqueFlags();
    }

    @Implementation
    @Override
    public void setOnFocusChangeListener(View.OnFocusChangeListener l) {
        super.setOnFocusChangeListener(l);
    }

    @Implementation
    @Override
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Implementation
    @Override
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
    }

    @Implementation
    @Override
    public void setOnSystemUiVisibilityChangeListener(View.OnSystemUiVisibilityChangeListener onSystemUiVisibilityChangeListener) {
        super.setOnSystemUiVisibilityChangeListener(onSystemUiVisibilityChangeListener);
    }

    @Implementation
    @Override
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        super.setOnCreateContextMenuListener(onCreateContextMenuListener);
    }

    @Implementation
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Implementation
    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Implementation
    @Override
    public boolean onLayoutWasCalled() {
        return super.onLayoutWasCalled();
    }

    @Implementation
    @Override
    public void requestLayout() {
        super.requestLayout();
    }

    @Implementation
    @Override
    public boolean didRequestLayout() {
        return super.didRequestLayout();
    }

    @Implementation
    @Override
    public void setDidRequestLayout(boolean didRequestLayout) {
        super.setDidRequestLayout(didRequestLayout);
    }

    @Implementation
    @Override
    public void setViewFocus(boolean hasFocus) {
        super.setViewFocus(hasFocus);
    }

    @Implementation
    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Implementation
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Implementation
    @Override
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    @Implementation
    @Override
    public MotionEvent getLastTouchEvent() {
        return super.getLastTouchEvent();
    }

    @Implementation
    @Override
    public String innerText() {
        return super.innerText();
    }

    @Implementation
    @Override
    public void dump() {
        super.dump();
    }

    @Implementation
    @Override
    public void dump(PrintStream out, int indent) {
        super.dump(out, indent);
    }

    @Implementation
    @Override
    protected void dumpFirstPart(PrintStream out, int indent) {
        super.dumpFirstPart(out, indent);
    }

    @Implementation
    @Override
    protected void dumpAttributes(PrintStream out) {
        super.dumpAttributes(out);
    }

    @Implementation
    @Override
    protected void dumpAttribute(PrintStream out, String name, String value) {
        super.dumpAttribute(out, name, value);
    }

    @Implementation
    @Override
    protected void dumpIndent(PrintStream out, int indent) {
        super.dumpIndent(out, indent);
    }

    @Implementation
    @Override
    public boolean wasInvalidated() {
        return super.wasInvalidated();
    }

    @Implementation
    @Override
    public void clearWasInvalidated() {
        super.clearWasInvalidated();
    }

    @Implementation
    @Override
    public boolean checkedPerformClick() {
        return super.checkedPerformClick();
    }

    @Implementation
    @Override
    public View.OnTouchListener getOnTouchListener() {
        return super.getOnTouchListener();
    }

    @Implementation
    @Override
    public View.OnClickListener getOnClickListener() {
        return super.getOnClickListener();
    }

    @Implementation
    @Override
    public View.OnLongClickListener getOnLongClickListener() {
        return super.getOnLongClickListener();
    }

    @Implementation
    @Override
    public View.OnSystemUiVisibilityChangeListener getOnSystemUiVisibilityChangeListener() {
        return super.getOnSystemUiVisibilityChangeListener();
    }

    @Implementation
    @Override
    public View.OnCreateContextMenuListener getOnCreateContextMenuListener() {
        return super.getOnCreateContextMenuListener();
    }

    @Implementation
    @Override
    public Bitmap getDrawingCache() {
        return super.getDrawingCache();
    }

    @Implementation
    @Override
    public void post(Runnable action) {
        super.post(action);
    }

    @Implementation
    @Override
    public void postDelayed(Runnable action, long delayMills) {
        super.postDelayed(action, delayMills);
    }

    @Implementation
    @Override
    public void postInvalidateDelayed(long delayMilliseconds) {
        super.postInvalidateDelayed(delayMilliseconds);
    }

    @Implementation
    @Override
    public void removeCallbacks(Runnable callback) {
        super.removeCallbacks(callback);
    }

    @Implementation
    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Implementation
    @Override
    public int getScrollX() {
        return super.getScrollX();
    }

    @Implementation
    @Override
    public int getScrollY() {
        return super.getScrollY();
    }

    @Implementation
    @Override
    public void setScrollX(int scrollX) {
        super.setScrollX(scrollX);
    }

    @Implementation
    @Override
    public void setScrollY(int scrollY) {
        super.setScrollY(scrollY);
    }

    @Implementation
    @Override
    public void setAnimation(Animation animation) {
        super.setAnimation(animation);
    }

    @Implementation
    @Override
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Implementation
    @Override
    public void callOnAttachedToWindow() {
        super.callOnAttachedToWindow();
    }

    @Implementation
    @Override
    public void callOnDetachedFromWindow() {
        super.callOnDetachedFromWindow();
    }

    @Implementation
    @Override
    public boolean performHapticFeedback(int hapticFeedbackType) {
        return super.performHapticFeedback(hapticFeedbackType);
    }

    @Implementation
    @Override
    public boolean getGlobalVisibleRect(Rect rect, Point globalOffset) {
        return super.getGlobalVisibleRect(rect, globalOffset);
    }

    @Implementation
    @Override
    public void setGlobalVisibleRect(Rect rect) {
        super.setGlobalVisibleRect(rect);
    }

    @Implementation
    @Override
    public int lastHapticFeedbackPerformed() {
        return super.lastHapticFeedbackPerformed();
    }

    @Implementation
    @Override
    public void setMyParent(ViewParent viewParent) {
        super.setMyParent(viewParent);
    }

    @Implementation
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Implementation
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Implementation
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Implementation
    @Override
    public String toString() {
        return super.toString();
    }

    @Implementation
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
