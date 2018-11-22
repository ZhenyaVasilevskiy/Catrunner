package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.catrunner.HistoryElement;
import com.example.user.catrunner.HistoryRecyclerViewAdapter;
import com.example.user.catrunner.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HistoryFragment extends Fragment {

    private ArrayList<HistoryElement> historyElements;
    private HistoryRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historyElements = new ArrayList<>();
//  добавление "элемента" истории и вывод его на экран
        historyElements.add(new HistoryElement(new GregorianCalendar(2018, Calendar.NOVEMBER, 16, 20, 50, 23), 5.3));
        historyElements.add(new HistoryElement(new GregorianCalendar(2018, Calendar.JUNE, 1, 12, 10, 46), 55.04));
        adapter = new HistoryRecyclerViewAdapter(this.getActivity(), historyElements);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, null);
        recyclerView = view.findViewById(R.id.recycler_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
