package br.mtm.modernidades.views;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import br.mtm.modernidades.ItemMenuModel;

/**
 * Created by Angelo on 29/03/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    List<ItemMenuModel> itemMenuModelList;
    static Activity actv;

    public MenuAdapter(List<ItemMenuModel> itemMenuModelList, Activity actv) {
        this.itemMenuModelList = itemMenuModelList;
        this.actv = actv;
    }

    public void rearrange() {
        Collections.sort(itemMenuModelList);
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ItemMenuView_.build(parent.getContext());
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.bind(itemMenuModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemMenuModelList.size();
    }



    public static class MenuViewHolder extends RecyclerView.ViewHolder {


        private ItemMenuView itemMenuView;

        public MenuViewHolder(View v) {
            super(v);
            itemMenuView = (ItemMenuView)v;
        }
        public void bind(ItemMenuModel model){
            itemMenuView.tvTitulo.setText(model.titulo);
            itemMenuView.ivImagem.setImageDrawable(actv.getResources().getDrawable(model.resourceId));
            itemMenuView.resourceId = model.resourceId;

        }

    }
}
