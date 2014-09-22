package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ClassroomCBC extends Activity {
Button bSearch1, bSearch2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classroom_cbc);
	bSearch1=(Button)findViewById(R.id.button1);
	bSearch2=(Button)findViewById(R.id.button2);
	
	bSearch1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent classroomGo1 = new Intent(ClassroomCBC.this,
					Classroom.class);
			startActivity(classroomGo1);
		
		}});
	
	bSearch2.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent buildToRoom = new Intent(ClassroomCBC.this,
					BuildingToClassroom.class);
			startActivity(buildToRoom);
		}});
	
	}

}
