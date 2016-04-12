// Jennifer Li <jli10@stanford.edu>
// Simple To-do List - This app allows the user to enter in items to put in a to-do list
// The user can delete the items in the list by clickin on them.
// Empty items are not entered into the list.


package cs193a.hw2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;
import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up the list
        ListView listView = (ListView) findViewById(R.id.todo_list);
        listItems = new ArrayList<>(); //empty
        // make adapter
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);

        //to delete the items
        deleteItemClick(listView);


    }

    public void addItemClick(View view) {
        EditText todoBox = (EditText)findViewById(R.id.todoText);
        String todoText = todoBox.getText().toString();

        todoBox.setText("");

        if(todoText.trim().length() != 0) { //so that user add blank items
            listItems.add(todoText);
            adapter.notifyDataSetChanged();
        }

    }

    public void deleteItemClick(ListView listView){
        // listen to clicks on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // when a list item is clicked remove that item
                listItems.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

}
