package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var emp: Emp
    var str = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var empid: EditText =findViewById(R.id.empid)
        var empname:EditText = findViewById(R.id.ename)
        var empphone:EditText = findViewById(R.id.phone)
        var submit: Button = findViewById(R.id.submit)
        var show:Button = findViewById(R.id.show)
        var del:Button = findViewById(R.id.delete)
        var update:Button = findViewById(R.id.update)
        var tv: TextView =findViewById(R.id.tv)

        emp=Emp()

        submit.setOnClickListener {
            val id:String=empid.getText().toString()
            val name: String = empname.getText().toString()
            val phone: String = empphone.getText().toString()

            emp.setename(name)
            emp.setPhone(phone)
            FirebaseDatabase.getInstance().getReference().child("Emp").child(id).push().setValue(emp)
            Toast.makeText(this, "data added", Toast.LENGTH_SHORT).show()
        }

        show.setOnClickListener {
            Firebase.database.getReference("Emp").child("101")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        tv.setText("")
                        str=""
                        for ( postSnapshot:DataSnapshot in snapshot.getChildren()) {
                            var e:Emp?=postSnapshot.getValue(Emp::class.java)
                            str+=e?.getename()+" "+e?.getPhone()+"\n"
                        }
                        tv.setText(str)
                        empid.text.clear()
                        empname.text.clear()
                        empphone.text.clear()
                    }
                    override fun onCancelled(error: DatabaseError) {
                        tv.setText(error.toString())
                    }
                })
        }//show close
        del.setOnClickListener {

            var ref = FirebaseDatabase.getInstance().getReference("Emp").child("102");
            ref.removeValue();
            Toast.makeText(this, "data deleted", Toast.LENGTH_SHORT).show()

        }
        update.setOnClickListener {
            var ref=FirebaseDatabase.getInstance().getReference("Emp").child("102")
            var emp=Emp()
            emp.setename("ami")
            emp.setPhone("999999")
            ref.setValue(emp)
            Toast.makeText(this, "Emp Updated", Toast.LENGTH_LONG).show();

        }
    }
}