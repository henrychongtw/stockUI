package henrychong.stock.stockui;

/**
 * Created by henrychong on 2016/9/20.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by henrychong on 2016/9/19.
 */
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPageNo;

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataset = {"Oraclet Info", "Oraclet Info 2",
            "Oraclet Info 3", "Oraclet Info 4", "Oraclet Info 5", "Oraclet Info 6" ,
            "Oraclet Info 7", "Oraclet Info 8", "Oraclet Info 9"};
    public static final int item1 = 0;
    public static final int item2 = 1;
    public static final int item3 = 2;
    public static final int item4 = 3;
    public static final int item5 = 4;
    public static final int item6 = 5;
    public static final int item7 = 6;
    public static final int item8 = 7;
    public static final int item9 = 8;
    private int mDatasetTypes[] = {item1,item2,item3,item4,item5,item6,item7,item8,item9 }; //view types

    public static PageFragment newInstance(int pageNo){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNo = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mPageNo == 1){
            View view = inflater.inflate(R.layout.fragment_info,container,false);
            mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            //Adapter is created in the last step

            mAdapter = new CustomAdapter(mDataset, mDatasetTypes);
            mRecyclerView.setAdapter(mAdapter);
            return view;
        }else if(mPageNo == 2){
            View view = inflater.inflate(R.layout.fragment_graph,container,false);
            return view;
        }else if(mPageNo == 3){
            View view = inflater.inflate(R.layout.fragment_contrary,container,false);
            return view;
        }else if(mPageNo == 4){
            View view = inflater.inflate(R.layout.fragment_comment,container,false);
            return view;
        }else if(mPageNo == 5){
            View view = inflater.inflate(R.layout.fragment_subscribe,container,false);
            return view;
        }
        else{
            View view = inflater.inflate(R.layout.fragment_page,container,false);
            return view;
        }
//        View view = inflater.inflate(R.layout.fragment_page,container,false);
//        TextView textView = (TextView) view;
//        textView.setText("Fragment #"+ mPageNo);
//        return view;

    }

}
