package jay.kotlin.projects.happyplaces

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(application, "efb997d0-c5dd-4768-94f8-b9fa07e82125",
                Analytics::class.java, Crashes::class.java)
    }

    fun moveToAddHappyPlace(view: View) {
        val intent = Intent(this, AddHappyPlaceActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}