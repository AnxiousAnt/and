5. Develop an android application to create a Registration form
using appropriate widgets.
Step 1 create a new android project with empty activity
Step 2 xml file drag and drop
Step 3 main activity.java fill the properties
6. <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 tools:context="com.example.applicationform.MainActivity"
 tools:layout_editor_absoluteY="81dp"
 tools:layout_editor_absoluteX="0dp">
 <TextView
 android:id="@+id/textView"
 android:layout_width="0dp"
 android:layout_height="33dp"
 android:layout_marginEnd="13dp"
 android:layout_marginStart="13dp"
 android:text="Register"
 android:textAlignment="center"
 tools:layout_constraintTop_creator="1"
 tools:layout_constraintRight_creator="1"
 tools:layout_constraintBottom_creator="1"
 app:layout_constraintBottom_toTopOf="@+id/editText"
 app:layout_constraintRight_toRightOf="parent"
 android:layout_marginTop="34dp"
 tools:layout_constraintLeft_creator="1"
 android:layout_marginBottom="27dp"
 app:layout_constraintLeft_toLeftOf="parent"
 app:layout_constraintTop_toTopOf="parent" />
 <EditText
 android:id="@+id/editText"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginStart="42dp"
 android:ems="10"
 android:hint="UserName"
 android:inputType="text|textPersonName"
 tools:layout_constraintBottom_creator="1"
 app:layout_constraintBottom_toTopOf="@+id/editText2"
 tools:layout_constraintLeft_creator="1"
 android:layout_marginBottom="27dp"
 app:layout_constraintLeft_toLeftOf="@+id/textView"
/>
 <EditText
 android:id="@+id/editText2"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:ems="10"
 android:hint="Password"
 android:inputType="textPassword|textWebPassword"
 tools:layout_constraintRight_creator="1"
 tools:layout_constraintBottom_creator="1"
 app:layout_constraintBottom_toTopOf="@+id/editText3"
 app:layout_constraintRight_toRightOf="@+id/editText"
 tools:layout_constraintLeft_creator="1"
 android:layout_marginBottom="27dp"
 app:layout_constraintLeft_toLeftOf="@+id/editText" />
 <EditText
 android:id="@+id/editText3"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:ems="10"
 android:hint="Confirm Password"
 android:inputType="textPassword|textWebPassword"
 tools:layout_constraintRight_creator="1"
 tools:layout_constraintBottom_creator="1"
 app:layout_constraintBottom_toTopOf="@+id/editText4"
 app:layout_constraintRight_toRightOf="@+id/editText2"
 tools:layout_constraintLeft_creator="1"
 android:layout_marginBottom="33dp"
 app:layout_constraintLeft_toLeftOf="@+id/editText2" />
 <EditText
 android:id="@+id/editText4"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:ems="10"
 android:hint="Contact Number"
 android:inputType="phone"
 tools:layout_constraintRight_creator="1"
 tools:layout_constraintBottom_creator="1"
 app:layout_constraintBottom_toTopOf="@+id/editText5"
 app:layout_constraintRight_toRightOf="@+id/editText3"
 tools:layout_constraintLeft_creator="1"
 android:layout_marginBottom="26dp"
 app:layout_constraintLeft_toLeftOf="@+id/editText3" />
 <EditText
 android:id="@+id/editText5"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:ems="10"
 android:hint="email id"
 android:inputType="textEmailAddress|textWebEmailAddress"
 tools:layout_constraintRight_creator="1"
 tools:layout_constraintBottom_creator="1"
 app:layout_constraintBottom_toTopOf="@+id/button"
 app:layout_constraintRight_toRightOf="@+id/editText4"
 tools:layout_constraintLeft_creator="1"
 android:layout_marginBottom="23dp"
 app:layout_constraintLeft_toLeftOf="@+id/editText4" />
 <Button
 android:id="@+id/button"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginEnd="48dp"
 android:onClick="verify_reg"
 android:text="SUBMIT"
 tools:layout_constraintRight_creator="1"
 tools:layout_constraintBottom_creator="1"
 app:layout_constraintBottom_toBottomOf="parent"
 app:layout_constraintRight_toRightOf="@+id/editText5"
 android:layout_marginBottom="18dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
Main activity.java
package com.example.applicationform;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
 EditText uname, pwd, cpwd, phno, email;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 }
 public static boolean isValidEmailAddress(String mail) {
 String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[az]+";
 return mail.matches(emailPattern);
 }
 public void verify_reg(View view) {
 uname = (EditText)findViewById(R.id.editText);
 pwd = (EditText)findViewById(R.id.editText2);
 cpwd = (EditText)findViewById(R.id.editText3);
 phno = (EditText)findViewById(R.id.editText4);
 email = (EditText)findViewById(R.id.editText5);
 if(uname.getText().toString().isEmpty() ||
pwd.getText().toString().isEmpty() ||
 cpwd.getText().toString().isEmpty() ||
phno.getText().toString().isEmpty() ||
 email.getText().toString().isEmpty()) {
 Toast.makeText(this,"Please Enter all the
details...", Toast.LENGTH_LONG).show();
 }
 else if(pwd.getText().toString().length()<=8) {
 Toast.makeText(this,"Password should be more than
8 characters...",Toast.LENGTH_LONG).show();
 }
 else
if(!pwd.getText().toString().equals(cpwd.getText().toString())
) {
 Toast.makeText(this,"Passwords do not
match..!!",Toast.LENGTH_LONG).show();
 }
 else if(phno.getText().toString().length() < 10) {
 Toast.makeText(this,"Invalid Mobile
Number..!!",Toast.LENGTH_LONG).show();
 }
 else if(!isValidEmailAddress(email.getText().toString())) {
 Toast.makeText(this,"Invalid Email
ID",Toast.LENGTH_LONG).show();
 }
 else {
 Intent obj = new Intent(this,secondactivity.class);
 obj.putExtra("Uname",uname.getText().toString());
 obj.putExtra("Pwd", pwd.getText().toString());
 obj.putExtra("Mobile", phno.getText().toString());
 obj.putExtra("Email", email.getText().toString());
 startActivity(obj);
 }
 }
}
