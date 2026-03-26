package com.geraldeberhard.tugasthrlebaran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geraldeberhard.tugasthrlebaran.databinding.FragmentScheduleBinding
import com.geraldeberhard.tugasthrlebaran.databinding.ItemScheduleBinding

class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    data class Schedule(val day: String, val subject: String, val time: String)

    private val scheduleList = listOf(
        Schedule("Senin", "Pemrograman Perangkat Bergerak", "08.00 - 10.00"),
        Schedule("Senin", "Basis Data Lanjut", "10.00 - 12.00"),
        Schedule("Selasa", "Kecerdasan Buatan", "08.00 - 10.00"),
        Schedule("Rabu", "Rekayasa Perangkat Lunak", "13.00 - 15.00"),
        Schedule("Kamis", "Jaringan Komputer", "08.00 - 10.00"),
        Schedule("Jumat", "Etika Profesi", "10.00 - 12.00")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSchedule.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSchedule.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            inner class ScheduleViewHolder(val binding: ItemScheduleBinding) :
                RecyclerView.ViewHolder(binding.root)

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val b = ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ScheduleViewHolder(b)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                val schedule = scheduleList[position]
                (holder as ScheduleViewHolder).binding.apply {
                    tvDay.text = schedule.day
                    tvSubject.text = schedule.subject
                    tvTime.text = schedule.time
                }
            }

            override fun getItemCount() = scheduleList.size
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}