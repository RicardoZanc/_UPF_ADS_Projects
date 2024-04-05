package com.example.guestappfirebase.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.guestappfirebase.databinding.FragmentHomeBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class HomeFragment : Fragment() {
    val db = Firebase.firestore
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var lista: ArrayList<String> = ArrayList();


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, lista)
        _binding!!.listView.adapter = adapter

        getList(adapter)

        _binding!!.btnSave.setOnClickListener {
            // Create a new user with a first and last name
            val guest = hashMapOf(
                "name" to _binding!!.edtName.text.toString()
            )

            // Add a new document with a generated ID
            db.collection("guests")
                .add(guest)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(requireContext(), "Adicionado com sucesso", Toast.LENGTH_LONG)
                        .show()
                    getList(adapter)
                    Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("TAG", "Error adding document", e)
                }
        }
        return root
    }

    fun getList(adapter: ArrayAdapter<String>){
        lista.clear()
        db.collection("guests")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("TAG", "${document.id} => ${document.data}")
                    lista.add(document.data["name"].toString())
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}