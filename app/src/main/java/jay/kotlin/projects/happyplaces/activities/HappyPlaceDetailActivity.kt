package jay.kotlin.projects.happyplaces.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import jay.kotlin.projects.happyplaces.R
import jay.kotlin.projects.happyplaces.models.HappyPlaceModel
import kotlinx.android.synthetic.main.activity_happy_place_detail.*

class HappyPlaceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_place_detail)

        AppCenter.start(application, "efb997d0-c5dd-4768-94f8-b9fa07e82125",
            Analytics::class.java, Crashes::class.java)

        var happyPlaceDetailModel : HappyPlaceModel? = null
        if(intent.hasExtra(MainActivity.EXTRA_PLACE_DETAILS)){
            happyPlaceDetailModel = intent.getParcelableExtra(MainActivity.EXTRA_PLACE_DETAILS) as HappyPlaceModel
        }

        if(happyPlaceDetailModel != null){
            setSupportActionBar(toolbar_happy_place_detail)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = happyPlaceDetailModel.title
            toolbar_happy_place_detail.setNavigationOnClickListener {
                onBackPressed()
            }
        }

        if (happyPlaceDetailModel != null) {
            iv_place_image.setImageURI(Uri.parse(happyPlaceDetailModel.image))
            tv_description.text = happyPlaceDetailModel.description
            tv_location.text = happyPlaceDetailModel.location
        }

        btn_view_on_map.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            intent.putExtra(MainActivity.EXTRA_PLACE_DETAILS, happyPlaceDetailModel)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}