package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private lateinit var promoAdapter: ProductAdapter

    private val productList = mutableListOf<Product>()
    private val promoList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        // 🔹 ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        binding.recyclerViewPromos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        promoAdapter = ProductAdapter(promoList)
        binding.recyclerViewPromos.adapter = promoAdapter

        // 🔹 โหลดข้อมูล
        loadProducts()
        loadPromotions()
    }

    private fun loadProducts() {
        productList.add(Product("Sunsilk Shampoo", "149 บาท", R.drawable.sunsilk))
        productList.add(Product("เสื้อกันหนาว", "134 บาท", R.drawable.hoodie))
        productList.add(Product("หูฟังไร้สาย", "99 บาท", R.drawable.airpods))
        productList.add(Product("นาฬิกา LED", "126 บาท", R.drawable.watch))
        productAdapter.notifyDataSetChanged()
    }

    private fun loadPromotions() {
        promoList.add(Product("Sunsilk Shampoo", "ลดเหลือ 99 บาท", R.drawable.sunsilk))
        promoList.add(Product("เสื้อกันหนาว", "ลดเหลือ 110 บาท", R.drawable.hoodie))
        promoList.add(Product("หูฟังไร้สาย", "ลดเหลือ 79 บาท", R.drawable.airpods))
        promoList.add(Product("นาฬิกา LED", "ลดเหลือ 100 บาท", R.drawable.watch))
        promoAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
