package com.geraldeberhard.tugasthrlebaran

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _announcements = MutableLiveData<List<Announcement>>()
    val announcements: LiveData<List<Announcement>> = _announcements

    init {
        loadAnnouncements()
    }

    private fun loadAnnouncements() {
        _announcements.value = listOf(
            Announcement(1, "Jadwal UTS Semester Genap", "20 Maret 2026", "Akademik", "UTS akan dilaksanakan pada tanggal 1-7 April 2026. Seluruh mahasiswa wajib hadir."),
            Announcement(2, "Pendaftaran KKN Batch 5", "18 Maret 2026", "KKN", "Pendaftaran KKN Batch 5 dibuka mulai 25 Maret hingga 10 April 2026."),
            Announcement(3, "Seminar Nasional Energi 2026", "15 Maret 2026", "Event", "Universitas Pertamina menyelenggarakan Seminar Nasional Energi pada 5 April 2026."),
            Announcement(4, "Beasiswa Pertamina Foundation", "12 Maret 2026", "Beasiswa", "Pendaftaran beasiswa Pertamina Foundation dibuka untuk mahasiswa aktif semester 3-7."),
            Announcement(5, "Libur Idul Fitri 1446H", "10 Maret 2026", "Akademik", "Kampus libur Idul Fitri mulai 28 Maret hingga 6 April 2026.")
        )
    }

    fun getAnnouncementById(id: Int): Announcement? {
        return _announcements.value?.find { it.id == id }
    }
}