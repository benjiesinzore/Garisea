package com.garisea.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.garisea.datasets.MyPreferences
import com.garisea.views.R
import com.garisea.views.databinding.FragmentDashboardBinding
import com.garisea.views.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _fragmentBinding: FragmentProfileBinding? = null
    private val fragmentBinding get() = _fragmentBinding!!

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
    ): View {
        // Inflate the layout for this fragment
        _fragmentBinding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = fragmentBinding.root

        // Access the binding here
        val pref = MyPreferences(requireContext())
        fragmentBinding.txUsername.text = pref.getUserName()
        fragmentBinding.txFirstName.text = pref.getFirstName()
        fragmentBinding.txMiddleName.text = pref.getMiddleName()
        fragmentBinding.txLastName.text = pref.getLastName()
        fragmentBinding.txHomeCity.text = pref.getHomeCity()
        fragmentBinding.txHomeAddress.text = pref.getHomeAddress()
        fragmentBinding.txMonthlyIncome.text = pref.getMonthlyIncome()

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}