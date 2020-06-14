package com.example.myfirstapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.myfirstapp.R
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.utilities.InjectorUtils
import com.example.myfirstapp.viewmodels.TaskViewModel
import com.example.myfirstapp.views.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.counter_actionbar_title.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Counter.newInstance] factory method to
 * create an instance of this fragment.
 */
class Counter : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val model: TaskViewModel by viewModels { InjectorUtils.provideTaskViewModelFactory(requireActivity()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        enableCounterToolbar()
    }

    override fun onPause() {
        super.onPause()

        disableCounterToolbar()
    }

    private fun enableCounterToolbar() {
        // https://stackoverflow.com/questions/33219485/add-and-remove-views-from-toolbar-depending-on-fragment-displayed
        val toolbar = (activity as MainActivity).supportActionBar
        toolbar?.setDisplayShowTitleEnabled(false)
        toolbar?.setDisplayShowHomeEnabled(false)
        toolbar?.setDisplayShowCustomEnabled(true)

        val counterToolbarView = layoutInflater.inflate(R.layout.counter_actionbar_title, null)

        model.selectedTask.observe(viewLifecycleOwner, Observer { task ->
            task?.let {
                counterToolbarView.counter_intensity_unit_text.text = "${it.intensity} ${it.unit}"
                counterToolbarView.counter_sets_reps_text.text = "${it.sets} × ${it.reps}"
                counterToolbarView.counter_tag_text.text = "#${it.tag}"
            }
        })

        toolbar?.customView = counterToolbarView
    }

    private fun disableCounterToolbar() {
        val toolbar = (activity as MainActivity).supportActionBar
        toolbar?.setDisplayShowCustomEnabled(false)
        toolbar?.setDisplayShowTitleEnabled(true)
        toolbar?.setDisplayShowHomeEnabled(true)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Counter.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Counter().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}