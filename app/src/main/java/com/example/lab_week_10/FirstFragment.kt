package com.example.lab_week_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.lab_week_10.viewmodels.TotalViewModel

class FirstFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[TotalViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textTotal = view.findViewById<TextView>(R.id.text_total)

        viewModel.total.observe(viewLifecycleOwner) {
            textTotal.text = getString(R.string.text_total, it)
        }
    }
}
