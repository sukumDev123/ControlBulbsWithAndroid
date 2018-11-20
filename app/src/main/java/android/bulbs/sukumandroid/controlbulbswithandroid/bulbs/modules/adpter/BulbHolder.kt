package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter

import android.annotation.SuppressLint
import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.logic.MoreControl
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
    fun setCoutnDownTime(time: Long?, typeTime : String?, openOrClose : Int? ) {
        openOrClose?.let {
            if(it == 0) {
                countDownTime.setTextColor(Color.BLACK)
            }else {
                countDownTime.setTextColor(Color.WHITE)

            }
        }
        time?.let {
            typeTime?.let {
                countDownTime?.text = MoreControl().setCountDownTimeStart(time , typeTime )
            }
        }
    }
    fun openOrNot(status : Int) {
        if(status == 0) {
            cardViewBulb?.imageView?.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp_off)
            cardViewBulb?.textViewTitle?.setTextColor(Color.rgb(98, 0, 238))
            cardViewBulb?.setBackgroundResource(R.drawable.shape_normal_f)

        } else {
            cardViewBulb?.imageView?.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp)
            cardViewBulb?.textViewTitle?.setTextColor(Color.WHITE)
            cardViewBulb?.setBackgroundResource(R.drawable.shape_normal)

        }
    }



}