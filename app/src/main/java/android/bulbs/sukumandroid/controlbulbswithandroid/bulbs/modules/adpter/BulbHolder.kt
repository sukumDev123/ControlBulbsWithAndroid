package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter

import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_bulbs_list.*
import kotlinx.android.synthetic.main.activity_bulbs_list.view.*


class BulbHolder( override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
    fun setNameBulb(bulbName : String) {
        textViewTitle?.text = bulbName
    }

    fun setOnSwitchListener(listener: View.OnClickListener) {
        itemOn?.setOnClickListener(listener)
    }

    fun openOrNot(status : Int) {
        if(status == 0) {
            cardViewBulb?.imageView?.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp)
            cardViewBulb?.textViewTitle?.setTextColor(Color.rgb(98, 0, 238))
            cardViewBulb?.setBackgroundResource(R.drawable.shape_normal_f)

        } else {
            cardViewBulb?.imageView?.setImageResource(R.drawable.ic_lightbulb_outline_on)
            cardViewBulb?.textViewTitle?.setTextColor(Color.WHITE)
            cardViewBulb?.setBackgroundResource(R.drawable.shape_normal)

        }
    }



}