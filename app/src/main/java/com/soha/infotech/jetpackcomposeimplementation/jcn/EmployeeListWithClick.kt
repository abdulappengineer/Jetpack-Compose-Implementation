package com.soha.infotech.jetpackcomposeimplementation.jcn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Employee(val name: String, val mobile: String)

@Composable
fun EmployeeList() {
    val employeeList = listOf(
        Employee("John Doe", "1234567890"),
        Employee("Jane Smith", "9876543210"),
        Employee("Alice Brown", "4567891230"),
        Employee("Robert Taylor", "6541239870"),
        Employee("Emily Johnson", "1112223333"),
        Employee("Michael White", "4445556666"),
        Employee("Sarah Wilson", "7778889999"),
        Employee("David Miller", "1231231234"),
        Employee("Sophia Davis", "9879879876"),
        Employee("Daniel Anderson", "4564564561")
    )

    var selectedEmployee by remember { mutableStateOf<Employee?>(null) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "User List",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(8.dp)
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(employeeList) { employee ->
                EmployeeItem(employee) { selectedEmployee = employee }
            }
        }

        selectedEmployee?.let {
            Text(
                text = "Selected Employee: ${it.name}, ${it.mobile}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp, bottom = 40.dp)
            )
        }
    }
}

@Composable
fun EmployeeItem(employee: Employee, onclick: (Employee) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onclick(employee) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${employee.name}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Mobile: ${employee.mobile}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}