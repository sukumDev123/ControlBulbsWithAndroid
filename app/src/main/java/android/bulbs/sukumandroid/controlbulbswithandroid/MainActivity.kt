package android.bulbs.sukumandroid.controlbulbswithandroid

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Views.CreateNewBulb
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.adpter.BulbListAdpter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : RealTimeDbViewModel
    private lateinit var adpter: BulbListAdpter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adpter = BulbListAdpter()
        bulbRecyclerView?.layoutManager = LinearLayoutManager(this)
        bulbRecyclerView?.adapter = adpter
        getObserFromFireBase()
        adpter?.setListener(object : BulbListAdpter.Listener {
            override fun onSwichClick(bulb: BulbsModel) {
                val statusChage = if(bulb.statusBulb == 0) 1 else 0
                viewModel?.updateStatusBulb(statusChage , bulb.key)
            }

        })

    }

    override fun onStart() {
        super.onStart()
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
        })
    }
    private fun updateBulb(bulbs : List<BulbsModel>?) {
        bulbs?.let {
            adpter.setBulbList(bulbs)
            adpter.notifyDataSetChanged()
        }

    }


}
