package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.views

import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter.BulbListAdpter
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_more_option.*

class MoreOption : Fragment() {
    private lateinit var viewModel : RealTimeDbViewModel
    private lateinit var adpter: BulbListAdpter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getObserFromFireBase()
    }


    private fun getObserFromFireBase() {
        viewModel = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        viewModel.realTimeDBFireBase.observe(this , Observer<List<BulbsModel>> {
            bulbs ->
            showTimeis(bulbs)
        })
    }

    private fun showTimeis(bulbs: List<BulbsModel>?) {


    }


}
