package com.sejigner.glee.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sejigner.glee.GridItemDecoration
import com.sejigner.glee.R
import com.sejigner.glee.WorkListStaggeredAdapter
import com.sejigner.glee.WorkModel
import kotlinx.android.synthetic.main.fragment_share.*

open class FragmentShare : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        return inflater.inflate(R.layout.fragment_share, container, false)
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