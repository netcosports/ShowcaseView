/*
 * Copyright 2014 Alex Curran
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.amlcurran.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by curraa01 on 13/10/2013.
 */
class NewShowcaseDrawer extends StandardShowcaseDrawer {

    private static final int ALPHA_60_PERCENT = 153;
    private final float outerRadius;
    private final float middleRadius;
    private final float innerRadius;

    public NewShowcaseDrawer(Resources resources) {
        super(resources);
        outerRadius = resources.getDimension(R.dimen.showcase_radius_outer);
        middleRadius = resources.getDimension(R.dimen.showcase_radius_middle);
        innerRadius = resources.getDimension(R.dimen.showcase_radius_inner);
    }

    @Override
    public void setShowcaseColour(int color) {
        eraserPaint.setColor(color);
    }

    @Override
    public void drawShowcase(Bitmap buffer, float x, float y, float scaleMultiplier) {
        eraserPaint.setStyle(Paint.Style.STROKE);

        Canvas bufferCanvas = new Canvas(buffer);

        eraserPaint.setStrokeWidth(12);
        bufferCanvas.drawCircle(x, y, outerRadius, eraserPaint);
        eraserPaint.setStrokeWidth(9);
        bufferCanvas.drawCircle(x, y, middleRadius, eraserPaint);
        eraserPaint.setStrokeWidth(6);
        bufferCanvas.drawCircle(x, y, innerRadius, eraserPaint);
    }

    @Override
    public int getShowcaseWidth() {
        return (int) (outerRadius * 2);
    }

    @Override
    public int getShowcaseHeight() {
        return (int) (outerRadius * 2);
    }

    @Override
    public float getBlockedRadius() {
        return innerRadius;
    }

    @Override
    public void setBackgroundColour(int backgroundColor) {
        this.backgroundColour = backgroundColor;
    }
}
