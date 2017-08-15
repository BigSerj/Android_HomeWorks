package com.android.bigserj.domain.interaction.base;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<InParam, OutParam> {

    // в RxJava-1 назывался subscriber
    private Disposable disposable;

    protected abstract Observable<OutParam> buildUseCase();

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver){
        disposable = buildUseCase()
                .observeOn(AndroidSchedulers.mainThread())  // нужно выполнить в потоке UI
                .subscribeOn(Schedulers.newThread())  // где выполнить observable
                .subscribeWith(disposableObserver);
    }

    public void dispose(){
        if (!disposable.isDisposed())
            disposable.dispose();
    }

}