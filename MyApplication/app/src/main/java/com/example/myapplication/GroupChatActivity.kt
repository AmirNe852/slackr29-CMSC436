package com.example.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class GroupChatActivity : AppCompatActivity() {
    private var db: FirebaseDatabase? = FirebaseDatabase.getInstance()
    private var notebookRef: DatabaseReference? = db!!.getReference("Notebooks")
    private var dataUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private var usersDB: DatabaseReference? = db!!.getReference("Users")
    private lateinit var getNames: MutableList<User>
    private lateinit var listViewClasses: ListView
    internal lateinit var getClasses: MutableList<Classes>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.group_chat)
        val singleClass = intent.getSerializableExtra("singleClass") as Classes
        getNames = ArrayList()
        usersDB!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                var myUser: User? = null
                var myClasses: Classes? = null
                for (postSnap in dataSnapshot.children) {
                    try {
                        usersDB!!.child(postSnap.toString()).child("joinedClasses").addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                var myClasses: Classes? = null
                                for (eachClass in dataSnapshot.children)
                                {
                                    myClasses = eachClass.getValue(Classes::class.java)
                                    if(myClasses!!.equals(singleClass))
                                    {
                                        myUser = postSnap.getValue(User::class.java)
                                        getNames.add(myUser!!)
                                    }
                                }
                            }
                            override fun onCancelled(databaseError: DatabaseError) {
                                Log.e("cancel", databaseError.toString())
                            }
                        })

                    } catch (e: java.lang.Exception) {
                        Log.e(ContentValues.TAG, e.toString())
                    }
                }
            }


            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("cancel", databaseError.toString())
            }
        })
        listViewClasses = findViewById(R.id.member_list)
        val classListAdapter = UserList(this@GroupChatActivity, getNames)
        listViewClasses.adapter = classListAdapter


    }
}