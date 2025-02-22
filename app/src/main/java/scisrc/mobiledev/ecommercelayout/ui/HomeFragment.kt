package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ProductAdapter
    private val productList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2) // แสดง 2 คอลัมน์
        adapter = ProductAdapter(productList)
        binding.recyclerView.adapter = adapter

        loadProducts() // โหลดข้อมูลสินค้า
    }

    private fun loadProducts() {
        productList.add(Product("Sunsilk Shampoo", "149 บาท", R.drawable.sunsilk))
        productList.add(Product("เสื้อกันหนาว", "134 บาท", R.drawable.hoodie))
        productList.add(Product("หูฟังไร้สาย", "99 บาท", R.drawable.airpods))
        productList.add(Product("นาฬิกา LED", "126 บาท", R.drawable.watch))
        productList.add(Product("เก้าอี้แคมป์ปิ้ง", "164 บาท", R.drawable.camping_chair))

        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
