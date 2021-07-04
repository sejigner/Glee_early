package com.sejigner.glee.fragment

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sejigner.glee.CanvasActivity
import com.sejigner.glee.R
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment() {

    private lateinit var tvCafe24: TextView
    private lateinit var tvAritaBuri: TextView
    private lateinit var tvMapoFlowerIsland: TextView
    private lateinit var tvHambakSnow: TextView
    private lateinit var tvNewTranscription: TextView

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvCafe24 = view.findViewById(R.id.tv_cafe24)
        tvAritaBuri = view.findViewById(R.id.tv_arita)
        tvMapoFlowerIsland = view.findViewById(R.id.tv_mapo)
        tvHambakSnow = view.findViewById(R.id.tv_hambaksnow)
        tvNewTranscription = view.findViewById(R.id.tv_new_transcription)

        tvCafe24.setOnClickListener {
            tv_work_example.typeface = Typeface.createFromAsset(requireActivity().assets, "fonts/cafe24_surround_air.ttf")
        }
        tvAritaBuri.setOnClickListener {
            tv_work_example.typeface = Typeface.createFromAsset(requireActivity().assets, "fonts/arita_buri.otf")
        }
        tvMapoFlowerIsland.setOnClickListener {
            tv_work_example.typeface = Typeface.createFromAsset(requireActivity().assets, "fonts/mapo_flower_island.ttf")
        }

        tvHambakSnow.setOnClickListener {
            tv_work_example.typeface = Typeface.createFromAsset(requireActivity().assets, "fonts/hambaksnow.ttf")
        }

        tvNewTranscription.setOnClickListener {
            val intent = Intent(activity, CanvasActivity::class.java)
            startActivity(intent)
        }
    }

}