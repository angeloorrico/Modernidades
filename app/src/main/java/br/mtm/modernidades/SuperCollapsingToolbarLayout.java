package br.mtm.modernidades;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;

/**
 * Created by Angelo on 06/04/2016.
 */
@EViewGroup
public class SuperCollapsingToolbarLayout extends CollapsingToolbarLayout {

    private int mToolbarId;
    private Toolbar mToolbar;
    private boolean mScrimsAreShown;

    public SuperCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs,
                android.support.design.R.styleable.CollapsingToolbarLayout, defStyleAttr,
                android.support.design.R.style.Widget_Design_CollapsingToolbar);
        mToolbarId = a.getResourceId(android.support.design.R.styleable.CollapsingToolbarLayout_toolbarId, -1);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (mToolbarId != -1) {
            // If we have an ID set, try and find it and it's direct parent to us
            mToolbar = (Toolbar) findViewById(mToolbarId);
        }
        if (mToolbar == null) {
            // If we don't have an ID, or couldn't find a Toolbar with the correct ID, try and find
            // one from our direct children
            Toolbar toolbar = null;
            for (int i = 0, count = getChildCount(); i < count; i++) {
                final View child = getChildAt(i);
                if (child instanceof Toolbar) {
                    toolbar = (Toolbar) child;
                    break;
                }
            }
            mToolbar = toolbar;
        }

    }
    @Override
    public void setScrimsShown(boolean shown, boolean animate) {
        if (mScrimsAreShown != shown) {
            animateImage();
            mScrimsAreShown = shown;
        }
    }

    private void animateImage(){
        TransitionManager.beginDelayedTransition(this);
        if (mToolbar != null) {
            ImageView imagem = (ImageView) mToolbar.findViewById(R.id.icone);
            ImageView imagemGrande = (ImageView) findViewById(R.id.image);
            Toolbar.LayoutParams paramsIcone = (Toolbar.LayoutParams)imagem.getLayoutParams();
            FrameLayout.LayoutParams paramsImagem = (FrameLayout.LayoutParams)imagemGrande.getLayoutParams();
            paramsImagem.height = paramsIcone.height;
            paramsImagem.width = paramsIcone.width;
            paramsImagem.setMargins(paramsIcone.leftMargin, paramsIcone.topMargin, paramsIcone.rightMargin, paramsIcone.bottomMargin);
            imagemGrande.setLayoutParams(paramsImagem);
        }
    }

    public SuperCollapsingToolbarLayout(Context context) {
        this(context, null);

    }

    public SuperCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
}
