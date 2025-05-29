package com.remotearmz.commandcenter.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.remotearmz.commandcenter.R

class DashboardFragment : Fragment() {
    private lateinit var kpiAdapter: KpiAdapter
    private lateinit var performanceAdapter: PerformanceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupKpiRecyclerView()
        setupPerformanceRecyclerView()
        
        // Initialize sample data
        setupSampleData()
    }

    private fun setupKpiRecyclerView() {
        kpiAdapter = KpiAdapter()
        view?.findViewById<RecyclerView>(R.id.kpiCards)?.apply {
            adapter = kpiAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupPerformanceRecyclerView() {
        performanceAdapter = PerformanceAdapter()
        view?.findViewById<RecyclerView>(R.id.performanceItems)?.apply {
            adapter = performanceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupSampleData() {
        // Sample KPI data
        val kpiItems = listOf(
            KpiItem("Total Clients", "125", R.drawable.ic_clients),
            KpiItem("Active Leads", "42", R.drawable.ic_leads),
            KpiItem("Targets", "85%", R.drawable.ic_targets)
        )
        kpiAdapter.submitList(kpiItems)

        // Sample Performance data
        val performanceItems = listOf(
            PerformanceItem("Client Acquisition", 75),
            PerformanceItem("Lead Conversion", 60),
            PerformanceItem("Target Achievement", 85)
        )
        performanceAdapter.submitList(performanceItems)
    }
}
