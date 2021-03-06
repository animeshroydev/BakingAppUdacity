package com.udacity.animesh.baking.presentation.recipes_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.animesh.baking.R;
import com.udacity.animesh.baking.data.models.Recipe;
import com.udacity.animesh.baking.databinding.RecipesListContentBinding;

import java.util.List;

public class RecipesListRecyclerAdapter
        extends RecyclerView.Adapter<RecipesListRecyclerAdapter.ViewHolder> {

    private List<Recipe> recipes;
    private final OnRecipeClickListener onClickListener;

    RecipesListRecyclerAdapter(List<Recipe> recipes,
                               OnRecipeClickListener onClickListener) {
        this.recipes = recipes;
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipes_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(recipes.get(position));
    }

    public void swapData(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return recipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final RecipesListContentBinding binding;

        private
        ViewHolder(View view) {
            super(view);
            binding = RecipesListContentBinding.bind(view);
        }

        void bind(Recipe recipe){
            binding.setRecipe(recipe);
            binding.setListener(onClickListener);
        }
    }

    public interface OnRecipeClickListener {
        void onClick(Recipe recipe);
    }
}
