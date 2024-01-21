<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 tools:context="com.example.toastmessage.MainActivity">
 <EditText
 android:id="@+id/editText"
 android:layout_width="0dp"
 android:layout_height="wrap_content"
 android:layout_marginEnd="17dp"
 android:layout_marginLeft="17dp"
 android:layout_marginRight="17dp"
 android:layout_marginStart="17dp"
 android:layout_marginTop="16dp"
 android:ems="10"
 android:hint="@string/enter_username"
 android:inputType="textPersonName"
 app:layout_constraintLeft_toLeftOf="parent"
 app:layout_constraintRight_toRightOf="parent"
 app:layout_constraintTop_toTopOf="parent"
 tools:layout_constraintLeft_creator="1"
 tools:layout_constraintRight_creator="1"
 tools:layout_constraintTop_creator="1"
 android:autofillHints="" />
 <EditText
 android:id="@+id/editText2"
 android:layout_width="0dp"
 android:layout_height="wrap_content"
 android:layout_marginEnd="16dp"
 android:layout_marginLeft="16dp"
 android:layout_marginRight="16dp"
 android:layout_marginStart="16dp"
 android:layout_marginTop="8dp"
 android:ems="10"
 android:hint="@string/enter_password"
 android:inputType="textPersonName"
 app:layout_constraintLeft_toLeftOf="parent"
 app:layout_constraintRight_toRightOf="parent"
 app:layout_constraintTop_toBottomOf="@+id/editText"
 tools:layout_constraintLeft_creator="1"
 tools:layout_constraintRight_creator="1"
 app:layout_constraintHorizontal_bias="0.0"
 android:autofillHints="" />
 <Button
 android:id="@+id/button"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginTop="7dp"
 android:onClick="onSubmit"
 android:text="@string/button"
 app:layout_constraintLeft_toLeftOf="@+id/editText2"
 app:layout_constraintRight_toRightOf="@+id/editText2"
 app:layout_constraintTop_toBottomOf="@+id/editText2"
 tools:layout_constraintLeft_creator="1"
 tools:layout_constraintRight_creator="1" />
</androidx.constraintlayout.widget.ConstraintLayout>
Main activity.java
package com.example.toastmessage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
 EditText txt1,txt2;
 String name,password;
 int counter=0;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 }
 public void onSubmit(View view){
 txt1=(EditText)findViewById(R.id.editText);
 name=txt1.getText().toString();
 txt2=(EditText)findViewById(R.id.editText2);
 password=txt2.getText().toString();
 if (name.equals("Bharath") && password.equals("admin")) {
 Toast.makeText(this, "Login Successfull",
Toast.LENGTH_SHORT).show();
 }
 else if (name.equals("")||password.equals("")){
 Toast.makeText(this, "Enter credentials",
Toast.LENGTH_SHORT).show();
 counter++;
 }
 else{
 Toast.makeText(this, "Invalid credentials",
Toast.LENGTH_SHORT).show();
 counter++;
 }
 if(counter>=3){
 Toast.makeText(this, "Helde tane Sayi Nan Magnen iga",
 Toast.LENGTH_SHORT).show();
 finish();
 }
 else{
 Toast.makeText(this, "After "+(3-counter)+" more wrong attempts
app will close", Toast.LENGTH_SHORT).show();
 }
 }
}