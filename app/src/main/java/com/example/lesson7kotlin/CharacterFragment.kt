package com.example.lesson7kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson7kotlin.databinding.FragmentCharacterBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val data = arrayListOf<Character>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data.add(Character("Alive", "Rick Sanchez", R.drawable.rick))
        data.add(Character("Alive", "Morty Smith", R.drawable.morty))
        data.add(Character("Dead", "Albert Einstein", R.drawable.enshtein))
        data.add(Character("Alive", "Jerry Smith", R.drawable.jimmy))

        val adapter = CharacterAdapter(data){
            findNavController().navigate(R.id.action_characterFragment_to_profileFragment, Bundle().apply {
                putSerializable("key1", data[it])
            })
        }

        binding.recycler.adapter = adapter
    }
}