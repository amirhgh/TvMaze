package com.aghafari.tvmaze.network;


import android.support.design.widget.Snackbar;
import android.view.View;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by amir on 8/25/17.
 */

public class ErrorHandler implements Consumer<Throwable> {
	private final View view;

	public ErrorHandler(View view) {
		this.view = view;
	}

	/**
	 * Consume the given value.
	 *
	 * @param throwable the value
	 * @throws Exception on error
	 */
	@Override
	public void accept(@NonNull Throwable throwable) throws Exception {
		Snackbar.make(view, throwable.getLocalizedMessage(), Snackbar.LENGTH_SHORT).show();
	}
}
