package br.mtm.modernidades;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.mtm.modernidades.views.MenuAdapter;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    RecyclerView rvMenu;

    MenuAdapter adapter;

    @AfterViews
    void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                TransitionManager.beginDelayedTransition(rvMenu);
                adapter.rearrange();
                adapter.notifyDataSetChanged();
            }
        });

        rvMenu.setHasFixedSize(false);
        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvMenu.setLayoutManager(lm);
        List<ItemMenuModel> lista = new ArrayList<>();
        lista.add(new ItemMenuModel("item 10", R.drawable.tall));
        lista.add(new ItemMenuModel("item 1", R.drawable.facebook));
        lista.add(new ItemMenuModel("item 2", R.drawable.gears_stop));
        lista.add(new ItemMenuModel("item 3", R.drawable.google_icon));
        lista.add(new ItemMenuModel("item 4", R.drawable.twitter));
        lista.add(new ItemMenuModel("item 5", R.drawable.utorrent));
        lista.add(new ItemMenuModel("item 6", R.drawable.ares));
        lista.add(new ItemMenuModel("item 7", R.drawable.d_effect));
        lista.add(new ItemMenuModel("item 8", R.drawable.shelby));
        lista.add(new ItemMenuModel("item 9", R.mipmap.ic_launcher));
        lista.add(new ItemMenuModel("item 11", R.mipmap.ic_launcher));
        lista.add(new ItemMenuModel("item 12", R.mipmap.ic_launcher));
        adapter = new MenuAdapter(lista, this);
        rvMenu.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
