package com.burcaliahmadov.saveddatakotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.burcaliahmadov.saveddatakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var editNumber: Int?=null
    lateinit var shardPreferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        var view: View =binding.root
        setContentView(view)
        shardPreferences=this.getSharedPreferences("com.burcaliahmadov.saveddatakotlin",
            MODE_PRIVATE)
        var age:Int= shardPreferences.getInt("age",-1)
        if(age ==-1){
            binding.textView.text=""
        }else{
            binding.textView.text="Your age: $age"
        }
    }
    fun save(view: View){
        editNumber=binding.editText.text.toString().toIntOrNull()
        if (editNumber!=null){
            binding.textView.text="Your age: $editNumber"
            shardPreferences.edit().putInt("age",editNumber!!).apply()
        }




    }
    fun delete(view: View){
        var age:Int= shardPreferences.getInt("age",-1)
        if(age!=-1){
            shardPreferences.edit().remove("age").apply()
        }
        binding.textView.text=""
    }
}