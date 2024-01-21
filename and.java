Android lab manual
Program 1. Introducing different Android development tools and developing Hello World
application.
Solution
Step 1 open the android studio.
Step 2 create a new project by name my application.
Step 3 choose empty activity
There it opens .XML file and .java file
Xml file:
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
 app:layout_constraintStart_toStartOf="parent"
 app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
.java file
package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 }
}
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
program 3.
Develop an android application to investigate the fragments.
1. Using Android Studio, create a new Android project and name it Fragments.
2. Choose basic activity
3. It opens main activity.java, .XML, firstfragment.java, second fragment.java.
Solution:
Main activity.java
package com.example.myapplication;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import
com.example.myapplication.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {
 private AppBarConfiguration appBarConfiguration;
 private ActivityMainBinding binding;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 binding =
ActivityMainBinding.inflate(getLayoutInflater());
 setContentView(binding.getRoot());
 setSupportActionBar(binding.toolbar);
 NavController navController =
Navigation.findNavController(this,
R.id.nav_host_fragment_content_main);
 appBarConfiguration = new
AppBarConfiguration.Builder(navController.getGraph()).build();
 NavigationUI.setupActionBarWithNavController(this,
navController, appBarConfiguration);
 binding.fab.setOnClickListener(new
View.OnClickListener() {
 @Override
 public void onClick(View view) {
 Snackbar.make(view, "Replace with your own
action", Snackbar.LENGTH_LONG)
 .setAction("Action", null).show();
 }
 });
 }
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 // Inflate the menu; this adds items to the action bar
if it is present.
 getMenuInflater().inflate(R.menu.menu_main, menu);
 return true;
 }
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
 // Handle action bar item clicks here. The action bar
will
 // automatically handle clicks on the Home/Up button,
so long
 // as you specify a parent activity in
AndroidManifest.xml.
 int id = item.getItemId();
 //noinspection SimplifiableIfStatement
 if (id == R.id.action_settings) {
 return true;
 }
 return super.onOptionsItemSelected(item);
 }
 @Override
 public boolean onSupportNavigateUp() {
 NavController navController =
Navigation.findNavController(this,
R.id.nav_host_fragment_content_main);
 return NavigationUI.navigateUp(navController,
appBarConfiguration)
 || super.onSupportNavigateUp();
 }
}
activity main.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout
xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 tools:context=".MainActivity">
 <com.google.android.material.appbar.AppBarLayout
 android:layout_width="match_parent"
 android:layout_height="wrap_content"

android:theme="@style/Theme.MyApplication.AppBarOverlay">
 <androidx.appcompat.widget.Toolbar
 android:id="@+id/toolbar"
 android:layout_width="match_parent"
 android:layout_height="?attr/actionBarSize"
 android:background="?attr/colorPrimary"

app:popupTheme="@style/Theme.MyApplication.PopupOverlay" />
 </com.google.android.material.appbar.AppBarLayout>
 <include layout="@layout/content_main" />

<com.google.android.material.floatingactionbutton.FloatingActi
onButton
 android:id="@+id/fab"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_gravity="bottom|end"
 android:layout_marginEnd="@dimen/fab_margin"
 android:layout_marginBottom="16dp"
 app:srcCompat="@android:drawable/ic_dialog_email" />
</androidx.coordinatorlayout.widget.CoordinatorLayout>
First fragment.java
package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import
com.example.myapplication.databinding.FragmentFirstBinding;
public class FirstFragment extends Fragment {
 private FragmentFirstBinding binding;
 @Override
 public View onCreateView(
 LayoutInflater inflater, ViewGroup container,
 Bundle savedInstanceState
 ) {
 binding = FragmentFirstBinding.inflate(inflater,
container, false);
 return binding.getRoot();
 }
 public void onViewCreated(@NonNull View view, Bundle
savedInstanceState) {
 super.onViewCreated(view, savedInstanceState);
 binding.buttonFirst.setOnClickListener(new
View.OnClickListener() {
 @Override
 public void onClick(View view) {

NavHostFragment.findNavController(FirstFragment.this)

.navigate(R.id.action_FirstFragment_to_SecondFragment);
 }
 });
 }
 @Override
 public void onDestroyView() {
 super.onDestroyView();
 binding = null;
 }
}
second fragment.java
package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import
com.example.myapplication.databinding.FragmentSecondB
inding;
public class SecondFragment extends Fragment {
 private FragmentSecondBinding binding;
 @Override
 public View onCreateView(
 LayoutInflater inflater, ViewGroup
container,
 Bundle savedInstanceState
 ) {
 binding =
FragmentSecondBinding.inflate(inflater, container,
false);
 return binding.getRoot();
 }
 public void onViewCreated(@NonNull View view,
Bundle savedInstanceState) {
 super.onViewCreated(view,
savedInstanceState);
 binding.buttonSecond.setOnClickListener(new
View.OnClickListener() {
 @Override
 public void onClick(View view) {

NavHostFragment.findNavController(SecondFragment.this
)

.navigate(R.id.action_SecondFragment_to_FirstFragment
);
 }
 });
 }
 @Override
 public void onDestroyView() {
 super.onDestroyView();
 binding = null;
 }
}
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
output:
8. Develop an android application to utilize Action bar.
Step 1 create an android project with basic activity
Step 2 mainactivity.java
package com.example.myactionbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import
com.google.android.material.floatingactionbutton.FloatingActio
nButton;
import com.google.android.material.snackbar.Snackbar;
public class MainActivity extends AppCompatActivity {
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 Toolbar toolbar = (Toolbar)
findViewById(R.id.toolbar);
 setSupportActionBar(toolbar);
 FloatingActionButton fab = (FloatingActionButton)
findViewById(R.id.fab);
 fab.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 Snackbar.make(view,
 "Replace with your own
action", Snackbar.LENGTH_LONG)
 .setAction("Action", null).show();
 }
 });
 }
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it
is present.
//getMenuInflater().inflate(R.menu.menu_main, menu);
 CreateMenu(menu);
 return true;
 }
 private void CreateMenu(Menu menu)
 {
 MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
 {
 mnu1.setIcon(R.mipmap.ic_launcher);

mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
 }
 MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
 {
 mnu2.setIcon(R.mipmap.ic_launcher);

mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
 }
 MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
 {
 mnu3.setIcon(R.mipmap.ic_launcher);

mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
 }
 MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
 {

mnu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
 }
 MenuItem mnu5 = menu.add(0, 4, 4,"Item 5");
 {

mnu5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
 }
 }
 private boolean MenuChoice(MenuItem item)
 {
 switch (item.getItemId()) {
 case 0:
 Toast.makeText(this, "You clicked on Item 1",
 Toast.LENGTH_LONG).show();
 return true;
 case 1:
 Toast.makeText(this, "You clicked on Item 2",
 Toast.LENGTH_LONG).show();
 return true;
 case 2:
 Toast.makeText(this, "You clicked on Item 3",
 Toast.LENGTH_LONG).show();
 return true;
 case 3:
 Toast.makeText(this, "You clicked on Item 4",
 Toast.LENGTH_LONG).show();
 return true;
 case 4:
 Toast.makeText(this, "You clicked on Item 5",
 Toast.LENGTH_LONG).show();
 return true;
 }
 return false;
 }
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
 int id = item.getItemId();
//noinspection SimplifiableIfStatement
 if (id == R.id.action_settings) {
 return true;
 }
 return MenuChoice(item);
 }
}
output: