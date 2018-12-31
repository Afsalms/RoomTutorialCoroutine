package com.example.afsal.roomtutorialcoroutine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.afsal.roomtutorialcoroutine.databases.DatabaseHelper
import com.example.afsal.roomtutorialcoroutine.models.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var databaseObj: DatabaseHelper;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseObj = DatabaseHelper.getInstance(applicationContext)
        loadDataFromDb()
        Thread.sleep(1000)


        button.setOnClickListener {
            var task = Task()
            task.name = inputField.text.toString()
            GlobalScope.launch {
                databaseObj.taskDao().addNewTask(task)
            }
            textView.text = inputField.text.toString()+  "\n" + textView.text.toString()
            inputField.text = null

        }

    }
    fun loadDataFromDb(){
            GlobalScope.launch {
                var taskList = async(Dispatchers.IO) {databaseObj.taskDao().getAllTask()}.await()
                textView.text = null
                taskList.forEach {
                    textView.text = textView.text.toString() + "\n" +it.name
                }

            }



    }
}