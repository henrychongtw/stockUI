package henrychong.stock.stockui;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private TabLayout mTabLayout;

    private int[] mTabsIcons = {
            R.drawable.info,
            R.drawable.graph,
            R.drawable.question2,
            R.drawable.comment,
            R.drawable.subscribe
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.tabView_pager);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        if(viewPager != null){
            viewPager.setAdapter(pagerAdapter);
        }

        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        if(mTabLayout != null){
            mTabLayout.setupWithViewPager(viewPager);

            for(int i= 0; i <mTabLayout.getTabCount(); i++){
                TabLayout.Tab tab = mTabLayout.getTabAt(i);
                Log.d("testing", tab.toString() );
                if(tab != null){
                    tab.setCustomView(pagerAdapter.getTabView(i));
                    Log.d("testing2", tab.toString());

                }
            }
            mTabLayout.getTabAt(0).getCustomView().setSelected(true);
        }


    }

    private class MyPagerAdapter extends FragmentPagerAdapter{
        public final int PAGE_COUNT = 5;
        private final String[] mTabsTitle = {"Info","Graph","Contrary","Comment","Subscribe"};
        public MyPagerAdapter(android.support.v4.app.FragmentManager fm){
            super(fm);
        }



        public View getTabView(int position){
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab, null);
            TextView title = (TextView) view.findViewById(R.id.tabTitle);
            title.setText((mTabsTitle[position]));
            Log.d("testing2", title.toString());
            Log.d("testing2", Integer.toString(position));

            ImageView icon = (ImageView)view.findViewById(R.id.tabIcon);
            Log.d("testing2", icon.toString());

            icon.setImageResource(mTabsIcons[position]);
            return view;
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos){
                case 0:
                    return PageFragment.newInstance(1);
                case 1:
                    return PageFragment.newInstance(2);
                case 2:
                    return PageFragment.newInstance(3);
                case 3:
                    return PageFragment.newInstance(4);
                case 4:
                    return PageFragment.newInstance(5);
            }
            return null;
        }


        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabsTitle[position];
        }
    }



}
