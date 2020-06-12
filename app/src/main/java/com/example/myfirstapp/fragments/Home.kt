package com.example.myfirstapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R
import com.example.myfirstapp.TaskAdapter
import com.example.myfirstapp.models.Task
import com.example.myfirstapp.utilities.InjectorUtils
import com.example.myfirstapp.viewmodels.TaskViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val context = requireActivity()
    private val model: TaskViewModel by viewModels { InjectorUtils.provideTaskViewModelFactory(context) }

    //private val model: TaskViewModel by activityViewModels()

    // Recycler View components
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_create -> {
                    view.findNavController().navigate(R.id.action_home_to_create)
                }
            }
            true
        }

        val tasks: List<Task> = model.getTasks()

        if (tasks.isNotEmpty()) {
            viewManager = LinearLayoutManager(activity)
            viewAdapter = TaskAdapter(model.getTasks())

            recyclerView = view.findViewById<RecyclerView>(R.id.recentTasks).apply {
                setHasFixedSize(true)

                layoutManager = viewManager
                adapter = viewAdapter
            }

////            Snackbar.make(view.homeFragmentLayout, model.getTask().toString(), Snackbar.LENGTH_LONG)
////                .setAction("Action", null)
////                .show()
        }

//        Log.v("Home", tasks.toString())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
