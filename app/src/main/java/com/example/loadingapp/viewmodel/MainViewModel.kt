package com.example.loadingapp.viewmodel

import android.app.Application
import android.app.DownloadManager
import android.app.NotificationManager
import android.net.Uri
import android.os.Environment
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.loadingapp.utils.sendNotification
import com.example.loadingapp.R

//AndroidViewModel is simply a ViewModel that includes an Application reference.
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var downloadID: Long = 0
    var checkedRadioId = MutableLiveData<Int>()

    private val REQUEST_CODE = 0
    private val context = getApplication<Application>().applicationContext

    init {
        checkedRadioId.postValue(R.id.r1)//def value

    }

    fun sendNotification() {
        Log.d("sendNotification()", "sent")
        val notificationManager =
                ContextCompat.getSystemService(
                        context,
                        NotificationManager::class.java
                ) as NotificationManager
        notificationManager.sendNotification(context.getString(R.string.app_name),context)
    }


    fun download() {
        var path = ""

        when (checkedRadioId.value) {
            R.id.r1 -> path = context.getString(R.string.radio_glide_repo)
            R.id.r2 -> path = context.getString(R.string.radio_glide_repo)
            R.id.r3 -> path = context.getString(R.string.radio_retrofit_repo)
        }
        Log.d("download()",path)

       val request =
           DownloadManager.Request(Uri.parse(path))
               .setTitle(context.getString(R.string.app_name))
               .setDescription(context.getString(R.string.app_description))
               .setRequiresCharging(false)
               .setAllowedOverMetered(true)
               .setAllowedOverRoaming(true)
               // Required for api 29 and up
               .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/$context.getString(R.string.app_name)")

       val downloadManager = context.getSystemService(AppCompatActivity.DOWNLOAD_SERVICE) as DownloadManager
       downloadID =
           downloadManager.enqueue(request)// enqueue puts the download request in the queue.

   }
/*
   private val receiver = object : BroadcastReceiver() {
       override fun onReceive(context: Context?, intent: Intent?) {
           val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
       }
   }

   companion object {
       private const val URL =
           "https://github.com/udacity/nd940-c3-advanced-android-programming-project-starter/archive/master.zip"
       private const val CHANNEL_ID = "channelId"
   }
*/

}