package com.codepolitan.contactapp.views.detailcontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codepolitan.contactapp.R;
import com.codepolitan.contactapp.model.Contact;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailContactActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT = "extra_contact";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        //SupportActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CircleImageView ivContactDetailContact = findViewById(R.id.iv_contact_detail_contact);
        TextView tvNameDetailContact = findViewById(R.id.tv_name_detail_contact);
        TextView tvNumberDetailContact = findViewById(R.id.tv_number_detail_contact);
        Button btnCallDetailContact = findViewById(R.id.btn_call_detail_contact);

        Contact contact = null;

        if (getIntent() != null) {
            contact = getIntent().getParcelableExtra(EXTRA_CONTACT);
        }
        if (contact != null) {
            ivContactDetailContact.setImageResource(contact.getImage());
            tvNameDetailContact.setText(contact.getName());
            tvNumberDetailContact.setText(contact.getNumber());
            String phoneNumber = contact.getNumber();


            //Onclick
            btnCallDetailContact.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}