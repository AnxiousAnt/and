program 2.
Develop an android application to investigate the activity life cycle.
Step 1 start the android studio
Step 2 create a new project by name activity_test
Step3 choose empty activity
Their it opens .xml file and .java file
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 tools:context="com.example.myapplication.MainActivity">
 <EditText
 android:id="@+id/editText"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginStart="16dp"
 android:autofillHints=""
 android:ems="10"
 android:hint="@string/enter_name"
 android:inputType="textPersonName"

app:layout_constraintBaseline_toBaselineOf="@+id/button"
 app:layout_constraintLeft_toLeftOf="parent"
 tools:layout_constraintBaseline_creator="1"
 tools:layout_constraintLeft_creator="1" />
 <Button
 android:id="@+id/button"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginStart="8dp"
 android:layout_marginLeft="8dp"
 android:layout_marginTop="16dp"
 android:onClick="onSubmit"
 android:text="@string/submit"
 app:layout_constraintLeft_toRightOf="@+id/editText"
 app:layout_constraintTop_toTopOf="parent"
 tools:ignore="OnClick,RtlHardcoded"
 tools:layout_constraintTop_creator="1" />
</androidx.constraintlayout.widget.ConstraintLayout>
mainactivity.java file
package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
 String tag = "Life Cycle";
 EditText txt;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 Log.d(tag, "In onCreate() function");
 }
 public void display(View view)
 {
 String name;
 txt = (EditText)findViewById(R.id.editText);
 name = txt.getText().toString();
 String str="Good Afternoon : " + name;
 Toast.makeText(getApplicationContext(), str,
Toast.LENGTH_LONG).show();
 }
 public void onStart()
 {
 super.onStart();
 Log.d(tag, "In onStart() function");
 }
 public void onResume()
 {
 super.onResume();
 Log.d(tag, "In onResume() function");
 }
 public void onPause(){
 super.onPause();
 Log.d(tag, "In onPause() function");
 }
 public void onRestart()
 {
 super.onRestart();
 Log.d(tag, "In onRestart() function");
 }
 public void onDestroy() {
 super.onDestroy();
 Log.d(tag, "In onDestroy() function");
 }
 public void onSubmit(View view) {
 }
}
