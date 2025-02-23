package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private val productList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับรายการสินค้า
        binding.recyclerViewProducts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        loadProducts()
    }

    private fun loadProducts() {
        productList.clear()
        productList.add(Product("Sunsilk Shampoo", "149 บาท", R.drawable.sunsilk, "🧴 ผลิตภัณฑ์"))
        productList.add(Product("เสื้อกันหนาว", "134 บาท", R.drawable.hoodie, "👕 เสื้อผ้า"))
        productList.add(Product("หูฟังไร้สาย", "99 บาท", R.drawable.airpods, "🎧 Gadget"))
        productList.add(Product("นาฬิกา LED", "126 บาท", R.drawable.watch, "⌚ Gadget"))
        productAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
