package com.garisea.views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.garisea.datasets.MyPreferences
import com.garisea.datasets.local.adapter.ItemFinancingAdapter
import com.garisea.datasets.local.models.ParseJsonData
import com.garisea.views.activities.EditScoreActivity
import com.garisea.views.activities.HelpActivity
import com.garisea.views.activities.UserDetailsActivity
import com.garisea.views.databinding.FragmentDashboardBinding
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _fragmentBinding: FragmentDashboardBinding? = null
    private val fragmentBinding get() = _fragmentBinding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)



            //



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _fragmentBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = fragmentBinding.root

        val context = requireContext()
        val pref = MyPreferences(context)




        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        var greetingMessage = ""
        greetingMessage = when (hourOfDay) {
            in 6..11 -> "Hello, Good Morning"
            in 12..17 -> "Hello, Good Afternoon"
            in 18..21 -> "Hello, Good Evening"
            else -> "Hello, "
        }

        fragmentBinding.txGreetings.text = greetingMessage
        fragmentBinding.txUsername.text = pref.getUserName()

        fragmentBinding.rlProfileBtn.setOnClickListener {
            context.startActivity(Intent(requireActivity(), UserDetailsActivity::class.java))
        }

        fragmentBinding.rlSettingsBtn.setOnClickListener {
            context.startActivity(Intent(requireActivity(), EditScoreActivity::class.java))
        }

        fragmentBinding.rlHelpBtn.setOnClickListener {
            context.startActivity(Intent(requireActivity(), HelpActivity::class.java))
        }

        val items = ParseJsonData(context).financingWrapper.items

        fragmentBinding.recycleViewFinancing.layoutManager = LinearLayoutManager(context)

        val itemAdapter = ItemFinancingAdapter(items)
        fragmentBinding.recycleViewFinancing.adapter = itemAdapter

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}