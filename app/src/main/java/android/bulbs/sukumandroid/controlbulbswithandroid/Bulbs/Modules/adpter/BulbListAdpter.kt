package android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.adpter

import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.R
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BulbListAdpter : RecyclerView.Adapter<BulbHolder>() {
    private var bulbsList: List<BulbsModel>? = null
    private var listener: Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BulbHolder  = BulbHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_bulbs_list , parent, false))


    override fun getItemCount(): Int = bulbsList?.size ?: 0

    override fun onBindViewHolder(holder: BulbHolder, position: Int) {
        val bulb = bulbsList?.get(position)
        bulb?.let {
            holder.setNameBulb(bulb.nameBulb)
            holder.setStatusBulb(bulb.statusBulb)
            holder.setSwitch(bulb.statusBulb)
            holder.setOnSwitchListener(View.OnClickListener {
                listener?.onSwichClick(bulb)
            })
        }

    }
    fun setBulbList(bulbs : List<BulbsModel>) {
        this.bulbsList = bulbs

    }
    fun setListener(listener : Listener) {
        this.listener = listener
    }
    interface Listener {
        fun onSwichClick(bulb : BulbsModel)
    }

}