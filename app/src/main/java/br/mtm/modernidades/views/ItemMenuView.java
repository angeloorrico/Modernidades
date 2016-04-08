package br.mtm.modernidades.views;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.mtm.modernidades.DetalheActivity_;
import br.mtm.modernidades.R;

/**
 * Created by Angelo on 29/03/2016.
 */
@EViewGroup(R.layout.item_menu)
public class ItemMenuView extends RelativeLayout{

    @ViewById
    TextView tvTitulo;
    @ViewById
    ImageView ivImagem;

    public int resourceId;


    public ItemMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemMenuView(Context context) {
        super(context);
    }

    @Click(R.id.root)
    void click(){
        Toast.makeText(this.getContext(), "Click", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.getContext(), DetalheActivity_.class);
        Activity actv = (Activity) this.getContext();

        intent.putExtra("imagem", resourceId);
        View sharedView = ivImagem;
        String transitionName = "imagem";
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(actv, sharedView, transitionName);
        ActivityCompat.startActivity(actv, intent, transitionActivityOptions.toBundle());
    }

}
