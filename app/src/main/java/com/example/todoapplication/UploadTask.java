package com.example.todoapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.DateFormat;
import java.util.Calendar;

public class UploadTask extends AppCompatActivity {


//    ImageView recipeImage;
    Uri uri;
    EditText txt_task, txt_description, txt_DeadLine;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);


        txt_task = findViewById(R.id.txt_task);
        txt_description = findViewById(R.id.text_description);
        txt_DeadLine = findViewById(R.id.text_DeadLine);

    }



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK){
//
//            uri = data.getData();
//            recipeImage.setImageURI(uri);
//
//        }
//        else Toast.makeText(this, "You haven't picked image", Toast.LENGTH_SHORT).show();
//    }

    public void uploadImage(){

//        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("RecipeImnage").child(uri.getLastPathSegment());

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Task Uploading....");
        progressDialog.show();


//        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<com.google.firebase.storage.UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(com.google.firebase.storage.UploadTask.TaskSnapshot taskSnapshot) {
//                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
//                while(!uriTask.isComplete());
//                Uri urlImage = uriTask.getResult();
//                imageUrl = urlImage.toString();
                    addTask();

                progressDialog.dismiss();

            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                progressDialog.dismiss();
//            }
//        });
//
//    }



    public void btnUploadRecipe(View view) {

        uploadImage();

    }

    public void addTask(){

        final ProgressDialog progressDialog
                = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();



        FoodData foodData = new FoodData(
                txt_task.getText().toString(),
                txt_description.getText().toString(),
                txt_DeadLine.getText().toString()

        );


        String myCurrentDateTime = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        // Write a message to the database
        FirebaseDatabase.getInstance().getReference("Task").child(myCurrentDateTime).setValue(foodData)

        .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){


                    Toast.makeText(UploadTask.this, "Task Uploaded Successfully", Toast.LENGTH_SHORT).show();

                    progressDialog.dismiss();
                    finish();


                }



            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UploadTask.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                progressDialog.dismiss();
            }
        });

    }

}

