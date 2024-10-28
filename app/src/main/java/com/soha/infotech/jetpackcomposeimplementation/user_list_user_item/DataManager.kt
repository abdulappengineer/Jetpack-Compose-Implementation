package com.soha.infotech.jetpackcomposeimplementation.user_list_user_item

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.soha.infotech.jetpackcomposeimplementation.R

/**
 * Step2: Prepare a user list
 */

object DataManager {
    val isDataLoaded = mutableStateOf(false)
    val userList = mutableListOf<User>()

    var currentPage = mutableStateOf(Pages.LISTING)
    var currentUser: User? = null

    fun loadUser(): List<User> {
        val names = listOf(
            "Abdul Khalid",
            "Sara Ali",
            "John Doe",
            "Emma Watson",
            "Michael Jordan",
            "Chris Evans",
            "Natalie Portman",
            "Tom Holland",
            "Elena Gilbert",
            "Bruce Wayne",
            "Clark Kent",
            "Diana Prince",
            "Tony Stark",
            "Steve Rogers",
            "Natasha Romanoff",
            "Peter Parker",
            "Wanda Maximoff",
            "Stephen Strange",
            "Scott Lang",
            "T'Challa"
        )
        val occupations = listOf(
            "Senior Software Engineer",
            "Project Manager",
            "Data Scientist",
            "Product Designer",
            "Mobile Developer",
            "Web Developer",
            "System Architect",
            "UX Researcher",
            "Product Manager",
            "DevOps Engineer",
            "Backend Developer",
            "Frontend Developer",
            "AI Engineer",
            "Machine Learning Engineer",
            "Cloud Engineer",
            "Cybersecurity Specialist",
            "Database Administrator",
            "Business Analyst",
            "Network Engineer",
            "IT Consultant"
        )
        val profileIcons = listOf(
            R.drawable.ic_profile,
            R.drawable.ic_home,
            R.drawable.ic_book,
            R.drawable.ic_movie,
            R.drawable.ic_music,
            R.drawable.ic_profile,
            R.drawable.ic_home,
            R.drawable.ic_book,
            R.drawable.ic_movie,
            R.drawable.ic_music,
            R.drawable.ic_profile,
            R.drawable.ic_home,
            R.drawable.ic_book,
            R.drawable.ic_movie,
            R.drawable.ic_music,
            R.drawable.ic_profile,
            R.drawable.ic_home,
            R.drawable.ic_book,
            R.drawable.ic_movie,
            R.drawable.ic_music
        )

        for (i in names.indices) {
            userList.add(
                User(
                    img = profileIcons[i],
                    name = names[i],
                    occupation = occupations[i]

                )
            )
        }
        isDataLoaded.value = true
        return userList
    }

    // Navigate without navigation
    fun switchPages(user: User?) {
        if (currentPage.value == Pages.LISTING) {
            currentUser = user
            currentPage.value = Pages.DETAIL
        } else {
            currentUser = null // Clear the current user when going back
            currentPage.value == Pages.LISTING
        }
    }
}