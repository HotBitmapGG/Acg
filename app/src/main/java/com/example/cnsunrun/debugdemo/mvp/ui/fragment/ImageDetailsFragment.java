package com.example.cnsunrun.debugdemo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.widget.CircleProgressView;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by cnsunrun on 2017/4/24.
 */

public class ImageDetailsFragment extends Fragment implements RequestListener<String, GlideDrawable> {

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.iv_image_details)
    ImageView mImageView;

    private String url;
    private PhotoViewAttacher mPhotoViewAttacher;

    public static ImageDetailsFragment newInstance(String url) {
        ImageDetailsFragment fragment = new ImageDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_details, container, false);
        ButterKnife.bind(this, view);
        url = getArguments().getString("url");
        initView();
        return view;
    }

    private void initView() {
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        Glide.with(this).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade(0)
                .listener(this)
                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }

    @Override
    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        return false;
    }

    @Override
    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mImageView.setImageDrawable(resource);
        mPhotoViewAttacher = new PhotoViewAttacher(mImageView);
        mPhotoViewAttacher.setOnViewTapListener((view, v, v1) -> getActivity().finish());

        return false;
    }
}
