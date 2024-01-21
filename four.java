4. Develop an android application to create user interfaces with
different layouts and views.
Using the HelloWorld project, you created in Chapters 1 and 2, create a new layout
resource file for your
application, add a Frame Layout to the new layout resource, and finally place a Text
View within the
Frame Layout.
1. Open the HelloWorld project in Android Studio.
2. Right-click the res/layout folder and add a new layout resource file. Name the file
framelayout_example.xml.
4. Using the design panel, drag the Frame Layout and place it anywhere on the device
screen.
5. Using the design panel, drag a Plain Text View and place it in the Frame Layout.
6. Type some text into the Plain Text View.
XML.java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 tools:context=".MainActivity">
 <TextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:text="Hello World!"
 app:layout_constraintBottom_toBottomOf="parent"
 app:layout_constraintEnd_toEndOf="parent"
 app:layout_constraintHorizontal_bias="0.473"
 app:layout_constraintStart_toStartOf="parent"
 app:layout_constraintTop_toTopOf="parent"
 app:layout_constraintVertical_bias="0.918" />
 <LinearLayout
 android:layout_width="409dp"
 android:layout_height="652dp"
 android:orientation="vertical"
 tools:layout_editor_absoluteX="1dp"
 tools:layout_editor_absoluteY="1dp">
 <EditText
 android:id="@+id/editTextTextPersonName"
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 android:ems="10"
 android:inputType="textPersonName"
 android:text="Name" />
 <EditText
 android:id="@+id/editTextTextPersonName2"
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 android:ems="10"
 android:inputType="textPersonName"
 android:text="Name" />
 <EditText
 android:id="@+id/editTextTextPersonName3"
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 android:ems="10"
 android:inputType="textPersonName"
 android:text="Name" />
 <LinearLayout
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 android:orientation="vertical">
 <LinearLayout
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 android:orientation="horizontal">
 <Button
 android:id="@+id/button4"
android:layout_width="wrap_content"
 android:layout_height="wrap_content"
android:layout_weight="1"
android:text="Button" />
 <Button
 android:id="@+id/button5"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
android:layout_weight="1"
android:text="Button" />
 <Button
 android:id="@+id/button6"
 android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_weight="1"
android:text="Button" />
 </LinearLayout>
 </LinearLayout>
 </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
Main activity.java
package com.example.layouts_views;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 }
}