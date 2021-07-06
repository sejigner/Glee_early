package com.sejigner.glee.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
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