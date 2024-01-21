6. Develop an android application to embed Picker Views in an activity.
Step1 create an android project with java as programming language
Step 2 choose empty activity
Step 3 write the xml file with linear layout
Step 4 write the mainactivity.java file
7. <?xml version="1.0" encoding="utf-8"?>
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android
"
 android:layout_width="fill_parent"
 android:layout_height="fill_parent"
 android:orientation="vertical" >
 <Button android:id="@+id/btnSet"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:text="I am all set!"
 android:onClick="onClick" />
 <DatePicker android:id="@+id/datePicker"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content" />
 <TimePicker android:id="@+id/timePicker"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content" />
</LinearLayout>
Main activity.java
package com.example.pickerview;
import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
 TimePicker timePicker;
 DatePicker datePicker;
 int hour, minute;
 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 timePicker = (TimePicker)
findViewById(R.id.timePicker);
 timePicker.setIs24HourView(true);
 datePicker = (DatePicker)
findViewById(R.id.datePicker);
 }
 private TimePickerDialog.OnTimeSetListener
mTimeSetListener =
 new TimePickerDialog.OnTimeSetListener()
 {
 public void onTimeSet(
 TimePicker view, int hourOfDay,
int minuteOfHour)
 {
 hour = hourOfDay;
minute = minuteOfHour;
SimpleDateFormat timeFormat = new
SimpleDateFormat("hh:mm aa");
 Date date = new Date();
 String strDate =
timeFormat.format(date);
 Toast.makeText(getBaseContext(),
 "You have selected " +
strDate,
 Toast.LENGTH_SHORT).show();
 }
 };
 public void onClick(View view) {
 Toast.makeText(getBaseContext(),
 "Date selected:" + (datePicker.getMonth()
+ 1) +
 "/" + datePicker.getDayOfMonth() +
 "/" + datePicker.getYear() + "\n"
+
 "Time selected:" +
timePicker.getHour() +
 ":" + timePicker.getMinute(),
 Toast.LENGTH_SHORT).show();
 }
 }
