package com.aghafari.tvmaze.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aghafari.tvmaze.R;
import com.aghafari.tvmaze.databinding.ItemShowBinding;
import com.aghafari.tvmaze.model.Show;
import com.aghafari.tvmaze.ui.vh.ShowViewHolder;

import java.util.List;


/**
 * Created by amir on 8/18/17.
 */

public class ShowsListAdapter extends RecyclerView.Adapter<ShowViewHolder> {
	private final Context context;
	private List<Show> showList;

	public ShowsListAdapter(Context context, @NonNull List<Show> showList) {
		this.showList = showList;
		this.context = context;
	}

	@Override
	public ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View inflate = LayoutInflater.from(context).inflate(R.layout.item_show, parent, false);
		return new ShowViewHolder((ItemShowBinding) DataBindingUtil.bind(inflate), viewType);
	}

	@Override
	public void onBindViewHolder(ShowViewHolder holder, int position) {
		holder.bindView(showList.get(position));
	}

	@Override
	public int getItemCount() {
		return showList.size();
	}
}
