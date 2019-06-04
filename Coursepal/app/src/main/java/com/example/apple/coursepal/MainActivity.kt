package com.example.apple.coursepal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    lateinit var editTextName: EditText
    lateinit var ratingBar: RatingBar
    lateinit var buttonSave:Button
    lateinit var ref :DatabaseReference
    lateinit var heroList: MutableList<Hero>
lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroList = mutableListOf()
         ref = FirebaseDatabase.getInstance().getReference("heroes")

        editTextName = findViewById(R.id.editTextName) as EditText
        ratingBar = findViewById(R.id.ratingBar) as RatingBar
        buttonSave = findViewById(R.id.buttonSave) as Button
        listView = findViewById(R.id.listView)as ListView

        buttonSave.setOnClickListener {
            saveHero()
        }

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if(p0!!.exists()){
                    for(h in p0.children){
                        val hero = h.getValue(Hero::class.java)
                        heroList.add(hero!!)
                    }
                    val adapter = HeroAdapter(applicationContext,R.layout.heroes,heroList)
                    listView.adapter =adapter

                }
            }

        })
    }

    private fun saveHero(){
        val name =editTextName.text.toString().trim();
        if(name.isEmpty()){
            editTextName.error = "Please enter name"
            return
        }



        val heroId = ref.push().key
        val hero = Hero(heroId, name , ratingBar.numStars)

        ref.child(heroId).setValue(hero).addOnCompleteListener(OnCompleteListener<Void>(){
            //Toast.makeText(this.MainActivity, "Button 1",
            //      Toast.LENGTH_LONG).show();
            //Log.d(TAG,"Log -1")
            //Toast.makeText("1","2").show()
            Toast.makeText(applicationContext, "Hero Saved Successfully", Toast.LENGTH_LONG).show()
            //    Toast.makeText(MainActivity, "Authentication failed.", Toast.LENGTH_SHORT).show()
        }    )

    }
}
