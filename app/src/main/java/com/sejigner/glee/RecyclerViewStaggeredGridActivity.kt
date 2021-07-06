package com.sejigner.glee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sejigner.glee.fragment.FragmentShare
import kotlinx.android.synthetic.main.fragment_share.*

class RecyclerViewStaggeredGridActivity : FragmentShare() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        initView()
        return inflater.inflate(R.layout.fragment_share, container, false)
    }
    private fun initView() {
        recyclerViewWorks.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //This will for default android divider
        recyclerViewWorks.addItemDecoration(GridItemDecoration(10, 2))

        val movieListAdapter = WorkListStaggeredAdapter()
        recyclerViewWorks.adapter = movieListAdapter
        movieListAdapter.setWorkList(generateDummyData())
    }

    private fun generateDummyData(): List<WorkModel> {
        val listOfMovie = mutableListOf<WorkModel>()

        var workModel = WorkModel("지멘", 128, R.mipmap.ic_launcher, R.drawable.ic_people)
        listOfMovie.add(workModel)

        workModel = WorkModel("지멘", 128, R.mipmap.ic_launcher, R.drawable.ic_people)
        listOfMovie.add(workModel)

        workModel = WorkModel("뮌스터", 128, R.mipmap.ic_launcher, R.drawable.ic_people)
        listOfMovie.add(workModel)

        workModel = WorkModel("뮌스터", 298, 400, 1)
        listOfMovie.add(workModel)

        workModel = WorkModel("뮌스터", 298, 400, 1)
        listOfMovie.add(workModel)

        workModel = WorkModel("뮌스터", 298, 400, 1)
        listOfMovie.add(workModel)

        return listOfMovie
    }
}