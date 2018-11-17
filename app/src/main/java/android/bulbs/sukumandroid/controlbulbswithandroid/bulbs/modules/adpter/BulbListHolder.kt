package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter

import android.view.View
import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.logic.MoreControl
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.views.MainActivity
import android.util.Log


import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_bulb_detail.*
import java.util.*
import java.util.logging.Handler

class BulbListHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun setNameBulb(name: String) {
        nameBulbD.text = name
    }

    fun setStatus(statusB: Int) {
        statusBulbIs.text = if (statusB == 1) "On" else "Off"
    }

    fun setTimeCreate(time: Long) {
        timeCreateAt.text = MoreControl().setTimeStart(time)

    }

    fun openOrNot(status: Int) {
        when (status) {
            1 -> imageView2.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp)
            0 -> imageView2.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp_off)

        }
    }

    fun onCickCard(view: View.OnClickListener) {
        showDetail.setOnClickListener(view)
    }


}