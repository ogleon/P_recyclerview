package leon.itb.m08.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import leon.itb.m08.recyclerview.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userAdapter = UserAdapter(getUsers())
        linearLayoutManager = LinearLayoutManager(context)

        binding.recyclerView.apply {
            setHasFixedSize(true) //Optimitza el rendiment de l’app
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()
        users.add(User(1, "Batman", "https://i.blogs.es/24bcec/the-batman-affleck/840_560.jpg"))
        users.add(
            User(
                2,
                "Robin Hood",
                "https://static.wikia.nocookie.net/disney/images/4/42/Robin_Hood_Disney.jpg/revision/latest?cb=20170813180356&path-prefix=es"
            )
        )
        users.add(
            User(
                3,
                "Joker",
                url = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/joker-2-1569239913.jpg"
            )
        )

        return users
    }


}