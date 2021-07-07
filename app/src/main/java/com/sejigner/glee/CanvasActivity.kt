package com.sejigner.glee

import android.graphics.Typeface
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import com.sejigner.glee.Scroll.isPainting
import kotlinx.android.synthetic.main.activity_canvas.*
import kotlinx.android.synthetic.main.activity_canvas.tv_hambaksnow
import kotlinx.android.synthetic.main.activity_canvas.tv_cafe24
import kotlinx.android.synthetic.main.activity_canvas.tv_arita
import kotlinx.android.synthetic.main.activity_canvas.tv_mapo
import kotlinx.android.synthetic.main.fragment_home.*

object Scroll {
    var isPainting:Boolean = true
}

class CanvasActivity : AppCompatActivity() {
    private var paintView: PaintView? = null
    private var width : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas)
        paintView = findViewById<View>(R.id.paintView) as PaintView
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        paintView!!.doOnLayout {
            var width = it.measuredWidth
            var height = it.measuredHeight
            paintView!!.init(width, height)
        }
        tv_is_scrollable.setOnClickListener {
            if(isPainting) {
                paintView!!.setOnTouchListener { view, event -> // 터치 이벤트 제거 (필사 기능 off)
                    true
                }
                isPainting = false
            }
            else {
                paintView!!.setOnTouchListener { view, event -> // 터치 이벤트
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

        Toast.makeText(this,"원하는 글씨체를 선택하고 따라써보세요.", Toast.LENGTH_LONG).show()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.normal -> {
                paintView!!.normal()
                return true
            }
            R.id.emboss -> {
                paintView!!.emboss()
                return true
            }
            R.id.blur -> {
                paintView!!.blur()
                return true
            }
            R.id.clear -> {
                paintView!!.clear()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}