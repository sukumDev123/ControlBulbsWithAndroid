package android.bulbs.sukumandroid.controlbulbswithandroid

<<<<<<< HEAD
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase
=======
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Views.CreateNewBulb
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.adpter.BulbListAdpter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView

>>>>>>> Update loading. I'll be creating detaill bulb , remove , update -> name , update -> pinMode.
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD

=======
        showLoading()
        adpter = BulbListAdpter()
        bulbRecyclerView?.layoutManager = LinearLayoutManager(this)
        bulbRecyclerView?.adapter = adpter
        getObserFromFireBase()
        adpter?.setListener(updateStatusBulb)
        adpter?.setListener(showDetailBulb)

    }
    private val showDetailBulb = object : BulbListAdpter.Listener {
        override fun onBulbClick(bulb: BulbsModel) {
//            val
        }

    }
    private val updateStatusBulb =
        object : BulbListAdpter.Listener {
            override fun onBulbClick(bulb: BulbsModel) {
                val statusChage = if(bulb.statusBulb == 0) 1 else 0
                 viewModel?.updateStatusBulb(statusChage , bulb.key)
            }

        }


    override fun onStart() {
        super.onStart()
        navBottom()
    }
    fun navBottom() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.item_recent -> {
                    val intent = Intent(this , MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_recent2 -> {
                    val intent2 = Intent(this , CreateNewBulb::class.java)
                    startActivity(intent2)
                    true
                }

                else -> false
            }


        }

    }
    private fun getObserFromFireBase() {
        viewModel = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        viewModel.realTimeDBFireBase.observe(this , Observer<List<BulbsModel>> {
            bulbs ->
            updateBulb(bulbs)
            showContent()
        })
    }
    private fun updateBulb(bulbs : List<BulbsModel>?) {
        bulbs?.let {
            adpter.setBulbList(bulbs)
            adpter.notifyDataSetChanged()
        }
>>>>>>> Update loading. I'll be creating detaill bulb , remove , update -> name , update -> pinMode.

    }
    private fun showLoading() {
        bulbRecyclerView?.visibility = View.GONE
        progressBar?.visibility = View.VISIBLE
    }

    private fun showContent() {
        bulbRecyclerView?.visibility = View.VISIBLE
        progressBar?.visibility = View.GONE
    }


}
