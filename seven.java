7 Develop an android application on using implicit &amp; explicit Intents.
Step 1 create a new android project with empty activity
Step 2 .xml file
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 tools:context="com.example.intents.MainActivity">
 <Button
 android:id="@+id/button"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:text="@string/display_contacts"
 android:onClick="displayContacts"
 tools:layout_constraintTop_creator="1"
 android:layout_marginStart="27dp"
 android:layout_marginTop="12dp"
 tools:layout_constraintLeft_creator="1"
 app:layout_constraintLeft_toLeftOf="parent"
 app:layout_constraintTop_toTopOf="parent"
 android:layout_marginLeft="27dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
Step 3 main activity.java
package com.example.intents;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 }
 public void displayContacts(View view) {
 Intent i= new Intent(Intent.ACTION_VIEW);
 i.setData(Uri.parse("content://contacts/people"));
 startActivity(i);
 }
}