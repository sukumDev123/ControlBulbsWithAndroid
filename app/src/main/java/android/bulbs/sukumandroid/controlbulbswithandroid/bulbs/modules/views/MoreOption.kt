package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.views

import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.bulbs.sukumandroid.controlbulbswithandroid.SetTime
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter.BulbListAdpter
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter.BulbListAdpter2
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_bulb.*
import kotlinx.android.synthetic.main.fragment_more_option.*
import java.util.*

class MoreOption : Fragment() {
    private lateinit var viewModel: RealTimeDbViewModel
    private lateinit var adpter2: BulbListAdpter2
    private var bulbListData: List<BulbsModel>? = listOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        adpter2 = BulbListAdpter2()
        recyclerViewDetailPage?.layoutManager = LinearLayoutManager(context)
        recyclerViewDetailPage?.adapter = adpter2
        getObserFromFireBase()
        activity?.let {
            it.title = "Set Countdown time."
        }
        val kk = BulbsModel("NameBulb", 0, "D0", "", 0, false, false, 0, 0)
        bulbListData = listOf(kk)

    }

    override fun onStart() {
        super.onStart()
        updateBulbTime()
        adpter2.setListener(clickForShowDetail)
    }

    private val clickForShowDetail = object : BulbListAdpter2.Listener {
        override fun onClick(bulbsModel: BulbsModel) {
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout_bulb, SetTime.newInstance(bulbsModel))?.addToBackStack(null)?.commit()
        }

    }

    private fun updateBulbTime() {
        val mHandler = Handler()
        val mTimer = Timer()

        mTimer.schedule(object : TimerTask() {
            override fun run() {
                bulbListData?.let {
                    mHandler.post {
                        showTimeis(it)
                    }
                }
            }
        }, 0, 1000)
    }


    private fun getObserFromFireBase() {

        viewModel = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        viewModel.realTimeDBFireBase.observe(this, Observer<List<BulbsModel>> { bulbs ->
            bulbListData = bulbs
            showTimeis(bulbs)
            showContent()
        })


    }

    private fun showTimeis(bulbs: List<BulbsModel>?) {
        bulbs?.let {
            adpter2.setBulbModel(bulbs)
            adpter2.notifyDataSetChanged()

        }

    }

    private fun showLoading() {
        recyclerViewDetailPage?.visibility = View.GONE
        progressBar2?.visibility = View.VISIBLE
    }

    private fun showContent() {
        recyclerViewDetailPage?.visibility = View.VISIBLE
        progressBar2?.visibility = View.GONE
    }


}
