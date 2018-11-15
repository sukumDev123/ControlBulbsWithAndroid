package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter

import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.R
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_bulbs_list.view.*

class BulbListAdpter : RecyclerView.Adapter<BulbHolder>() {
    private var bulbsList: List<BulbsModel>? = null
    private var listener: Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BulbHolder  = BulbHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_bulbs_list , parent, false))


    override fun getItemCount(): Int = bulbsList?.size ?: 0

    override fun onBindViewHolder(holder: BulbHolder, position: Int) {
        val bulb = bulbsList?.get(position)
        bulb?.let {bulb ->
            holder.setNameBulb(bulb.nameBulb)
            holder.openOrNot(bulb.statusBulb)
            holder.setOnSwitchListener(View.OnClickListener { view ->
                listener?.onBulbClick(bulb , view)
            })

        }

    }

//    override fun onItemSelected() {
//
//    }
    fun setBulbList(bulbs : List<BulbsModel>) {
        this.bulbsList = bulbs

    }

    fun setListener(listener : Listener) {
        this.listener = listener
    }
    interface Listener {
        fun onBulbClick(bulb : BulbsModel , view : View)
    }

}