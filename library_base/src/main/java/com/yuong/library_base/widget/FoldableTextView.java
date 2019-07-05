package com.yuong.library_base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuong.library_base.R;

import java.lang.ref.WeakReference;

public class FoldableTextView extends LinearLayout {

    FoldTextViewHolder mFoldTextViewHolder;

    View mView;

    /**
     * 真实行数
     */
    int realLineCounts = 0;

    /**
     * 默认行数
     */
    int defaultLineCounts = 2;

    /**
     * 真实高度
     */
    int realHeight = 0;

    /**
     * 折叠后的高度
     */
    int foldHeight = 0;

    boolean isFirstLoad = true;

    /**
     * Icon状态 展开动画
     */
    RotateAnimation expIconAnimation;

    /**
     * Icon状态 折叠动画
     */
    RotateAnimation foldIconAnimation;

    /**
     * 当前是否展开
     */
    boolean isExp = false;

    /**
     * 展开TextView
     */
    final int TEXT_OPEN = 1;

    /**
     * 关闭TextView
     */
    final int TEXT_CLOSE = 2;

    @SuppressLint("HandlerLeak")
    class MyHandler extends Handler {
        WeakReference<FoldableTextView> weakReference;

        public MyHandler(FoldableTextView view) {
            weakReference = new WeakReference<>(view);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int lines = (Integer) msg.obj;
            switch (msg.what) {
                case TEXT_OPEN:    //打开，增加高度
                    weakReference.get().mFoldTextViewHolder.tvFold.setMaxLines(lines);
                    break;
                case TEXT_CLOSE://关闭，减少高度
                    weakReference.get().mFoldTextViewHolder.tvFold.setMaxLines(lines);
                    break;
                default:
                    break;
            }
        }
    }

    private MyHandler mHandler;

//    Handler mHander = new Handler() {
//        @Override
//        public void handleMessage(android.os.Message msg) {
//            int lines = (Integer) msg.obj;
//            switch (msg.what) {
//                case TEXT_OPEN:    //打开，增加高度
//                    mFoldTextViewHolder.tvFold.setMaxLines(lines);
//                    break;
//                case TEXT_CLOSE://关闭，减少高度
//                    mFoldTextViewHolder.tvFold.setMaxLines(lines);
//                    break;
//            }
//        }
//    };

    public FoldableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FoldableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mHandler = new MyHandler(this);
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        mView = inflater.inflate(R.layout.view_widget_foldtextview, null);
        this.addView(mView, layoutParams);

        //设置小箭头展开时的旋转动画
        expIconAnimation = new RotateAnimation(0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        expIconAnimation.setDuration(300);
        expIconAnimation.setFillAfter(true);

        //设置小箭头关闭时的旋转动画
        foldIconAnimation = new RotateAnimation(180f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        foldIconAnimation.setDuration(300);
        foldIconAnimation.setFillAfter(true);

        mFoldTextViewHolder = new FoldTextViewHolder(this);
    }

    public void setText(String text) {
        mFoldTextViewHolder.tvFold.setText(text);

        ViewTreeObserver vto = mFoldTextViewHolder.tvFold.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (!isFirstLoad) {
                    return;
                }

                //获取真实行数
                realLineCounts = mFoldTextViewHolder.tvFold.getLineCount();
                realHeight = mFoldTextViewHolder.tvFold.getMeasuredHeight();

                //如果真实行数大于默认的显示行数，则默认将其折叠起来  isExp为false
                if (realLineCounts > defaultLineCounts) {
                    mFoldTextViewHolder.tvFold.setMaxLines(defaultLineCounts);
                    mFoldTextViewHolder.tvFold.measure(0, 0);
                    foldHeight = mFoldTextViewHolder.tvFold.getMeasuredHeight();
                    mFoldTextViewHolder.ivFold.setVisibility(View.VISIBLE);

                    mFoldTextViewHolder.tvFold.setOnClickListener(FoldOnclick);
                    mFoldTextViewHolder.ivFold.setOnClickListener(FoldOnclick);
                    isExp = false;
                }
                //如果真实行数小于默认行数，则直接展示出来。isExp为true;
                else {
                    mFoldTextViewHolder.ivFold.setVisibility(View.GONE);
                    isExp = true;
                }

                isFirstLoad = false;
            }
        });
    }

    View.OnClickListener FoldOnclick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isExp) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int endcount = realLineCounts;
                        while (endcount-- > defaultLineCounts) {
                            Message msg = Message.obtain();
                            msg.what = TEXT_CLOSE;
                            msg.obj = endcount;
                            mHandler.sendMessage(msg);
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }).start();

                mFoldTextViewHolder.ivFold.setAnimation(foldIconAnimation);
                foldIconAnimation.startNow();

                isExp = false;
            } else {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        int startcount = defaultLineCounts;
                        while (startcount++ < realLineCounts) {
                            Message msg = Message.obtain();
                            msg.what = TEXT_OPEN;
                            msg.obj = startcount;
                            mHandler.sendMessage(msg);
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                mFoldTextViewHolder.ivFold.setAnimation(expIconAnimation);
                expIconAnimation.startNow();
                isExp = true;
            }
        }
    };

    class FoldTextViewHolder {
        TextView tvFold;
        ImageView ivFold;

        public FoldTextViewHolder(View v) {
            tvFold = v.findViewById(R.id.tvFold);
            ivFold = v.findViewById(R.id.ivFold);
        }
    }


}
