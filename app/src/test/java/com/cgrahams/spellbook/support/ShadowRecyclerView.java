//package com.cgrahams.spellbook.support;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.ListView;
//
//import org.robolectric.annotation.Implementation;
//import org.robolectric.annotation.Implements;
//import org.robolectric.annotation.RealObject;
//import org.robolectric.shadows.ShadowViewGroup;
//
//@Implements(value = RecyclerView.class)
//public class ShadowRecyclerView extends ShadowViewGroup {
//    @RealObject private RecyclerView realRecyclerView;
//    private int index = 0;
//
//    @Implementation
//    public ShadowRecyclerView firstItemContainsText(View view, String text) {
//        View firstView = realRecyclerView.getLayoutManager().findViewByPosition(0);
//    }
//
//    public ShadowRecyclerView shadowOf(View recyclerView) {
//
//    }
//}
