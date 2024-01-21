Content provider
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 tools:context="com.example.contentprovider.MainActivity">
 <TextView
 android:text="@string/textview"
 android:layout_width="0dp"
 android:layout_height="60dp"
 android:id="@+id/contactName"
 app:layout_constraintLeft_toLeftOf="@+id/activity_main"
 android:layout_marginStart="63dp"
 tools:layout_constraintLeft_creator="1"
 app:layout_constraintRight_toRightOf="@+id/activity_main"
 android:layout_marginEnd="63dp"
 tools:layout_constraintRight_creator="1"
 app:layout_constraintBottom_toTopOf="@+id/contactID"
 android:layout_marginBottom="40dp"
 tools:layout_constraintBottom_creator="1" />
 <TextView
 android:id="@+id/contactID"
 android:layout_width="406dp"
 android:layout_height="203dp"
 android:layout_marginBottom="56dp"
 android:text="@string/TextViews"
 app:layout_constraintBottom_toBottomOf="@+id/activity_main"
 app:layout_constraintLeft_toLeftOf="@+id/activity_main"
 app:layout_constraintRight_toRightOf="@+id/activity_main"
 tools:layout_constraintBottom_creator="1"
 tools:layout_constraintLeft_creator="1"
 tools:layout_constraintRight_creator="1" />
 <ListView
 android:layout_height="0dp"
 android:id="@android:id/list"
 android:layout_width="wrap_content"
 app:layout_constraintLeft_toLeftOf="@+id/activity_main"
 app:layout_constraintTop_toTopOf="@+id/activity_main"
 tools:layout_constraintTop_creator="1"
 app:layout_constraintRight_toRightOf="@+id/activity_main"
 app:layout_constraintBottom_toTopOf="@+id/contactName"
 android:layout_marginBottom="5dp"
 tools:layout_constraintBottom_creator="1"
 tools:ignore="UnknownId" />
</androidx.constraintlayout.widget.ConstraintLayout>
Main activity.java
Content provider
package com.example.contentprovider;
import android.Manifest;
import android.app.ListActivity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;
public class MainActivity extends ListActivity {
 final private int REQUEST_READ_CONTACTS = 123;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 if (ContextCompat.checkSelfPermission(this,
 Manifest.permission.READ_CONTACTS) !=
PackageManager.PERMISSION_GRANTED) {
 ActivityCompat.requestPermissions(this, new
String[]{Manifest.permission.READ_CONTACTS},
 REQUEST_READ_CONTACTS);
 } else {
 ListContacts();
 }
 }
 @Override
 public void onRequestPermissionsResult(int requestCode
 , String[] permissions, int[] grantResults) {
 if (requestCode == REQUEST_READ_CONTACTS) {
 if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
 ListContacts();
 } else {
 Toast.makeText(MainActivity.this
 , "Permission Denied", Toast.LENGTH_SHORT).show();
 }
 } else {
 super.onRequestPermissionsResult(requestCode
 , permissions, grantResults);
 }
 }
 protected void ListContacts(){
 Uri allContacts = Uri.parse("content://contacts/people");
 Cursor c;
 CursorLoader cursorLoader = new CursorLoader(
 this,
 allContacts,
 null,
 null,
 null,
 null);
 c = cursorLoader.loadInBackground();
 String[] columns = new String[]{
Content provider
 ContactsContract.Contacts.DISPLAY_NAME,
 ContactsContract.Contacts._ID};
 int[] views = new int[]{R.id.contactName, R.id.contactID};
 SimpleCursorAdapter adapter;
 adapter = new SimpleCursorAdapter(
 this, R.layout.activity_main, c, columns, views,
 CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
 this.setListAdapter(adapter);
 }
}
edit androidmanifest.xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:tools="http://schemas.android.com/tools">
 <uses-permission android:name="android.permission.READ_CONTACTS"/>
 <application
 android:allowBackup="true"
 android:dataExtractionRules="@xml/data_extraction_rules"
 android:fullBackupContent="@xml/backup_rules"
 android:icon="@mipmap/ic_launcher"
 android:label="@string/app_name"
 android:supportsRtl="true"
 android:theme="@style/Theme.Contentprovider"
 tools:targetApi="31">
 <activity
 android:name=".MainActivity"
 android:exported="true">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />
 <category android:name="android.intent.category.LAUNCHER"
/>
 </intent-filter>
 </activity>
 </application>
</manifest>
Launch an AVD and create a few contacts in the Android Emulator.
To add a contact, go to the
Phone application and click the Contact icon at the top (). You see a
warning about
backing up your contacts. Click the Keep Local button and enter the
name, phone number, and
email address of a few people.