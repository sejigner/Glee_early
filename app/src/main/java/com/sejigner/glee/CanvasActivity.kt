package com.sejigner.glee

import android.graphics.Typeface
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import com.sejigner.glee.Scroll.isPainting
import kotlinx.android.synthetic.main.activity_canvas.*
import kotlinx.android.synthetic.main.activity_canvas.tv_arita
import kotlinx.android.synthetic.main.activity_canvas.tv_cafe24
import kotlinx.android.synthetic.main.activity_canvas.tv_hambaksnow
import kotlinx.android.synthetic.main.activity_canvas.tv_mapo
import kotlinx.android.synthetic.main.fragment_home.*

object Scroll {
    var isPainting: Boolean = true
}

class CanvasActivity : AppCompatActivity() {
    private var customView: CustomView? = null
    private var width: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas)
        customView = findViewById<View>(R.id.customView) as CustomView
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        /*
        customView!!.doOnLayout {
            var width = it.measuredWidth
            var height = it.measuredHeight
            customView!!.init(width, height)
        }
        */
        btn_toggle_scroll.setOnClickListener {
            if (isPainting) {
                customView!!.setOnTouchListener { view, event -> // 터치 이벤트 제거 (필사 기능 off)
                    true
                }
                isPainting = false
            } else {
                customView!!.setOnTouchListener { view, event -> // 터치 이벤트
                    false
                }
                isPainting = true
            }

        }


        tv_cafe24.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/cafe24_surround_air.ttf")
        }

        tv_arita.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/arita_buri.otf")
        }

        tv_mapo.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/mapo_flower_island.ttf")
        }

        tv_hambaksnow.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/hambaksnow.ttf")
        }

        btn_undo.setOnClickListener {
            customView!!.onClickUndo()
        }

        btn_redo.setOnClickListener {
            customView!!.onClickRedo()
        }

        Toast.makeText(this, "원하는 글씨체를 선택하고 따라써보세요.", Toast.LENGTH_LONG).show()

    }
}