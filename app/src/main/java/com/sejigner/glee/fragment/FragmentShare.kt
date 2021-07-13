package com.sejigner.glee.fragment

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sejigner.glee.*
import kotlinx.android.synthetic.main.fragment_share.*
import kotlinx.android.synthetic.main.list_item_grid_work.view.*

open class FragmentShare : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        return inflater.inflate(R.layout.fragment_share, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWorkExam()
    }

    private fun setWorkExam() {
        GlideApp.with(this).load(R.drawable.work_exam).into(iv_work_exam_1)
        GlideApp.with(this).load(R.drawable.work_exam2).into(iv_work_exam_2)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {

        rv_work.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //This will for default android divider
        rv_work.addItemDecoration(GridItemDecoration(10, 2))

        val workListAdapter = WorkListStaggeredAdapter()
        rv_work.adapter = workListAdapter
        workListAdapter.setWorkList(generateDummyData())
    }

    private fun generateDummyData(): List<WorkModel> {
        val listOfWork = mutableListOf<WorkModel>()

        var workModel = WorkModel("지멘", 128,R.drawable.exam_1 , R.drawable.ic_my_page)
        listOfWork.add(workModel)

        workModel = WorkModel("뮌스터", 128, R.drawable.exam_2, R.drawable.ic_my_page)
        listOfWork.add(workModel)

        workModel = WorkModel("뮌스터", 298, R.drawable.exam_3, R.drawable.ic_my_page)
        listOfWork.add(workModel)

        workModel = WorkModel("뮌스터", 298, R.drawable.girl, R.drawable.ic_my_page)
        listOfWork.add(workModel)

        workModel = WorkModel("뮌스터", 298, R.drawable.exam_3, R.drawable.ic_my_page)
        listOfWork.add(workModel)

        workModel = WorkModel("뮌스터", 298, R.drawable.exam_1, R.drawable.ic_my_page)
        listOfWork.add(workModel)
        workModel = WorkModel("지멘", 128, R.drawable.girl, R.drawable.ic_my_page)
        listOfWork.add(workModel)



        return listOfWork
    }

}