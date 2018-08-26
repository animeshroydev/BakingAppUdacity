package com.udacity.animesh.baking.presentation.recipes_list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.udacity.animesh.baking.data.api.RecipesApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {


    private RecipesApi recipesApi;

    @Inject
    public ViewModelFactory(RecipesApi recipesApi) {
        super();
        this.recipesApi = recipesApi;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RecipesListViewModel.class)) {
            return (T) new RecipesListViewModel(recipesApi);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
