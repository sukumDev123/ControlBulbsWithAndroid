package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter

import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BulbListAdpter2 : RecyclerView.Adapter<BulbListHolder>() {
    private var bulbsList: List<BulbsModel>? = null
    private var listener: Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BulbListHolder = BulbListHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_bulb_detail, parent, false))
    override fun getItemCount(): Int = bulbsList?.size ?: 0

    override fun onBindViewHolder(holder: BulbListHolder, position: Int) {
        val bulb = bulbsList?.get(position)
        bulb?.let {
            holder.setNameBulb(bulb.nameBulb)
            holder.openOrNot(bulb.statusBulb)
            holder.setStatus(bulb.statusBulb)
            holder.setTimeCreate(bulb.createAt)
            holder.onCickCard(View.OnClickListener {
                listener?.onClick(bulb)
            })

        }
    }

    fun setBulbModel(bulbsModel: List<BulbsModel>) {
        this.bulbsList = bulbsModel
    }

    fun setListener(listener: Listener) {
        this.listener = listener

    }

    interface Listener {
        fun onClick(bulbsModel: BulbsModel)
    }
}