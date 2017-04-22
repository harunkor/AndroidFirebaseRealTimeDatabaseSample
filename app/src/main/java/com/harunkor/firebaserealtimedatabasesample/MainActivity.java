package com.harunkor.firebaserealtimedatabasesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;  // database referans tanımlama
    private FirebaseDatabase  mFirebaseInstance;  //  firedatabase modelini ulaşmak için tanım

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseInstance=FirebaseDatabase.getInstance(); // modeli çağırma hazır etme
        mFirebaseInstance.setPersistenceEnabled(true); // modele ulaşma izni

       mDatabaseReference = mFirebaseInstance.getReference("str_deger"); // str_deger degerine ulaşıyor
        mDatabaseReference.setValue("yaw hehe"); // değeri değiştiriyor


         mDatabaseReference=mFirebaseInstance.getReference().getRoot();
        mDatabaseReference.child("str_deger").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String degerim=dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, ""+degerim, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






    }
}
