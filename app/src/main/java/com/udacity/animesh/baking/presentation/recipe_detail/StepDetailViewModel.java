package com.udacity.animesh.baking.presentation.recipe_detail;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.udacity.animesh.baking.data.models.Step;

public class StepDetailViewModel extends ViewModel {

    public ObservableField<Step> step = new ObservableField<>();

    public ObservableBoolean orientationLandscape = new ObservableBoolean();

    public StepDetailViewModel(Step step) {
        this.step.set(step);
    }

}
