/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView.ScaleType;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.R;

public class RotateLoadingLayout extends LoadingLayout {

    static final int ROTATION_ANIMATION_DURATION = 1200;

    private final Animation mRotateAnimation;
    private final Matrix mHeaderImageMatrix;

    private float mRotationPivotX, mRotationPivotY;

    private final boolean mRotateDrawableWhilePulling;

    public RotateLoadingLayout(Context context, Mode mode, Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);

        mRotateDrawableWhilePulling = attrs.getBoolean(R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);

        mHeaderImage.setScaleType(ScaleType.MATRIX);
        mHeaderImageMatrix = new Matrix();
        mHeaderImage.setImageMatrix(mHeaderImageMatrix);

        mRotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        mRotateAnimation.setDuration(ROTATION_ANIMATION_DURATION);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
        mRotateAnimation.setRepeatMode(Animation.RESTART);
    }

    public void onLoadingDrawableSet(Drawable imageDrawable) {
        if (null != imageDrawable) {
            mRotationPivotX = Math.round(imageDrawable.getIntrinsicWidth() / 2f);
            mRotationPivotY = Math.round(imageDrawable.getIntrinsicHeight() / 2f);
        }
    }

    protected void onPullImpl(float scaleOfLayout) {
        float angle;
        if (mRotateDrawableWhilePulling) {
            angle = scaleOfLayout * 90f;
        } else {
            angle = Math.max(0f, Math.min(180f, scaleOfLayout * 360f - 180f));
        }

        mHeaderImageMatrix.setRotate(angle, mRotationPivotX, mRotationPivotY);
        mHeaderImage.setImageMatrix(mHeaderImageMatrix);
//        LevelListDrawable drawable = (LevelListDrawable) mAnimationImage.getDrawable();//TODO 帧动画
//        mAnimationImage.setVisibility(View.VISIBLE);
//        int level = (int) (scaleOfLayout * 23);
//        if (level > 22) {//总共23帧
//            level = 22;
//        }
//
//        mAnimationImage.setImageLevel(level);
    }

    @Override
    protected void refreshingImpl() {
        mHeaderImage.startAnimation(mRotateAnimation);
//        mAnimationImage.setImageResource(R.drawable.home_loading_progressbar);
//        AnimationDrawable drawable = (AnimationDrawable) mAnimationImage.getDrawable();
//        drawable.start();
    }

    @Override
    protected void resetImpl() {
        mHeaderImage.clearAnimation();
//        mAnimationImage.clearAnimation();
        resetImageRotation();
    }

    private void resetImageRotation() {
        if (null != mHeaderImageMatrix) {
            mHeaderImageMatrix.reset();
            mHeaderImage.setImageMatrix(mHeaderImageMatrix);
//            mAnimationImage.setVisibility(View.INVISIBLE);//结束后重置并隐藏
//            mAnimationImage.setImageResource(R.drawable.home_pull_progresses);//TODO 重置图片
//        }

        }
    }

    @Override
    protected void pullToRefreshImpl() {
        // NO-OP
    }

    @Override
    protected void releaseToRefreshImpl() {
        // NO-OP
    }

    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.default_ptr_rotate;
    }
}
