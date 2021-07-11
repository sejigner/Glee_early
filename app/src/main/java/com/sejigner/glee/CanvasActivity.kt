package com.sejigner.glee

import android.graphics.Typeface
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sejigner.glee.Scroll.isPainting
import kotlinx.android.synthetic.main.activity_canvas.*
import kotlinx.android.synthetic.main.fragment_home.*

object Scroll {
    var isPainting: Boolean = true
}

class CanvasActivity : AppCompatActivity() {
    private var mCustomView: CustomView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas)
        mCustomView = findViewById<View>(R.id.customView) as CustomView
        val metrics = DisplayMetrics()
        val seek = findViewById<SeekBar>(R.id.seek_bar_brush_size)
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
                btn_toggle_scroll.setImageResource(R.drawable.btn_scroll)
                mCustomView!!.setOnTouchListener { view, event -> // 터치 이벤트 제거 (필사 기능 off)
                    true
                }
                isPainting = false
            } else {
                btn_toggle_scroll.setImageResource(R.drawable.btn_draw)
                mCustomView!!.setOnTouchListener { view, event -> // 터치 이벤트
                    false
                }
                isPainting = true
            }

        }




        rb_canvas_cafe24SurroundAir.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/cafe24_surround_air.ttf")
        }

        rb_canvas_aritaBuri.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/arita_buri.otf")
        }

        rb_canvas_mapoFlowerIsland.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/mapo_flower_island.ttf")
        }

        rb_canvas_hambaksnow.setOnClickListener {
            tv_work_canvas.typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/hambaksnow.ttf")
        }

        view_btn_undo.setOnClickListener {
            btn_undo.performClick()
            btn_undo.setPressed(true)
            btn_undo.invalidate()
            btn_undo.setPressed(false)
            btn_undo.invalidate()
        }
        btn_undo.setOnClickListener { mCustomView!!.onClickUndo() }

        view_btn_redo.setOnClickListener {
            btn_redo.performClick()
            btn_redo.setPressed(true)
            btn_redo.invalidate()
            btn_redo.setPressed(false)
            btn_redo.invalidate()
        }
        btn_redo.setOnClickListener { mCustomView!!.onClickRedo() }
        
        seek?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            var progressChanged = 0
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressChanged = progress
                tv_progress_seek_bar.setText(getString(R.string.draw_thickness, progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                tv_progress_seek_bar.setText(getString(R.string.draw_thickness, seek.progress))
                progressChanged = seek.progress

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                /*
                Toast.makeText(this@CanvasActivity,
                "획 두께가 " + seek.progress + "포인트에요.",
                Toast.LENGTH_SHORT).show()
                */
                tv_progress_seek_bar.setText(getString(R.string.draw_thickness, seek.progress))
                Log.d("Debug","brush : $progressChanged pt")
                mCustomView!!.setBrushSize(progressChanged.toFloat())
                mCustomView!!.setLastBrushSize(progressChanged.toFloat())


            }
        })

        Toast.makeText(this, "원하는 글씨체를 선택하고 따라써보세요.", Toast.LENGTH_LONG).show()
    }
}