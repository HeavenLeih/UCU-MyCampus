package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Classroom extends Activity {

	/*
	 * Change to type CustomAutoCompleteView instead of AutoCompleteTextView
	 * since we are extending to customize the view and disable filter The same
	 * with the XML view, type will be CustomAutoCompleteView
	 */
	CustomAutoCompleteView myAutoComplete, myAutoloc;

	// adapter for auto-complete
	ArrayAdapter<MyObject> myAdapter;

	// for database operations
	DatabaseHandler databaseH;
	Button btnGoDR;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classroom);

		try {

			// instantiate database handler
			databaseH = new DatabaseHandler(Classroom.this);

			// put sample data to database
			insertSampleData();

			// autocompletetextview is in activity_main.xml
			myAutoComplete = (CustomAutoCompleteView) findViewById(R.id.searchClass);
			myAutoloc = (CustomAutoCompleteView) findViewById(R.id.searchloc);

			btnGoDR = (Button) findViewById(R.id.btnGoDR);

			btnGoDR.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub

					if ((myAutoComplete.getText().toString().equals("17A"))
							&& ((myAutoloc.getText().toString().equals("18A")))) {

						Toast.makeText(
								getApplicationContext(),
								"HONNASAN HALL BUILDING/18A IS RIGHT SIDE OF 17A",
								Toast.LENGTH_LONG).show();

					} else if ((myAutoComplete.getText().toString()
							.equals("17A"))
							&& ((myAutoloc.getText().toString()
									.equals("Room 21")))) {

						Intent classroomGo1 = new Intent(Classroom.this,
								Classroom17A.class);
						startActivity(classroomGo1);

					} else if ((myAutoComplete.getText().toString()
							.equals("17A"))
							&& ((myAutoloc.getText().toString()
									.equals("Room 22")))) {

						Intent classroomGo1 = new Intent(Classroom.this,
								Classroom17A.class);
						startActivity(classroomGo1);

					}

				}
			});

			myAutoComplete.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View arg1,
						int pos, long id) {

					RelativeLayout rl = (RelativeLayout) arg1;
					TextView tv = (TextView) rl.getChildAt(0);
					myAutoComplete.setText(tv.getText().toString());

				}

			});

			myAutoloc.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View arg1,
						int pos, long id) {

					RelativeLayout rl1 = (RelativeLayout) arg1;
					TextView tv1 = (TextView) rl1.getChildAt(0);
					myAutoloc.setText(tv1.getText().toString());

				}

			});

			// add the listener so it will tries to suggest while the user types
			myAutoComplete
					.addTextChangedListener(new CustomAutoCompleteTextChangedListener(
							this));

			myAutoloc
					.addTextChangedListener(new CustomAutoCompleteTextChangedListener(
							this));

			// ObjectItemData has no value at first
			MyObject[] ObjectItemData = new MyObject[0];

			// set the custom ArrayAdapter
			myAdapter = new AutocompleteCustomArrayAdapter(this,
					R.layout.list_view_row, ObjectItemData);
			myAutoComplete.setAdapter(myAdapter);

			myAdapter = new AutocompleteCustomArrayAdapter(this,
					R.layout.list_view_row, ObjectItemData);
			myAutoloc.setAdapter(myAdapter);

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertSampleData() {

		// CREATE
		// HONNASAN HALL
		databaseH.create(new MyObject("17A"));
		databaseH.create(new MyObject("18A"));
		databaseH.create(new MyObject("19A"));
		databaseH.create(new MyObject("20A"));

		// BADAR BUILDING
		databaseH.create(new MyObject("Room 21"));
		databaseH.create(new MyObject("Room 22"));
		databaseH.create(new MyObject("Room 23"));
		databaseH.create(new MyObject("Room 24"));

		// ORATA 2
		// first floor
		databaseH.create(new MyObject("OB2 81"));
		databaseH.create(new MyObject("OB2 82"));
		databaseH.create(new MyObject("OB2 83"));
		// second floor
		databaseH.create(new MyObject("OBL 1"));
		databaseH.create(new MyObject("OB2 84A"));
		databaseH.create(new MyObject("OB2 84B"));
		databaseH.create(new MyObject("OB2 84C"));
		databaseH.create(new MyObject("OB2 85"));
		databaseH.create(new MyObject("OB2 86"));
		databaseH.create(new MyObject("OB2 87A"));
		databaseH.create(new MyObject("OB2 87B"));
		databaseH.create(new MyObject("OB2 L2"));
		// third floor
		databaseH.create(new MyObject("OB2 L3"));
		databaseH.create(new MyObject("OB2 88"));
		databaseH.create(new MyObject("OB2 89"));
		databaseH.create(new MyObject("OB2 90"));
		databaseH.create(new MyObject("OB2 91"));
		databaseH.create(new MyObject("OB2 92"));
		databaseH.create(new MyObject("OB2 93"));

		// ORATA 1
		// first floor
		databaseH.create(new MyObject("Circulation section"));
		databaseH.create(new MyObject("Periodical"));
		databaseH.create(new MyObject("Reference Section"));
		// second floor
		databaseH.create(new MyObject("Regelation"));
		databaseH.create(new MyObject("Thesis"));
		databaseH.create(new MyObject("GS"));
		databaseH.create(new MyObject("Archives Section"));
		databaseH.create(new MyObject("Multimedia Room"));
		databaseH.create(new MyObject("Internet"));
		databaseH.create(new MyObject("Law library"));
		// third floor
		databaseH.create(new MyObject("OB 71"));
		databaseH.create(new MyObject("OB 72"));
		databaseH.create(new MyObject("OB 73"));
		databaseH.create(new MyObject("OB 74"));
		databaseH.create(new MyObject("OB 75"));
		// fourth floor
		databaseH.create(new MyObject("OB 76"));
		databaseH.create(new MyObject("OB 77"));
		databaseH.create(new MyObject("OB 78"));
		databaseH.create(new MyObject("OB 79"));
		databaseH.create(new MyObject("OB 80"));

		// NEW BUILDING
		// first floor
		databaseH.create(new MyObject("NB 51"));
		databaseH.create(new MyObject("NB 52"));
		databaseH.create(new MyObject("NB 53"));
		databaseH.create(new MyObject("NB 54"));
		databaseH.create(new MyObject("NB 55"));
		databaseH.create(new MyObject("Chemical Laboratory"));
		databaseH.create(new MyObject("REQUITION"));
		databaseH.create(new MyObject("STOCK ROOM"));
		// second floor
		databaseH.create(new MyObject("NB 56"));
		databaseH.create(new MyObject("NB 57"));
		databaseH.create(new MyObject("NB 58"));
		databaseH.create(new MyObject("NB 59"));
		databaseH.create(new MyObject("NB 60"));
		// third floor
		databaseH.create(new MyObject("NB61 COMPLAB"));
		databaseH.create(new MyObject("NB62 COMPLAB"));
		databaseH.create(new MyObject("NB63 COMPLAB"));
		databaseH.create(new MyObject("NB64 COMPLAB"));
		databaseH.create(new MyObject("NB65 COMPLAB"));
		// fourth floor
		databaseH.create(new MyObject("NB 66"));
		databaseH.create(new MyObject("NB 67"));
		databaseH.create(new MyObject("NB 68"));
		databaseH.create(new MyObject("NB 69"));
		databaseH.create(new MyObject("NB 70"));

		// AIRPLANE
		databaseH.create(new MyObject("AP1"));
		databaseH.create(new MyObject("AP2"));
		databaseH.create(new MyObject("AP3"));
		databaseH.create(new MyObject("AP4"));
		databaseH.create(new MyObject("AP5"));

		// sa may gilid
		databaseH.create(new MyObject("ROOM 1"));
		databaseH.create(new MyObject("ROOM 2"));
		databaseH.create(new MyObject("ROOM 3"));
		databaseH.create(new MyObject("ROOM 4"));
		databaseH.create(new MyObject("ROOM 5"));
		databaseH.create(new MyObject("ROOM 6"));
		databaseH.create(new MyObject("ROOM 7"));
		databaseH.create(new MyObject("ROOM 8"));
		databaseH.create(new MyObject("ROOM 9"));
		databaseH.create(new MyObject("ROOM 10"));
		databaseH.create(new MyObject("GUIDANCE"));
		databaseH.create(new MyObject("OSA"));
		// second floor
		databaseH.create(new MyObject("11"));
		databaseH.create(new MyObject("12"));
		databaseH.create(new MyObject("13"));
		databaseH.create(new MyObject("14"));
		databaseH.create(new MyObject("15"));
		databaseH.create(new MyObject("16"));
		databaseH.create(new MyObject("ID ROOM"));
		databaseH.create(new MyObject("CIM"));

		// EDUCATION BUILDING
		databaseH.create(new MyObject("46SWRM"));
		databaseH.create(new MyObject("47A"));
		databaseH.create(new MyObject("47B"));
		databaseH.create(new MyObject("48"));
		databaseH.create(new MyObject("49"));
		databaseH.create(new MyObject("50"));
		databaseH.create(new MyObject("51"));

		// CRIMINALISTIC
		databaseH.create(new MyObject("ROOM 25"));
		databaseH.create(new MyObject("ROOM 26"));
		databaseH.create(new MyObject("ROOM 27"));
		databaseH.create(new MyObject("ROOM 28"));

	}
}