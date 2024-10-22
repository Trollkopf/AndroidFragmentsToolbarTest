package com.example.ejercicio5masterd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FirstFragment : Fragment() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        editText = view.findViewById(R.id.inputText)
        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            val text = editText.text.toString()

            // Create a bundle with the inserted text
            val bundle = Bundle()
            bundle.putString("inputText", text)

            // Create a new instance of the second fragment and pass the bundle
            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, secondFragment)
                ?.addToBackStack(text)
                ?.commit()
        }

        return view
    }

}