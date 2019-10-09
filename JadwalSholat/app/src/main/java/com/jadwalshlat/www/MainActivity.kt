package com.jadwalshlat.www

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.jadwalshlat.www.view.HomeFragment
import com.jadwalshlat.www.jetpackcontroller.UserDatabase
import com.jadwalshlat.www.jetpackcontroller.UserRepository
import com.jadwalshlat.www.jetpackcontroller.Webservice
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userRepository = UserRepository(
            Webservice.create("https://time.siswadi.com/"),
            Room.databaseBuilder(this, UserDatabase::class.java, "jadwal_sholat").build().userDao(),
            Executors.newSingleThreadExecutor())
        changeFragmentOne(HomeFragment(), "HomeFragment")

    }

    fun changeFragmentOne(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout_activity_main_1, fragment, tag)
            .commitAllowingStateLoss()

    }

    fun popUp(messages: String) {
        Toast.makeText(applicationContext, messages, Toast.LENGTH_SHORT).show()

    }

    fun startLoading() {
        frameLayout_activity_main_2.visibility = View.VISIBLE

    }

    fun stopLoading() {
        frameLayout_activity_main_2.visibility = View.GONE

    }
}
