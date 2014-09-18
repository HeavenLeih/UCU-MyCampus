package edu.ucuccs.ucumycampus;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class CustomAutoCompleteTextChangedListener implements TextWatcher {

	public static final String TAG = "CustomAutoCompleteTextChangedListener.java";
	Context context;

	public CustomAutoCompleteTextChangedListener(Context context) {
		this.context = context;
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence userInput, int start, int before,
			int count) {

		try {

			// if you want to see in the logcat what the user types
			Log.e(TAG, "User input: " + userInput);

			Classroom classroom = ((Classroom) context);

			// update the adapater
			classroom.myAdapter.notifyDataSetChanged();

			// get suggestions from the database
			MyObject[] myObjs = classroom.databaseH.read(userInput
					.toString());

			// update the adapter
			classroom.myAdapter = new AutocompleteCustomArrayAdapter(
					classroom, R.layout.list_view_row, myObjs);

			classroom.myAutoComplete.setAdapter(classroom.myAdapter);

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}