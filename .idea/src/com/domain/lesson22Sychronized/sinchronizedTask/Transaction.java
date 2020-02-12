package com.domain.lesson22Sychronized.sinchronizedTask;

public class Transaction implements Runnable{
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        // TODO: перевод средств в количестве (money) с аккаунта (src) на аккаунт (dst)
        //  с какой проблемой можно столкнуться?
        //  как ее решить?
        if (src.getId() < dst.getId()){
            synchronized (src){
                synchronized (dst){

                }
            }
        }else {
            synchronized (dst) {
                synchronized (src) {

                }
            }
        }
    }
}
