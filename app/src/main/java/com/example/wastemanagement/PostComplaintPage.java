package com.example.wastemanagement;

import static com.example.wastemanagement.R.id.send_complaint_button;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostComplaintPage extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();


    EditText comp_description;
    EditText area;
    EditText landmark;
    Button sendbtn;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_complaint_page);

        comp_description = findViewById(R.id.writeincompliantbox);
        area = findViewById(R.id.complaintinarea);
        landmark= findViewById(R.id.complaintarealandmark);
        sendbtn = findViewById(R.id.send_complaint_button);

        sendbtn.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View v) {

                String complaint_des = comp_description.getText().toString();
                String complaint_area = area.getText().toString();
                String complaint_land = landmark.getText().toString();

                if (complaint_des.isEmpty() && complaint_area.isEmpty())
                {
                    Toast.makeText(PostComplaintPage.this, "Please enter the Complaint Description and Area", Toast.LENGTH_SHORT).show();
                }
                else if (complaint_des.isEmpty())
                {
                    Toast.makeText(PostComplaintPage.this, "Please enter the Complaint Description", Toast.LENGTH_SHORT).show();

                }
                else if (complaint_area.isEmpty())
                {
                    Toast.makeText(PostComplaintPage.this, "Please enter a Area", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    complaint_by_userFirebase(complaint_des,complaint_area,complaint_land);
                    Toast.makeText(PostComplaintPage.this, "Your complaint registered successfully", Toast.LENGTH_SHORT).show();


                }
            }
        });


    }
    private void complaint_by_userFirebase(String complaint_des,String complaint_area,String complaint_land)
    {
        UserComplaint usercomplaint= new UserComplaint(complaint_des,complaint_area,complaint_land);
        reference.child("UserComplaint").push().setValue(usercomplaint);
    }
}