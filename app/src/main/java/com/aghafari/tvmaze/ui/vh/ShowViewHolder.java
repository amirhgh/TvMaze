package com.aghafari.tvmaze.ui.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aghafari.tvmaze.databinding.ItemShowBinding;
import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.vm.ShowViewModel;

/**
 * Created by amir on 8/18/17.
 */

public class ShowViewHolder extends RecyclerView.ViewHolder{
	protected ItemShowBinding binding;
	private int position;

	public ShowViewHolder(ItemShowBinding binding, int viewType) {
		super(binding.getRoot());
		this.binding = binding;
	}
	public void bindView(Show show){
		ShowViewModel vm = new ShowViewModel(show);
		binding.setShow(vm);
	}
}
