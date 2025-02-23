package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoriteAdapter: ProductAdapter
    private val favoriteList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับสินค้าที่ถูกใจ
        binding.recyclerViewFavorites.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        favoriteAdapter = ProductAdapter(favoriteList)
        binding.recyclerViewFavorites.adapter = favoriteAdapter

        loadFavorites()
    }

    private fun loadFavorites() {
        favoriteList.clear()
        favoriteList.add(Product("หูฟังไร้สาย", "99 บาท", R.drawable.airpods, "🎧 Gadget"))
        favoriteList.add(Product("สมาร์ทวอช", "199 บาท", R.drawable.watch, "⌚ Gadget"))
        favoriteAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
