package com.codepolitan.contactapp.views.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.codepolitan.contactapp.R;
import com.codepolitan.contactapp.adapter.ContactAdapter;
import com.codepolitan.contactapp.model.Contact;
import com.codepolitan.contactapp.views.detailcontact.DetailContactActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int[] contactImages ={
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
    };
    private final String[] contactNames = {
            "Eleanor Pena",
            "Cameron Williamson",
            "Ronald Ricard",
            "Marvin McKinney",
            "Eleanor Pena",
            "Cameron Williamson",
            "Ronald Ricard",
            "Marvin McKinney",
            "Eleanor Pena",
            "Cameron Williamson",
            "Ronald Ricard",
            "Marvin McKinney",
            "Eleanor Pena",
            "Cameron Williamson",
            "Ronald Ricard",
            "Marvin McKinney",
            "Eleanor Pena",
            "Cameron Williamson",
            "Ronald Ricard",
            "Marvin McKinney"
    };
    private final String[] contactNumbers = {
            "0857484748569",
            "0876363637847",
            "0812635263798",
            "0846273633836",
            "0857484748569",
            "0876363637847",
            "0812635263798",
            "0846273633836",
            "0857484748569",
            "0876363637847",
            "0812635263798",
            "0846273633836",
            "0857484748569",
            "0876363637847",
            "0812635263798",
            "0846273633836",
            "0857484748569",
            "0876363637847",
            "0812635263798",
            "0846273633836"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List Contacts
        ArrayList<Contact> contacts = new ArrayList<>();
        //init Contact Adapter
        ContactAdapter contactAdapter = new ContactAdapter();

        RecyclerView rvContacts = findViewById(R.id.rv_contacts);

        for (int i  = 0; i < contactNames.length; i++){
            Contact contact = new Contact(
                    contactImages[i],
                    contactNames[i],
                    contactNumbers[i]
            );
            contacts.add(contact);
        }
        //SetData contact adapter
        contactAdapter.setData(contacts);

        //Vertical Scroll
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvContacts.setLayoutManager(linearLayoutManager);
        rvContacts.setAdapter(contactAdapter);

        //OnClick
        contactAdapter.onClick(contact -> {
            Intent intent = new Intent(MainActivity.this, DetailContactActivity.class);
            intent.putExtra(DetailContactActivity.EXTRA_CONTACT, contact);
        });
    }
}