package com.example.myfirstapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.myfirstapp.databinding.FragmentCreateBinding
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.utilities.InjectorUtils
import com.example.myfirstapp.viewmodels.TaskViewModel
import kotlinx.android.synthetic.main.fragment_create.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Create.newInstance] factory method to
 * create an instance of this fragment.
 */
class Create : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val model: TaskViewModel by activityViewModels { InjectorUtils.provideTaskViewModelFactory(requireActivity()) }

    //private val model: TaskViewModel by activityViewModels()

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
//        return inflater.inflate(R.layout.fragment_create, container, false)
        return FragmentCreateBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.floatingActionButton.setOnClickListener { v ->
//            Snackbar.make(v, "you clicked on that FAB!", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null)
//                    .show()
//        }

        view.floatingActionButton.setOnClickListener { v ->
            val task: Task =
                Task(
                    view.setText.text.toString().toInt(),
                    view.repText.text.toString().toInt(),
                    view.tagText.text.toString(),
                    view.intensityText.text.toString().toInt(),
                    view.unitText.text.toString()
                )
//            model.setTask(task)
            model.insert(task)
            Log.v("Create Fragment", "$task")
            view.findNavController().popBackStack()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Create.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Create().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
