package com.example.mediaplayer.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Track
import com.example.domain.repository.TrackRepository
import com.example.domain.trackListSort.TracksSort
import com.example.mediaplayer.R
import com.example.mediaplayer.adapter.TrackAdapter
import com.example.mediaplayer.di.modules.ViewModelFactory
import com.example.mediaplayer.ui.viewModel.TracksViewModel
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.*
import javax.inject.Inject


class TrackFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    val viewModel by viewModels<TracksViewModel>() { factory }
    lateinit var adapter: TrackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_track, container, false)
        // Inflate the layout for this fragment
        val recyclerView = view.findViewById<RecyclerView>(R.id.trackRecyclerview)
        adapter = TrackAdapter(
            requireContext()
            , viewModel.tracksList
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.tracksListLiveData.observe(viewLifecycleOwner, Observer {
            viewModel.tracksList.clear()
            viewModel.tracksList.addAll(it)
            adapter.notifyDataSetChanged()
        })

        viewModel.getTrackList()

    }

}