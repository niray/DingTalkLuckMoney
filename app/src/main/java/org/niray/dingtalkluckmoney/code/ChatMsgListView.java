///**
// * Generated by smali2java 1.0.0.558
// * Copyright (C) 2013 Hensence.com
// */
//
//package com.alibaba.android.dingtalkim.imtools;
//
//import com.alibaba.wukong.im.Message;
//import com.alibaba.Disappear;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.AbsListView;
//import android.view.GestureDetector;
//import android.animation.ObjectAnimator;
//import android.view.View;
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.widget.TextView;
//import android.content.res.Resources;
//import android.os.SystemClock;
//import android.view.MotionEvent;
//import java.util.List;
//
//public class ChatMsgListView extends LinearLayout {
//    private ListView a;
//    private wb<Message> b;
//    private ChatMsgListView.b c;
//    private AbsListView.OnScrollListener d;
//    private GestureDetector e;
//    private float f;
//    private float g;
//    private boolean h;
//    private ObjectAnimator i;
//    private float j;
//    private float k;
//
//    public ChatMsgListView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        a(context, attrs);
//    }
//
//    public ChatMsgListView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        a(context, attrs);
//    }
//
//    private void a(Context context, AttributeSet attrs) {
//        setOrientation(0x1);
//        setGravity(0x11);
//        LayoutInflater.from(getContext()).inflate(xa.g.chat_list_content, this);
//        a = (ListView)findViewById(xa.f.list_view);
//        TextView footerHolderTextView = new TextView(context);
//        footerHolderTextView.setText(" ");
//        footerHolderTextView.setTextSize((float)un.b(context, 5.0f));
//        a.addFooterView(footerHolderTextView, 0x0, false);
//        a.setItemsCanFocus(true);
//        a.setFocusable(true);
//        a.setOnScrollListener(m);
//        setOnTouchListener(l);
//        j = getContext().getResources().getDimension(xa.d.chatting_item_time_width);
//        k = j;
//    }
//
//    public void setAdapter(wb<Message> p1) {
//        // :( Parsing error. Please contact me.
//    }
//
//    public ListView getListView() {
//        return a;
//    }
//
//    public void setOnListViewArrivedListener(ChatMsgListView.b listener) {
//        c = listener;
//    }
//
//    public void setOnScrollListener(AbsListView.OnScrollListener listener) {
//        d = listener;
//    }
//
//    public void setGestureDetector(GestureDetector gestureDetector) {
//        e = gestureDetector;
//    }
//
//    public int getFirstVisibleDataPosition() {
//        if(a != null) {
//            return b(a.getFirstVisiblePosition());
//        }
//        return -0x1;
//    }
//
//    public int getLastVisibleDataPosition() {
//        if(a != null) {
//            return b(a.getLastVisiblePosition());
//        }
//        return -0x1;
//    }
//
//    public View a(int position) {
//        if(a != null) {
//            position += a.getHeaderViewsCount();
//            if((position >= a.getFirstVisiblePosition()) && (position <= a.getLastVisiblePosition())) {
//                position -= a.getFirstVisiblePosition();
//                return a.getChildAt(position);
//            }
//        }
//        return null;
//    }
//
//    public int getTotalDataCount() {
//        if(b != null) {
//            return b.getCount();
//        }
//        return 0x0;
//    }
//
//    public ChatMsgListView.a getCurrentAnchor() {
//        int firstVisibleDataPosition = getFirstVisibleDataPosition();
//        if((firstVisibleDataPosition >= 0) && (b != null)) {
//            Message data = (Message)b.getItem(firstVisibleDataPosition);
//            if(data != null) {
//                return new ChatMsgListView.a(data, getFirstVisibleDataBottomOffset(), 0x0);
//            }
//        }
//        return null;
//    }
//
//    public void a(ChatMsgListView.a anchor) {
//        if((anchor != null) && (ChatMsgListView.a.a(anchor) != null) && (b != null) && (b.b() != null) && (b.b().size() > 0)) {
//            int position = abm.a(b.b(), ChatMsgListView.a.a(anchor));
//            if(position >= 0) {
//                if(position >= (b.b().size() - 0x1)) {
//                    a(position, 0x0, false, false);
//                    return;
//                }
//                position = position + 0x1;
//                a(position, ChatMsgListView.a.b(anchor), false, false);
//            }
//        }
//    }
//
//    public void a(int dataPosition, int offset, boolean smooth, boolean safe) {
//        if((a != null) && (b != null) && (b.getCount() > 0)) {
//            if(dataPosition < 0) {
//                dataPosition += b.getCount();
//            }
//            int headerCount = a.getHeaderViewsCount();
//            int position = dataPosition + headerCount;
//            if(smooth) {
//                a.smoothScrollToPositionFromTop(position, offset);
//                return;
//            }
//            a.setSelectionFromTop(position, offset);
//            if(safe) {
//                a.post(new Runnable(this, position, offset) {
//
//                    1(ChatMsgListView p1, int p2, int p3) {
//                    }
//
//                    public void run() {
//                        a(c).setSelectionFromTop(a, b);
//                    }
//                });
//            }
//        }
//    }
//
//    public void a(boolean smooth, boolean safe) {
//        a(-0x1, -0xf4240, smooth, safe);
//    }
//
//    public void setBottomMode(boolean isBottomMode) {
//        if(a != null) {
//            if(isBottomMode) {
//                a.setTranscriptMode(0x2);
//                return;
//            }
//            a.setTranscriptMode(0x0);
//        }
//    }
//
//    public void a() {
//        if(a != null) {
//            a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0x3, 0.0f, 0.0f, 0x0));
//        }
//    }
//
//    public void setEmptyView(View emptyView) {
//        if(a != null) {
//            a.setEmptyView(emptyView);
//        }
//    }
//
//    private int b(int position) {
//        if((a != null) && (b != null)) {
//            position -= a.getHeaderViewsCount();
//            if(position < 0) {
//                return position;
//            }
//            if(position > (b.getCount() - 0x1)) {
//                return position;
//            }
//        }
//        return -0x1;
//    }
//
//    private int getFirstVisibleDataBottomOffset() {
//        if(a != null) {
//            int dataPosition = a.getFirstVisiblePosition() - a.getHeaderViewsCount();
//            View child = 0x0;
//            if(dataPosition <= -a.getChildCount()) {
//                return 0x0;
//            }
//            if(dataPosition < 0) {
//                child = a.getChildAt(-dataPosition);
//            } else {
//                child = a.getChildAt(0x0);
//            }
//            if(child != null) {
//                return (child.getTop() + child.getHeight());
//            }
//        }
//        return 0x0;
//    }
//
//    public boolean onInterceptTouchEvent(MotionEvent e) {
//        // :( Parsing error. Please contact me.
//    }
//
//    public void setHiddenTimeCurrentOffset(float offset) {
//        if(a != null) {
//            int l = a.getChildCount();
//            for(int i = 0x0; i < l; i = i + 0x1) {
//                View v = a.getChildAt(i);
//                if((v != null) && (v.getTag() != null) && (v.getTag() instanceof xb)) {
//                    xb holder = (xb)v.getTag();
//                    holder.a(offset);
//                }
//            }
//            k = offset;
//        }
//    }
//    private View.OnTouchListener l = new View.OnTouchListener(this) {
//        private float b;
//        private int c;
//
//        2(ChatMsgListView p1) {
//            b = 0.0f;
//            c = -0x1;
//        }
//
//        public boolean onTouch(View v, MotionEvent event) {
//            switch((event.getAction() & 0xff)) {
//                case 2:
//                {
//                    if(event.getPointerCount() == 0x1) {
//                        if((b [cmp] 0x1 == null) || (event.getPointerId(0x0) != c)) {
//                            b = event.getX();
//                            c = event.getPointerId(0x0);
//                            return true;
//                        }
//                        if(b(a) != null) {
//                            b(a).cancel();
//                            a(a, 0x0);
//                        }
//                        float diff = event.getX() - b;
//                        float value = c(a);
//                        value += diff;
//                        if(value > d(a)) {
//                            value = d(a);
//                        } else if(value < 0x0) {
//                            value = 0.0f;
//                        }
//                        a.setHiddenTimeCurrentOffset(value);
//                        b = event.getX();
//                        return true;
//                    }
//                    case 1:
//                    case 3:
//                    {
//                        e(a);
//                        b = 0.0f;
//                        c = -0x1;
//                        break;
//                    }
//                }
//            }
//            return true;
//        }
//    };
//
//    private void b() {
//        if(i != null) {
//            i.cancel();
//            i = 0x0;
//        }
//        i = ObjectAnimator.ofFloat(this, "hiddenTimeCurrentOffset", new float[] {k, j});
//        i.setDuration(0xc8);
//        i.start();
//    }
//
//    protected void onDetachedFromWindow() {
//        if(i != null) {
//            i.cancel();
//            i = 0x0;
//        }
//        super.onDetachedFromWindow();
//    }
//    private AbsListView.OnScrollListener m = new AbsListView.OnScrollListener(this) {
//        private boolean b;
//        private boolean c;
//
//        3(ChatMsgListView p1) {
//        }
//
//        public void onScrollStateChanged(AbsListView view, int scrollState) {
//            if(a(a) != null) {
//                if((scrollState == 0x1) || (scrollState == 0x2)) {
//                    a(a).setVerticalScrollBarEnabled(true);
//                } else if(scrollState == 0) {
//                    a(a).setVerticalScrollBarEnabled(false);
//                }
//            }
//            if(f(a) != null) {
//                f(a).onScrollStateChanged(view, scrollState);
//            }
//        }
//
//        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//            if(firstVisibleItem == 0) {
//                if(!b) {
//                    b = true;
//                    if(g(a) != null) {
//                        g(a).a();
//                    }
//                }
//            } else if(b) {
//                b = false;
//            }
//            if((firstVisibleItem + visibleItemCount) == totalItemCount) {
//                if(!c) {
//                    c = true;
//                    if(g(a) != null) {
//                        g(a).b();
//                    }
//                }
//            } else if(c) {
//                c = false;
//            }
//            if(f(a) != null) {
//                f(a).onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
//            }
//        }
//    };
//}
