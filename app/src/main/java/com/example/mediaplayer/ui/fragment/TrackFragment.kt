package com.example.mediaplayer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediaplayer.adapter.TrackAdapter
import com.example.mediaplayer.databinding.FragmentTrackBinding
import com.example.mediaplayer.di.modules.ViewModelFactory
import com.example.mediaplayer.ui.viewModel.TracksViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TrackFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel by viewModels<TracksViewModel>() { factory }

    private var binding: FragmentTrackBinding? = null

    private var adapter: TrackAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = TrackAdapter(requireContext(), viewModel.tracksList)

        binding = FragmentTrackBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@TrackFragment.viewLifecycleOwner

            trackRecyclerview.layoutManager = LinearLayoutManager(requireContext())
            trackRecyclerview.adapter = adapter
        }

        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.tracksListLiveData.observe(viewLifecycleOwner, Observer {
            viewModel.tracksList.clear()
            viewModel.tracksList.addAll(it)
            adapter?.notifyDataSetChanged()
        })

        viewModel.getTrackList()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
        binding = null
    }

}