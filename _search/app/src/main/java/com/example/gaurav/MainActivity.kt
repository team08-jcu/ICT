package com.example.gaurav

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSearchField: EditText
    private lateinit var mSearchBtn: ImageButton
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var mFirebaseAdapter : FirebaseRecyclerAdapter<Courses, UserViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDatabaseReference = FirebaseDatabase.getInstance().reference.child("courses")
        mSearchField = this.findViewById(R.id.search_field)
        mSearchBtn = this.findViewById(R.id.search_btn)

        mRecyclerView = findViewById<RecyclerView>(R.id.result_view)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.setHasFixedSize(true)

        mSearchBtn.setOnClickListener {
            println("Hello2")
            val searchtxt : String = mSearchField.text.toString()

            firebaseCourseSearch(searchtxt.replace(" ","_").toLowerCase())

        }
}

    private fun firebaseCourseSearch(searchtxt: String) {

        val firebaseSearchQuery : Query = mDatabaseReference.orderByChild("name").startAt(searchtxt).endAt(  searchtxt + "\uf8ff")

        val options = FirebaseRecyclerOptions.Builder<Courses>()
            .setQuery( firebaseSearchQuery, Courses::class.java)
            .build()

        mFirebaseAdapter = object : FirebaseRecyclerAdapter<Courses, UserViewHolder>(options) {

            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UserViewHolder {
                val itemView: View = LayoutInflater.from(this@MainActivity).inflate(R.layout.list_layout, p0, false)
                return UserViewHolder(itemView)
                println("On create view holder")
            }

            override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: Courses) {
                val refid : String = getRef(position).key.toString()
                println("On bind view holder")
                mDatabaseReference.child(refid).addValueEventListener(object : ValueEventListener{
                    override fun onCancelled(p0: DatabaseError) {

                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        println("On Data change view holder")
                        val str = model.name.replace("_"," ")
                        holder.mName.text = "Bachelor of " + str.capitalize()
                        holder.mUni.text = model.university
                    }
                })
            }
        }
        mFirebaseAdapter.startListening()
        mRecyclerView.adapter = mFirebaseAdapter
}

    //View Holder
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



            val mName: TextView = itemView!!.findViewById<TextView>(R.id.course_name)
            val mUni: TextView = itemView!!.findViewById<TextView>(R.id.university)




    }

}


