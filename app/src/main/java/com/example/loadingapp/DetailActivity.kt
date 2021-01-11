package com.example.loadingapp
import android.app.NotificationManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.loadingapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManager
    private lateinit var activityDetailBinding: ActivityDetailBinding

    companion object {
        const val EXTRA_DETAIL_STATUS = "status"
        const val EXTRA_DETAIL_FILENAME = "fileName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        setSupportActionBar(activityDetailBinding.toolbar)


        // initialize the notification manager
        notificationManager = ContextCompat.getSystemService(
            applicationContext,
            NotificationManager::class.java
        ) as NotificationManager

        notificationManager.cancelAll()

        activityDetailBinding.contentDetail.fileName.text = intent.getStringExtra(EXTRA_DETAIL_FILENAME)
        activityDetailBinding.contentDetail.status.text = intent.getStringExtra(EXTRA_DETAIL_STATUS)


        activityDetailBinding.contentDetail.okButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }



}
