package ph.uic.edu.dahiroc_prelim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskBuddy : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    private lateinit var btnAddTodo: Button
    private lateinit var btnDeleteDoneTodos: Button
    private lateinit var etTodoTitle: TextView
    private lateinit var taskBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_buddy)

        todoAdapter = TodoAdapter(mutableListOf())

        val rvTodoItems = findViewById<View>(R.id.rvTodoItems) as RecyclerView
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)
        btnAddTodo = this.findViewById(R.id.btnAddTodo)
        btnDeleteDoneTodos = this.findViewById(R.id.btnDeleteDoneTodos)
        etTodoTitle = this.findViewById(R.id.etTodoTitle)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.setText("")
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
        taskBack = this.findViewById(R.id.backButton)
        taskBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}